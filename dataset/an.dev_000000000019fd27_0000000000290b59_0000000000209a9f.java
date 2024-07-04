
import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(String s) {
        int n = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            int cur = Character.getNumericValue(c);
            while(n > cur) {
                sb.append(")");
                n--;
            }
            while(n < cur) {
                sb.append("(");
                n++;
            }
            sb.append(c);
        }
        while(n > 0) {
            sb.append(")");
            n--;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/nestingdepth-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String s = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(s));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}