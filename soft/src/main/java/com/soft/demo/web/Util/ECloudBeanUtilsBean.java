package com.soft.demo.web.Util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by shencydel on 2018/3/18.
 */
public class ECloudBeanUtilsBean extends BeanUtilsBean {
    private ECloudBeanUtilsBean() {

    }
    public static ECloudBeanUtilsBean getInstance() {
        return BEANS_BY_CLASSLOADER.get();
    }

    private static final ContextClassLoaderLocal<ECloudBeanUtilsBean>
            BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<ECloudBeanUtilsBean>() {
        // Creates the default instance used when the context classloader is unavailable
        @Override
        protected ECloudBeanUtilsBean initialValue() {
            return new ECloudBeanUtilsBean();
        }
    };

    private String[] excludeFiledName;

    public void copyProperties(Object dest, Object orig, String... excludeFiledName) throws IllegalAccessException, InvocationTargetException {
        this.excludeFiledName = excludeFiledName;
        super.copyProperties(dest, orig);
        this.excludeFiledName = null;
    }

//    @Override
//    public void copyProperty(Object bean, String name, Object value) throws IllegalAccessException, InvocationTargetException {
//        if (value != null) {
//            if (!ArrayUtils.contains(excludeFiledName, name)) {
//                super.copyProperty(bean, name, value);
//            }
//        }
//    }

//    @Override
//    protected Object convert(Object sourceValue, Class<?> targetClass) {
//        if(ConfMediaType.class.isAssignableFrom(targetClass)) {
//            return ConfMediaType.fromValue(sourceValue.toString());
//        }
//        return super.convert(sourceValue, targetClass);
//    }

}
