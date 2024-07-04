import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        ArrayList<ArrayList<Integer>> jList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> cList = new ArrayList<>();

        String shift = "";
        for (int i = 1; i <= t; ++i) {
            jList.clear();
            cList.clear();
            boolean impossible = false;
            shift = "";
            int n = in.nextInt();
            for (int j = 0; j < n; j++){
                int start = in.nextInt();
                int end = in.nextInt();
                ArrayList<Integer> task = new ArrayList<>();
                task.add(start);
                task.add(end);

                if(checkJ(jList, task)){
                    jList.add(task);
                    shift += "J";
                }else if(checkC(cList, task)){
                    cList.add(task);
                    shift += "C";
                }else{
                    impossible = true;
                }
            }
            if(impossible)
                shift = "IMPOSSIBLE";
            System.out.println("Case #" + i + ": "+shift);
        }
    }

    public static boolean checkJ(ArrayList<ArrayList<Integer>> jList, ArrayList<Integer> task) {
        if(jList.isEmpty()){
            jList.add(task);
            return true;
        }

        for(int i = 0; i < jList.size(); i++){
            if(task.get(1) <= jList.get(i).get(0) || jList.get(i).get(1) <= task.get(0)){

            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean checkC(ArrayList<ArrayList<Integer>> cList, ArrayList<Integer> task) {
        if(cList.isEmpty()){
            cList.add(task);
            return true;
        }

        for(int i = 0; i < cList.size(); i++){
            if(task.get(1) <= cList.get(i).get(0) || cList.get(i).get(1) <= task.get(0)){

            }else{
                return false;
            }
        }
        return true;
    }
}