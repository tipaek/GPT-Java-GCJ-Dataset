import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            Map<String, Integer> indexMap = new HashMap<>();
            Map<Integer, List<Integer>> valueMap = new HashMap<>();
            int[] startTimes = new int[n];
            String[] resultArr = new String[n];
            String result = "";
            for(int j = 0; j < n; j++){
                String input = sc.nextLine();
                String[] inputArr = input.split(" ");
                indexMap.put(input, j);
                if(!valueMap.containsKey(Integer.parseInt(inputArr[0]))){
                    valueMap.put(Integer.parseInt(inputArr[0]), new ArrayList<>());
                }
                valueMap.get(Integer.parseInt(inputArr[0])).add(Integer.parseInt(inputArr[1]));
                startTimes[j] = Integer.parseInt(inputArr[0]);
            }

            Arrays.sort(startTimes);

            List<int[]> sortedActivities = new ArrayList<>();
            int startTime, endTime;
            int[] current;
            for(int j = 0; j < startTimes.length; j++){
                startTime = startTimes[j];
                for (int k = 0; k < valueMap.get(startTime).size(); k++) {
                    endTime = valueMap.get(startTime).get(k);
                    current = new int[]{startTime, endTime};
                    sortedActivities.add(current);
                }
            }

            resultArr[indexMap.get(sortedActivities.get(0)[0] + " " + sortedActivities.get(0)[1])] = "C";
            String lastPartner = "C";
            int[] cLastActivity = sortedActivities.get(0);
            int[] jLastActivity = new int[]{0, 0};
            for(int j = 1; j < sortedActivities.size(); j++) {
                int index = indexMap.get(sortedActivities.get(j)[0] + " " + sortedActivities.get(j)[1]);
                int prevEnd = sortedActivities.get(j - 1)[1];
                int currStart = sortedActivities.get(j)[0];
                int currEnd = sortedActivities.get(j)[1];

                if(currStart < cLastActivity[1] && currStart < jLastActivity[1]){
                       result = "IMPOSSIBLE";
                       break;
                }else if(lastPartner.equals("C") && currStart < cLastActivity[1]){
                    lastPartner = "J";
                    resultArr[index] = lastPartner;
                    jLastActivity = new int[]{currStart, currEnd};
                }else if(lastPartner.equals("J") && currStart < jLastActivity[1]){
                    lastPartner = "C";
                    resultArr[index] = lastPartner;
                    cLastActivity = new int[]{currStart, currEnd};
                }else{
                    if(lastPartner.equals("C")){
                        cLastActivity = new int[]{currStart, currEnd};
                    }else{
                        jLastActivity = new int[]{currStart, currEnd};
                    }
                    resultArr[index] = lastPartner;
                }
            }
            if(!result.equals("IMPOSSIBLE")){
                result = String.join("", Arrays.asList(resultArr));
            }
            System.out.println("Case #" + (i + 1) + ": " + result);

        }
    }
}
