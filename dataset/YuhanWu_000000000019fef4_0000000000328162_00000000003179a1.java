import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Harry on 5/2/20.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            int[] max = new int[26];
            Arrays.fill(max, 100);
            boolean[] visited = new boolean[26];
            int[] count = new int[26];
            int tot = 0;
            for(int c=0; c<10000; c++){
                String num = in.next();
                String code = in.next();
                for(char cur : code.toCharArray()){
                    visited[cur-'A'] = true;
                    count[cur-'A']++;
                }
            }
            List<int[]> list = new ArrayList<>();
            for(int k=0; k<26; k++){
                if(visited[k]){
                    list.add(new int[]{k, count[k]});
                }
            }
            Collections.sort(list, (a,b)->(a[1]-b[1]));
            char[] res = new char[10];
            res[0] = (char)(list.get(0)[0]+'A');
            for(int j=1; j<10; j++){
                res[j] = (char)(list.get(10-j)[0]+'A');
            }
            System.out.println("Case #"+i+": "+new String(res));
        }
    }
}
