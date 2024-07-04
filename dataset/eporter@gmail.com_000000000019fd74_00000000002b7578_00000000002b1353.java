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
        int n = in.nextInt();
        println(String.format("Case #%s:", cs));
        println("1 1");
        n--;
        int i = 2;
        for (; i <= n; i++) {
            println(i + " " + 2);
            n -= i - 1;
        }
        i--;
        for (; n > 0; i++) {
            println(i + " " + 1);
            n -= 1;
        }
    }
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}
