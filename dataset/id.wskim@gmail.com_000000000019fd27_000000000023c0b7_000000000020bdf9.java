import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private void print(int[] e){
        System.out.println( e[0] + "\t" + e[1]);
    }

    private boolean isOverlap(Stack<int[]> stack, int[] e){
        List<int[]> list = new ArrayList<>(stack);
        for(int[] e1 : list){
            if( isOverlap(e1, e)){

//                System.out.println("===Overlap S======");
//                print(e1);
//                print(e);
//                System.out.println("===Overlap E======");

                return true;
            }
        }

        return false;
    }

    private boolean isOverlap(int[] e1, int[] e2){
        if( e1 == null || e2 == null)   return false;
        else if( e1[0] < e2[0] && e2[0] < e1[1]  ){
//            System.out.println( "Overlap");
            return true;
        }else if( e2[0] < e1[0] && e1[0] < e2[1]  ) {
//            System.out.println( "Overlap");
            return true;
        }
        return false;
    }

    private void doDFS(int[][] schedules, int level, char[] path, List<String> output, Stack<int[]> historyC, Stack<int[]> historyJ) {
        if( level == schedules.length){
//            System.err.println( path );

            output.add(String.valueOf(path));
            return;
        }

        int[] curSchedule = schedules[level];

        if( level == 0){
            // Cameron
            path[level] = 'C';
            historyC.push(curSchedule);
            doDFS(schedules, level + 1, path, output, historyC, historyJ);
            historyC.pop();

            // Jamie
            path[level] = 'J';
            historyJ.push(curSchedule);
            doDFS(schedules, level + 1, path, output, historyC, historyJ);
            historyJ.pop();

        }else{

//            if( level == 1){
//                System.out.println( "isOverlap(historyC, curSchedule)");
//                System.out.println(historyC.size());
//                new ArrayList<int[]>(historyC).stream().forEach( e -> print(e));
//                print(curSchedule);
//                System.out.println(isOverlap(historyC, curSchedule));
//                System.out.println("-------------------");
//            }

            if( isOverlap(historyC, curSchedule) == false){
                // Cameron
                path[level] = 'C';
                historyC.push(curSchedule);
                doDFS(schedules, level + 1, path, output, historyC, historyJ);
                historyC.pop();
            } else if( isOverlap(historyJ, curSchedule) == false ){
                // Jamie
                path[level] = 'J';
                historyJ.push(curSchedule);
                doDFS(schedules, level + 1, path, output, historyC, historyJ);
                historyJ.pop();
            }
        }
    }


    private String arrange(int[][] schedules) {

        char[] path = new char[schedules.length];

        Stack<int[]> historyC = new Stack<>();
        Stack<int[]> historyJ = new Stack<>();

        List<String> output = new ArrayList<>();
        doDFS(schedules, 0, path, output, historyC, historyJ);

        if( output.size() == 0){
            return null;
        }

        return output.get(0);
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
