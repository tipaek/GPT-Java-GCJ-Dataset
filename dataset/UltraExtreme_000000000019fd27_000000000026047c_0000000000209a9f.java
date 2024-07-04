import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            System.out.println("Case #" + i + ": " + new Solver().solve(line));
        }
    }

    public static class Solver {

        public String solve(String input) {
            StringBuilder mid = new StringBuilder();
            char[] arr = input.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                mid.append(surroundWithParen(arr[i]));
            }
            String midString = mid.toString();
            while(midString.contains(")(")){
                midString = midString.replace(")(","");
            }
            return midString;
        }

        private String surroundWithParen(char c) {
            int digit = Integer.parseInt(String.valueOf(c));
            StringBuilder result = new StringBuilder(digit + "");
            for(int i=0;i<digit;i++){
                result = new StringBuilder("(" + result + ")");
            }
            return result.toString();
        }
    }
}