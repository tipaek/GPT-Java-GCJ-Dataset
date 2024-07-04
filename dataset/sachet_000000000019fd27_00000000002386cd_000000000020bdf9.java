
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String ar[]) throws IOException {

       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int numOfTest = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //int numOfTest = Integer.valueOf(reader.readLine());
        int numOfTest = in.nextInt();

        for(int i = 1 ; i <= numOfTest ; i++) {
            int numActivities = in.nextInt();
            List<Integer> start = new ArrayList<>();
            List<Integer> end = new ArrayList<>();
            for(int j = 0 ; j < numActivities; j++) {
                start.add(in.nextInt());
                end.add(in.nextInt());

            }
            System.out.println("Case #" + i + ": "+ getAnswer(start, end));
        }
    }

    public static String getAnswer(List<Integer> start, List<Integer> end) {
        int c[] = new int[1441];
        int j[] = new int[1441];
        for(int i = 1; i < 1441; i++) {
            c[i] = 0;
            j[i] = 0;
        }
        String ans = "";
        for(int i = 0 ; i< start.size(); i ++) {
            int startTime = start.get(i);
            int endTime = end.get(i);

            boolean cHasSpot = hasSlot(c, startTime, endTime);

            if(cHasSpot) {
                updateSlot(c, startTime, endTime);
                ans = ans + 'C';
                continue;
            }

            boolean jHasSpot = hasSlot(j, startTime, endTime);

            if(jHasSpot) {
                updateSlot(j, startTime, endTime);
                ans = ans + 'J';
                continue;
            }
            return "IMPOSSIBLE";

        }
        return ans;
    }

    public static boolean hasSlot(int arr[], int startTime, int endTime) {
        for(int l =startTime; l < endTime; l++ ) {
            if(arr[l] !=0) {
                return false;
            }
        }
        return true;
    }

    public static void updateSlot(int arr[], int startTime, int endTime) {
        for(int l =startTime; l < endTime; l++ ) {
            arr[l] = 1;
        }
        //return true;
    }
}
