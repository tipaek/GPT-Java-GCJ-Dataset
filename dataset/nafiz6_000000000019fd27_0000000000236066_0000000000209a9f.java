import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int z = 1; z <= t; ++z) {
            String S = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int depth = 0;
            for (int i=0;i<S.length();i++){
                int val = Integer.parseInt(S.charAt(i)+"");
                if (depth>val){
                    while (depth>val){
                        sb.append(')');
                        depth--;
                    }
                }
                else if (depth<val){
                    while (depth<val){
                        sb.append('(');
                        depth++;
                    }

                }

                sb.append(S.charAt(i));

            }
            while (depth!=0){
                sb.append(')');
                depth--;
            }

            String res = sb.toString();
            System.out.println("Case #" + z + ": " + res );
        }
    }
}