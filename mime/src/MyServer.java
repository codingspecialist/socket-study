import com.google.gson.Gson;
import model.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    static int clientCount = 0;

    public MyServer() throws Exception {

        ServerSocket serverSocket = new ServerSocket(10000);
        while (true) {
            // 1. 서버 대기중
            Socket socket = serverSocket.accept();
            clientCount++;
            System.out.println("클라이언트가 연결되었습니다");
            System.out.println("연결된 클라이언트 : "+clientCount);

            new Thread(() -> {
                try {
                    // 2. 서버 요청 받음
                    BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
                    String mimeType = request.readLine(); // 버퍼에 \n까지 읽음
                    String responseData = parser(mimeType);

                    // 3. 테스트를 위해 5초 대기
                    Thread.sleep(5000);

                    // 4. 서버 응답
                    BufferedWriter response = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
                    response.write(responseData);
                    response.write("\n");
                    response.flush();
                    System.out.println("클라이언트에게 응답합니다 ---------------- close");
                    socket.close();
                    request.close();
                    response.close();
                    clientCount--;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private String parser(String mimeType){
        Data data = new Data("SocketStudy", "portAndIp");
        if(mimeType.equals(MimeType.TEXT_HTML)){
            return "<body>title : "+data.getTitle()+"<br/> content : "+data.getContent()+"</body>";
        }else if(mimeType.equals(MimeType.FORM_URLENCODED)){
            return "title="+data.getTitle()+"&content="+data.getContent();
        }else if(mimeType.equals(MimeType.APPLICATION_JSON)){
            Gson gson = new Gson();
            return gson.toJson(data);
        }

        return "badRequest";
    }


    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}