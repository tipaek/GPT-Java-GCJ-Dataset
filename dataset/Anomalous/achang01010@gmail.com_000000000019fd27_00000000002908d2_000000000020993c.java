import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            System.out.println(number);
        }
    }
}