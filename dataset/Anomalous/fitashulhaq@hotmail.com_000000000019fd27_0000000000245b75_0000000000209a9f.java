import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            
            System.out.print("Case #" + i + ": ");
            int bracketCount = 0;

            for (int index = 0; index < line.length(); index++) {
                int number = Character.getNumericValue(line.charAt(index));

                if (index == 0) {
                    for (int bracks = 0; bracks < number; bracks++) {
                        System.out.print("(");
                        bracketCount++;
                    }
                    System.out.print(number);
                } else {
                    if (number == bracketCount) {
                        System.out.print(number);
                    } else if (number < bracketCount) {
                        while (number != bracketCount) {
                            System.out.print(")");
                            bracketCount--;
                        }
                        System.out.print(number);
                    } else {
                        while (number != bracketCount) {
                            System.out.print("(");
                            bracketCount++;
                        }
                        System.out.print(number);
                    }
                }
            }

            while (bracketCount > 0) {
                System.out.print(")");
                bracketCount--;
            }
            System.out.println();
        }
    }
}