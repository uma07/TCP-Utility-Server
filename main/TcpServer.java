package main;

import java.net.*;
import java.io.*;
import java.util.*;
import main.apps.*;
import main.utility.*;
import java.lang.Thread;

public class TcpServer extends Thread
{
	Socket s;
	
	TcpServer(Socket s1)
	{
		s = s1;
	}
	
	public void run()
	{
		try
		{
			String str = "", result = "";
			double res = 0.0;
			int date, month, year;
			
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String service = "Choose from the following options : \nA)Postfix Calculator(Enter 'A/a') \nB)Day of the given date(Enter 'B/b')\nC)Conversion of given number to roman(Enter 'C/c') \nD)Exit(Enter 'D/d')\n";
			out.println("HAI!\n" + service + "-EOF-");
			out.flush();
			
			while(!str.equalsIgnoreCase("-EOF-"))
			{
				str = r.readLine();
				System.out.println(str);

				switch(str)
				{
					case "A" :
					case "a" :
								res = TestCalc.postFixMain(out, r);
								out.println("Result for given postfix expression is : " + res + "\n-EOF-");
								out.flush();
								break;
					
					case "B" :
					case "b" :
								out.println("Enter the date, month and year in numbers respectively (date followed by ENTER, month by ENTER and year by ENTER): ");
								out.flush();
								date = Integer.parseInt( r.readLine() );
								month = Integer.parseInt( r.readLine() );
								year = Integer.parseInt( r.readLine() );
							
								result = DateGivesDay.dateGivesDayMain(date, month, year);
								out.println("Day on " + date + "-" + month + "-" + year + "is : " + result + "\n-EOF-");
								out.flush();
								break;
					
					case "C" :
					case "c" :
								out.println("Enter the integer(1-4000) : ");
								out.flush();
								int num = Integer.parseInt( r.readLine() );
								
								if(num >= 1 && num < 4000)
								{
									result = Roman.mainFunction(num);
									out.println("The roman number for " + num + "is : " + result + "\n-EOF-");
									out.flush();
								}
								
								else
								{
									out.println("Sorry !!! Range is from 1 to 4000");
									out.flush();
									str = "-EOF-";
								}
								
								break;
								
								
					case "D" :
					case "d" :
								out.println("Thank You for using our server and 'BYE'.\n\t\t\t-EOF-");
								out.flush();
								break;
								
					default  : 
								out.println("Sorry !!! There are only 3 options(A or B or C)");
								break;
				}
				
			}
			
			s.close();
		}
		
		catch(java.net.BindException e)
		{
			System.out.println("Sorry !!! Server is already in use");
		}
		
		catch(IOException e1)
		{
			System.out.println("Sorry !!! IOException has occured");
			e1.printStackTrace();
		}
		
		catch(java.lang.NullPointerException e3)
		{
			System.out.println("Sorry !!! Null-pointer Exception has occured.");
		}
		
		catch(Exception e2)
		{
			System.out.println("Sorry !!! Invalid Input");
			e2.printStackTrace();
		}
		
	}

}