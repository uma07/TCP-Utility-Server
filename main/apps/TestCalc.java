package main.apps;

import java.util.*;
import java.util.Queue.*;
import main.utility.*;
import java.io.*;

public class TestCalc
{

	public static double postFixMain(PrintWriter out, BufferedReader r)
	{
		String Str;
		String ch;
		String[] tok;
		Double result = new Double(0);
		
		Queue<String> q = new LinkedList<String>();
		
		while(true)
		{
			try
			{
				
				out.println("Enter the post-fix expression (tokens separated by a space) : ");
				out.flush();
				
				Str = r.readLine();
								
				tok = Str.split(" ");	//is a regular expression that splits characters separated by one space

				int ind = 0;
				
				while(ind < tok.length)
				{
					if(tok[ind].toCharArray()[tok[ind].length()-1] == '.')
						throw new IllegalArgumentException() ;
					
					q.offer(tok[ind]);
					ind++;
				}
				
				result = PfCalculator.EvaluationOfPostFixCalc(q);
			}
			
			catch(IOException e)
			{
				System.out.println("Error !!! IOException has occurred");
			}
			
			catch(ArrayIndexOutOfBoundsException e1)
			{
				System.out.println("Error !!! Expression is missing");
				result = 0.0;
			}
			
			catch(NullPointerException e2)
			{
				System.out.println("Error !!! NULL pointer exception");
				result = 0.0;
			}
			
			catch(ClassCastException e3)
			{
				System.out.println("Error !!! Class Casting is incorrect");
				result = 0.0;
			}
			
			catch(IllegalArgumentException e4)
			{
				System.out.println("Error !!! Arguments are incorrect") ;
				result = 0.0;
			}
			
			//out.println("Final Result : " + result);
			//out.flush();
			
			return result;
			
		}
	
	}

}