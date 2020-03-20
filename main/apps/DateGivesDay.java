package main.apps;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*; 

public class DateGivesDay 
{

	public static String dateGivesDayMain(int date, int month, int year)
	{
		Calendar c; 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String res = "";
		int day;

		try
		{
            
				Date d = formatter.parse( (String.format( "%d/%d/%d",date,month,year ) ) );
								
				c = Calendar.getInstance();
				c.setTime(d);
				
				day = c.get(Calendar.DAY_OF_WEEK);

				if (day == Calendar.SUNDAY)
					res = "Sunday";

				else if (day == Calendar.MONDAY)
					res = "Monday";
			
				else if (day == Calendar.TUESDAY)
                    res = "Tuesday";
            
				else if (day == Calendar.WEDNESDAY)
                    res = "Wednesday";
           
				else if (day == Calendar.THURSDAY)
					res = "Thursday";
            
				else if (day == Calendar.FRIDAY)
					res = "Friday";
            
				else if (day == Calendar.SATURDAY)
					res = "Saturday";
				
		}
	
		catch(NoSuchElementException e)
		{
			System.out.println("NoSuchElementException");
		}
	
		catch (ParseException e1)
		{
			System.out.println("invalid date");
		}
	
		return res;

	}
	
}