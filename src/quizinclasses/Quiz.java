package quizinclasses;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {
            QuizEngine quiz = new QuizEngine();
            quiz.startQuiz(user);
        }

    }
}
