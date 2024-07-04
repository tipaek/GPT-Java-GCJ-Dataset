 import java.util.*;
 import java.io.*;

 
 public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int[][] records = new int[1440][2];
            boolean isImpossible = false;
            
            int n = in.nextInt();
            int[][] result = new int[n][2];
            int[][] input = new int[n][3];
            for (int j = 0; j < n; ++j) {
                input[j][0] = in.nextInt();
                input[j][1] = in.nextInt();
                input[j][2] = j;
            }

            Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);

            for (int j = 0; j < n; ++j) {
                int begin = input[j][0];
                int stop = input[j][1];
                boolean flag_c = true;
                boolean flag_j = true;

                for (int time = begin; time < stop; time++) {
                    if (records[time][0] == 1) {
                        flag_c = false;
                    }
                }

                if (flag_c) {
                    for (int time = begin; time < stop; time++) {
                        records[time][0] = 1;
                    }
                    result[j] = new int[]{input[j][2], 1};
                } else {
                    for (int time = begin; time < stop; time++) {
                        if (records[time][1] == 1) {
                            flag_j = false;
                        }
                    } 
                    if (flag_j) {
                        for (int time = begin; time < stop; time++) {
                            records[time][1] = 1;
                        }
                        result[j] = new int[]{input[j][2], 2};
                    } else {
                        isImpossible = true;
                    }
                }
            }

            String res = "";    
            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                Arrays.sort(result, (o1, o2) -> o1[0] - o2[0]);
                for (int j = 0; j < n; ++j)
                    res += (result[j][1] == 1) ? "C" : "J";
                System.out.println("Case #" + i + ": " + res);
            }
        }
    }
}