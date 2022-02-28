package banksystem;


public class BankLobby {
    public static void main(String[] args) {
        try {
            BankSystem otusBank = new BankSystem();
            Client cl1 = new Client("Пётр Иванов", 35);
            otusBank.addNewClient(cl1);
            Client cl2 = new Client("Александр Cидоров", 19);
            otusBank.addNewClient(cl2);
            Client cl3 = new Client("Иван Греков", 22);
            otusBank.addNewClient(cl3);
            Client cl4 = new Client("Василий Жданов", 51);
            otusBank.addNewClient(cl4);
            Client cl5 = new Client("Михаил Котиков", 70);
            otusBank.addNewClient(cl5);
            System.out.println("Количество клиентов =" +               //Коллекция наших клиентов
                    otusBank.getClients().size());
            System.out.println("Номера счётов клиента =" +               //Находим номера счетов выбранного клиента
                    otusBank.getAccounts(cl1));
            otusBank.createNewAccForClient(0, 10000); //Создаём новый счёт с 10000
                                                                         // золотых у первого клиента

            int x = otusBank.getAccounts(cl1).get(0);                 // Сохраняем в переменную номер
                                                                      // счёта  владельца которого хотим найти
            System.out.println("Номера счётов клиента =" +
                    otusBank.getAccounts(cl1));
            System.out.println(otusBank.findClient(x));
            otusBank.findClient(x).                                   //Показываем сколько ещё счетов у него есть
                    getAccountOfThisClient().
                    showNumberOfAccounts();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
