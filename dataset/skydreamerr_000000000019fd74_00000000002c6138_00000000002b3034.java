import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int b = in.nextInt();
            int n = in.nextInt();
            String[] words = new String[n];
            for(int i =0;i< n ;i++){
                words[i] = in.next();
            }
            String ans = solve(words);
            System.out.printf("Case #%d: %s%n", x, ans);
        }
    }

    static private String solve(String[] words) {
        int max = 0;
        String maxS = null;
        for(String word: words) {
            if(word.length()>max){
                max= word.length();
                maxS = word;
            }
        }
        char[] s = maxS.toCharArray();
        for(String word: words){
            int j = s.length-1;
            for(int i =word.length()-1; i>=0;i++){
                if(word.charAt(i) != s[j--]){
                    return "*";
                }
            }
        }

        return maxS.substring(1);
    }
}