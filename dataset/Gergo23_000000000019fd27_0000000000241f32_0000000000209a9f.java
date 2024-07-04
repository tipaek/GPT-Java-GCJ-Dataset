import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int ks = 1; ks <= T; ks++) {
            solve(input.next(), ks);
        }
    }
    
    public static void solve(String s, int ks) {
        StringBuilder sb = new StringBuilder();
        char[] in = s.toCharArray();
    
        
        int nestingLevel = 0;
        for(int i = 0; i < in.length; i++) {
            int c = in[i] - 48;
            if(c < nestingLevel) {
                int diff = nestingLevel - c;
                for(int j = 0; j < diff; j++) {
                    nestingLevel--;
                    sb.append(")");
                }
            } else if (c > nestingLevel) {
                int diff = c - nestingLevel;
                for(int j = 0; j < diff; j++) {
                    nestingLevel++;
                    sb.append("(");
                }
            }
            sb.append(c);
        }
        for(int j = 0; j < nestingLevel; j++) {
            sb.append(")");
        }
        System.out.println("Case #" + ks + ": " + sb.toString());
    }
    
}