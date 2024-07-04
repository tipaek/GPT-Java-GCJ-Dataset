import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
          
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        in.nextLine();
        
        for (int i=1; i <= t; i++) {
            String str = in.nextLine();
            String result = "";
            Queue<Character> charQueue = makeQueue(str);
            
            int prevDigit = 0;
            while (charQueue.peek() != null) {
                int nextDigit = Character.getNumericValue(charQueue.poll());
                if (nextDigit > prevDigit) {
                    for (int j = 0; j < nextDigit - prevDigit; j++)
                        result += "(";
                } else {
                    for (int j = 0; j < prevDigit - nextDigit; j++) {
                        result += ")";
                    }
                }
                result += nextDigit;
                prevDigit = nextDigit;
            }
            
            // add closing bracket for lsat digit
            for (int j = 0; j < prevDigit; j++) {
                result += ")";
            }
            
            System.out.printf("Case #%d: %s\n", i, result);
        }
    }
    
   public static Queue<Character> makeQueue(String str) {
       Queue<Character> q = new LinkedList<>();
       for (int i = 0; i < str.length(); i++) {
           q.offer(str.charAt(i));
       }
       return q;
   }
}
        