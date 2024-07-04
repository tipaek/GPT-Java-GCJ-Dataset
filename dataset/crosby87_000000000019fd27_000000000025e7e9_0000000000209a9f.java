import java.util.*;

public class Solution {
    public static int countDigit(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public static void printparen (int n){
        if (n > 0){
            for (int i = 0; i < n; i++){
                System.out.print(")");
            }
        }
        else{
            for (int i = 0; i < Math.abs(n); i++){
                System.out.print("(");
            }
        }
    }

    public static int[] digits (String n){
        int[] digits = n.chars().map(c -> c-'0').toArray();
        return digits;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int a = 1; a <= N; a++){
            String s = sc.next();
            int count = 1;
            int[] digits = digits(s);
            int[] diff = new int[digits.length + 1];
            diff[0] = -1*digits[0];
            for (int i = 1; i < digits.length; i++){
                diff[i] = digits[i-1] - digits[i];
            }
            diff[digits.length] = digits[digits.length - 1];

//            for (int i = 0; i < diff.length; i++){
//                System.out.print(diff[i]);
//            }
//            System.out.println();

            System.out.print("Case #" + a + ": ");

            for (int i = 0; i < digits.length; i++){
                printparen(diff[i]);
                System.out.print(digits[i]);
            }
            printparen(diff[digits.length]);
            System.out.println();
        }
    }
}
