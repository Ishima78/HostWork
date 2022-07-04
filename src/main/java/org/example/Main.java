package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args)throws IOException {
        System.out.println("Начало работы сервера");
        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("Новое подключение .Port: %d%n "+clientSocket.getPort());

                final String name = bufferedReader.readLine();
                out.println(String.format("Привет %s , твой Port %d" ,name,clientSocket.getPort() ));
            }

        }
    }
}