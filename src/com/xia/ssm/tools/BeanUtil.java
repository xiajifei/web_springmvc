package com.xia.ssm.tools;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * Title: 把model转化为entity
 * </p>
 * 
 * @author xjf
 * @version 1.0
 */

public class BeanUtil {

	static final Log log = LogFactory.getLog(BeanUtil.class);

	// 把model转化为entity
	/**
	 * @param dest
	 *            目标对象 将要复制的对象
	 * @param src
	 *            源对象 提供复制数据的对象
	 */
	public static void copy(Object dest, Object src) {
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			log.error(e.toString());
			throw new RuntimeException("复制属性时发生错误!");
		}
	}

	/**
	 * @param dest
	 *            目标对象 将要复制的对象
	 * @param src
	 *            源对象 提供复制数据的对象
	 * @deprecated(如果目标对象的属性为空，进行copy；如果目标对象的属性不空，不进行copy。)
	 */
	public static void copyProperties(Object dest, Object orig)
			throws IllegalAccessException, InvocationTargetException {
		int i;
		String name;
		Object value;
		if (dest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}

		if (orig == null)
			throw new IllegalArgumentException("No origin bean specified");

		if (log.isDebugEnabled()) {
			log.debug("BeanUtils.copyProperties(" + dest + ", " + orig + ")");
		}

		if (orig instanceof DynaBean) {
			DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass()
					.getDynaProperties();

			for (i = 0; i < origDescriptors.length; ++i) {
				name = origDescriptors[i].getName();
				if (PropertyUtils.isWriteable(dest, name)) {
					value = ((DynaBean) orig).get(name);
					if (value != null) {
						BeanUtils.copyProperty(dest, name, value);
					}
				}
			}
		} else if (orig instanceof Map) {
			Iterator names = ((Map) orig).keySet().iterator();
			while (names.hasNext()) {
				name = (String) names.next();
				if (PropertyUtils.isWriteable(dest, name)) {
					value = ((Map) orig).get(name);
					if (value != null) {
						BeanUtils.copyProperty(dest, name, value);
					}
				}
			}
		} else {
			PropertyDescriptor[] origDescriptors = PropertyUtils
					.getPropertyDescriptors(orig);

			for (i = 0; i < origDescriptors.length; ++i) {
				name = origDescriptors[i].getName();
				if ("class".equals(name))
					continue;

				if ((PropertyUtils.isReadable(orig, name))
						&& (PropertyUtils.isWriteable(dest, name)))
					try {
						value = PropertyUtils.getSimpleProperty(orig, name);
						if (value != null) {
							BeanUtils.copyProperty(dest, name, value);
						}
					} catch (NoSuchMethodException e) {
					}
			}
		}
	}
}
