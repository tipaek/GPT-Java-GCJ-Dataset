import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++) {
            System.out.printf("Case #%d: ",i+1);
            String digits = scan.next();
            int curParens = 0;
            for(int j = 0; j < digits.length(); j++) {
                String digit = digits.substring(j, j+1);
                int num = Integer.parseInt(digit);
                while(curParens<num) {
                    System.out.print("(");
                    curParens++;
                }
                while(curParens>num) {
                    System.out.print(")");
                    curParens--;
                }
                System.out.print(digit);
            }
            while(curParens>0) {
                System.out.print(")");
                curParens--;
            }
            System.out.println();
        }
    }
}
