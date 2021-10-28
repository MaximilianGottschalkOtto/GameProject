import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        /**
         * LOGIK
         */
        try {
            Connection connection = new Connection();
            System.out.println("===============<========>=================");
            System.out.println("Möchtest du das Spiel starten? (JA/NEIN)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            connection.send(input);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Connection {
        private final BufferedReader bufferedReader;
        private final BufferedWriter bufferedWriter;

        public Connection() throws IOException {

            Socket socket = new Socket("localhost", 44444);
            InputStream in = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            this.bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            this.bufferedWriter = new BufferedWriter(outputStreamWriter);
        }


        String send(String msg) throws IOException {
            System.out.println("[Client] To Server: " + msg);
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            String response = bufferedReader.readLine();
            System.out.println("[Client] From Server: " + response);
            return response;
        }
    }
}
