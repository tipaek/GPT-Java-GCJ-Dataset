import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for(int cases = 1; cases <= tests; cases++) {
            StringBuilder ret = new StringBuilder();
            String input = scanner.next();

            int first = (input.charAt(0) - 48);
            for (int f = 0; f < first; f++){
                ret.append("(");
            }
            ret.append(first);

            int prev = first;
            for(int index = 1; index < input.length(); index++){
                int curr = (input.charAt(index) - 48);
                char put;
                int diff;
                if (curr > prev){
                    diff = curr - prev;
                    put = '(';
                } else {
                    diff = prev - curr;
                    put = ')';
                }
                for (int d = 0; d < diff; d++){
                    ret.append(put);
                }
                ret.append(curr);
                prev = curr;
            }

            for (int l = 0; l < prev; l++){
                ret.append(")");
            }

            System.out.println("Case #" + cases + ":" + " " + ret.toString());
        }

    }
}


