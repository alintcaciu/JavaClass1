import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
* <h1> TransferService </h1>
* The program implements an application that
* transfers a simple file from a Client to a Server in Java using
* Socket and BufferedStreams.
* * 
* <p>
*/
public class TransferService {

	public final static int FILE_SIZE = 99999999;
	
	/*
	 * This is the max size of reading from a file 
	 */
	
	
	public static class MyServer extends Thread
	{
		/*
		 * Public class implementing the Server using Threads
		 * initialize the Server object variables
		 *  
		 */
		
		Socket server = null; 
		
		ServerSocket serverSocket;
		
		private int serverPort = 0;
		
		File myFile = null;	
		byte [] mybytearray  = null;  
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
	    
		OutputStream os = null;
	    InputStream is = null;
	    
	    int bytesRead;
	    int current = 0;
	    
		public MyServer(int inputPort)
		{
			//public constructor sets the port for the Socket
			serverPort = inputPort;		
		
			{
		try
			{
			//initialize the Socket with port received
			serverSocket = new ServerSocket(serverPort);
			//Sets the Socket timeout at 40 seconds
			serverSocket.setSoTimeout(40000);		
			}
		
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
	
		}
	}
	
	public void run()
{
	while(true)
	{
	try
	{
		System.out.println("......................................................................");
		System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
		System.out.println("......................................................................");
		
		server = serverSocket.accept();
		// server is waiting for clients connections
		
	   
	   System.out.println("......................................................................");
	   System.out.println("Connected to " + server.getRemoteSocketAddress());
	   System.out.println("......................................................................");
	   
	   Scanner scanPath = new Scanner(System.in);
	   //read the file input from user using Scanner, this could be further exposed for both Client/Server
	   System.out.println("......................................................................");
	   System.out.println("Input the desired path and file name of the form: c:\\{folders}\\filename.txt");
	   System.out.println("......................................................................");
	   
	   String pathToSave = scanPath.nextLine();
	      
	   //setting buffer reading size
	     mybytearray  = new byte [FILE_SIZE];
	   
	     //read from the socket input stream
	      is = server.getInputStream();
	     
	      //Use the filepath from the user and sets the BufferedOutPutStream
	      
	      fos = new FileOutputStream(pathToSave);
	      bos = new BufferedOutputStream(fos);
	      
	    //read from the file and write to the output file
	      
	      bytesRead = is.read(mybytearray,0,mybytearray.length);
	      
	      current = bytesRead;
	   
	      do 	{
	          bytesRead =
	             is.read(mybytearray, current, (mybytearray.length-current));
	          if(bytesRead >= 0) current += bytesRead;
	       		}
	      while(bytesRead > -1);
	      
	      bos.write(mybytearray, 0 , current);
	      bos.flush();
	      
	      System.out.println("......................................................................");
	      System.out.println("File " + pathToSave + " downloaded (" + current + " bytes read)");
	      System.out.println("......................................................................");
	    	            
      
	}
	
	catch (IOException e) {
		e.printStackTrace();
		break;
	}
	
	}
	
}
	
	}
	
	public static class MyClient
	{
		private String clientHostname = "";
		private int clientPort = 0;
		
		
		
		public MyClient(String inputHostname, int inputPort)
		{	
			//Client will be using a Socket with hostname destination and connection port
			clientHostname = inputHostname;
			clientPort = inputPort;

			Socket clientSocket = null;
		    
			File myFile = null;
		    byte [] mybytearray;
		    
		    FileInputStream fis = null;
		    BufferedInputStream bis = null;
		    
		    OutputStream os = null;
		    
		    {
				try
				{
				clientSocket = new Socket(clientHostname, clientPort);
				System.out.println("......................................................................");
				System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
				System.out.println("......................................................................");
				
				   //read the file input from user using Scanner, this could be further exposed for both Client/Server
				 Scanner scanPath = new Scanner(System.in);
				   
				   System.out.println("......................................................................");
				   System.out.println("Input the desired path and file name of the form: c:\\{folders}\\filename.txt");
				   System.out.println("......................................................................");
				   
				   String pathToSave = scanPath.nextLine();
				      
			
				myFile = new File (pathToSave);
				
				//Initialized the file that will be used 
				mybytearray  = new byte [(int)myFile.length()];
				 fis = new FileInputStream(myFile);
		          bis = new BufferedInputStream(fis);
		          bis.read(mybytearray,0,mybytearray.length);
		          os = clientSocket.getOutputStream();
		          System.out.println("......................................................................");
		          System.out.println("Sending " + pathToSave + "(" + mybytearray.length + " bytes)");
		          System.out.println("......................................................................");
		          os.write(mybytearray,0,mybytearray.length);
		          os.flush();
		          System.out.println("......................................................................");
		          System.out.println("Done.");
		          System.out.println("......................................................................");
		          
				}
				
				catch (IOException e) {
					e.printStackTrace();
				}
				
				finally {
					try {
				     if (bis != null) 
				     {
				    	 bis.close();
				     }
					if (os != null)
						{
							os.close();
						}
					if (clientSocket != null)
						{
						clientSocket.close();
						}
					}
					catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				      
				    }
			}
		
		}
	
}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("......................................................................");
		System.out.println("for client press > c < " + " for server press > s <");
		System.out.println("......................................................................");
		Scanner inputString = new Scanner(System.in);
		
		String ImplementationOption = inputString.next(); 
		
		switch (ImplementationOption)
		{
		case "s" : 
		{
			System.out.println("......................................................................");
			System.out.println("Server here, specify the port for incoming connections ..");
			System.out.println("e.g. XYZT" + "\\n");
			System.out.println("......................................................................");
			
			int port = Integer.parseInt(inputString.next());
			try
			{
			Thread t = new MyServer(port);
		    t.start();
		    }
			catch(Exception e)
		     {
		         e.printStackTrace();
		         break;
		      }
		   break;	
		}
		
		case "c" :
		{
			System.out.println("......................................................................");
			System.out.println("Client here, specify hostname and the port for connecting to server..");
			System.out.println("e.g. localhost XYZT" +"\\n");
			System.out.println("......................................................................");
			String hostname = inputString.next();
			int port = Integer.parseInt(inputString.next());
			
			MyClient client = new MyClient(hostname, port);
									
			break;
		}
		
		}
	}

}


