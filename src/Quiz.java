import java.util.Scanner;

public class Quiz {
    private static final String[] QUESTIONS = new String[]{
            "Кем был создан Linux?",
            "Сколько весит объект класса Integer в 64-х разрядной системе?",
            "Что не входит в содержание объекта String в памяти?"
    };
    private static final String[][] ANSWERS = new String[][]{
            {"Говардом Стенфордом?", "Мэтью Линуксом?",
                    "Линусом Торвальдсом?", "Хью Грантом?"},
            {"16 байт", "8 байт", "32 байта", "24 байта"},
            {"Заголовок объекта", "Память для примитивного типа",
                    "Память для ссылочного типа", "Коэффицент вариации"}
    };
    private static final int[] INDEX_OF_CORRECT_ANSWERS = new int[]{3, 4, 4};
    private static int indexOfQuestion = 0;
    private static int counterOfCorrectAnswers = 0;

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }

    public void startQuiz() {
        try {
            for (int i = 0; i < QUESTIONS.length; i++) {
                showQuestion();
                showAnswers();
                checkAnswer(getUserAnswer());
            }
            checkResult();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы ввели отрицательное число, Викторина окончена!");
        } finally {
            restartCounters();
        }
    }

    private int getUserAnswer() {
        Scanner user = new Scanner(System.in);
        if (user.hasNextInt()) {
            return user.nextInt();
        } else {
            System.out.println("Введённое значение не является числом, попробуйте ещё раз!");
            System.out.println("Если хотите прервать Викторину, введите отрицательное число.");
            return 0;
        }
    }

    private void showQuestion() {
        System.out.println(QUESTIONS[indexOfQuestion]);
    }

    private void showAnswers() {
        for (int i = indexOfQuestion; i < indexOfQuestion + 1; i++) {
            for (int j = 0; j < ANSWERS[i].length; j++) {
                String answers = String.format("%d. %s", j + 1, ANSWERS[i][j]);
                System.out.println(answers);
            }
        }
    }

    private void checkAnswer(int userAnswer) {
        if (userAnswer < 0) {
            indexOfQuestion = QUESTIONS.length;
        }
        if (userAnswer == 0) {
                checkAnswer(getUserAnswer());
        } else {
            if (userAnswer == INDEX_OF_CORRECT_ANSWERS[indexOfQuestion]) {
                System.out.println("Ваш ответ правильный!");
                counterOfCorrectAnswers++;
            } else {
                System.out.println("Ваш ответ не является верным!");
            }
            indexOfQuestion++;
        }
    }

    private void checkResult(){
        if (counterOfCorrectAnswers != 3) {
            System.out.printf("Вы ответили правильно на %d вопросов! У вас %d ошибок.",
                    counterOfCorrectAnswers, 3 - counterOfCorrectAnswers);
        } else {
            System.out.println("Вы ответили правильно на все вопросы, вы молодец!");
        }
    }

    private void restartCounters(){
        indexOfQuestion = 0;
        counterOfCorrectAnswers = 0;
    }
}
