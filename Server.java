import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        if (args.length != 1) System.exit(1);
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getInetAddress());
                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                out.println("testing 123");
                out.close();
                clientSocket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
