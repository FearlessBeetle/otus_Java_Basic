package banksystem;


import java.util.Objects;

class Client {
    private String name;
    private int age;

    public Client(String name, int age) {
        if (name == null || name.equals("")){
            throw new WrongInputException("Введено некорректное Имя");
        } else { this.name = name;}

        if (age < 18 || age > 120) {
            throw new WrongInputException("Клиент слишком молод или слишком стар!");
        }else {this.age = age;}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return " Клиент - {" +
                "Имя клиента ='" + name + '\'' +
                ", возраст клиента =" + age +
                '}' +
                " ";
    }
}
