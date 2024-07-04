import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tAsString = br.readLine();
        int t = Integer.parseInt(tAsString);
        int[] ns = new int[t];
        ArrayList<ArrayList<ArrayList<Integer>>> activities = new ArrayList<>();
        for(int i = 0; i < t; ++i) {
            activities.add(new ArrayList<>());
            String nAsString = br.readLine();
            int n = Integer.parseInt(nAsString);
            ns[i] = n;
            for(int j = 0; j < n; ++j) {
                activities.get(i).add(new ArrayList<>());
                String line = br.readLine();
                String[]elems = line.split(" ");
                activities.get(i).get(j).add(Integer.parseInt(elems[0]));
                activities.get(i).get(j).add(Integer.parseInt(elems[1]));
            }
        }
        for(int i = 0; i < t; ++i) {
            ArrayList<ArrayList<Integer>> cameron = new ArrayList<>(); 
            ArrayList<ArrayList<Integer>> jamie = new ArrayList<>();
            ArrayList<ArrayList<Integer>> activ = (ArrayList<ArrayList<Integer>>) activities.get(i).clone();
            HashMap<ArrayList<Integer>, String> map = new HashMap<>();
            Collections.sort(activ,new ActivityComparator()); 
            StringBuilder builder = new StringBuilder();
            boolean isBroken = false;
            for(int j = 0; j < ns[i]; ++j) {
                if(isAvailable(activ.get(j), cameron)) {
                    cameron.add(activ.get(j));
                    map.put(activ.get(j),"C");
                }else if(isAvailable(activ.get(j), jamie)) {
                    jamie.add(activ.get(j));
                    map.put(activ.get(j),"J");
                }else {
                    map.put(activities.get(i).get(0), "IMPOSSIBLE");
                    break;
                }
            }
            for(int j = 0; j < ns[i]; ++j) {
                if(map.get(activities.get(i).get(j)) == "IMPOSSIBLE") {
                    System.out.println("Case #"+(i + 1)+": IMPOSSIBLE");
                    isBroken = true;
                    break;
                }else {
                    builder.append(map.get(activities.get(i).get(j)));
                }
            }
            if(!isBroken) {
                System.out.println("Case #"+(i + 1)+": "+builder.toString());
            }
        }
    }

    static class ActivityComparator implements Comparator<ArrayList<Integer>>{

        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if(o1.get(0) == o2.get(0))  
                return 0;  
            else if(o1.get(0) > o2.get(0))  
                return 1;  
            else  
                return -1; 
        }

    }  

    public static boolean isAvailable(ArrayList<Integer> activity, ArrayList<ArrayList<Integer>> person) {
        if(person.isEmpty()) {
            return true;
        }else {
            return activity.get(0) >= person.get(person.size() - 1).get(1);       
        }

    }

}




