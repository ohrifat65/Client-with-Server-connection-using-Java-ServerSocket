
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rifat
 */
public class Client {

    public Client() {
        try {
            Socket client = new Socket("localhost", 3100);
            System.out.println("Client server " + client.getInetAddress().getLocalHost().getHostAddress());
            System.out.println("Client connected");
            PrintStream out = new PrintStream(client.getOutputStream());
            out.print("Hello from Client Rifat \n");
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new Client();
    }
}
