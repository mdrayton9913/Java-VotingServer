import java.io.*;
import java.net.*;

/**
 * This module contains the presentaton logic of an Echo Client.
 * @author M. L. Liu
 */
public class VotingClient {
   static final String endMessage = ".";
   public static void main(String[] args) {
      InputStreamReader is = new InputStreamReader(System.in);
      
      BufferedReader br = new BufferedReader(is);
      try {
         System.out.println("Welcome to the Echo client.\n" +
                            "What is the name of the server host?");
         String hostName = br.readLine();
         if (hostName.length() == 0) // if user did not enter a name
            hostName = "localhost";  //   use the default host name
         System.out.println("What is the port number of the server host?");
         String portNum = br.readLine();
         if (portNum.length() == 0)
            portNum = "7";          // default port number
         System.out.println("Please enter your vote:" + "\r\n" + "Yes: 1" + "\r\n" + "No: 2" + "\r\n" + "Don't Care: 3");
         MyStreamSocket mySocket = new MyStreamSocket(hostName, Integer.parseInt(portNum));
         InetAddress serverAddress = InetAddress.getByName(hostName);
         String vote = br.readLine();
         mySocket.sendMessage(vote);
         System.out.println(mySocket.receiveMessage());
         System.out.println("Thank you for your vote!");
         /*mySocket.sendMessage(serverAddress, Integer.parseInt(portNum), "");
         String message = mySocket.receiveMessage();
         System.out.println(message);
         String vote = br.readLine();
         mySocket.sendMessage(serverAddress, Integer.parseInt(portNum), vote);
         System.out.println(mySocket.receiveMessage());
         vote = br.readLine();
         mySocket.sendMessage(serverAddress, Integer.parseInt(portNum), vote);
         message = mySocket.receiveMessage();
         System.out.println(message);
         vote = br.readLine();
         int response = Integer.parseInt(vote);
         mySocket.sendMessage(serverAddress, Integer.parseInt(portNum), String.
                                valueOf(response));
         //message = mySocket.receiveMessage();*/
         } // end try  
      catch (Exception ex) {
         ex.printStackTrace( );
      } // end catch
   } //end main
} // end class      
