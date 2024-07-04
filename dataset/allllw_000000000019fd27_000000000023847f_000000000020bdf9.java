import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = in.nextInt();
        int count = 0;
        List<String> result = new ArrayList<>();
        while(count < num){
            int size = in.nextInt();
            List<int[]> schedule = new ArrayList<>();
            for(int i = 0; i < size; i++){
                schedule.add(new int[]{in.nextInt(),in.nextInt()});
            }
            result.add(calculate(schedule));
            count++;
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println("Case #" + (i + 1) + ": " + result.get(i));
        }
        return;
    }

    private static String calculate(List<int[]> schedule){
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> startTime = new HashMap<>();
        for(int[] i: schedule){
            map.put(i[0], map.getOrDefault(i[0], 0 ) + 1);
            map.put(i[1], map.getOrDefault(i[1], 0 ) - 1);
            startTime.put(i[0], startTime.getOrDefault(i[0],0 ) + 1);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i: map.keySet()){
            count += map.get(i);
            if(count > 2) return "IMPOSSIBLE";
            if(startTime.containsKey(i)){
                for(int j = 0; j < startTime.get(i); j++){
                    if(flag) sb.append('C');
                    else sb.append('J');
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }
}
