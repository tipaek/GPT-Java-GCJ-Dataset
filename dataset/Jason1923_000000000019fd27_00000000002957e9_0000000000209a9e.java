import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt(); // # of test cases
        int b = in.nextInt();
        for (int t = 1; t <= tests; t++) {
            StringBuilder output = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                int bit = in.nextInt();
                output.append(bit);
            }
            System.out.println(output);
            String result = in.next();
            if (result.equals("N"))
                break;
        }
    }
}
