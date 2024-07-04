import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int test = 1; test <= t; ++test) {

        String ans = "";

        int n = sc.nextInt();
        int timeJ = 0;
        int timeC = 0;

        int[][] sorting = new int[n][3];
        Map<Integer,Character> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            sorting[i] = new int[]{i,start,end};
        }

        Arrays.sort(sorting,(a,b) -> Integer.compare(a[1],b[1]));
        
        map.put(sorting[0][0],'C');
        int second[] = sorting[1];
        timeC = Math.max(timeC,sorting[0][2]);

        if (second[1]<sorting[0][2]) {
            map.put(sorting[1][0],'J');
            timeJ = Math.max(timeJ,sorting[1][2]);
        }
        else {
            map.put(sorting[1][0],'C');
            timeC = Math.max(timeJ,sorting[1][2]);
        }

        int flag = 0;
        for(int i = 2;i<n;i++){
            
            int current[] = sorting[i];
            if (current[1]>=timeC){
                timeC = Math.max(timeC, current[2]);
                map.put(current[0],'C');
            }
            else if(current[1]>=timeJ){
                timeJ = Math.max(timeJ, current[2]);
                map.put(current[0],'J');
            }
            else{
                flag = 1;
                break;
            }
        }

        if (flag == 1)
            ans = "IMPOSSIBLE";
        else{
            for(int i = 0;i<n;i++){
                ans+=map.get(i);
            }
        }

        System.out.println("Case #" + test + ": " + ans);
    }
  }
}