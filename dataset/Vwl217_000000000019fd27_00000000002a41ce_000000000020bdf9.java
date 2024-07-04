import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int numCase = 1; numCase <= t; numCase++) {
        int n = in.nextInt();
        int[] startTimeArray = new int[n];
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<List<Integer>, Integer> startEndToIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            int start = in.nextInt();
            startTimeArray[i] = start;
            int end = in.nextInt();
            List<Integer> endTimes;
            if(map.containsKey(start)){
                endTimes = map.get(start);
            }else{
                endTimes = new ArrayList<>();
            }
            endTimes.add(end);
            map.put(start, endTimes);
            List<Integer> startEnd = new ArrayList<>();
            startEnd.add(start);
            startEnd.add(end);
            startEndToIndex.put(startEnd, i);
        }
        Arrays.sort(startTimeArray);
        int cEndTime = 0;
        int jEndTime = 0;
        char[] schedule = new char[n];
        for(int i = 0; i < startTimeArray.length; i++){
            int start = startTimeArray[i];
            int end;
            List<Integer> endTimes = map.get(start);
            if(endTimes.size() > 1){
                Collections.sort(endTimes);
                end = endTimes.remove(0);
                map.put(start, endTimes);
            }else{
                end = endTimes.get(0);
            }
            List<Integer> startEnd = new ArrayList<>();
            startEnd.add(start);
            startEnd.add(end);
            int index = startEndToIndex.get(startEnd);
            if(cEndTime <= start){
                cEndTime = end;
                schedule[index] = 'C';
            }else if(jEndTime <= start){
                jEndTime = end;
                schedule[index] = 'J';
            }else{
                sb.append("IMPOSSIBLE");
                break;
            }
        }
        if(sb.length() == 0){
            for(int i = 0; i < schedule.length; i++){
                sb.append(schedule[i]);
            }
        }
        System.out.println("Case #" + numCase + ": " + sb.toString());
    }
  }
}