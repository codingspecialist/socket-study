package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private ServerSocket serverSocket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public MyServer() throws Exception{
        // 1. 서버 대기중
        serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트가 연결되었습니다");

        // 2. 서버 메시지 읽음
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String msg = reader.readLine(); // 버퍼에 \n까지 읽음
        System.out.println("서버 받은 메시지 : "+msg);

        // 3. 서버 메시지 전송
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        writer.write("Thank you");
        writer.write("\n"); // 버퍼에 끝을 알려주는 프로토콜
        writer.flush(); // 버퍼에 담긴 메시지를 전송
    }

    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
