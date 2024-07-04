import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            String line = in.nextLine();
            String newLine = "";
            int countParenthesis = 0;
            for (int j = 0; j < line.length(); j++) {
                int num = Integer.parseInt(line.charAt(j) + "");
                for (; countParenthesis > num; countParenthesis--) {
                    newLine += ")";
                }
                for (; countParenthesis < num; countParenthesis++) {
                    newLine += "(";
                }
                newLine += num + "";
            }
            for (; countParenthesis > 0; countParenthesis--) {
                newLine += ")";
            }
            int max = i+1;
            System.out.println("Case #" + max + ": " + newLine);
        }
    }
}
