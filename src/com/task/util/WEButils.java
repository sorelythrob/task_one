package com.task.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WEButils {
	
	
	public static<T> T params2bean(HttpServletRequest request,T t) {
		
//		//可以设置单个属性
//		BeanUtils.setProperty(bean, name, value);
		try {
			BeanUtils.populate(t, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
		
	}
	

}
