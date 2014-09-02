package com.gurps.newstuff.datetime;

import static org.junit.Assert.*;

import java.util.Date;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.Test;

public class DateTimeTest {

	@Test
	/**
	 * Converts a old Date object in the old API to 
	 * a new Instant object in the new API.
	 */
	public void testDateFormatting() {
		Date d = Calendar.getInstance().getTime();
		Instant dateInstant = d.toInstant();
		
		LocalDate currentDate = LocalDate.now();
		 
		// 2014-02-10
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
		 
		// months values start at 1 (2014-08-01)
		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
		 
		// the 65th day of 2010 (2010-03-06)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
		
		Month february = currentDate.getMonth(); // FEBRUARY
		int februaryIntValue = february.getValue(); // 2
		int minLength = february.minLength(); // 28
		int maxLength = february.maxLength(); // 29
		Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY
		 
		// information about the year
		int year = currentDate.getYear(); // 2014
		int dayOfYear = currentDate.getDayOfYear(); // 46
		int lengthOfYear = currentDate.lengthOfYear(); // 365
		boolean isLeapYear = currentDate.isLeapYear(); // false
		 
		DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
		int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
		String dayOfWeekName = dayOfWeek.name(); // SATURDAY
		 
		int dayOfMonth = currentDate.getDayOfMonth(); // 15
		LocalDateTime startOfDay = currentDate.atStartOfDay(); // 2014-02-15 00:00
		 
		// time information
		LocalTime time = LocalTime.of(15, 30); // 15:30:00
		int hour = time.getHour(); // 15
		int second = time.getSecond(); // 0
		int minute = time.getMinute(); // 30
		int secondOfDay = time.toSecondOfDay(); // 55800
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				LocalDate date = LocalDate.parse("24/06/2014", f);
				String str = date.format(f);
				System.out.println(str);
	}

}
