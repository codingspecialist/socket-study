import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient1 {

    private Socket socket;
    private BufferedWriter request;
    private BufferedReader response;

    public MyClient1() throws Exception {
        // 1. 서버 연결
        socket = new Socket("localhost", 10000);

        // 2. 키보드 연결
        Scanner sc = new Scanner(System.in);
        String requestData = sc.nextLine();

        // 3. 클라이언트 요청함
        request = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        request.write(requestData);
        request.write("\n"); // 버퍼에 끝을 알려주는 프로토콜
        request.flush(); // 버퍼에 담긴 메시지를 전송

        // 4. 클라이언트 응답 받음
        response = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String msg = response.readLine(); // 버퍼에 \n까지 읽음
        System.out.println("서버에게서 응답이 왔습니다 : "+msg);
    }

    public static void main(String[] args) {
        try {
            new MyClient1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}