import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            String input = scanner.next();
            String output = addParen(Integer.parseInt(input.substring(0,1)), Integer.parseInt(input.substring(0,1)));
            
            for (int j = 1; j < input.length(); j++) {
                int prev = Integer.parseInt(input.substring(j-1, j));
                int next = Integer.parseInt(input.substring(j, j+1));
                int parens = Math.max(next-prev,0);
                int nest = Math.min(prev,next);
                output = output.substring(0,output.length()-nest) + addParen(next,parens) + output.substring(output.length()-nest);
            }
            System.out.printf("Case #%d: %s\n",i,output);
        }
    }

    static String addParen(int num, int c) {
        String output = "";
        for (int i = 0; i < c; i++) {
            output+="(";
        }
        output += num;
        for (int i = 0; i < c; i++) {
            output+=")";
        }
        return output;
    }
}