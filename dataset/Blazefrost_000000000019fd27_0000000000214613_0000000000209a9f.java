import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < cases; i++) {
            StringBuilder bob = new StringBuilder();
            String line = scan.nextLine();

            int level = 0;

            for (int c = 0; c < line.length(); c++) {
                int newLevel = line.charAt(c)-'0';

                // There are three cases:
                //  - newLevel == level: No braces needed
                //  - newLevel > level: Rolling in the deep (add opening brace)
                //  - newLevel < level: Go up some levels
                while (newLevel > level) {
                    bob.append('(');
                    level++;
                }
                while (newLevel < level) {
                    bob.append(')');
                    level--;
                }

                bob.append(line.charAt(c));
            }

            // Level out to level 0
            while (level > 0) {
                bob.append(')');
                level--;
            }

            System.out.printf("Case #%d: %s\n", (i+1), bob.toString());
        }

        scan.close();
    }
}
