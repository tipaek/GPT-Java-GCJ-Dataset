import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            boolean[] timeP = new boolean[N];

            String order = "C";



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
                    order += timeP[j] ? "J" : "C";
                }
            }


            System.out.println("Case #" + (i + 1) + ": " + order);
        }
    }
}
