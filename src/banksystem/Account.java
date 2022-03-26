package banksystem;


import java.util.Objects;


class Account {
    private int accountNumber = (int)((Math.random() * 1000000) + hashCode());
    private int value;

    public Account(int value) {
        if (value <= 0) {
            throw new WrongInputException("Некорректный счёт клиента или денежная сумма равна нулю");
        } else {
        this.value = value;
        }
    }

    public Account(int value, int accountNumber) {
        if (accountNumber <= 0 && value <= 0) {
            throw new WrongInputException("Некорректный счёт клиента или денежная сумма равна нулю");
        } else {
            this.value = value;
            this.accountNumber = accountNumber;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber && value == account.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, value);
    }

    @Override
    public String toString() {
        return "Счёт номер - " + accountNumber +
                ", состояние счёта = " + value +
                '}'+
                " ";
    }
}
