import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        if (args.length != 3) System.exit(1);
        try {
            Socket s = new Socket(args[0], args[1]);
            InputStream inputStream = s.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder("Magic 8 Ball says: ");
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            System.out.println(response);
        }
    }
}
