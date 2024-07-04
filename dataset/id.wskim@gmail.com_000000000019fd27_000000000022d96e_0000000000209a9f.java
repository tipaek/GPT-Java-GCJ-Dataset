
import java.util.*;
import java.io.*;
public class Solution {

    private int trace;
    private int r;
    private int c;

    private String process(String line){

        int open = 0;

        StringBuilder sb = new StringBuilder();
        for(Character ch : line.toCharArray()){
            int val = Integer.valueOf(ch - '0');

            // Before
            if( open < val){
                int count = val - open;
                for(int i=0; i<count;i++){
                    sb.append("(");
                }
                open = val;
            }else if(open > val){
                int count = open - val;
                for(int i=0; i<count;i++){
                    sb.append(")");
                }
                open = val;
            }

            sb.append(val);
        }

        // After, closing
        for(int i=0; i<open;i++){
            sb.append(")");
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.next();
            String out = sol.process(line);

            System.out.println(String.format("Case #%d: %s", i, out));
        }
    }
}