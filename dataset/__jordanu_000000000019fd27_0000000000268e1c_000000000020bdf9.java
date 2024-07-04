import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        // Solve each test case
        for (int i=1; i<cases+1; i++) {
            solve(i, in);
        }
    }

    public static void solve(int i, Scanner in) {
        int number = in.nextInt();
        int appointments[][] = new int[number][4];
        for (int j=0; j<number; j++) {
            for (int k=0; k<2; k++) {
                appointments[j][k] = in.nextInt();
            }
            appointments[j][2] = j;
        }

        Arrays.sort(appointments, (a, b) -> Integer.compare(a[0], b[0]));

        int endOne = 0, endTwo = 0;
        for (int m=0; m<appointments.length; m++) {
//            System.out.println("First Loop: START - " + appointments[m][0] + ", END: " + appointments[m][1]);
            if (appointments[m][0] >= endOne) {
                appointments[m][3] = 200;
//                System.out.println("Changing endOne from " + endOne + " to " + appointments[m][1]);
                endOne = appointments[m][1];
            } else if (appointments[m][0] >= endTwo) {
                appointments[m][3] = 100;
//                System.out.println("Changing endTwo from " + endTwo + " to " + appointments[m][1]);
                endTwo = appointments[m][1];
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(appointments, (a, b) -> Integer.compare(a[2], b[2]));

        StringBuffer sb = new StringBuffer();
        for (int k=0; k<appointments.length; k++) {

            if (appointments[k][3] == 100) {
                sb.append("C");
            } else {
                sb.append("J");
            }
        }

        String str = sb.toString();
        System.out.println("Case #" + i + ": " + str);

//        // Make a graph of which activities collide with others
//        int collisions[][] = new int[number][number];
//        for (int k=0; k<number; k++) {
//            for (int m=0; m<number; m++) {
//
//                // Same activity
//                if (k == m) {
//                    collisions[k][m] = 0;
//                }
//                // Collision for 2 activities
//                else if ((appointments[k][0] < appointments[m][0] && appointments[k][1] > appointments[m][0]) ||
//                        (appointments[m][0] < appointments[k][0] && appointments[m][1] > appointments[k][0])) {
//                    collisions[k][m] = 1;
//                } else {
//                    collisions[k][m] = 0;
//                }
//            }
//        }
//
////        for (int n=0; n<collisions.length; n++) {
////            StringBuffer kk = new StringBuffer();
////            for (int p=0; p<collisions.length; p++) {
////                kk.append(collisions[n][p]);
////                kk.append(" ");
////            }
////            System.out.println(kk);
////        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        ArrayList<Integer> explored = new ArrayList<Integer>();
//
//        queue.add(0);
//        while (queue.size() > 0) {
//            int node = queue.remove();
//            for (int m=0; m<collisions.length; m++) {
//
//                // No Collision
//                if (node == m || collisions[node][m] == 0) {
//                    continue;
//                }
//
//                // Collision Detected - Unable to avoid
//                else if (appointments[node][2] == appointments[m][2]) {
//                    System.out.println("Case #" + i + ": IMPOSSIBLE");
//                    return;
//                }
//                // Assign the other to that activity and add the activity to queue
//                else {
//                    appointments[m][2] = appointments[node][2] == 200 ? 100 : 200;
//
//                    if (!explored.contains(m)) {
//                        queue.add(m);
//                    }
//                }
//            }
//            explored.add(node);
//        }
//
//        StringBuffer sb = new StringBuffer();
//
//        for (int n=0; n<number; n++) {
//            if (appointments[n][2] == 100) {
//                sb.append("J");
//            } else {
//                sb.append("C");
//            }
//        }
//        String str = sb.toString();
//        System.out.println("Case #" + i + ": " + str);
    }
}