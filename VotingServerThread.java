import java.io.*;

/**
 * This module contains the application logic of an echo server
 * which uses a connectionless datagram socket for interprocess 
 * communication.
 * A command-line argument is required to specify the server port.
 * @author M. L. Liu
 */
 class VotingServerThread implements Runnable{
   static final String endMessage = ".";
   MyStreamSocket myDataSocket;

   VotingServerThread(MyStreamSocket myDataSocket) {
      this.myDataSocket = myDataSocket;
   }
    public static int yesCount = 0;
    public static int noCount = 0;
    public static int dontCareCount = 0;
   public void run() {
     //StringBuilder m = new StringBuilder();
     String message, response;
     try {
       message = myDataSocket.receiveMessage();
       switch(message){
       case "1": yesCount++;
                 myDataSocket.sendMessage("Yes votes: " + yesCount);
                 break;
       case "2": noCount++;
                 myDataSocket.sendMessage("No votes: " + noCount);
                 break;
       case "3": dontCareCount++;
                 myDataSocket.sendMessage("Don't Care votes: " + dontCareCount);
                 break;
     }
       //m.append("Yes votes: " + yesCount + "\r\n");
       //m.append("Yes votes: " + noCount + "\r\n");
      // m.append("Yes votes: " + dontCareCount + "\r\n");
       } // end try
     catch (Exception ex) {
          ex.printStackTrace( );
     } // end catch
   } //end main
} // end class 

