import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("/Users/berendjanlange/GitDrive/Hashcode/CodeJamQualification/src/scratch.txt");
        //Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests = in.nextInt();

        nextTest: for (int test = 0; test < tests; test++) {
            int Case = test + 1;
            int N = in.nextInt();
            int[][] events = new int[N][3];
            int endTimeC = 0;
            int endTimeJ = 0;
            for (int i = 0; i < N; i++) {
                events[i][0] = in.nextInt();
                events[i][1] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int mini = 0;
                int minval = 24 * 60;
                for (int j = 0; j < N; j++) {
                    if (events[j][2] == 0 && minval > events[j][0]) {
                        mini = j;
                        minval = events[j][0];
                    }
                }
                if (endTimeC <= endTimeJ) {
                    if (endTimeC > events[mini][0]) {
                        System.out.println("Case #" + Case + ": IMPOSSIBLE");
                        continue nextTest;
                    }
                    endTimeC = events[mini][1];
                    events[mini][2] = 1;
                } else {
                    if (endTimeJ > events[mini][0]) {
                        System.out.println("Case #" + Case + ": IMPOSSIBLE");
                        continue nextTest;
                    }
                    endTimeJ = events[mini][1];
                    events[mini][2] = 2;
                }
            }
            String ret = "";
            for (int i = 0; i < N; i++) {
                if (events[i][2] == 1) {
                    ret += "C";
                } else {
                    ret += "J";
                }
            }

            System.out.println("Case #" + Case + ": " + ret);

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (i != j) {
//                        if ((events[j][0] > events[i][0] && events[j][0] < events[i][1]) ||
//                                (events[j][1] > events[i][0] && events[j][1] < events[i][1]) ||
//                                (events[j][0] <= events[i][0] && events[j][1] >= events[i][1])) {
//                            events[i][2]++;
//                            if (events[i][2] > 2) {
//                                System.out.println("Case #" + Case + ": IMPOSSIBLE");
//                                continue testing;
//                            }
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < N; i++) {
//                System.out.println(events[i][2]);
//                int mini = 0;
//                int minval = -1;
//                for (int j = 0; j < N; j++) {
//                    if (!used[j] && minval < events[j][2]) {
//                        mini = j;
//                    }
//                }
//                used[mini] = true;
//
//            }



        }

    }
}