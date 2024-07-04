import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int number = scanner.nextInt();
            number -= 1;
            int level = 1;

            while (number > level) {
                number -= level;
                level++;
            }
            level--;

            System.out.println("Case #" + (t + 1) + ":");
            System.out.println("1 1");
            for (int i = 0; i < level; i++) {
                System.out.println((i + 2) + " 2");
            }
            for (int i = 0; i < number; i++) {
                System.out.println((i + level + 1) + " 1");
            }
        }

        scanner.close();
    }
}