import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static boolean assignTask(Map<Integer, Integer> person, List<Integer> task, int taskNumber){
        int start = task.get(0);
        int end = task.get(1);

        for(int t=start; t<end; t++){
            if(person.containsKey(t))
                return false;
        }

        for(int t=start; t<end; t++){
            person.put(t, taskNumber);
        }
        return true;
    }

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

        Set<Integer> assigned = new HashSet<>();
        assigned.add(-1);
        Map<Integer, Integer> carter = new TreeMap<>();
        Map<Integer, Integer> jamie = new TreeMap<>();

        for(int t: map.keySet()){
            List<Integer> tasks = map.get(t);
            int task1 = tasks.get(0);
            int task2 = (tasks.size() == 2) ? tasks.get(1) : -1;

            if(!assigned.contains(task1)) {
                if (!assignTask(carter, list.get(task1), task1))
                    assignTask(jamie, list.get(task1), task1);
                assigned.add(task1);
            }

            if(!assigned.contains(task2)){
                if(!assignTask(carter, list.get(task2), task2))
                    assignTask(jamie, list.get(task2), task2);
                assigned.add(task2);
            }
        }

        char[] result = new char[list.size()];
        for(int key: jamie.keySet()){
            int value = jamie.get(key);
            result[value] = 'J';
        }
        for(int key: carter.keySet()){
            int value = carter.get(key);
            result[value] = 'C';
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