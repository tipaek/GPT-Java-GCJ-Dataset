import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            String[] patterns = new String[num];

            for (int j = 0; j < num; j++) {
                patterns[j] = sc.next();
            }

            Arrays.sort(patterns, (a, b) -> b.length() - a.length());
            String finalResult = patterns[0];

            OUTER_LOOP:
            for (int k = 1; k < patterns.length; k++) {
                String pattern1 = patterns[0];
                String pattern2 = patterns[k];
                int index1 = 0, index2 = 0;
                boolean star1 = false, star2 = false;

                while (true) {
                    char char1 = pattern1.charAt(index1);
                    char char2 = pattern2.charAt(index2);

                    if (char1 == '*') {
                        index1++;
                        star1 = true;
                    }
                    if (char2 == '*') {
                        index2++;
                        star2 = true;
                    }

                    if (star1 && star2) {
                        String sub1 = pattern1.substring(index1);
                        String sub2 = pattern2.substring(index2);

                        if (!sub1.contains(sub2)) {
                            finalResult = "*";
                            break OUTER_LOOP;
                        } else {
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + finalResult);
        }
    }
}