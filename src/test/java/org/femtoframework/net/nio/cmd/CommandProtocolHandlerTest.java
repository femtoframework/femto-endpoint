package org.femtoframework.net.nio.cmd;

import org.femtoframework.util.nutlet.NutletUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * CommandProtocolHandler测试
 *
 * @author fengyun
 * @version 1.00 2005-1-3 16:57:28
 */
public class CommandProtocolHandlerTest
{

    public static class SimpleProtocolHandler
        extends CommandProtocolHandler
    {

        /**
         * 处理BaseContext
         *
         * @param action  事件动作
         * @param context Socket上下文
         */
        protected void handleEvent(int action, CommandContext context)
        {
        }
    }

    /**
     * 测试handleEvent
     */
    @Test
    public void testHandleEvent() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        int action = NutletUtil.getInt();
        handler.handleEvent(action, null);
    }

    /**
     * 测试getCommandHandler
     */
    @Test
    public void testGetCommandHandler() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        assertNull(handler.getCommandHandler());
    }

    /**
     * 测试setCommandHandler
     */
    @Test
    public void testSetCommandHandler() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        SimpleCommandHandler commandHandler = new SimpleCommandHandler();
        handler.setCommandHandler(commandHandler);
        assertEquals(commandHandler, handler.getCommandHandler());
    }

    /**
     * 测试addContextListener（没有CommandHandler的情况下添加ContextListener)
     */
    @Test
    public void testAddContextListener0() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        handler.addContextListener(new SimpleContextListener());
        handler.addContextListener(null);

        assertEquals(0, handler.getContextListeners().size());
    }

    /**
     * 测试addContextListener（有CommandHandler的情况下添加ContextListener)
     */
    @Test
    public void testAddContextListener1() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        handler.setCommandHandler(new SimpleCommandHandler());
        handler.addContextListener(new SimpleContextListener());
        assertEquals(1, handler.getContextListeners().size());
    }


    /**
     * 测试getContextListeners
     */
    @Test
    public void testGetContextListeners() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        assertEquals(0, handler.getContextListeners().size());
    }

    /**
     * 测试removeContextListener
     */
    @Test
    public void testRemoveContextListener1() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        handler.setCommandHandler(new SimpleCommandHandler());
        CommandContextListener listener = new SimpleContextListener();
        handler.addContextListener(listener);
        assertEquals(1, handler.getContextListeners().size());

        handler.removeContextListener(listener);
        assertEquals(0, handler.getContextListeners().size());
    }

    /**
     * 测试removeContextListener
     */
    @Test
    public void testRemoveContextListener0() throws Exception
    {
        SimpleProtocolHandler handler = new SimpleProtocolHandler();
        CommandContextListener listener = new SimpleContextListener();
        handler.removeContextListener(listener);
        handler.removeContextListener(null);
    }

}
