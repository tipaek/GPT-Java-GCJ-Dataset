import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
        public static boolean comp(List<Integer[]> currentTimestamp, Integer[] newTimestamp){
            boolean flag = true;
            for (Integer[] timestamp:currentTimestamp){
                Integer s = newTimestamp[0];
                Integer e = newTimestamp[1];
                if ((s > timestamp[0] && s<timestamp[1]) || (s<timestamp[0] && s>timestamp[1])
                        || (s.equals(timestamp[0]) && s>timestamp[1]) || (s.equals(timestamp[0]) && s<timestamp[1])
                        || (s>timestamp[0] && s.equals(timestamp[1])) || (s<timestamp[0] && s.equals(timestamp[1])) ) {
                    flag = false;
                }
                if ((e > timestamp[0] && e<timestamp[1]) || (e<timestamp[0] && e>timestamp[1])
                        || (e.equals(timestamp[0]) && e>timestamp[1]) || (e.equals(timestamp[0]) && e<timestamp[1])
                        || (e>timestamp[0] && e.equals(timestamp[1])) || (e<timestamp[0] && e.equals(timestamp[1]))){
                    flag = false;
                }
                if (s.equals(timestamp[0]) && e.equals(timestamp[1])){
                    flag = false;
                    break;
                }
                if (s < timestamp[0] && e > timestamp[1]){
                    flag = false;
                    break;
                }
                if ((s>timestamp[0] && s.equals(timestamp[1])) && (e>timestamp[0] &&  e>timestamp[1])){
                    flag = true;
                }
                if ((s<timestamp[0] && s<timestamp[1]) && (e.equals(timestamp[0]) && e<timestamp[1])){
                    flag = true;
                }
            }
            
            return flag;
        }

        public static String solve(List<Integer[]>  actList){
            int freeJamie = 24*60;
            int freeCameron = 24*60;
            List<Integer[]> Jamie = new ArrayList<>();
            List<Integer[]> Cameron = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (Integer[] timestamp: actList){
                if (comp(Jamie,timestamp)){
                    Jamie.add(timestamp);
                    freeJamie -= timestamp[1]- timestamp[0];
                    sb.append("C");
                }else if (comp(Cameron, timestamp)){
                    Cameron.add(timestamp);
                    freeCameron -= timestamp[1]- timestamp[0];
                    sb.append("J");
                }else {
                    flag = true;
                }
            }
            if (freeCameron<0 || freeJamie<0) flag = true;
            if (flag) return "IMPOSSIBLE";
            return sb.toString();
        }

        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for (int i = 1; i <= t; i++){
                int n = in.nextInt();
                List<Integer[]>  actList = new ArrayList<>();
                for (int j=0; j<n; j++){

                    Integer[] act = new Integer[2];
                    for (int k=0; k<2; k++){
                        act[k] = in.nextInt();
                    }
                    actList.add(act);

                }

                System.out.println("Case #" + i + ": " + solve(actList));
            }
        }
    }