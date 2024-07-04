import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int test = 1; test <= t; ++test) {

        String ans = "";

        int n = sc.nextInt();

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
        if (second[1]<sorting[0][2]) map.put(sorting[1][0],'J');
        else map.put(sorting[1][0],'C');

        int flag = 0;
        for(int i = 2;i<n;i++){
            
            int pprev[] = sorting[i-2];
            int prev[] = sorting[i-1];
            int current[] = sorting[i];
            char c;
            if (current[1]<prev[2]){
                c = (map.get(prev[0]) == 'C')?'J':'C';
            }else{
                c = map.get(prev[0]);
            }

            if (current[1]<prev[2] && current[1]<pprev[2] && prev[1]<pprev[2]){
                flag = 1;
                break;
            }
            else{
                map.put(current[0],c);
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