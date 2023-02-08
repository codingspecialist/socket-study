package ex01;

public class Transaction {
    private int id;
    private String gubun;
    private String sender;
    private String reciver;
    private int amount;

    public Transaction(int id, String gubun, String sender, String reciver, int amount) {
        this.id = id;
        this.gubun = gubun;
        this.sender = sender;
        this.reciver = reciver;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
