import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        
        for (int x = 0; x++ < T;) {
            String S = in.readLine();
            String y = S
                .replaceAll("1", "(1)")
                .replaceAll("2", "((2))")
                .replaceAll("3", "(((3)))")
                .replaceAll("4", "((((4))))")
                .replaceAll("5", "(((((5)))))")
                .replaceAll("6", "((((((6))))))")
                .replaceAll("7", "(((((((7)))))))")
                .replaceAll("8", "((((((((8))))))))")
                .replaceAll("9", "(((((((((9)))))))))");
            while (y.contains(")(")) {
                y = y.replaceAll("\\)\\(", "");
            }
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }
}