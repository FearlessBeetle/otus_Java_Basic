package banksystem;

public enum ConsoleNotifications {
    CLIENT_NAME("Введите Имя клиента"),
    CLIENT_AGE("Введите возраст клиента"),
    ACCOUNT_VALUE("Введите сумму счёта"),
    ACCOUNT_NUMBER("Введите номер счёта");

    private final String notification;

    ConsoleNotifications(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

}
