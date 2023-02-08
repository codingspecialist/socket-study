import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    static int clientCount = 0;

    public MyServer() throws Exception{
        // 1. 서버 대기중
        ServerSocket serverSocket = new ServerSocket(10000);
        while(true){
            Socket socket = serverSocket.accept();
            clientCount++;
            System.out.println("===============================");
            System.out.println("클라이언트가 연결되었습니다");
            System.out.println("연결된 클라이언트 : "+clientCount);

            // 2. 서버 요청 받음
            BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            String msg = request.readLine(); // 버퍼에 \n까지 읽음
            System.out.println("클라이언트에게서 요청이 왔습니다 : "+msg);

            // 3. 테스트를 위해 5초 대기
            Thread.sleep(5000);

            // 4. 서버 응답
            BufferedWriter response = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
            response.write("<html><h1>Hello</h1></html>");
            response.write("\n");
            response.flush();
            System.out.println("클라이언트에게 응답합니다");
            System.out.println("===============================");

            clientCount--;
        }

    }


    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
