package src.config;

public enum CardType {
    CREDIT_CARD(2000.0, 25.0),
    DEBIT_CARD(2000.0, 25.0),
    VIRTUAL_DEBIT_CARD(2000.0, 25.0);


    private final double cardLimit;
    private final double expDate;

    CardType(double cardLimit, double expDate) {
        this.cardLimit = cardLimit;
        this.expDate = expDate;
    }

}