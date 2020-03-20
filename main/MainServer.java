package main;

import java.net.*;
import java.io.*;

public class MainServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(4444);
		
			while(true)
			{	
				Socket s = ss.accept();
				TcpServer server = new TcpServer(s);
				server.start();
			}
		}
		
		catch(IOException e)
		{
			System.out.println("Error !!! IOException has occured");
			e.printStackTrace();
		}
	}

}