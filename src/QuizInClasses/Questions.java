package QuizInClasses;

class Questions {
    private final String[] QUESTIONS = new String[]{
            "Кем был создан Linux?",
            "Сколько весит объект класса Integer в 64-х разрядной системе?",
            "Что не входит в содержание объекта String в памяти?"
    };

    public String[] getQUESTIONS() {
        return QUESTIONS;
    }

    void showQuestion (int indexOfQuestion) throws IndexOutOfBoundsException {
        if (indexOfQuestion < 0 || indexOfQuestion > QUESTIONS.length) {
            throw new IndexOutOfBoundsException();
        } else {
        System.out.println(QUESTIONS[indexOfQuestion]+ "\n");
        }
    }
}
