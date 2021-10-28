import java.util.*;

public class QuizLogic {

    static int numberOfRounds;

    public static String input (){
        System.out.print("Deine Eingabe: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void start( String str ){
        if( str.equals("JA".toLowerCase()) ){
            System.out.println("Wie viele Runden willst du spielen? (1-20)");
            numberOfRounds = Integer.parseInt(input());
        }else if( str.equals("NEIN".toLowerCase())){
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
