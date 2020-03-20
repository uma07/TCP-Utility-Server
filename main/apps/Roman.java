package main.apps;

public class Roman
{
	public static String mainFunction(int num)
	{

			int n;
			String res = "";

			n = num/1000;

			if(n == 1)
				res = res + "M";

			else if(n == 2)
				res = res + "MM";

			else if(n == 3)
				res = res + "MMM";

			n = (num/100)%10;

			if(n == 9)
				res = res + "CM";

			else if(n>4 && n<9)
			{
				res = res + "D";
				while(n != 5)
				{
					res = res + "C";
					n--;
				}
			}


			else if(n == 4)
				res = res + "CD";

			else if(n>0 && n<4)
			{
				while(n > 0)
				{
					res = res + "C";
					n--;
				}
			}

			n = (num/10)%10;

			if(n == 9)
				res = res + "XC";

			else if(n>4 && n<9)
			{
				res = res + "L";
				while(n != 5)
				{
					res = res + "X";
					n--;
				}
			}


			else if(n == 4)
				res = res + "XL";

			else if(n>0 && n<4)
			{
				while(n > 0)
				{
					res = res + "X";
					n--;
				}
			}

			n = num%10;

			if(n == 9)
				res = res + "IX";

			else if(n>4 && n<9)
			{
				res = res + "V";
				while(n != 5)
				{
					res = res + "I";
					n--;
				}
			}

			else if(n == 4)
				res = res + "IV";

			else if(n>0 && n<4)
			{
				while(n > 0)
				{
					res = res + "I";
					n--;
				}
			}
			
			return res;

	}
}