import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            StringBuffer str = new StringBuffer("");
            boolean imp = false;
            if (n > 0) {
                int freeC = 0;
                int freeJ = 0;
                int[] start = new int[n];
                int[] end = new int[n];
                int[] order = new int[n];
                for (int j = 0; j < n; ++j) {
                    order[j] = j;
                    start[j] = in.nextInt();
                    end[j] = in.nextInt();
                }
                int tempS, tempE, tempO;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (start[j] > start[k]) {
                            tempS = start[j];
                            start[j] = start[k];
                            start[k] = tempS;
                            tempE = end[j];
                            end[j] = end[k];
                            end[k] = tempE;
                            tempO = order[j];
                            order[j] = order[k];
                            order[k] = tempO;
                        }
                    }
                }
                for (int j = 0; j < n; ++j) {
                    if (start[j] < freeC && start[j] < freeJ) {
                        imp = true;
                        break;
                    }
                    if (start[j] >= freeC) {
                        str.append('C');
                        freeC = end[j];
                    } else {
                        str.append('J');
                        freeJ = end[j];
                    }
                }
                if (!imp) {
                    StringBuffer strCopy = new StringBuffer(str);
                    String copy = strCopy.toString();
                    for (int j = 0; j < copy.length(); ++j) {
                        char c = copy.charAt(j);
                        str.setCharAt(order[j],c);
                    }
                }
                if (imp) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + str);
                }
            }
        }
    }
}