package main;

import java.net.*;
import java.io.*;
import java.util.*;
import main.utility.*;

public class TcpClient
{

	public static void main(String []args)
	{
		try
		{
			String host = "localhost";
			byte[] addressBytes = new byte[] {(byte)10, (byte)0, (byte)3, (byte)160};
			InetAddress server = InetAddress.getByName(host);
			Socket s = new Socket(server, 4444);
		
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			String str = "",response = "";
			
			out.flush();

			while(true)
			{
				response =  r.readLine();
				System.out.println(response);
   
				while(!response.equals("-EOF-"))
				{
					response = r.readLine();
					System.out.println(response);
				}
  
				str = Validator.getString("Please enter your choice\n");
				out.println(str);
				out.flush();
     
				if(str.equalsIgnoreCase("bye") || str.equalsIgnoreCase("D"))    
				{
					response = r.readLine();
					System.out.println(response);
					break;
				}
    
				else if(str.equalsIgnoreCase("A") || str.equalsIgnoreCase("C"))
				{
					response = r.readLine();
					System.out.println(response);
 
					String temp =Validator.getString("");
					out.println(temp);
					out.flush();
				}
				
				 else if (str.equalsIgnoreCase("B") )
				 {
					int i = 0;
					response = r.readLine();
					System.out.println(response);
 
					while(i < 3)
					{
						String temp =Validator.getString("");
						out.println(temp);
						out.flush();
						i++;
					}
				 }

			}
			
			s.close();
		}
	
		catch(UnknownHostException e)
		{
			System.out.println("Sorry !!! Host is unknown.");
		}
	
		catch(IOException e1)
		{
			System.out.println("Sorry !!! IO-Exception has occured.");
		}
		
		catch(NullPointerException e2)
		{
			System.out.println("Sorry !!! Null-pointer Exception.");
		}
	
	}
}