package banksystem2;

import java.util.Scanner;

public class BankLobby {
    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {  // try с ресурсами
            BankSystem system = new BankSystem();
            system.fillData(user);
            system.fillData(user);
            system.fillData(user);
            system.fillData(user);
            system.fillData(user);
            system.createClient();
            system.createClient();
            system.createClient();
            system.createClient();
            system.createClient();
            system.addNewAcc("Иван", 26, 110111, 100500);
            system.addNewAcc("Иван", 26, 112304, 132344);
            system.showClients();
            System.out.println("Номера счёта клиента " +
                    system.getAccounts("Иван", 26));
            System.out.println("Тот кого вы искали это - " +
                    system.findClient(110111));
            System.out.println("Номера счёта клиента " +
                    system.getAccounts("Андрей", 20));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
