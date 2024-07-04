
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private boolean isOverlap(int[] e1, int[] e2){
        if( e1 == null || e2 == null)   return false;
//        else if( e1[0] <= e2[0] && e2[0] < e1[1]  ){
////            System.out.println( "Overlap");
//            return true;
//        }else if( e2[0] <= e1[0] && e1[0] < e2[1]  ) {
////            System.out.println( "Overlap");
//            return true;
//        }else if( e1[0] == e2[0] && e1[1] == e2[1]){
//            return true;
//        }
        else if( e1[0] <= e2[0] && e2[0] < e1[1]  ) {
            //System.out.println("Overlap");
            return true;
        }
        return false;
    }

    private void doDFS(int[][] schedules, int level, char[] path, List<String> output, int[] lastC, int[] lastJ) {
        if( level == schedules.length){
//            System.err.println( path );

            output.add(String.valueOf(path));
            return;
        }

        if( level == 0){
            // Cameron
            path[level] = 'C';
            doDFS(schedules, level + 1, path, output, schedules[0], null);

            // Jamie
            path[level] = 'J';
            doDFS(schedules, level + 1, path, output, null, schedules[0]);
        }else{
            int[] prevSchedule = schedules[level-1];
            int[] curSchedule = schedules[level];

            if( isOverlap(lastC, curSchedule) == false){
                // Cameron
                path[level] = 'C';
                doDFS(schedules, level + 1, path, output, curSchedule, lastJ);
            } else if( isOverlap(lastJ, curSchedule) == false ){
                // Jamie
                path[level] = 'J';
                doDFS(schedules, level + 1, path, output, lastC, curSchedule);
            }
        }
    }


    private String arrange(int[][] schedules) {

        int[][] sortSchedules = new int[schedules.length][2];
        for(int i=0;i<sortSchedules.length;i++){
            sortSchedules[i][0] = schedules[i][0];
            sortSchedules[i][1] = schedules[i][1];
        }

        Arrays.sort(sortSchedules, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
//        Arrays.stream(schedules).forEach( e -> System.out.println( e[0] + "\t" + e[1]));

        char[] path = new char[sortSchedules.length];
        List<String> output = new ArrayList<>();
        doDFS(sortSchedules, 0, path, output, null, null);

        if( output.size() == 0){
            return null;
        }
        char[] result = new char[sortSchedules.length];

        String oneSolution = output.get(0);
//        System.out.println( oneSolution );

        for(int i=0;i<sortSchedules.length;i++){
            for(int j=0;j<schedules.length;j++){
                if( sortSchedules[i][0] == schedules[j][0] && sortSchedules[i][1] == schedules[j][1]){
                    result[j] = oneSolution.charAt(i);
                }
            }
        }

        return String.valueOf(result);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[][] schedules = new int[n][2];
            for( int j=0; j < n; j++){
                schedules[j][0] = in.nextInt();
                schedules[j][1] = in.nextInt();
            }

            String output = sol.arrange(schedules);

            if( output == null){
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i));

            }else{
                System.out.println(String.format("Case #%d: %s", i, output));
            }
        }
    }


}