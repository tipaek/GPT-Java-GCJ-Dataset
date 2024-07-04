import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tTestCases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < tTestCases; i++) {
            String line = sc.nextLine();

            StringBuilder str = new StringBuilder();
            int depth = 0;
            for (int j = 0; j < line.length(); j++) {
                int c = Integer.parseInt(line.charAt(j)+"");

                if (c<depth) {
                    for (; depth > c; depth--) {
                    str.append(")");
                    }
                    depth = c;
                } else if (c>depth) {
                    for (; depth < c; depth++) {
                    str.append("(");
                    }
                    depth = c;
                }

                str.append(c);

            }
            for (; depth != 0; depth--) {
            str.append(")");
            }

            System.out.println("Case #" + (i+1) + ": " + str.toString());
        }
    }
}
