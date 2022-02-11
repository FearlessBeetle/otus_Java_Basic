package quizinclasses;

class Result {
    private int numberOfCorrectAnswers = 0;
    private int numberOfBadAnswers = 0;
    private int numberOfNonAnswered = 0;

    void compareAnswersAndIndexes(int indexForCompare, int userAnswer, OptionsOfAnswers optionsArray) {
        if (userAnswer == optionsArray.getIndexOfCorrectAnswersArray()[indexForCompare]) {
            System.out.println("Вы ответили правильно!");
            numberOfCorrectAnswers++;
        } else if (userAnswer > optionsArray.getLengthOfOptions(indexForCompare)) {
            System.out.println("Ваш ответ выходит за рамки вариантов! " +
                    "\n и будет засчитан как неправильный.");
            numberOfBadAnswers++;
        } else {
            System.out.println("Ваш ответ неправильный.");
            numberOfBadAnswers++;
        }
        numberOfNonAnswered = optionsArray.getIndexOfCorrectAnswersArray().length -
                    (numberOfCorrectAnswers + numberOfBadAnswers);
    }

    void showResult(int[] array) {
        if ((numberOfCorrectAnswers + numberOfBadAnswers) == 0) {
            numberOfNonAnswered = array.length;
        }
        System.out.printf("Число ваших правильных ответов :%d" +
                        "\n Число ваших ошибок :%d" +
                        "\n Число вопросов без ответа :%d ",
                numberOfCorrectAnswers,
                numberOfBadAnswers,
                numberOfNonAnswered);
    }

    void reset() {
        this.numberOfCorrectAnswers = 0;
        this.numberOfBadAnswers = 0;
        this.numberOfNonAnswered = 0;
    }
}
