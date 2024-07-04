import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean DEBUG = true;

    private static String solve(String input){
        Queue<Character> queue = new LinkedList<Character>();
        char leftP = "(".charAt(0);
        char rightP = ")".charAt(0);
        char prev = "0".charAt(0);
        char temp = "0".charAt(0);
        queue.offer(prev);
        int len=input.length();
        for (int i=0; i<len;i++){
            temp = input.charAt(i);
            int gap = (int)temp-(int)prev;
            if(gap>0){
                for (int k=0;k<gap;k++){
                    queue.offer(leftP);
                }
            }else if(gap<0){
                for (int k=0;k<-gap;k++){
                    queue.offer(rightP);
                }
            }
            queue.offer(temp);
            prev = temp;
        }
        int gapOfLast = temp-("0".charAt(0));
        if(gapOfLast>0) {
            for (int k = 0; k < gapOfLast; k++) {
                queue.offer(rightP);
            }
        }
        StringBuilder result = new StringBuilder();
        queue.poll();
        for (char c:queue){
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String []args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input=scanner.nextLine();
                if (input.equals("")) input =scanner.nextLine();
                String result = solve(input);
                System.out.println("Case #" + testNumber + ": " +result);
            }
        }
    }

}