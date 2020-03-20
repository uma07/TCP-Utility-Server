package main.apps;

import java.util.*;
import java.lang.*;
import java.lang.Math.*;

public class PfCalculator
{
		
	public static double EvaluationOfPostFixCalc(Queue<String> q)
	{
		Double result = new Double(0);
		Stack<String> s = new Stack<String>();
		double operand1,operand2;
		int op1,op2;
		Integer res = new Integer(0);
		
		while(q.isEmpty() != true)
		{
			try
			{
				if((q.element()).equals("+"))
				{
					operand2 = Double.parseDouble(s.pop());
					operand1 = Double.parseDouble(s.pop());
					result = (Double)operand1 + operand2;
					s.push(result.toString());
					q.remove();
				}
				
				else if((q.element()).equals("-"))
				{
					operand2 = Double.parseDouble(s.pop());
					operand1 = Double.parseDouble(s.pop());
					result = (Double)operand1 - operand2;
					s.push(result.toString());
					q.remove();
				}
				
				else if((q.element()).equals("*"))
				{
					operand2 = Double.parseDouble(s.pop());
					operand1 = Double.parseDouble(s.pop());
					result = (Double)operand1 * operand2;
					s.push(result.toString());
					q.remove();
				}
				
				else if((q.element()).equals("/"))
				{
					operand2 = Double.parseDouble(s.pop());
					operand1 = Double.parseDouble(s.pop());
					result = (Double)operand1 / operand2;
					s.push(result.toString());
					q.remove();
				}
				
				else if((q.element()).equals("%"))
				{
					op2 = Integer.parseInt(s.pop());
					op1 = Integer.parseInt(s.pop());
					res = (Integer)op1 % op2;
					s.push(res.toString());
					q.remove();
				}
				
				else if((q.element()).equals("^"))
				{
					operand2 = Double.parseDouble(s.pop());
					operand1 = Double.parseDouble(s.pop());
					//System.out.println(result);
					result = (Double) Math.pow(operand1,operand2);
					s.push(result.toString());
					q.remove();
				}
				
				else
					s.push(q.poll());
			}
			
			catch(EmptyStackException e1)
			{
				System.out.println("Error !!! Incorrect input !!!");
				result = 0.0;
				return 0.0;
			}
			
			catch(NumberFormatException e2)
			{
				System.out.println("Error(e2) !!! Incorrect input format!!!");
				result = 0.0;
				return 0.0;
			}
		}
		
		try
		{
			result = Double.parseDouble(s.pop());
			if(s.isEmpty() == true)
				return result;
			else
				throw new Exception();
		}
		
		catch(NumberFormatException e3)
		{
			System.out.println("Error(e3) !!! Incorrect input format!!!");
			result = 0.0;
			return 0.0;
		}
		
		catch(Exception e)
		{
			System.out.println("Error !!! Invalid input");
			result = 0.0;
			return 0.0;
		}
			
	}

}