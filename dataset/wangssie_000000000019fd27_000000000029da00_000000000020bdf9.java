import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int JAMIE = 0;
    static int CAMERON = 1;
    public static void main(String[] Args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] activities = new int[N][4];
            /*Creat array of activity's start and end time*/
            int startTime, endTime;
            for (int i=0; i<N; i++) {
                startTime = in.nextInt();
                endTime = in.nextInt();
                activities[i] = new int[]{startTime, endTime, i, -1};
            }
            activities = sort4dArray(activities);
            String y = parentingResult(activities);
            System.out.println("Case #"+t+": "+y);
        }
    }
    private static String parentingResult(int[][] array) {
        int[][] jamie = new int[array.length+1][2];
        int jamieIndex = 0;
        int[][] cameron = new int[array.length+1][2];
        int cameronIndex=0;
        for (int i=0; i<array.length; i++) {
            if (jamie[jamieIndex][1] <= array[i][0]) {
                jamieIndex++;
                jamie[jamieIndex] = Arrays.copyOf(array[i], 2);
                array[i][3] = JAMIE;
            } else if (cameron[cameronIndex][1] <= array[i][0]) {
                cameronIndex++;
                cameron[cameronIndex] = Arrays.copyOf(array[i], 2);
                array[i][3] = CAMERON;
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        int index, parent;
        char parentChar;
        char[] parentsOrder = new char[array.length];
        for (int i=0; i<array.length; i++){
            index = array[i][2];
            parent = array[i][3];
            parentChar = (parent==JAMIE)?'J':'C';
            parentsOrder[index] = parentChar;
        }
        String parentsOrderString = new String(parentsOrder);
        return parentsOrderString;
    }

    private static int[][] sort4dArray(int[][] array) {

        for (int i=1; i<array.length; i++){
            for (int j=i-1; j>=0; j--) {
                if (array[j+1][0] < array[j][0]) {
                    int[] temp = Arrays.copyOf(array[j+1],4);
                    array[j+1] = Arrays.copyOf(array[j],4);
                    array[j] = temp;
                }
                else {
                    break;
                }
            }
        }
        return array;
    }
    private static void print4dArray(int[][] array) {
        System.out.print("[ ");
        for (int i=0; i<array.length; i++) {
            System.out.print("("+array[i][0]+", "+array[i][1]+", "+array[i][2]+", "+array[i][3]+"), ");
        }
        System.out.print(" ]");
    }
}
