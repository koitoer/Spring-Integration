package com.koitoer.spring.webservice.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
public class DateUtils {

	public static XMLGregorianCalendar convertDate(final Date serviceDate) {
		final GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(serviceDate);
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		}
		catch (final DatatypeConfigurationException e) {
			throw new RuntimeException();
		}
	}

	public static Date toDate(final XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return null;
		}
		return calendar.toGregorianCalendar().getTime();
	}
}
