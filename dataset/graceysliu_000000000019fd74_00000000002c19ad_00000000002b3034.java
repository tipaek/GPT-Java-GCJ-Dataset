import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int i = 0; i < numTests; i++) {
            int numWords = in.nextInt();
            in.nextLine();  // scanner discrepancy

            Set<String> w1 = new HashSet<>();
            Set<String> w2 = new HashSet<>();

            // for test 1
            String l1 = "";
            String l2 = "";

            for (int j = 0; j < numWords; j++) {
                String s = in.nextLine();
                int index = 0;

                StringBuilder part = new StringBuilder();
                while (s.charAt(index) != '*') {
                    part.append(s.charAt(index));
                    index++;
                }

                if (part.length() > l1.length())
                    l1 = part.toString();

                if (part.length() != 0)
                    w1.add(part.toString());

                part = new StringBuilder(); // clear
                index++;

                while (index != s.length()) {
                    part.append(s.charAt(index));
                    index++;
                }

                if (part.length() > l2.length())
                    l2 = part.toString();

                if (part.length() != 0)
                    w2.add(part.toString());
            }

            // System.out.println(w1.toString());
            // System.out.println(w2.toString());

            boolean match = true;

            for (String s : w1) {
                if (l1.indexOf(s) == -1) {
                    match = false;
                    break;
                }
            }

            if (match) {
                StringBuilder result = new StringBuilder(l1);
                result.append(l2);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
            else
                System.out.println("Case #" + (i + 1) + ": *");
        }
    }
}