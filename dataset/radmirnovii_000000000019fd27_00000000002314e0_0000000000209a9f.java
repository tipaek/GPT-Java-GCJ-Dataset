import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int tt = 0; tt < t; tt++) {
            String line = in.nextLine().trim();
            int[] lineArr = new int[line.length()];

            for (int i = 0; i < line.length(); i++) {
                lineArr[i] = Character.getNumericValue(line.charAt(i));
            }


            StringBuilder resB = new StringBuilder("");
            int opend = 0;
            for (int i = 0; i < line.length(); i++) {
                int num = lineArr[i];
                if (num <= opend) {
                    for (int j = 0; j < opend - num; j++) {
                        resB.append(")");
                    }
                } else {
                    for (int j = 0; j < num - opend; j++) {
                        resB.append("(");
                    }
                }

                opend = num;
                resB.append(lineArr[i]);
            }

            for (int i = 0; i < opend; i++) {
                resB.append(")");
            }

            System.out.println("Case #" + (t + 1) + ": " + resB);
        }
    }
}
