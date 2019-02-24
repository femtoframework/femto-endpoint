package org.femtoframework.io.ser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 对象反串行化器（用于对某一类对象的反串行化）
 * <p/>
 *
 * @author fengyun
 * @version 1.00 2004-8-2 13:33:44
 */
public interface ObjectDeserializer
    extends Serializable
{
    /**
     * 输出对象
     *
     * @param ois       对象输入流
     * @param className 类名
     * @throws IOException
     */
    public Object demarshal(ObjectInputStream ois, String className)
        throws IOException, ClassNotFoundException;

    /**
     * 输出对象
     *
     * @param ois   对象输入流
     * @param clazz 类
     * @throws IOException
     */
    public Object demarshal(ObjectInputStream ois, Class clazz)
        throws IOException, ClassNotFoundException;
}
