package QuizInClasses;

import java.util.Scanner;

class QuizEngine {
    User user1 = new User();
    Questions questions1 = new Questions();
    OptionsOfAnswers optionsOfA1 = new OptionsOfAnswers();
    Result resultOfQuiz = new Result();

    public void startQuiz(Scanner user){
        try {
            for (int i = 0; i < questions1.getQUESTIONS().length; i++) {
                questions1.showQuestion(i);
                optionsOfA1.showOptions(i);
                user1.setUserAnswer(user);
                resultOfQuiz.compareAnswersAndIndexes(
                        i,
                        user1.getUserAnswer(),
                        optionsOfA1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не существующий вопрос или вариант ответа");
        } catch (RuntimeException e) {
            System.out.println("Введённое значение отрицательное или не является числом." +
                    "\n Викторина окончена!");
        } finally {
            resultOfQuiz.showResult(optionsOfA1.getIndexOfCorrectAnswersArray());
            resultOfQuiz.reset();
        }
    }
}
