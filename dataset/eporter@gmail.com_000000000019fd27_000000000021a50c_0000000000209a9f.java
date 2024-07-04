import java.io.IOException;
import java.util.Scanner;

public class Solution {
    final Scanner in;

    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
        scanner.close();
    }
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
    
    public Solution(Scanner in) {
        this.in = in;
    }
    
    private void runCase(int cs) {
        String s = in.next();
        StringBuilder buf = new StringBuilder();
        int n = 0;
        for (char ch : s.toCharArray()) {
            int c = Integer.parseInt(String.valueOf(ch));
            while (n < c) {
                buf.append('(');
                n++;
            }
            while (n > c) {
                buf.append(')');
                n--;
            }
            buf.append(ch);
        }
        while (n > 0) {
            buf.append(')');
            n--;
        }
        println(String.format("Case #%s: %s", cs, buf));
    }
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}
