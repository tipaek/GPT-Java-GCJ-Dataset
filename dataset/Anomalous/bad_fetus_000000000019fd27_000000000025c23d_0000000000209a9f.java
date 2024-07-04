import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = Integer.parseInt(sc.nextLine());
            for (int l = 0; l < testCount; l++) {
                String input = sc.nextLine();
                int[] numbers = input.chars().map(Character::getNumericValue).toArray();

                StringBuilder sb = new StringBuilder("Case #").append(l + 1).append(": ");
                int currDepth = 0;

                for (int number : numbers) {
                    while (currDepth < number) {
                        sb.append("(");
                        currDepth++;
                    }
                    while (currDepth > number) {
                        sb.append(")");
                        currDepth--;
                    }
                    sb.append(number);
                }

                while (currDepth > 0) {
                    sb.append(")");
                    currDepth--;
                }

                System.out.println(sb);
            }
        }
    }
}