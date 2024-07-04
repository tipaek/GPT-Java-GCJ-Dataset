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

//            System.out.println(Arrays.toString(lineArr));

            StringBuilder resB = new StringBuilder("(".repeat(lineArr[0]));
            resB.append(lineArr[0]);
            int opend = lineArr[0];
            for (int i = 1; i < line.length(); i++) {
                int num = lineArr[i];
                if (num <= opend) {
                    resB.append(")".repeat(opend - num));
                } else {
                    resB.append("(".repeat(num - opend));
                }

                opend = num;
                resB.append(lineArr[i]);
            }

            resB.append(")".repeat(opend));

            System.out.println("Case #" + (t + 1) + ": " + resB);
        }
    }
}
