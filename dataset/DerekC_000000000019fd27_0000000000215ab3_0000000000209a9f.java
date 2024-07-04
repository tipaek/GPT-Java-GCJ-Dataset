import java.util.*;
import java.io.*;

class Solution {

    public static String nestedDepth(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int open = 0;

        for(int i = 0; i < length; i++) {
            int d = Character.getNumericValue(s.charAt(i));

            if(i > 0) {
                int prev = Character.getNumericValue(s.charAt(i-1));
                int diff = d-prev;
                if(diff > 0) {
                    for(int j = 0; j < Math.abs(diff); j++) {
                        sb.append('(');
                        open++;
                    }
                } else if(diff < 0) {
                    for(int j = 0; j < Math.abs(diff); j++) {
                        sb.append(')');
                        open--;
                    }
                }
            }

            if(open == 0) {
                for(int j = 0; j < d; j++) {
                    sb.append('(');
                    open++;
                }
            }

            sb.append(d);
        }   

        while(open-- > 0) {
            sb.append(')');
        }
            

        return sb.toString();

    }
    public static void main(String[] args) throws Exception {
        // File file = new File("./input.txt");
        // Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); //# of testcases

        for (int i = 1; i <= t; ++i) {
            String s = in.next();
        

            System.out.println("Case #" + i + ": " + nestedDepth(s));
        }
        in.close();
    }
}