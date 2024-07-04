import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] ans = new String[N];

        for(int p = 0; p < N; p++) {
            int M = Integer.parseInt(scan.nextLine());
            int[][] times = new int[M][2];
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(scan.nextLine());
                times[i][0] = Integer.parseInt(st.nextToken());
                times[i][1] = Integer.parseInt(st.nextToken());
            }

            int[] ordering = new int[M];
            boolean[] visited = new boolean[M];
            for(int i = 0; i < M; i++){
                int ind = -1;
                for(int k = 0; k < M; k++) {
                    if(!visited[k]){
                        if(ind == -1)
                            ind = k;
                        else if (times[ind][0] > times [k][0])
                            ind = k;
                    }
                }
                visited[ind] = true;
                ordering[i] = ind;
            }

            boolean invalid = false;
            char[] arrChars = new char[M];
            int endC = -1;
            int endJ = -1;
            for(int i = 0; i < M; i++){
                int actStart = times[ordering[i]][0];
                int actEnd = times[ordering[i]][1];
                if(endC <= actStart){
                    arrChars[ordering[i]] = 'C';
                    endC = actEnd;
                } else if (endJ <= actStart){
                    arrChars[ordering[i]] = 'J';
                    endJ = actEnd;
                } else {
                    invalid = true;
                    break;
                }
            }

            if(invalid){
                ans[p] = "IMPOSSIBLE";
            } else {
                String output = "";
                for(char i: arrChars)
                    output += i;
                ans[p] = output;
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println("Case #" + (i+1) + ": " + ans[i]);
        }

    }
}
