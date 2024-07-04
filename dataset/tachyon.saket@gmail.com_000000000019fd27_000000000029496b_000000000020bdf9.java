import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class Schedule implements Comparable<Schedule> {
        int index;
        Integer startTime;
        Integer endTime;

        Schedule(int starTime, int endTime, int index) {
            this.index = index;
            this.startTime = starTime;
            this.endTime = endTime;
        }

        Integer getEndTime() {
            return this.endTime;
        }
        Integer getStartTime() {
            return this.startTime;
        }
        int getIndex() {
            return  this.index;
        }

        @Override
        public int compareTo(Schedule u) {

            return getStartTime().compareTo(u.getStartTime());
        }
    }

    public static void main(String args[]) throws IOException {

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfTest = input.nextInt();

        Solution solutionFinder = new Solution();
        for(int i = 1; i <= numOfTest; i++) {
            int activityCount = input.nextInt();
            List<Integer> startList = new ArrayList<>();
            List<Integer> endList = new ArrayList<>();
            List<Schedule> activitySchedule = new ArrayList<>();
            for(int j = 0 ; j < activityCount; j++) {
                int startTime = input.nextInt();
                int endTime = input.nextInt();
                activitySchedule.add(new Schedule(startTime, endTime, j));
            }
            System.out.println("Case #" + i + ": "+ solutionFinder.getSchedule(activitySchedule));
        }
    }


    public String getSchedule(List<Schedule> scheduleList) {
        Collections.sort(scheduleList);
        int cameronArray[] = new int[1441];
        int jamesArray[] = new int[1441];
        for(int i = 0; i < 1441; i++) {
            cameronArray[i] = 0;
            jamesArray[i] = 0;
        }
        char[] arr = new char[scheduleList.size()];
        for(int i = 0; i< scheduleList.size(); i++) {

            int startTime = scheduleList.get(i).getStartTime();
            int endTime = scheduleList.get(i).getEndTime();

            // Assign to Cameroon if available
            if(checkAvailableAndUpdate(cameronArray, startTime, endTime)) {
                arr[scheduleList.get(i).getIndex()] = 'C';
                continue;
            }

            // Assign to James if available
            if(checkAvailableAndUpdate(jamesArray, startTime, endTime)) {
                arr[scheduleList.get(i).getIndex()] = 'J';
                continue;
            }

            // Return immediately if impossible
            return "IMPOSSIBLE";

        }

        // Return the solution
        return new String(arr);
    }

    private boolean checkAvailableAndUpdate(int arr[], int startTime, int endTime) {
        for(int l =startTime; l < endTime; l++ ) {
            if(arr[l]==1) {
                return false;
            }
        }

        for(int l =startTime; l < endTime; l++ ) {
            arr[l] = 1;
        }

        return true;
    }
}
