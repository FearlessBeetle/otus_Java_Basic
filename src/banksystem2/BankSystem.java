package banksystem2;

import java.util.*;


class BankSystem {
    private Map<Client, Account> clientAccountHashMap = new HashMap<>();
    private LinkedList<String> clientDataQueue = new LinkedList<>();

    public void fillData(Scanner user) {
        try {
            System.out.println("Введите имя клиента и возраст клиента");
            if (user.hasNextLine()) {
                clientDataQueue.addLast(user.nextLine());
                clientDataQueue.addLast(user.nextLine());
                System.out.println("Введите номер счёта и сумму вклада");
                clientDataQueue.addLast(user.nextLine());
                clientDataQueue.addLast(user.nextLine());
            } else throw new MyOwnException("Некорректное значение на входе");
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createClient() {
        try {
            Client tempClient = new Client(
                    clientDataQueue.pollFirst(),
                    Integer.parseInt(
                            clientDataQueue.pollFirst()));
            if (!tempClient.isCorrectAge()) {
                System.out.println("Клиент не может быть зарегистрирован.");
                return;
            }
            Account tempAccount = new Account(
                    Integer.parseInt(
                            clientDataQueue.pollFirst()),
                    Integer.parseInt(
                            clientDataQueue.pollFirst()));
            clientAccountHashMap.put(tempClient, tempAccount);
        } catch (MyOwnException | NullPointerException | NumberFormatException e) {
            System.out.println("Клиент не может быть зарегистрирован "
                    + "\nНомер счёта и размер вносимых средств не могут быть отрицательными");
        }
    }

    public void showClients() {
        System.out.println(clientAccountHashMap.keySet());
    }

    public void addNewAcc(String name, int age, int numberOfAcc, int value) {
        try {
            Client tempClient = new Client(name, age);
            clientAccountHashMap.get(tempClient).
                    setAccounts(numberOfAcc, value);
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Такого клиента не существует");
        }
    }

    public List<Integer> getAccounts(String name, int age) {
        try {
            Client tempClient = new Client(name, age);
            return new ArrayList<>(clientAccountHashMap.
                    get(tempClient).
                    getAccounts().
                    keySet());
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();              // 3 способ значение возвращаем значение по умолчанию
        } catch (NullPointerException e) {
            System.out.println("Такого клиента не существует");
            return Collections.emptyList();
        }
    }

    public Client findClient(int accountNumber) {
        try {
            Set<Map.Entry<Client, Account>> tempSet = clientAccountHashMap.entrySet();
            for (Map.Entry<Client, Account> pair : tempSet) {
                if (pair.getValue().
                        getAccounts().
                        containsKey(accountNumber)) {
                    return pair.getKey();
                }
            }
            return null;
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
