import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            boolean[] timeP = new boolean[N];

            String order = "J";


            for (int j = 0; j < N * 2; j++) {
                if (j % 2 == 0) start[j / 2] = cin.nextInt();
                if (j % 2 == 1) end[(j - 1) / 2] = cin.nextInt();
            }

            boolean parents = false;
            timeP[0] = parents;
            impossible:
            {
                for (int j = 1; j < N; j++) { 
                    int count = 0;
                    for (int k = 0; k < j; k++) { 
                        if (start[j] >= end[k] || end[j] <= start[k]) {

                            timeP[j] = parents;
                        } else {
                            count++;
                            if (j > 1) {
                                if (start[j - 1] >= end[j - 2] || end[j - 1] <= start[j - 2]) 
                                    if (start[j] >= end[j - 2] && start[j] <= start[j - 1] || end[j] >= end[j - 1] && end[j] <= start[j - 2])
                                        if (end[j] > start[j - 1] || start[j] < end[j - 1]) {

                                            order = order.substring(0, order.length() - 1);
                                            timeP[j - 1] = !timeP[j - 1];
                                            parents = !timeP[j - 1];
                                            order += timeP[j - 1] ? "C" : "J";


                                        }
                            }
                            if (count > 1 && (timeP[k] != timeP[j])) { 
                                count--;
                            } else {
                                parents = !timeP[k];
                                timeP[j] = parents;
                            }
                            if (count > 1) {
                                order = "IMPOSSIBLE";
                                break impossible;
                            }

                        }
                    }
                    order += timeP[j] ? "C" : "J";
                }
            }


            System.out.println("Case #" + (i + 1) + ": " + order);
        }
    }
}