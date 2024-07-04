import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int R = Integer.parseInt(input[0]);
            int S = Integer.parseInt(input[1]);
            int moveCount = 0;
            List<String> output = new ArrayList<>();

            for (int j = 1; j < S; j++) {
                int a = R * j;
                output.add(a + " " + (R - 1));
                moveCount++;

                for (int k = R; k > 2; k--) {
                    int e = k - 1;
                    int m = k - (j * 2);
                    output.add(e + " " + m);
                    moveCount++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + moveCount);
            for (String line : output) {
                System.out.println(line);
            }
        }

        scanner.close();
    }
}