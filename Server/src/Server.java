import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try(ServerSocket server = new ServerSocket(8000)){
            while(true)
                try(Socket socket = server.accept();
                    BufferedWriter writer = new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
            BufferedReader reader= new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));){

                    var i = -16;

                    String request = reader.readLine();
                    writer.write(i);
                    writer.newLine();
                    writer.flush();


                    System.out.println("Client");
                    System.out.println(request);


            }catch (IOException e){
                    throw new RuntimeException(e);
                }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
