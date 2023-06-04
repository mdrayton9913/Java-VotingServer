# Java-VotingServer

The Voting Server is a Java program that listens for client connections and handles voting sessions. It allows multiple clients to connect simultaneously and submit their votes.

## Usage

To run the Voting Server, follow these steps:

1. Compile the Java source file:
   ```
   javac VotingServer.java
   ```

2. Run the server:
   ```
   java VotingServer [port]
   ```

   - The `port` argument is optional. If provided, it specifies the port number on which the server should listen for incoming connections. If not provided, the server will use the default port `7`.

3. The server will display a message indicating that it is waiting for connections:
   ```
   Waiting for a connection.
   ```

4. Clients can now connect to the server and start voting.

## Functionality

- The server listens for incoming connections using a `ServerSocket`.
- Once a client connects, the server creates a `MyStreamSocket` to handle the communication with that client.
- A new thread is started to handle the client's voting session independently. This allows multiple clients to vote concurrently.
- The server continues to listen for new connections in an infinite loop.
- Any errors that occur during the execution of the server are caught and printed to the console.

## Customization

- The default port number is set to `7`. You can change the default port by modifying the `serverPort` variable in the `main` method of `VotingServer`.
- The server can be customized further by extending the `VotingServerThread` class and implementing the desired behavior for handling client sessions.

## Dependencies

- The Voting Server requires Java Development Kit (JDK) to compile and run.

Feel free to modify the code and adapt it to your specific requirements.

Enjoy using the Voting Server!
