
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();
        for (int numTest = 1; numTest <= numTests; ++numTest) {
            solve(numTest, in.next());
        }
    }

    private static void solve(int numTest, String inp) {
        StringBuilder sb = new StringBuilder();
        int currDepth = 0;

        for (char c : inp.toCharArray()) {
            int curr = Integer.parseInt(String.valueOf(c));
            while (curr > currDepth) {
                sb.append('(');
                currDepth++;
            }
            while (curr < currDepth) {
                sb.append(')');
                currDepth--;
            }
            sb.append(c);
        }

        while (currDepth > 0) {
            sb.append(')');
            currDepth--;
        }

        System.out.format("Case #%d: %s%n", numTest, sb.toString());
    }
}