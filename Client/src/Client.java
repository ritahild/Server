import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws IOException {
        try(
                Socket socket = new Socket("127.0.0.1",8000);

                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                        socket.getOutputStream()));
        BufferedReader reader= new BufferedReader(
                new InputStreamReader(socket.getInputStream()));){

            System.out.println("connect");
            String request = "Tver";
            writer.write(request);
            writer.newLine();
            writer.flush();

            String respone = reader.readLine();
            System.out.println(respone);
        }

    }
}
