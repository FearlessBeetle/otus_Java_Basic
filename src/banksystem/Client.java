package banksystem;

import java.util.Objects;

class Client {
    private String name;
    private int age;
    private final Account accountOfThisClient = new Account(
            (int) (Math.random() * this.hashCode()),  // K рандомный ключ - номер первого счёта клиента
            (int) (Math.random() * 5000));            // V количество денег внесённое на первый счёт

    public Client(String name, int age) {
            if (name == null || name.equals("")) {
                System.out.println("Вместо имени клиента введено некорректное значение");
            } else {
                this.name = name;
            }
            if (age < 18) {
                throw new RuntimeException("Ваш возраст не соответствует минимальным требованиям");
            } else {
                this.age = age;
            }
    }

    public Account getAccountOfThisClient() {
        return accountOfThisClient;
    }

    @Override
    public boolean equals(Object anotherClient) {
        if (this == anotherClient) return true;
        if (anotherClient == null || getClass() != anotherClient.getClass()) return false;
        Client client = (Client) anotherClient;
        return age == client.age &&
                name.equals(client.name) &&
                accountOfThisClient.equals(client.accountOfThisClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, accountOfThisClient);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
