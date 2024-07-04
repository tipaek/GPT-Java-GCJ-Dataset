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
            Map<Integer, ArrayList> temp = new HashMap<>();
            int n = in.nextInt();
            for (int j = 0; j < n; j++){
                int start = in.nextInt();
                int end = in.nextInt();
                ArrayList<Integer> task = new ArrayList<>();
                task.add(start);
                task.add(end);

                boolean jCheck = false;
                boolean cCheck = false;

                if(j == 0) {
                    jList.add(task);
                    shift += "J";
                    continue;
                }

                if(checkJ(jList, task)){
                    jCheck = true;
                    //jList.add(task);
                    //shift += "J";
                }
                if(checkC(cList, task)){
                    cCheck = true;
                    //cList.add(task);
                    //shift += "C";
                }

                if(cCheck&&!jCheck){
                    cList.add(task);
                    shift += "C";
                }
                if(!cCheck&&jCheck){
                    jList.add(task);
                    shift += "J";
                }
                if(cCheck&&jCheck){
                    if(Random(cList, jList, task)){
                        cList.add(task);
                        shift += "C";
                    }else{
                        jList.add(task);
                        shift += "J";
                    }
                }
                if(!cCheck&&!jCheck){
                    impossible = true;
                }
            }
            if(impossible)
                shift = "IMPOSSIBLE";
            System.out.println("Case #" + i + ": "+shift);
        }
    }

    public static boolean Random(ArrayList<ArrayList<Integer>> jList, ArrayList<ArrayList<Integer>> cList, ArrayList<Integer> task){
        ArrayList<Integer> jArray = new ArrayList();
        for(int i = 0; i < jList.size(); i++) {
            jArray.add(jList.get(i).get(0) - task.get(1));
            jArray.add(task.get(0) - jList.get(i).get(1));
        }

        ArrayList<Integer> cArray = new ArrayList();
        for(int i = 0; i < cList.size(); i++) {
            cArray.add(cList.get(i).get(0) - task.get(1));
            cArray.add(task.get(0) - cList.get(i).get(1));
        }

        int min1 = Collections.min(jArray);
        int min2 = Collections.min(cArray);

        if(min2 - min1>= 0) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean checkJ(ArrayList<ArrayList<Integer>> jList, ArrayList<Integer> task) {
        if(jList.isEmpty()){
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