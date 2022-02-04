package QuizInClasses;

import java.util.Scanner;

class User {
    private int userAnswer;

    void setUserAnswer(Scanner user) throws RuntimeException {
        if (user.hasNextInt()) {
            int answer = user.nextInt();
            if (answer <= 0) {
                throw new RuntimeException("Отрицательное значение");
            }
            userAnswer = answer;
        } else {
            throw new RuntimeException("Введённое значение не является числом");
        }
    }

    public int getUserAnswer() {
        return userAnswer;
    }
}
