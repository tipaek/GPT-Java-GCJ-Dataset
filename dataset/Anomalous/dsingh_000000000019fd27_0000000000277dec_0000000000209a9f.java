import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previous = -1;

            for (int i = 0; i < input.length(); i++) {
                int current = Character.getNumericValue(input.charAt(i));
                if (previous != -1) {
                    if (previous < current) {
                        for (int j = 0; j < current - previous; j++) {
                            result.append('(');
                        }
                    } else if (previous > current) {
                        for (int j = 0; j < previous - current; j++) {
                            result.append(')');
                        }
                    }
                } else {
                    for (int j = 0; j < current; j++) {
                        result.append('(');
                    }
                }
                result.append(current);
                previous = current;
            }

            for (int j = 0; j < previous; j++) {
                result.append(')');
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}