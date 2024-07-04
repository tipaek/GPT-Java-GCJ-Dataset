import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            boolean possible = true;
            int tasks = sc.nextInt();
            int [] result = new int [tasks];

            HashMap<Integer, ArrayList<Integer>> schedule = new HashMap<>();
            for(int x = 0; x< tasks; x++) {
                ArrayList<Integer> times = new ArrayList<>();
                times.add(sc.nextInt());
                times.add(sc.nextInt());
                schedule.put(x, times);
            }

            HashMap<Integer,  ArrayList<Integer>> sortedSchedule = sortByValue(schedule);

            int jEnd = 0;   //true if jamie can accommodate the task n, false otherwise
            int cEnd = 0;

            for(Map.Entry task: sortedSchedule.entrySet()){
                int index = (int)task.getKey();
                ArrayList<Integer> currentTime = (ArrayList<Integer>)task.getValue();
                int start = currentTime.get(0);
                int end = currentTime.get(1);

                if(start >= jEnd){
                    jEnd = end;
                    result[index] = 1;
                }
                else if(start >= cEnd){
                    cEnd = end;
                    result[index] = -1;
                }
                else possible = false;
            }
            if(possible){
                StringBuilder solution = new StringBuilder();

                for(int c =0; c< tasks; c++){
                    if(result[c] == -1) solution.append('C');
                    else if (result[c] == 1) solution.append('J');
                }
                System.out.println("Case #" + (i + 1) + ": " + solution.toString());
            }
            else System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");

        }
    }

    static HashMap<Integer, ArrayList<Integer>> sortByValue(HashMap<Integer, ArrayList<Integer>> hm)
    {
        List<Map.Entry<Integer, ArrayList<Integer>> > list = new LinkedList<>(hm.entrySet());

        Collections.sort(list, Comparator.comparing(o -> (o.getValue().get(0))));

        HashMap<Integer, ArrayList<Integer>> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}