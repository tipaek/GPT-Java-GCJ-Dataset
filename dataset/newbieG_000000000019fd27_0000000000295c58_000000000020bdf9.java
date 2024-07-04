import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static TreeMap<Integer, Integer[]> timePeriod = new TreeMap<>();

    public static void main(String[] args) {
        int testCase;
        int numberOfActivity;
        String[] result;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCase = Integer.parseInt(in.nextLine().trim());
        result = new String[testCase];
        for(int i=0; i<testCase; i++){
            numberOfActivity = Integer.parseInt(in.nextLine().trim());
            for (int j=0; j<numberOfActivity; j++) {
                String inputString = in.nextLine().trim();
                StringTokenizer tmp = new StringTokenizer(inputString.trim(), " ");
                int startTime = Integer.parseInt(tmp.nextToken());
                int endTime = Integer.parseInt(tmp.nextToken());
                Integer[] endTimeAndTrack = new Integer[]{endTime,j};
                timePeriod.put(startTime, endTimeAndTrack);
            }
            result[i] = assingedActivity(numberOfActivity);
        }
        for (int i = 0; i < testCase; i++) {
            if(result[i] == null)
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static String assingedActivity(int numberOfActivity){
        if(numberOfActivity == 2) {
            timePeriod.clear();
            return "CJ";
        }

        ArrayList<Integer> startTimeList = new ArrayList<>(numberOfActivity);
        ArrayList<Integer[]> endTimeAndTrackList = new ArrayList<>(numberOfActivity);
        StringBuilder workOrder = new StringBuilder(numberOfActivity);

        for(Map.Entry<Integer, Integer[]> entry : timePeriod.entrySet()) {
           startTimeList.add(entry.getKey());
           endTimeAndTrackList.add(entry.getValue());
        }

        int cameronWorkEndTime = endTimeAndTrackList.get(0)[0];
        workOrder.append('C');

        int jamieWorkingEndTime = -1;

        for(int i=1; i<numberOfActivity; i++){
            if(startTimeList.get(i) < endTimeAndTrackList.get(i-1)[0]) {

                if(cameronWorkEndTime <= startTimeList.get(i))
                    cameronWorkEndTime = -1;
                if(jamieWorkingEndTime <= startTimeList.get(i))
                    jamieWorkingEndTime = -1;

                if(jamieWorkingEndTime == -1 ) {
                    jamieWorkingEndTime = endTimeAndTrackList.get(i)[0];
                    workOrder.append('J');
                }
                else if(cameronWorkEndTime == -1) {
                    cameronWorkEndTime = endTimeAndTrackList.get(i)[0];
                    workOrder.append('C');
                } else {
                    timePeriod.clear();
                    return null;
                }
            } else {
                if(cameronWorkEndTime <= startTimeList.get(i)) {
                    cameronWorkEndTime = endTimeAndTrackList.get(i)[0];
                    workOrder.append('C');
                }
                else if(jamieWorkingEndTime <= startTimeList.get(i)) {
                    jamieWorkingEndTime = endTimeAndTrackList.get(i)[0];
                    workOrder.append('J');
                } else {
                    timePeriod.clear();
                    return null;
                }
            }
        }
        timePeriod.clear();
        StringBuilder sb = new StringBuilder(numberOfActivity);
        sb.append(workOrder);
        for(int i =0; i<numberOfActivity; i++)
        sb.setCharAt(endTimeAndTrackList.get(i)[1], workOrder.charAt(i));
        return sb.toString();
    }
}
