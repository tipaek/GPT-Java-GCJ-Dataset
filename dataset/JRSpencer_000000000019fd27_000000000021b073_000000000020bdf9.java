import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] array = new int[n][2];
            for (int j = 0; j < n; j++) {
                array[j][0] = in.nextInt();
                array[j][1] = in.nextInt();
            }
            String string = "";
            int[][] cArray = new int[n][2];
            int[][] jArray = new int[n][2];
            for (int j = 0; j < n; j++) {
                boolean canC = true;
                boolean canJ = true;
                for (int k = 0; k <= j; k++) {
                    if (cArray[k][0] == 0 && cArray[k][1] == 0 && canC) {
                        string += "C";
                        cArray[k][0] = array[j][0];
                        cArray[k][1] = array[j][1];
                        break;
                    } else if (!(array[j][0] >= cArray[k][1] || array[j][1] <= cArray[k][0])) {
                        canC = false;
                        break;
                    }
                }
                if (!canC) {
                    for (int k = 0; k <= j; k++) {
                        if (jArray[k][0] == 0 && jArray[k][1] == 0 && canJ && !canC) {
                            string += "J";
                            jArray[k][0] = array[j][0];
                            jArray[k][1] = array[j][1];
                            break;
                        } else if (!(array[j][0] >= jArray[k][1] || array[j][1] <= jArray[k][0])) {
                            canJ = false;
                            break;
                        }
                    }
                }
                if (!canC && !canJ) {
                    string = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, string));
        }
    }
}
