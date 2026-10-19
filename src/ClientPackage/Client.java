package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté...");

            Socket socket = new Socket("localhost", 1234);
            System.out.println("je suis un client connecté");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            String regex = "\\s*-?\\d+(\\.\\d+)?\\s*[+\\-*/]\\s*-?\\d+(\\.\\d+)?\\s*"; //first time using this
            String line;
            do {
                System.out.print("Entrez une opération : ");
                line = sc.nextLine();
                if (!line.matches(regex)) {
                    System.out.println("Syntaxe incorrecte, réessayez.");
                }
            } while (!line.matches(regex));

            java.util.regex.Matcher m = java.util.regex.Pattern
                    .compile("(-?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*(-?\\d+(?:\\.\\d+)?)")
                    .matcher(line.trim());
            m.matches();

            out.println(m.group(1));
            out.println(m.group(2));
            out.println(m.group(3));

            System.out.println("Résultat : " + in.readLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}