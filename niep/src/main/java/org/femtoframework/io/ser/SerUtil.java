package org.femtoframework.io.ser;

import org.femtoframework.implement.ImplementUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 串行化工具类
 *
 * @author fengyun
 * @version 1.00 2005-2-8 16:58:06
 */
public class SerUtil
{
    private static Map<String, ObjectSerializerFactory> serFactories =
        new HashMap<>();
    private static Map<String, ObjectDeserializerFactory> desFactories =
        new HashMap<>();

    /**
     * 根据编码和解码方式返回对象串行化工厂
     *
     * @param codec 编码和解码方式
     * @return
     */
    public static ObjectSerializerFactory getSerializerFactory(String codec)
    {
        ObjectSerializerFactory factory = serFactories.get(codec);
        if (factory == null) {
            factory = ImplementUtil.getInstance(codec, ObjectSerializerFactory.class);
            if (factory != null) {
                serFactories.put(codec, factory);
            }
        }
        return factory;
    }

    /**
     * 根据编码和解码方式返回对象串行化工厂
     *
     * @param codec 编码和解码方式
     * @return
     */
    public static ObjectDeserializerFactory getDeserializerFactory(String codec)
    {
        ObjectDeserializerFactory factory = desFactories.get(codec);
        if (factory == null) {
            factory = ImplementUtil.getInstance(codec, ObjectDeserializerFactory.class);
            if (factory != null) {
                desFactories.put(codec, factory);
            }
        }
        return factory;
    }
}
