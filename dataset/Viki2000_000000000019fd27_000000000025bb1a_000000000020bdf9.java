import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTests = Integer.parseInt(br.readLine());
        for(int i=0; i<numberOfTests; i++){

            int numberOfActivities = Integer.parseInt(br.readLine());
            String lineInput;
            Map<Integer, Map<Integer, Integer>> activities = new HashMap<>(); //Map< indexOfActivity, Map<startTime, endTime> >
            Map<Integer, Integer> activitiesWithoutEndTime = new HashMap<>(); //Map< startTime, indexOfActivity >
            List<Integer> sortedStartTimes = new ArrayList<>();
            for(int j=0; j<numberOfActivities; j++){
                lineInput = br.readLine();
                String[] numbersInString = lineInput.split(" ");
                int start = Integer.parseInt(numbersInString[0]);
                int end = Integer.parseInt(numbersInString[1]);
                Map<Integer, Integer> value = new HashMap<>();
                value.put(start, end);
                activities.put(j, value);
                activitiesWithoutEndTime.put(start, j);
                sortedStartTimes.add(start);
            }

            //testing

            //sorting the activities by startTime
            Collections.sort(sortedStartTimes);

            //finding out which person do which activity
            char[] namesForActivities = new char[numberOfActivities];
            int CfinishesAT =0;
            int JfinishesAT =0;
            boolean impossible = false;
            for(int j=0; j<sortedStartTimes.size(); j++){
                int startTime = sortedStartTimes.get(j);
                int indexOfActivity = activitiesWithoutEndTime.get(startTime);
                int endTime = activities.get(indexOfActivity).get(startTime);
                if(CfinishesAT <= startTime){
                    namesForActivities[indexOfActivity] = 'C';
                    CfinishesAT = endTime;
                }
                else if(JfinishesAT <= startTime){
                    namesForActivities[indexOfActivity] = 'J';
                    JfinishesAT = endTime;
                }
                else{
                    impossible = true;
                }
            }

            //building the string to print out
            if(impossible){
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
            else{
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<numberOfActivities; j++){
                    sb.append(namesForActivities[j]);
                }
                String toReturn = sb.toString();
                System.out.println("Case #" + (i+1) + ": " + toReturn);
            }

        }
        br.close();
    }
}
