package shop.mtcoding.hdx.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public MyServer() throws Exception{
        // 1. 서버 대기중
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트가 연결되었습니다");

        // 2. 서버 요청 받음
        BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String msg = request.readLine(); // 버퍼에 \n까지 읽음
        System.out.println("클라이언트에게서 요청이 왔습니다 : "+msg);

        // 3. 서버 응답
        BufferedWriter response = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        response.write("<html><h1>Hello</h1></html>");
        response.write("\n");
        response.flush();
        System.out.println("클라이언트에게 응답합니다");
    }


    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
