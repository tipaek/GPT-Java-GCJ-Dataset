import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String outputString = "";
            String inputNum = scanner.next();

            String[] listNum = inputNum.split("");

            for (int n = 0; n < listNum.length; n++) {
                int num = Integer.parseInt(listNum[n]);

                if (n == 0 || Integer.parseInt(listNum[n]) != Integer.parseInt(listNum[n - 1])) {
                    for (int i = 0; i < num; i++) outputString += '(';
                }

                outputString += num;

                if (n == listNum.length - 1 ||Integer.parseInt(listNum[n]) != Integer.parseInt(listNum[n + 1])) {
                    for (int i = 0; i < num; i++) outputString += ')';
                }
                
            }

            System.out.println("Case #" + t + ": " + outputString);
        }

        scanner.close();
    }
}