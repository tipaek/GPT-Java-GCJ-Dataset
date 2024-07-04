import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] activities = new int[N][2];
            /*Creat array of activity's start and end time*/
            int startTime, endTime;
            for (int i=0; i<N; i++) {
                startTime = in.nextInt();
                endTime = in.nextInt();
                activities[i] = new int[]{startTime, endTime};
            }
            activities = sort2dArray(activities);
            //print2dArray(activities);
            String y = parentingResult(activities, N);
            System.out.println("Case #"+t+": "+y);
        }
    }

    public static String parentingResult(int[][] activities, int N) {
        int[] overlaps = new int[N];
        /*Check for overlaps*/
        for (int i=1; i<N; i++) {
            if (activities[i][0]<activities[i-1][1]) {
                overlaps[i]++;
                if (i-2>=0 && activities[i][0]<activities[i-2][1]) {
                    return "IMPOSSIBLE";
                }
            }
        }
        //System.out.println("Over lap array: "+ Arrays.toString(overlaps));
        /*Divvy roles*/
        String[] parents = new String[]{"J", "C"};
        String parentsOrder = "";
        int index = 0;
        for (int i=0; i<N; i++){
            if (overlaps[i] == 1){
                index = Math.abs(index-1);
            }
            parentsOrder += parents[index];
        }
        return parentsOrder;
    }

    private static int[][] sort2dArray(int[][] array) {

        for (int i=1; i<array.length; i++){
            for (int j=i-1; j>=0; j--) {
                if (array[j+1][0] < array[j][0]) {
                    int[] temp = Arrays.copyOf(array[j+1],2);
                    array[j+1] = Arrays.copyOf(array[j],2);
                    array[j] = temp;
                }
                else {
                    break;
                }
            }
        }
        return array;
    }

    private static void print2dArray(int[][] array) {
        System.out.print("[ ");
        for (int i=0; i<array.length; i++) {
            System.out.print("("+array[i][0]+", "+array[i][1]+"), ");
        }
        System.out.print(" ]");
    }
}
