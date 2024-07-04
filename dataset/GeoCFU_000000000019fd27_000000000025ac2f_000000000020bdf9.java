import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner S = new Scanner(System.in);
        Integer T = S.nextInt();
        for(Integer t = 0 ; t < T ;t++) {
            String result = "";
           Integer actNum = S.nextInt();
           int j = -1;
           int c = -1;
           List<Integer[]> activities = new ArrayList<Integer[]>();
           for(int act = 0 ; act < actNum ; act++){
                int start = S.nextInt();
                int end = S.nextInt();
                activities.add(new Integer[]{start, end});
           }
           Collections.sort(activities, (a, b)->{
               return a[0] - b[0];
           });

           Boolean possible = true;
           for(int i = 0; i < activities.size() ; i++){
               Integer[] a = activities.get(i);
                if(a[0] >= j){
                    j = a[1];
                    result += 'J';
                } else if(a[0] >= c){
                    c = a[1];
                    result += "C";
                } else {
                    possible = false;
                    break;
                }
           }

           //activities.forEach(a-> {System.out.println(a[0] + " -> " + a[1]);});
            System.out.println("Case #" + (t+1) + ": " + (possible? result : "IMPOSSIBLE"));
           //System.out.println("======");
        }

    }
}