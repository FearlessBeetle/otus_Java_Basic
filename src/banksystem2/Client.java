package banksystem2;

import java.util.Objects;


class Client {
    private String name;
    private int age;
    private boolean isCorrectAge = true;

    public Client(String name, int age) {
        try {  // Использование try с ресурсами
            if (name == null || name.equals("")) {
                throw new MyOwnException("Некорректное значение для имени");
            } else {
                this.name = name;                                                   // 1 способ
            }                                                                       // выводим ошибку в консоль
            if (age < 18) {
                isCorrectAge = false;
                throw new MyOwnException("Клиент слишком молод");
            } else {
                this.age = age;
            }
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isCorrectAge() {
        return isCorrectAge;
    }

    @Override
    public boolean equals(Object anotherClient) {
        if (this == anotherClient) return true;
        if (anotherClient == null || getClass() != anotherClient.getClass()) return false;
        Client client = (Client) anotherClient;
        return age == client.age &&
                name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Клиент банка {" +
                "Имя клиента =" + name + '\'' +
                ", Возраст клиента =" + age +
                '}';
    }
}
