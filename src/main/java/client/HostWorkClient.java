



package client;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HostWorkClient {
    public static void main(String[] args) {
     String host = "127.0.0.1";
     int port =8081;

     try (Socket clientSocket = new Socket(host,port);
          PrintWriter out = new
                  PrintWriter(clientSocket.getOutputStream(),true);
          BufferedReader in = new BufferedReader(new
                  InputStreamReader(clientSocket.getInputStream()))){

              out.println("Super-Duper fly");

              String resp = in.readLine();
         System.out.println(resp);

     } catch (IOException e) {
         throw new RuntimeException(e);
     }
    }
}