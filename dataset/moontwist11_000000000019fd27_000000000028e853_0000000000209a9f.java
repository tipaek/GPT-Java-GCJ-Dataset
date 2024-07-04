import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = Integer.parseInt(input.nextLine());
        
        for(int i = 0; i < numTests; i++) {
            String line = input.nextLine();
            String y = solver2(line, 0);
            System.out.print("Case #" + (i+1) + " ");
            System.out.print(y);
            System.out.println();
        }
    }
    
    public static String solver2(String s, int depth) {
        if(s.length() == 0) {
            String endParen = "";
            for(int i = 0; i < depth; i++) {
                endParen += ")";
            }
            return s + endParen;
        }
        char first = s.charAt(0);
        char depthChar = (char)(depth + '0');
        if(first > depthChar) { //requires more depth
            return "(" + solver2(s, depth+1);
        } else if(first < depthChar) { //requires less depth
            return ")" + solver2(s, depth-1);
        } else { //correct depth, continue
            return first + solver2(s.substring(1), depth);
        }
    }
}