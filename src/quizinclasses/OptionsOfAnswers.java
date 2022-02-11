package quizinclasses;

class OptionsOfAnswers {
    private final String[][] ANSWERS = new String[][]{
            {"Говардом Стенфордом?", "Мэтью Линуксом?",
                    "Линусом Торвальдсом?", "Хью Грантом?"},
            {"16 байт", "8 байт", "32 байта", "24 байта"},
            {"Заголовок объекта", "Память для примитивного типа",
                    "Память для ссылочного типа", "Коэффицент вариации"}
    };
    private final int[] INDEX_OF_CORRECT_ANSWERS_ARRAY = new int[]{3, 4, 4};

    public int[] getIndexOfCorrectAnswersArray() {
        return INDEX_OF_CORRECT_ANSWERS_ARRAY;
    }
    public int getLengthOfOptions(int indexOfOptions) {
        return ANSWERS[indexOfOptions].length;
    }


    void showOptions(int indexOfOption) throws IndexOutOfBoundsException {
        if (indexOfOption < 0 || indexOfOption > ANSWERS[indexOfOption].length) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int j = 0; j < ANSWERS[indexOfOption].length; j++) {
                String answers = String.format("%d. %s", j + 1, this.ANSWERS[indexOfOption][j]);
                System.out.println(answers);
            }
        }
    }
}
