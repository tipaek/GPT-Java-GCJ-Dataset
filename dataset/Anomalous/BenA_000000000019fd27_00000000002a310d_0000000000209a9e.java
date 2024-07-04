import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String initialInput = scanner.nextLine();
        System.exit(1);
        
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            answer.append(scanner.nextLine());
            System.out.flush();
        }
    }
}