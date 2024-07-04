import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private Scanner in;
    private PrintWriter out;

    public Solution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Solution problem = new Solution(in, out);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            problem.solve(i);
        }
        out.flush();
        out.close();
    }

    private int N;
    int[][] a;

    // tl;dr: Given a string of digits S, insert a minimum number of opening and closing parentheses into it such that the resulting string is balanced and each digit d is inside exactly d pairs of matching parentheses.

    private void solve(int T) throws IOException {
        char[] s = in.next().toCharArray();
        List<Integer> digits = IntStream.range(0, s.length)
                .map(i -> Character.getNumericValue(s[i]))
                .boxed()
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int currentLevel = 0;
        for (Integer digit : digits) {
            while (digit > currentLevel) {
                sb.append('(');
                currentLevel++;
            }
            while (digit < currentLevel) {
                sb.append(')');
                currentLevel--;
            }
            sb.append(digit);
        }
        while (currentLevel > 0) {
            sb.append(')');
            currentLevel--;
        }
        out.println("Case #" + T +  ": " + sb.toString());
    }


}
