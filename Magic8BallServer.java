import java.io.*;
import java.net.*;
import java.util.Random;

public class Magic8BallServer {
    private static final String[] RESPONSES = {
            "It is certain",
            "Reply hazy, try again",
            "Don’t count on it",
            "It is decidedly so",
            "Ask again later",
            "My reply is no",
            "Without a doubt",
            "Better not tell you now",
            "My sources say no",
            "Yes definitely",
            "Cannot predict now",
            "Outlook not so good",
            "You may rely on it",
            "Concentrate and ask again",
            "Very doubtful",
            "As I see it, yes",
            "Most likely",
            "Outlook good",
            "Yes",
            "Signs point to yes"
    };

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Requires 1 argument (port number) to run.");
            System.exit(1);
        }
        else if (Integer.parseInt(args[0]) < 1024) {
            System.out.println("Port number cannot be between 0-1023.");
            System.exit(1);
        }
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            while (true) {
                Socket clientSocket = serverSocket.accept();
                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                Random random = new Random();
                String response = RESPONSES[random.nextInt(RESPONSES.length)];
                out.println(response + " (" + InetAddress.getLocalHost().getHostAddress() + ")");
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
