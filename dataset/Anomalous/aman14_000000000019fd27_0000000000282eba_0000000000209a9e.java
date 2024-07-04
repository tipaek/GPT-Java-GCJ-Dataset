import java.util.Scanner;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Random random = new Random();

        while (t > 0) {
            t--;
            int b = scanner.nextInt();
            int p = random.nextInt(b - 1) + 1;
            System.out.println(p);
        }

        scanner.close();
    }
}