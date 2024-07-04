import java.util.*;
import java.lang.*;

public class Solution {

    private static String getKey(int i, int j){
        return String.valueOf(i) + '-' + String.valueOf(j);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int sum = 0;
            HashSet<Integer> row;
            ArrayList<HashSet<Integer>> col = new ArrayList<>();
            boolean[] cDone = new boolean[n];
            int rCount = 0;
            int cCount = 0;
            for(int i = 0; i < n; i++){
                col.add(new HashSet<Integer>());
            }
            for(int i = 0; i < n; i++){
                row = new HashSet<>();
                boolean done = false;
                for(int j = 0; j < n; j++){
                    int curr = scanner.nextInt();
                    if(i == j){
                        sum += curr;
                    }
                    if(row.contains(curr) && !done){
                        rCount++;
                        done = true;
                    }
                    else{
                        row.add(curr);
                    }
                    if(col.get(j).contains(curr) && cDone[j] == false){
                        cCount++;
                        cDone[j] = true;
                    }
                    else{
                        col.get(j).add(curr);
                    }
                }
            }
            System.out.println(sum + " " + rCount + " " + cCount);
        }
    }
}