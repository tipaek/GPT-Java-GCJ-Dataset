import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            StringBuilder result = new StringBuilder();
            String[] digits = scanner.nextLine().split("");

            for (String digit : digits) {
                int num = Integer.parseInt(digit);
                if (num == 0) {
                    result.append(0);
                } else {
                    StringBuilder tempResult = new StringBuilder();
                    for (int i = 0; i < num; i++) {
                        tempResult.append("(");
                    }
                    tempResult.append(num);
                    for (int i = 0; i < num; i++) {
                        tempResult.append(")");
                    }
                    result.append(tempResult);
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}