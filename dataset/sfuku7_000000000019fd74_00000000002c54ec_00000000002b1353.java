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
            if (N <= 500) {
                for (int i = 1; i <= N; i++) {
                    ans.append(i+" "+i+"\n");
                }
            } else {
                ans.append("1 1\n");
                ans.append("2 1\n");
                ans.append("3 2\n");
                for (int i = 5; i <= N; i++) {
                    ans.append((i-2)+" "+(i-2)+"\n");
                }
            }
        }
        System.out.print(ans);
    }
}

