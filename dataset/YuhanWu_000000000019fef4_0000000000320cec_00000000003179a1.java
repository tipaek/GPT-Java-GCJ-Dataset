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
            for(int c=0; c<10000; c++){
                String num = in.next();
                String code = in.next();
                for(char cur : code.toCharArray()){
                    visited[cur-'A'] = true;
                }
                if(num.length() == code.length()){
                    int digit = num.charAt(0)-'0';
                    int cIndex = code.charAt(0)-'A';
                    max[cIndex] = Math.min(max[cIndex], digit);
                }
            }
            HashSet<Character> found = new HashSet<>();
            char[] res = new char[10];
            for(int j=1; j<10; j++){
                for(int k=0; k<26; k++){
                    if(visited[k] && max[k]==j){
                        char cur = (char)('A'+k);
                        found.add(cur);
                        res[j] = cur;
                    }
                }
            }
            for(int k=0; k<26; k++){
                if(visited[k] && !found.contains((char)('A'+k))){
                    res[0] = (char)('A'+k);
                    break;
                }
            }
            System.out.println("Case #"+i+": "+new String(res));
        }
    }
}
