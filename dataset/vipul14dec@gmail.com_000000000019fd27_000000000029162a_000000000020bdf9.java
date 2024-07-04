import java.util.*;
import java.io.*;
public class Solution {
    public static boolean canDo(ArrayList<ArrayList<Integer>> ll, int start, int end) {
        for(List<Integer> l : ll) {
            if((start > l.get(0) && start < l.get(1)) || (end > l.get(0) && end < l.get(1))
            || (start < l.get(0) && end>l.get(1))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i< t;i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] schedule = new int[n][2];
            String result = "";
            ArrayList<ArrayList<Integer>> jamieList = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> charlieList = new ArrayList<ArrayList<Integer>>();
            for(int j=0;j<n;j++) {
                String str[] = sc.nextLine().trim().split("\\s+");
                schedule[j][0] = Integer.parseInt(str[0]);
                schedule[j][1] = Integer.parseInt(str[1]);
                if(canDo(jamieList, schedule[j][0], schedule[j][1])) {
                    result += "J";
                    jamieList.add(new ArrayList<>(Arrays.asList(schedule[j][0], schedule[j][1])));
                }
                else {
                    if(canDo(charlieList, schedule[j][0], schedule[j][1])) {
                    result += "C";
                    charlieList.add(new ArrayList<>(Arrays.asList(schedule[j][0], schedule[j][1])));
                    }
                    else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + result);
        }
        sc.close();
    }
}