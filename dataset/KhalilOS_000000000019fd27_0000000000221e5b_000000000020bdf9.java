import java.util.*;

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
        HashMap<Integer, Integer> dayActivities = new HashMap<Integer, Integer>();
        
        /**
         * The data structure that will contain the schedules
         * for all the activities, on which I'll do the processing
         * to figure out a schedule that works or not everday
        */ 
        LinkedHashMap<Integer, Map<Integer, Integer>> AllActivities =
             new LinkedHashMap<Integer, Map<Integer, Integer>>();
        
        /**
         * The output when no possible convenient schedule has been found on a certain day
        */
        String NEGATIVE = "IMPOSSIBLE";
        
        /**
         * Names of the possible doers
         * C : Cameron
         * J : Jamie
        */ 
        char C = 'C', J = 'J';
        
        /**
         * Parameters of the problem :
         * T is the number of days 
         * N is the number of activities per day
         * S is the number of minutes after midnight. 
         *      -> indicates the start time of an activity
         * E is the number of minutes after midnight.
         *      -> indicates the end time of an activity
        */
        int T = 0, N = 0, S = 0, E = 0;
    
        // reading T
        T = sc.nextInt();
        
        // looping through each day
        for (int i = 1; i <= T; i++) {
            // reading N of the ith day
            N = sc.nextInt();

            // initiating the DS that'll hold day i activities
            AllActivities.put(i, new LinkedHashMap<Integer, Integer>());

            // reading the activities' schedules for day j
            for (int j = 1; j <= N; j++) {
                S = sc.nextInt();
                E = sc.nextInt();
                AllActivities.get(i).put(S, E);
            }
        }
        
        // the order in which Jamie and Cameron will do the activities, if any
        // e.g : JJCJC
        String Answer = "";
        
        // number of the day
        int index = 1;
        Set<Integer> tc = new TreeSet<Integer>();
        Set<Integer> tj = new TreeSet<Integer>();

        for (Map<Integer, Integer> day : AllActivities.values()) {
            // the time on which J/C will be available, again!
            // 100% availabilty for both at midnight 
            for (int i = 0; i <= 1440; i++) {
                tj.add(i);
            }

            for (int i = 0; i <= 1440; i++) {
                tc.add(i);
            }

            for (int s : day.keySet()) {
                if (tj.contains(s) && tj.contains(day.get(s))) {
                    Answer += "J";
                   // System.out.println(s + " - " + day.get(s) + "    Answer now is : " + Answer);
                    tj.removeIf(a -> a >= s && a < day.get(s));
                } else if (tc.contains(s) && tc.contains(day.get(s))) {
                    Answer += "C";
                   // System.out.println(s + " - " + day.get(s) + "    Answer now is : " + Answer);
                        tc.removeIf(a -> a >= s && a < day.get(s));
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
        }

        // testing if input was correctly stored
        /*
         * for (Map<Integer, Integer> day : AllActivities.values()) {
         * System.out.println(day); }
         */

    // public static void freeDay(Set<Integer> tc, Set<Integer> tj) {
        
    // }
}
