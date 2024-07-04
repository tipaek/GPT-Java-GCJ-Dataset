import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GreetingApp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        System.out.println("Hi, " + name1 + ".");

        Scanner scanner = new Scanner(System.in);
        String name2 = scanner.nextLine();
        System.out.println("Hi, " + name2 + ".");
    }
}