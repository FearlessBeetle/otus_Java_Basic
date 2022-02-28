package banksystem;

import java.util.*;


class Account {
    private HashMap<Integer, Integer> clientAccounts = new HashMap<>();

    Account(int account, int coinValue) {
        if (account <= 0) {
            clientAccounts.put(-account, coinValue);
        } else {
            clientAccounts.put(account, coinValue);
        }
    }

    int getValueOfAccount(int accountNumber) {
        return clientAccounts.get(accountNumber);
    }

    void addNewAccountForClient(int coinValue) throws RuntimeException {
        try {
        if (coinValue < 0) {
            throw new RuntimeException("Значение вносимое на счёт не может быть отрицательным");
        } else {
            clientAccounts.putIfAbsent(
                    (int) (Math.random() * Integer.MAX_VALUE),   // K рандомный ключ для нового счёта
                    coinValue);                                  // V Вводимое ненулевое значение
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    void showNumberOfAccounts() {
        System.out.println(" Количество банковских счетов клиента = " +
                clientAccounts.size());
    }

    List<Integer> getListOfAccounts() {
        return new ArrayList<Integer>(clientAccounts.keySet());
    }

    @Override
    public boolean equals(Object anotherAccount) {
        if (this == anotherAccount) return true;
        if (anotherAccount == null || getClass() != anotherAccount.getClass()) return false;
        Account account = (Account) anotherAccount;
        return clientAccounts.equals(account.clientAccounts);
    }


    @Override
    public int hashCode() {
        return Objects.hash(clientAccounts);
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientAccounts=" + clientAccounts +
                '}';
    }
}
