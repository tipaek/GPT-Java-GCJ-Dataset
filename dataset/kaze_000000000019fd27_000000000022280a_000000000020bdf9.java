import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int n = input.nextInt();
            int[][] time = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    time[i][j] = input.nextInt();
                }
                time[i][1]--;
                time[i][2] = i;
            }
            int[] die = new int[1440];
            for (int i = 0; i < 1440; i++) {
                die[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = time[i][0]; j <= time[i][1]; j++) {
                    die[j]++;
                }
            }
            boolean found3 = false;
            for (int i = 0; i < 1440; i++) {
                if (die[i] >=3) {
                    found3 = true;
                }
            }
//            if (found3) {
//                System.out.println("Case #" + (turn+1) + ": " + "IMPOSSIBLE");
//                continue;
//            }

            int ctime = -1;
            int jtime = -1;
            char[] result = new char[n];
            Arrays.sort(time, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0]==o2[0]) return o1[1]-o2[1];
                    return o1[0]-o2[0];
                }
            });
            boolean boom = false;
            for (int i = 0; i < n; i++) {
                //System.out.println(time[i][0] + " " + time[i][1]);
                if (time[i][0] > ctime) {
                    ctime = time[i][1];
                    result[time[i][2]] ='C';
                }else if (time[i][0] > jtime) {
                        jtime = time[i][1];
                    result[time[i][2]] ='J';
                }else{
                    System.out.println("Case #" + (turn+1) + ": " + "IMPOSSIBLE");
                    boom = true;
                    break;
                }
            }
            String tresult = "";
            for (int i = 0; i < n; i++) {
                tresult+=result[i];
            }
            if (!boom) {
                System.out.println("Case #" + (turn + 1) + ": " + tresult);
            }
        }
    }
}
