import java.util.*;
import java.io.*;
 
class Solution {
    
    public static void main(String[] args) {
        /**
         * Input reader
        */ 
        Scanner sc = new Scanner(System.in);
        
        /**
         * The data structure that will contain the schedules
         * for the activities of a day, on which I'll do the processing
         * to figure out a working schedule for the day, if possible
        */ 
        
        LinkedHashMap<Integer, int[][]> All = new LinkedHashMap<Integer, int[][]>();
    
        int T = 0, N = 0;
    
        // reading T
        T = sc.nextInt();
        
        // looping through each day
        for (int i = 0; i <= T; i++) {
            N = sc.nextInt();
            All.put(i, new int[N][2]);

            // reading the activities' schedules for day j
            for (int j = 0; j < N; j++) {
                All.get(i)[j][0] = sc.nextInt();
                All.get(i)[j][1] = sc.nextInt();
            }
        }
        
        // the order in which Jamie and Cameron will do the activities, if any
        // e.g : JJCJC
        String Answer = "";
        
        // number of the day
        int index = 1;
        Set<Integer> tc = new TreeSet<Integer>();
        Set<Integer> tj = new TreeSet<Integer>();

        for (int[][] day : All.values()) {
            // the time on which J/C will be available, again!
            // 100% availabilty for both at midnight 
            for (int i = 0; i <= 1440; i++) {
                tj.add(i);
            }

            for (int i = 0; i <= 1440; i++) {
                tc.add(i);
            }

            for (int[] d : day) {
                if (tj.contains(d[0]) && tj.contains(d[1])) {
                    Answer += "J";
                    tj.removeIf(a -> a >= d[0] && a < d[1]);
                } else if (tc.contains(d[0]) && tc.contains(d[1])) {
                    Answer += "C";
                        tc.removeIf(a -> a >= d[0] && a < d[1]);
                } else {
                    Answer = "IMPOSSIBLE";
                    break;
                }
            }
                // System.out.println("Case #" + index + ": " + Answer);
                Answer = "";
                index++;
            }

            // for (int[][] day : All.values()) {
            //     for (int[] d : day) {
            //         for (int a : d) {
            //             System.out.print(a + " - ");
            //         }
            //         System.out.println();
            //     }
            // }
    }
}
