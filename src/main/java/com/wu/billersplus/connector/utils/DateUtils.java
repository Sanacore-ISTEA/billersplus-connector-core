package com.wu.billersplus.connector.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author ogagli
 *
 */
public class DateUtils {

	public final static String yyyyddMMHHmmss = "yyyy-MM-dd HH:mm:ss";
	public final static String HHmmss = "HHmmss";
	public final static String yyyyddMM = "yyyyMMdd";
	public static final String FORMAT_YYYYMMDD_HHMMSS = "yyyyMMddHHmmss";

	/***
	 *
	 * @param data
	 * @return
	 */
	public static String getHora(DateTime data) {
		DateTimeFormatter hora = DateTimeFormat.forPattern(HHmmss);
		return hora.print(data);
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public static String getFecha(DateTime data) {
		DateTimeFormatter hora = DateTimeFormat.forPattern(yyyyddMM);
		return hora.print(data);
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public static String getFechaHora(DateTime data) {
		DateTimeFormatter hora = DateTimeFormat.forPattern(yyyyddMMHHmmss);
		return hora.print(data);
	}

	/**
	 * Crea un XMLGregorianCalendar partiendo de un date en formato string.
	 *
	 * @param dateTime
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlGregorianCalendar(Date dateTime) {

		XMLGregorianCalendar xmlCal = null;
		try {

			GregorianCalendar cal = dateToCalendar(dateTime);
			xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}

		return xmlCal;
	}

	/**
	 * Convierte una date a GregorianCalendar
	 *
	 * @param dateTime
	 * @return
	 */
	public static final GregorianCalendar dateToCalendar(Date dateTime) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dateTime);

		// Hay que crear otro nuevo calendar porque trae problemas al aplicar el
		// timezone.
		GregorianCalendar cal2 = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND));
		cal2.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));

		return cal2;
	}

	/**
	 * Convierte un String en un Date.
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parse(String date, String pattern) {

		SimpleDateFormat dFormat = new SimpleDateFormat(pattern);
		dFormat.setLenient(true);
		Date datetmp = null;
		try {

			datetmp = dFormat.parse(date);

		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return datetmp;
	}

	/**
	 *
	 * @param data
	 * @param timeZone
	 * @return
	 */
	public static DateTime getDataTimeZone(DateTime data, String timeZone) {
		if (timeZone != null)
			return data.toDateTime(DateTimeZone.forID(timeZone));
		else
			return data;
	}

}
