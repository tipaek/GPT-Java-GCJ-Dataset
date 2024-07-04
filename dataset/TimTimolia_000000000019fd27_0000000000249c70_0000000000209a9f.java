import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseAmount = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        scanner.nextLine();
        for (int caseNumber = 1; caseNumber <= caseAmount; caseNumber++) {
            String string = scanner.nextLine();
            String out = "";
            int openOarentheses = 0;
            for (int i = 0; i < string.length(); i++) {
                int number = Integer.parseInt(string.substring(i, i + 1));
                while (number > openOarentheses) {
                    out += "(";
                    openOarentheses++;
                }
                while (number < openOarentheses) {
                    out += ")";
                    openOarentheses--;
                }
                out += number;
            }
            for (int i = 0; i < openOarentheses; i++) {
                out += ")";
            }
            System.out.println("Case #" + caseNumber + ": " + out);
        }

    }

}
