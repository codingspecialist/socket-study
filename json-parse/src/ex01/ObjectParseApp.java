package ex01;

import com.google.gson.Gson;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ObjectParseApp {
    public static void main(String[] args) {
        String json = "{\"id\":6,\"gubun\":\"입금\",\"sender\":\"ATM\",\"reciver\":\"1111\",\"amount\":100}";
        Gson gson = new Gson();
        Transaction transaction = gson.fromJson(json, Transaction.class);
        System.out.println("id : "+transaction.getId());
        System.out.println("gubun : "+transaction.getGubun());
        System.out.println("sender : "+transaction.getSender());
        System.out.println("reciver : "+transaction.getReciver());
        System.out.println("amount : "+transaction.getAmount());
    }
}
