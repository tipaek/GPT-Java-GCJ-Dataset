import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int test = 1; test<=t; test++){
            int n = in.nextInt();
            TreeMap<Integer, ArrayList<Integer>> startToEndMap = new TreeMap<>();
            List<String> activityList = new ArrayList<>();
            for(int i = 0; i<n; i++){
                int start = in.nextInt();
                int end = in.nextInt();
                startToEndMap.putIfAbsent(start, new ArrayList<>());
                startToEndMap.get(start).add(end);
                activityList.add(start+","+end);
            }
            Map<String, LinkedList<String>> activityMap = new HashMap<>();
            int camEndTime = -1;
            int jamieEndTim = -1;
            StringBuilder sb = new StringBuilder();
            boolean possible = true;
            for (Integer key: startToEndMap.keySet()){
                for(Integer endTime: startToEndMap.get(key)) {
                    if (key >= camEndTime) {
                        camEndTime = endTime;
                        activityMap.putIfAbsent(key + "," + endTime, new LinkedList<>());
                        activityMap.get(key + "," + endTime).add("C");
                    } else if (key >= jamieEndTim) {
                        jamieEndTim = endTime;
                        activityMap.putIfAbsent(key + "," + endTime, new LinkedList<>());
                        activityMap.get(key + "," + endTime).add("J");
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            if(!possible) System.out.println(String.format("Case #%d: %s", test, "IMPOSSIBLE"));
            else {
                for(String activity: activityList){
                    sb.append(activityMap.get(activity).getFirst());
                    if(activityMap.get(activity).size()>1){
                        activityMap.get(activity).addFirst(activityMap.get(activity).getLast());
                    }
                }
                System.out.println(String.format("Case #%d: %s", test, sb.toString()));
            }
        }
    }
}
