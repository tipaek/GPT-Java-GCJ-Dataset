import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int num = sc.nextInt();
            int originalNum = num;
            num--;
            int steps = 1;

            while (num > steps) {
                num -= steps;
                steps++;
            }
            steps--;

            System.out.println("Case #" + (i + 1) + ":");

            if (originalNum != 2) {
                System.out.println("1 1");
            }

            for (int j = 0; j < steps; j++) {
                System.out.println((j + 2) + " 2");
            }

            for (int j = 0; j < num; j++) {
                System.out.println((j + steps + 1) + " 1");
            }

            if (originalNum == 2) {
                System.out.println("2 2");
            }
        }

        sc.close();
    }
}