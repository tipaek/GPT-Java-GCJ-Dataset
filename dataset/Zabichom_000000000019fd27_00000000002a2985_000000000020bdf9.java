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
                }else if(checkC(cList, task)){
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
                    temp.put(j, task);
                }
                if(!cCheck&&!jCheck){
                    impossible = true;
                }
            }
            if(!temp.isEmpty()){
                for(Map.Entry<Integer, ArrayList> entry : temp.entrySet()){
                    int key = entry.getKey();
                    ArrayList value = entry.getValue();
                    boolean jCheck = false;
                    boolean cCheck = false;
                    checkJ(jList, value);
                    checkC(cList, value);
                    if(checkJ(jList, value)){
                        jCheck = true;
                        //jList.add(value);
                        //shift += "J";
                    }
                    if(checkC(cList, value)){
                        cCheck = true;
                        //cList.add(value);
                        //shift += "C";
                    }

                    if(cCheck&&!jCheck){
                        cList.add(value);
                        shift = shifting(key, "C", shift);
                    }
                    if(!cCheck&&jCheck){
                        jList.add(value);
                        shift = shifting(key, "J", shift);
                    }
                    if(cCheck&&jCheck){
                        jList.add(value);
                        shift = shifting(key, "J", shift);
                    }
                    if(!cCheck&&!jCheck){
                        impossible = true;
                    }
                }
            }

            if(impossible)
                shift = "IMPOSSIBLE";
            System.out.println("Case #" + i + ": "+shift);
        }
    }

    public static String shifting(int key, String str, String shift){
        String a = shift;
        String[] arr = a.split("");
        String b = "";
        for(int i=0; i < arr.length ; i++){
            if(i==key){
                b+=str;
            }else{
                b += arr[i];
            }

        }
        return b;
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