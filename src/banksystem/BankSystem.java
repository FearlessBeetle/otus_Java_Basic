package banksystem;

import java.util.*;

class BankSystem {
    private static int totalNumberOfClients;
    private int creationOfClients;
    private Map<Account, Client> accountsOfClients = new HashMap<>();
    private Map<Client, ArrayList<Account>> allAccountsOfEachClient = new HashMap<>();
    private Queue<String> queqeOfUserData = new LinkedList<>();

    public void startBankSystem(Scanner scanner, int numberOfCreatedClients) {
        inputUserData(scanner, 3);
        parseUserDataAndAddClient();
        showTotalNumberOfClients();
    }

    private void inputUserData(Scanner scanner, int numberOfCreatedClients) {
        System.out.println("Количество создаваемых клиентов = " + numberOfCreatedClients);
        creationOfClients += numberOfCreatedClients;
        for (int i = 0; i < numberOfCreatedClients; i++) {
            addScannedUserAnswer(scanner, ConsoleNotifications.CLIENT_NAME);
            addScannedUserAnswer(scanner, ConsoleNotifications.CLIENT_AGE);
            addScannedUserAnswer(scanner, ConsoleNotifications.ACCOUNT_VALUE);
        }
    }

    private void parseUserDataAndAddClient() {
        for (int i = 0; i < creationOfClients; i++) {
            addNewClientWithAccount(parseStringUserData(),
                    parseIntUserData(),
                    parseIntUserData());
        }
    }

    public void addNewClientWithAccount(String name, int age, int value) {
        Client tempClient = createNewClient(name, age);
        Account tempAccount = createNewAccount(value);
        accountsOfClients.put(tempAccount,
                tempClient);
        ArrayList<Account> arrayListOfCurrentClient = createAccountListForNewClient();
        arrayListOfCurrentClient.add(tempAccount);
        allAccountsOfEachClient.put(tempClient, arrayListOfCurrentClient);
        totalNumberOfClients++;
    }

    public void addNewAccountForExistingClient(Client client, int value) {
        Account tempAccount = createNewAccount(value);
        accountsOfClients.put(tempAccount, client);
        ArrayList<Account> arrayListOfCurrentClient = allAccountsOfEachClient.get(client);
        arrayListOfCurrentClient.add(tempAccount);
    }

    public void addCustomAccountForExistingClient(Client client, int value, int accountNumber) {
        Account tempAccount = createNewAccount(value, accountNumber);
        accountsOfClients.put(tempAccount, client);
        ArrayList<Account> arrayListOfCurrentClient = allAccountsOfEachClient.get(client);
        arrayListOfCurrentClient.add(tempAccount);
    }

    public List<Account> getAllAccountsOfClient(Client client) {
        return allAccountsOfEachClient.get(client);
    }

    public Client findClient(Account account) {
        return accountsOfClients.get(account);
    }

    private Client createNewClient(String name, int age) {
        return new Client(name, age);
    }

    private Account createNewAccount(int value) {
        return new Account(value);
    }

    public Account createNewAccount(int value, int accountNumber) {
        return new Account(value, accountNumber);
    }

    private ArrayList<Account> createAccountListForNewClient() {
        return new ArrayList<>();
    }

    private void showConsoleNotification(ConsoleNotifications currentNotification) {
        System.out.println(currentNotification.getNotification());
    }

    private int scanUserInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else throw new WrongInputException("Вы ввели не число");
    }

    private String scanUserString(Scanner scanner) {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else throw new WrongInputException("Вы ввели некорректное значение имени");
    }

    private void addScannedUserAnswer(Scanner scanner, ConsoleNotifications notifications) {
        showConsoleNotification(notifications);
        String tempLine = scanUserString(scanner);
        queqeOfUserData.add(tempLine);
    }

    private int parseIntUserData() {
        if (queqeOfUserData.peek() != null) {
            return Integer.parseInt(queqeOfUserData.poll());
        } else throw new NullPointerException("Не удалось считать число");
    }

    private String parseStringUserData() {
        if (queqeOfUserData.peek() != null) {
            return queqeOfUserData.poll();
        } else throw new NullPointerException("Не удалось считать строку");
    }

    public void showTotalNumberOfClients() {
        System.out.println("Общее количество наших клиентов = " +
                totalNumberOfClients);
    }

    public Map<Account, Client> getAccountsOfClients() {
        return accountsOfClients;
    }

}
