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
        }
        Arrays.sort(startTimeArray);
        int cEndTime = 0;
        int jEndTime = 0;
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
            if(cEndTime <= start){
                cEndTime = end;
                sb.append("C");
            }else if(jEndTime <= start){
                jEndTime = end;
                sb.append("J");
            }else{
                sb = new StringBuilder();
                sb.append("IMPOSSIBLE");
                break;
            }
        }
        System.out.println("Case #" + numCase + ": " + sb.toString());
    }
  }
}