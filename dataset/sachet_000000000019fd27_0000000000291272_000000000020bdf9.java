
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class EntryTimes implements Comparable<EntryTimes> {
        Integer startTime;
        Integer endTime;
        int number;

        EntryTimes(int starTime, int endTime, int number) {
            this.startTime = starTime;
            this.endTime = endTime;
            this.number = number;
        }

        Integer getEndTime() {
            return this.endTime;
        }
        Integer getStartTime() {
            return this.startTime;
        }
        int getNumber() {
            return  this.number;
        }

        @Override
        public int compareTo(EntryTimes u) {

            return getStartTime().compareTo(u.getStartTime());
        }
    }

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
            List<EntryTimes> times = new ArrayList<>();
            for(int j = 0 ; j < numActivities; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                times.add(new EntryTimes(startTime, endTime, j));
            }
            System.out.println("Case #" + i + ": "+ getAnswer(times));
        }
    }
    public static String getAnswer() {

        return null;
    }

    public static String getAnswer(List<EntryTimes> entryTimes) {
        Collections.sort(entryTimes);
        int cameron[] = new int[1441];
        int james[] = new int[1441];
        for(int i = 0; i < 1441; i++) {
            cameron[i] = 0;
            james[i] = 0;
        }
        char[] arr = new char[entryTimes.size()];
        for(int i = 0 ; i< entryTimes.size(); i ++) {

            //System.out.println(entryTimes.get(i).getStartTime());
            int startTime = entryTimes.get(i).getStartTime();
            int endTime = entryTimes.get(i).getEndTime();

            boolean cHasSpot = hasSlot(cameron, startTime, endTime);

            if(cHasSpot) {
                updateSlot(cameron, startTime, endTime);
                arr[entryTimes.get(i).getNumber()] = 'C';
                //ans = ans + 'C';
                continue;
            }

            boolean jHasSpot = hasSlot(james, startTime, endTime);

            if(jHasSpot) {
                updateSlot(james, startTime, endTime);
                arr[entryTimes.get(i).getNumber()] = 'J';
                //ans = ans + 'J';
                continue;
            }
            return "IMPOSSIBLE";

        }

        return new String(arr);
    }

    public static boolean hasSlot(int arr[], int startTime, int endTime) {
        for(int l =startTime; l < endTime; l++ ) {
            if(arr[l] ==1) {
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
