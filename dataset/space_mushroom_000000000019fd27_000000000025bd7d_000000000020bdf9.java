import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(List<List<Integer>> list){
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for(int i=0; i<list.size(); i++){
            List<Integer> startEnd = list.get(i);
            int start = startEnd.get(0);
            int end = startEnd.get(1);

            for(int t=start; t<end; t++){
                if(!map.containsKey(t))
                    map.put(t, new ArrayList<>());
                List<Integer> currentTasks = map.get(t);
                if (currentTasks.size() == 2)
                    return "IMPOSSIBLE";
                if(!currentTasks.contains(i))
                    currentTasks.add(i);
            }
        }

        Set<Integer> carter = new HashSet<>();
        Set<Integer> jamie = new HashSet<>();

        for(int t: map.keySet()){
            List<Integer> tasks = map.get(t);
            int task1 = tasks.get(0);
            int task2 = (tasks.size() == 2) ? tasks.get(1) : -1;

            if(task2 == -1){
                if(carter.contains(task1) || jamie.contains(task1))
                    continue;
                carter.add(task1);
                continue;
            }

            if(carter.contains(task1)){
                if(jamie.contains(task2))
                    continue;
                jamie.add(task2);
                continue;
            }
            if(carter.contains(task2)){
                if(jamie.contains(task1))
                    continue;
                jamie.add(task1);
                continue;
            }
            if(!jamie.contains(task1)) {
                carter.add(task1);
                continue;
            }
            if(!jamie.contains(task2)) {
                carter.add(task2);
                continue;
            }
        }

        char[] result = new char[list.size()];
        for(int key: jamie){
            result[key] = 'J';
        }
        for(int key: carter){
            result[key] = 'C';
        }
        return String.valueOf(result);
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                int t1 = input.nextInt();
                int t2 = input.nextInt();
                list.add(new ArrayList<>(Arrays.asList(t1, t2)));
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(list));
        }
    }
}