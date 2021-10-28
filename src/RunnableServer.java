import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class RunnableServer implements Runnable {

    QuizLogic quizLogic = new QuizLogic();
    protected Socket clientSocket = null;


    public RunnableServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * THREAD FÜR SERVERSOCKET
     */

    @Override
    public void run() {
        while (true) {
            try {
                QuizLogik1 quizLogik1 = new QuizLogik1();
                while (true) {
                    InputStream in = clientSocket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(in);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    OutputStream out = clientSocket.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                    while (true) {
                        String msgFromClient = bufferedReader.readLine();
                        System.out.println("[SERVER] Msg from Client: " + msgFromClient);
                        bufferedWriter.write(response);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * LOGIK VOM GAME
     */

    class QuizLogik1 {
        static int numberOfRounds;

        public static String input() {
            System.out.print("Deine Eingabe: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return input;
        }

        public String start(String str) {
            if (str.equals("JA".toLowerCase())) {
                return "Wie viele Runden willst du spielen? (1-20)";
            } else if (str.equals("NEIN".toLowerCase())) {
                System.out.println("Programm schließt.");
                System.exit(0);
            }
        }

        public static void main(String[] args) {
            int i = 0;
            QuizLogic quizLogic = new QuizLogic();
            Questions questions = new Questions();

            System.out.println("===============<========>=================");
            System.out.println("Möchtest du das Spiel starten? (JA/NEIN)");
            String input = quizLogic.input();
            quizLogic.start(input);
            questions.questions();
        }
    }
}
