import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); 
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            for (int i = 0; i < N; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }

            char[] resultArr = new char[N];
            Arrays.fill(resultArr, ' ');
            int cCurrent = -1, jCurrent = -1, activeCount = 0;
            boolean impossible = false;

            for (int time = 0; time <= 1440; time++) {
                for (int j = 0; j < N; j++) {
                    if (end[j] == time) {
                        if (cCurrent == j) {
                            cCurrent = -1;
                            activeCount--;
                        } else if (jCurrent == j) {
                            jCurrent = -1;
                            activeCount--;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    if (start[j] == time) {
                        if (activeCount < 2) {
                            if (jCurrent == -1) {
                                jCurrent = j;
                                activeCount++;
                                resultArr[j] = 'J';
                            } else if (cCurrent == -1) {
                                cCurrent = j;
                                activeCount++;
                                resultArr[j] = 'C';
                            }
                        } else {
                            impossible = true;
                            break;
                        }
                    }
                }

                if (impossible) {
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : new String(resultArr).replaceAll(" ", "");
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        in.close();
    }
}