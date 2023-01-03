
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Rifat
 */
public class Server {

    public void Server() {
        try {
            ServerSocket server = new ServerSocket(3100);
            System.out.println("Server bined at " + (server.getInetAddress().getLocalHost().getHostAddress() + ":3100"));
            System.out.println("Run the client...");
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
            PrintStream out = new PrintStream(socket.getOutputStream());
            System.out.print("Welcome to client server \n");
            out.flush();
            in.close();
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        new Server().Server();

    }
}
