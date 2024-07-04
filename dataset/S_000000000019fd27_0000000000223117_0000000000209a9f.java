import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 1; i <= size; i++) {
            String output = "";
            String input = scanner.next();
            int stk = 0;
            int prev = 0;
            for (char n : input.toCharArray()) {
                int temp = n - '0';
                if (temp > prev) {
                    while (stk < temp) {
                        stk++;
                        output += '(';
                    }

                } else if (prev > temp) {
                    while (stk > temp) {
                        stk--;
                        output += ')';
                    }
                }
                output += n;
                prev = temp;
            }
            while (stk > 0) {
                stk--;
                output += ')';
            }
            System.out.println("case #" + i + ": " + output);
        }
    }
}
