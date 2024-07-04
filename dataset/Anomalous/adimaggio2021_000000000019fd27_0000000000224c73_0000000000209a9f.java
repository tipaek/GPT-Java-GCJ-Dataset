import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input

        for (int k = 0; k < n; k++) {
            String s = in.nextLine();
            StringBuilder str = new StringBuilder(s);
            int correct = 0;

            for (int i = 0; i < s.length(); ) {
                char digit = s.charAt(i);
                int f = 0;

                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) != s.charAt(i)) {
                        f = j - i;
                        break;
                    }
                }

                if (digit != '0') {
                    StringBuilder rig = new StringBuilder(")");
                    for (int b = 0; b < digit - '1'; b++) {
                        rig.append(")");
                    }
                    str.insert(i + correct + f + 1, rig);

                    StringBuilder left = new StringBuilder("(");
                    for (int b = 0; b < digit - '1'; b++) {
                        left.append("(");
                    }
                    str.insert(i + correct, left);
                }

                correct += (digit - '0') * 2;
                i += 1 + f;
            }

            System.out.println(str.toString());
        }

        in.close();
    }
}