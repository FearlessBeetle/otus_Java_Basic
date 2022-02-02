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
    private static int userAnswer = 0;
    private static int indexOfQuestion = 0;
    private static int counterOfCorrectAnswers = 0;

    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {
            Quiz quiz = new Quiz();
            quiz.startQuiz(user);
        }
    }

    public void startQuiz(Scanner user) throws RuntimeException {
        try {
            for (int i = indexOfQuestion; i < QUESTIONS.length; i++) {
                showQuestion();
                for (int j = 0; j < ANSWERS[i].length; j++) {
                    String answers = String.format("%d. %s", j + 1, ANSWERS[i][j]);
                    System.out.println(answers);
                }
                setUserAnswer(user);
                checkAnswer();
                if (userAnswer <= 0) {
                    throw new RuntimeException();
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Введено неверное значение, Викторина окончена");
        } finally {
            checkResult();
            restartCounters();
        }
    }

    private void setUserAnswer(Scanner user) {
        if (user.hasNextInt()) {
            userAnswer = user.nextInt();
        } else {
            userAnswer = 0;
        }
    }

    private void showQuestion() {
        System.out.println(QUESTIONS[indexOfQuestion]);
    }

    private void checkAnswer() {
        if (userAnswer == INDEX_OF_CORRECT_ANSWERS[indexOfQuestion]) {
            System.out.println("Ваш ответ правильный!");
            counterOfCorrectAnswers++;
        } else {
            System.out.println("Ваш ответ не является верным!");
        }
        indexOfQuestion++;
    }

    private void checkResult() {
        if (counterOfCorrectAnswers != 3) {
            System.out.printf("Вы ответили правильно на %d вопросов! У вас %d ошибок.",
                    counterOfCorrectAnswers, 3 - counterOfCorrectAnswers);
        } else {
            System.out.println("Вы ответили правильно на все вопросы, вы молодец!");
        }
    }

    private void restartCounters() {
        indexOfQuestion = 0;
        counterOfCorrectAnswers = 0;
        userAnswer = 0;
    }
}
