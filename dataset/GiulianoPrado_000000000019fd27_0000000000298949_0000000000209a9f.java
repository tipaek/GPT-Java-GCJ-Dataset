import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int prob = 1; prob <= N; ++prob) {
            String input = in.next();
            int parentCount = 0;
            int actualCount = 0;
            List<Character> out = new ArrayList<Character>();
            char[] inputArray = input.toCharArray();
            for (int i=0;i<inputArray.length;i++) {
                out.add(inputArray[i]);
            }
            int pos = 0;
            while (pos < out.size()) {
//                while (out.get(pos) == ')') pos++;
                while (out.get(pos) - '0' > actualCount) {
                    out.add(pos, '(');
                    pos++;
                    actualCount++;
                }
                while (out.get(pos) - '0' < actualCount) {
                    out.add(pos, ')');
                    pos++;
                    actualCount--;
                }
                pos++;

            }
            while (actualCount>0) {
                out.add(')');
                actualCount--;
            }

            System.out.print("Case #" + prob + ": ");
            for(Character ch : out) {
                System.out.print(ch);
            }
            System.out.print("\n");
        }


    }
}
