package banksystem2;

import java.util.HashMap;
import java.util.Objects;


class Account {
    private HashMap<Integer, Integer> accounts = new HashMap<>();

    public Account(int accountNumber, int value) {
        try {
            if (accountNumber <= 0 || value <= 0) {
                throw new MyOwnException("Номер счёта или сумма вклада нулевые" +
                        "Или введено некорректное значение счёта");
            } else {
                this.accounts.put(accountNumber, value);
            }
        } catch (MyOwnException e) {
            throw new MyOwnException("Это нужно обработать");       // 2 способ rethrow
        }
    }

    public Account(int accountNumber) {
        try {
            if (accountNumber <= 0) {
                throw new MyOwnException("Номер счёта не может быть нулевым. " +
                        "Или введено некорректное значение счёта");
            } else {
                this.accounts.put(accountNumber, 0);
            }
        } catch (MyOwnException e) {
            throw new MyOwnException("Это нужно обработать");       // 2 способ rethrow
        }
    }


    public void setAccounts(int numberOfAccount, int value) {
        int tempSize = accounts.size();
        if (numberOfAccount <= 0 || value <= 0) {
            throw new MyOwnException("Введено некорректное значение суммы вклада или номера счёта");
        } else {
            this.accounts.putIfAbsent(numberOfAccount, value);
            if (tempSize == accounts.size()) {
                System.out.println("Счёт с таким номером уже существует");
            }
        }
    }

    public HashMap<Integer, Integer> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object anotherAccount) {
        if (this == anotherAccount) return true;
        if (anotherAccount == null || getClass() != anotherAccount.getClass()) return false;
        Account account = (Account) anotherAccount;
        return accounts.equals(account.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }

    @Override
    public String toString() {
        return "Счета клиента{" +
                "Счета=" + accounts +
                '}';
    }
}
