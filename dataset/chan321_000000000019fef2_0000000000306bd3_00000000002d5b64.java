import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int k = 1; k <= t; k++) {
            StringBuilder sb = new StringBuilder();

            String[] s_n = bf.readLine().trim().split(" ");
            int n = Integer.parseInt(s_n[0]);
            int m = Integer.parseInt(s_n[1]);
            int count = 0;
            count = ans(n, m, count, sb);
            System.out.println("Case #"+k+": "+count+sb.toString());

        }

    }
    public static int ans(int n, int m, int count, StringBuilder sb){
        if(n<=1 || m<=1)
            return 0;
        for(int i=0;i<m-1;i++){
            int firstNum = n*(m-1)-i;
            int secondNum = n-1;
            sb.append("\n"+firstNum+" "+secondNum);
            count++;
        }
        ans(n-1,m, count, sb);
        return count;
    }
}
