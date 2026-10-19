package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client ");

            Socket socket = serverSocket.accept();
            System.out.println("un client est connecté");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            double a = Double.parseDouble(in.readLine());
            String op = in.readLine();
            double b = Double.parseDouble(in.readLine());
            System.out.println("Opération reçue : " + a + " " + op + " " + b);

            String result;
            switch (op) {
                case "+": result = String.valueOf(a + b); break;
                case "-": result = String.valueOf(a - b); break;
                case "*": result = String.valueOf(a * b); break;
                case "/":
                    result = (b == 0) ? "Erreur : division par zéro" : String.valueOf(a / b);
                    break;
                default: result = "Erreur : opérateur invalide";
            }
            out.println(result);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}