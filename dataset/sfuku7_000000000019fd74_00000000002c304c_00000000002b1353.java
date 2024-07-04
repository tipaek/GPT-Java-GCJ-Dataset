import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            ans.append("Case #"+t+":\n"); 
            ans.append("1 1\n");
            for (int i = 2; i <= N; i++) {
                if (i == 2) {
                    ans.append("2 1\n");
                } else {
                    ans.append((i-1)+" "+(i-1)).append('\n');
                }
            }
        }
        System.out.print(ans);
    }
}

