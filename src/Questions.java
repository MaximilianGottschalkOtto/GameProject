import java.security.SecureRandom;
import java.util.*;

public class Questions {

    private int score = 0;

    private String question;
    private String[] answer;
    private String solution;

    public Questions(String question, String[] answer, String solution) {
        this.question = question;
        this.answer = answer;
        this.solution = solution;
    }

    public Questions() {

    }

    public String getQuestion() {
        return question;
    }

    public void printAnswer() {
        for (String string: answer) {
            System.out.println(string);
        }
    }

    public String getSolution() {
        return solution;
    }


    public void questions() {
        int i = 0;
        QuizLogic quizLogic = new QuizLogic();
        List<Questions> list = new ArrayList<>();
        list.add(new Questions("Wann endete die Herrschaft der Habsburger? ", new String[]{"a)1918", "b)1923", "c)1916"}, "a"));
        list.add(new Questions("Wie groß ist Dresden? ?", new String[]{"a)287,7 km²", "b)200,2 km²", "c)328,8 km²"}, "c"));
        list.add(new Questions("Wie alt ist die Königin von England?", new String[]{"a)95", "b)96", "c)93"}, "a"));
        list.add(new Questions("Welches war das größte Königreich der Welt?", new String[]{"a)Das osmanische Reich ", "b)Das britische Imperium", "c) Das deutsche Kaiserreich"}, "b"));
        Collections.shuffle(list);
        Object[] string = list.toArray();

        for (Questions questions: list){
            while(i < quizLogic.numberOfRounds) {
                System.out.println(questions.getQuestion());
                questions.printAnswer();
                System.out.println("Typ your input here: ");
                String answerUser = QuizLogic.input();
                if (answerUser.equals(questions.getSolution())) {
                    System.out.println("---->Richtig! Du erhälst fünf Punkt.<-----");
                    score = score + 5;
                    System.out.println("Dein Score beträgt: " + score);

                } else {
                    System.out.println("---------------->Falsch<-------------------");
                    System.out.println("Dein Score beträgt: " + score);
                }
                i++;
                break;
            }
            System.out.println("DU HAST " + score + " PUNKTE ERREICHT!");
        }
    }
}


