import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] activities = new int[N][3];
            /*Creat array of activity's start and end time*/
            int startTime, endTime;
            for (int i=0; i<N; i++) {
                startTime = in.nextInt();
                endTime = in.nextInt();
                activities[i] = new int[]{startTime, endTime, i};
            }
            activities = sort3dArray(activities);
            //print2dArray(activities);
            String y = parentingResult(activities, N);
            System.out.println("Case #"+t+": "+y);
        }
    }

    public static String parentingResult(int[][] activities, int N) {
        int[] overlaps = new int[N];
        /*Check for overlaps*/
        for (int i=1; i<N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (activities[i][0] < activities[j][1]) {
                    overlaps[i]++;
                }
            }
        }

        for (int n: overlaps) {
            if (n>1) {
                return "IMPOSSIBLE";
            }
        }

        //System.out.println("Over lap array: "+ Arrays.toString(overlaps));
        /*Divvy roles*/
        char[] parents = new char[]{'J', 'C'};
        char[] parentsOrder = new char[N];
        int index = 0;
        for (int i=0; i<N; i++){
            if (overlaps[i] == 1){
                index = Math.abs(index-1);
            }
            parentsOrder[i] = parents[index];
        }
        char[] unorderedParentsOrder = new char[N];
        for (int i=0; i<N; i++){
            unorderedParentsOrder[activities[i][2]] = parentsOrder[i];
        }
        String str = new String(unorderedParentsOrder);
        return str;
    }

    private static int[][] sort3dArray(int[][] array) {

        for (int i=1; i<array.length; i++){
            for (int j=i-1; j>=0; j--) {
                if (array[j+1][0] < array[j][0]) {
                    int[] temp = Arrays.copyOf(array[j+1],3);
                    array[j+1] = Arrays.copyOf(array[j],3);
                    array[j] = temp;
                }
                else if (array[j+1][0] == array[j][0] && array[j+1][1]<array[j][1]) {
                    int[] temp = Arrays.copyOf(array[j+1],3);
                    array[j+1] = Arrays.copyOf(array[j],3);
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