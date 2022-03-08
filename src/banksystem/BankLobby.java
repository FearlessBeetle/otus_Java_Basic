package banksystem;


import java.util.Scanner;

public class BankLobby {
    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {
            BankSystem currentBank = new BankSystem();
            currentBank.startBankSystem(user, 3);
            currentBank.addNewClientWithAccount("Алексей", 24, 100500);
            System.out.println(currentBank.getAccountsOfClients());
            currentBank.addNewAccountForExistingClient(
                    new Client("Алексей", 24),
                    1235829);
            currentBank.showTotalNumberOfClients();
            System.out.println(currentBank.getAccountsOfClients());
            currentBank.addCustomAccountForExistingClient(
                    new Client("Алексей", 24),
                    99999, 352343);
            System.out.println(currentBank.findClient(
                    new Account(99999, 352343)));
            System.out.println(currentBank.getAllAccountsOfClient(
                    new Client("Алексей", 24)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}