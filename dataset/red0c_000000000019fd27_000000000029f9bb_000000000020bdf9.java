import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int ti=1;ti<=t;ti++){

            int n = in.nextInt();

            HashMap<Integer,Integer> tasks = new HashMap<>();
            HashMap<Integer,Integer> cTasks = new HashMap<>();
            HashMap<Integer,Integer> jTasks = new HashMap<>();
            HashMap<Integer,Integer> order = new HashMap<>();
            boolean cCan;
            boolean jCan;
            boolean isImpossible = false;
            char charAns [] = new char[n];

            for(int i=0;i<n;i++){
                int start = in.nextInt();
                int end = in.nextInt();
                tasks.put(start,end);
                order.put(start,i);
            }

            Map<Integer,Integer> sortedTasks = new TreeMap<>(tasks);

            for (Map.Entry<Integer, Integer> sortedEntry : sortedTasks.entrySet()){

                cCan = true;
                jCan = true;

                int start = sortedEntry.getKey();
                int end = sortedEntry.getValue();

                for (Map.Entry<Integer, Integer> entry : cTasks.entrySet()) {
                    int entryEnd = entry.getValue();
                    if(start < entryEnd){
                        cCan = false;
                        break;
                    }
                }
                if(cCan){
                    charAns[order.get(start)] = 'C';
                    cTasks.put(start,end);
                    continue;
                }

                for (Map.Entry<Integer, Integer> entry : jTasks.entrySet()) {
                    int entryEnd = entry.getValue();
                    if(start < entryEnd){
                        jCan = false;
                        break;
                    }
                }
                if(jCan){
                    charAns[order.get(start)] = 'J';
                    jTasks.put(start,end);
                    continue;
                }

                isImpossible = true;
                break;
            }

            String finalAns;
            if(isImpossible)
                finalAns = "IMPOSSIBLE";
            else
                finalAns = new String(charAns);

            System.out.println("Case #"+ti+": "+finalAns);

        }
    }
}