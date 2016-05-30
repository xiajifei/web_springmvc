package com.xia.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String sourse) {
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return sdf.parse(sourse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
