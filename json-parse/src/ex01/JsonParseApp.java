package ex01;

import com.google.gson.Gson;

public class JsonParseApp {
    public static void main(String[] args) {
        Transaction transaction = new Transaction(6, "입금", "ATM", "1111", 100);
        Gson gson = new Gson();
        String json = gson.toJson(transaction);
        System.out.println(json);
    }
}
