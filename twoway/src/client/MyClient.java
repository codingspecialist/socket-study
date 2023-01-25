package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClient {

    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

    public MyClient() throws Exception {
        // 1. 서버 연결
        socket = new Socket("localhost", 10000);

        // 2. 메시지 전송
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        writer.write("Hello World");
        writer.write("\n"); // 버퍼에 끝을 알려주는 프로토콜
        writer.flush(); // 버퍼에 담긴 메시지를 전송

        // 2. 클라이언트 메시지 읽음
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String msg = reader.readLine(); // 버퍼에 \n까지 읽음
        System.out.println("클라이언트 받은 메시지 : "+msg);
    }

    public static void main(String[] args) {
        try {
            new MyClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
