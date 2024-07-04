import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int ti=1;ti<=t;ti++){

            int n = in.nextInt();

            HashMap<Integer,Integer> cTasks = new HashMap<>();
            HashMap<Integer,Integer> jTasks = new HashMap<>();
            boolean cCan;
            boolean jCan;
            String ans = "";

            for(int i=0;i<n;i++){

                cCan = true;
                jCan = true;

                int start = in.nextInt();
                int end = in.nextInt();

                for (Map.Entry<Integer, Integer> entry : cTasks.entrySet()) {
                    int entryStart = entry.getKey();
                    int entryEnd = entry.getValue();
                    if((entryStart <= start && entryEnd >= end) || (entryStart>= start && entryEnd <= end) || (entryStart < end && entryEnd > start) || (entryEnd > start && entryStart < end)){
                        cCan = false;
                        break;
                    }
                }
                if(cCan){
                    ans+="C";
                    cTasks.put(start,end);
                    continue;
                }

                for (Map.Entry<Integer, Integer> entry : jTasks.entrySet()) {
                    int entryStart = entry.getKey();
                    int entryEnd = entry.getValue();
                    if((entryStart <= start && entryEnd >= end) || (entryStart>= start && entryEnd <= end) || (entryStart < end && entryEnd > start) || (entryEnd > start && entryStart < end)){
                        jCan = false;
                        break;
                    }
                }
                if(jCan){
                    ans+="J";
                    jTasks.put(start,end);
                    continue;
                }

                ans = "IMPOSSIBLE";
                break;
            }

            System.out.println("Case #"+ti+": "+ans);

        }
    }
}