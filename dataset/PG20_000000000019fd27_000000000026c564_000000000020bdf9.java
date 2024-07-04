import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        int cases= sc.nextInt();
        for (int k=0; k<cases; k++){
            int jobs= sc.nextInt();
            String[] ans = new String[jobs];
            ArrayList<Integer[]> intervals = new ArrayList<>();
            Map<Integer[], Integer> order = new HashMap<>();
            ArrayList<Integer[]> C= new ArrayList<>();
            ArrayList<Integer[]> J=new ArrayList<>();
            for (int i=0; i<jobs; i++) {
                Integer[] interval = new Integer[]{sc.nextInt(), sc.nextInt()};
                intervals.add(interval);
                order.put(interval, i);
            }
            intervals.sort(Comparator.comparing(integers -> integers[0]));
            boolean flag = false;
            for (Integer[] interval: intervals){
                if (C.isEmpty()) {
                    C.add(interval);
                    ans[order.get(interval)] =  "C";
                } else if (interval[0] >= C.get(C.size()-1)[1]){
                    C.add(interval);
                    ans[order.get(interval)] =  "C";
                } else if (J.isEmpty()) {
                    J.add(interval);
                    ans[order.get(interval)] =  "J";
                } else if (interval[0] >= J.get(J.size()-1)[1]){
                    J.add(interval);
                    ans[order.get(interval)] =  "J";
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
            else System.out.println("Case #"+(k+1)+": "+String.join("", ans));
        }
    }
}