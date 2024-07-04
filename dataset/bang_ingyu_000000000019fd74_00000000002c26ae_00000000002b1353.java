import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = stoi(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = stoi(br.readLine());

            sb.append(String.format("Case #%d: \n",i));

            int ans = 1;
            int[] path1 = new int[500];
            int[] path2 = new int[500];
            path1[0] = 1;
            path2[0] = 1;
            int j = 1;
            for (j = 1; j < 500 && ans + j < N; j++) {
                ans += j;
                path1[j] = j + 1;
                path2[j] = (j==1)?1:2;
            }
            while( j < 500 && ans < N){
                path1[j] = j+1;
                path2[j] = 1;
                ans ++;
                j++;
            }

            if(ans == N){
                for(int k = 0; k < j; k++){
                    sb.append(String.format("%d %d\n",path1[k],path2[k]));
                }
            } else {
                sb.append("1 1\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
