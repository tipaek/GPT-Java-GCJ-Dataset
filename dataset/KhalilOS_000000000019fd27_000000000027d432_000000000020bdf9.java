import java.util.*;
import java.io.*;

/**
 * This class contains the implementation of one solution 
 * for the Parenting Partnering Results problem
 * 
 * Info :
 * int N : Number of activities per day
 * int T : Number of days to try to solve the problem on
 * 
 */
 
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
        //HashMap<Integer, Integer> dayActivities = new HashMap<Integer, Integer>();
      
       //LinkedHashMap<Integer, Map<Integer, Integer>> AllActivities =
        //     new LinkedHashMap<Integer, Map<Integer, Integer>>();
        
        LinkedHashMap<Integer, int[][]> All =
             new LinkedHashMap<Integer, int[][]>();
    
        int T = 0, N = 0, S = 0, E = 0;
    
        // reading T
        T = sc.nextInt();
        
        // looping through each day
        for (int i = 1; i <= T; i++) {
            // reading N of the ith day
            N = sc.nextInt();
            // initiating the DS that'll hold day i activities
            All.put(i, new int[N][2]);

            // reading the activities' schedules for day j
            for (int j = 0; j < N; j++) {
                int[] activity = new int[2];
                activity[0] = sc.nextInt();
                activity[1] = sc.nextInt();
                //AllActivities.get(i).put(S, E);
                All.get(i)[j] = activity;
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
                   // System.out.println(s + " - " + day.get(s) + "    Answer now is : " + Answer);
                    tj.removeIf(a -> a >= d[0] && a < d[1]);
                } else if (tc.contains(d[0]) && tc.contains(d[1])) {
                    Answer += "C";
                   // System.out.println(s + " - " + day.get(s) + "    Answer now is : " + Answer);
                        tc.removeIf(a -> a >= d[0] && a < d[1]);
                } else {
                    Answer = "IMPOSSIBLE";
                    break;
                }
            }
                System.out.println("Case #" + index + ": " + Answer);
                Answer = "";
                index++;
            }

            // System.out.println("tc = " + tc);
            // System.out.println("tj = " + tj);
            // for (int[][] day : All.values()) {
            //     for (int[] d : day) {
            //         for (int a : d) {
            //             System.out.println(a);
            //         }
            //     }
            // }
        }

        // testing if input was correctly stored
        
        
         

    // public static void freeDay(Set<Integer> tc, Set<Integer> tj) {
        
    // }
}
