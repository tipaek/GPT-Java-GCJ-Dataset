import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Schedular{
    Map<String, ArrayList<ArrayList<Integer>>> map = new HashMap<>();

    public String taskSchedular(ArrayList<ArrayList<Integer>> input){
        ArrayList<ArrayList<Integer>> ctask = new ArrayList<>();
        ArrayList<ArrayList<Integer>> jtask = new ArrayList<>();
        map.put("C", ctask);
        map.put("J", jtask);
        StringBuilder builder = new StringBuilder();
        for(ArrayList<Integer> i : input){
            
            String chk = checkClash(i);
            if(chk.equals("IMPOSSIBLE")){
                return "IMPOSSIBLE";
            }
            else{
                builder.append(chk);
            }
            System.out.println(i.get(0) + " " + i.get(1));
        }
        return builder.toString();
    }

    private String checkClash(ArrayList<Integer> i){
        ArrayList<ArrayList<Integer>>  cTask = map.get("C");
        ArrayList<ArrayList<Integer>>  jTask = map.get("J");

        if(cTask.size() == 0){
            cTask.add(i);
            map.put("C", cTask);
            return "C";
        }
        if(jTask.size() == 0){
            jTask.add(i);
            map.put("J", jTask);
            return "J";
        }
        for(ArrayList<Integer> task : cTask){


                if(i.get(0) >= task.get(1) || (i.get(0)  < task.get(0) && i.get(1) <= task.get(0))){
                    cTask.add(i);
                    map.put("C", cTask);
                    return "C";
                }

        }
        for(ArrayList<Integer> task : jTask){


                if(i.get(0) >= task.get(1) || (i.get(0)  < task.get(0) && i.get(1) <= task.get(0))) {
                    cTask.add(i);
                    map.put("J", jTask);
                    return "J";
                }
        }

        return "IMPOSSIBLE";

    }


}


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        Schedular obj = new Schedular();
        for(int i=1;i <= t; i++)
        {	int inputTime = in.nextInt();
            ArrayList<ArrayList<Integer>> input = new ArrayList<>();

            for(int j=0; j<inputTime;j++){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(in.nextInt());
                l.add(in.nextInt());
                input.add(l);
            }

            String output = obj.taskSchedular(input);
            System.out.println("Case #" + i + ": " + output);

        }
    }
}

