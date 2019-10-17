package com.stefanini.hackaton.annotations;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import com.stefanini.hackaton.rest.exceptions.NegocioException;

public abstract class AbstractValidation {

	public static void valid(Object obj) throws IllegalArgumentException, 
		IllegalAccessException, NegocioException {
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			NotNull annotation = field.getAnnotation(NotNull.class);
			
			field.setAccessible(true);
			
			Object valor = field.get(obj);
			
			field.setAccessible(false);
			
			if (annotation != null && valor == null) {
				throw new NegocioException(
						MessageFormat.format("Campo {0} é obrigatório!", field.getName()));
			}
		}
		
	}	
}
