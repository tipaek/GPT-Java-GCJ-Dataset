import java.io.*;
import java.util.*;
class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");
        for(int k=1; k <= T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i=0; i<N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }
            // parse and find trace, duplicate
            int trace = 0;
            int rows = 0;
            int cols = 0;
            for (int i=0; i<N; i++) {
                HashSet<Integer> set = new HashSet<>();
                boolean hasDuplicates = false;
                for (int j=0; j<N; j++) {
                    if (i == j) {
                        trace += arr[i][j];
                    }
                    if (set.contains(arr[i][j])) {
                        hasDuplicates = true;
                    } else {
                        set.add(arr[i][j]);
                    }
                }
                if(hasDuplicates) {
                    rows += 1;
                }
            }
            for (int j=0; j<N; j++) {
                boolean hasDuplicates = false;
                HashSet<Integer> set = new HashSet<>();
                for (int i=0; i<N; i++) {
                    if (set.contains(arr[i][j])) {
                        hasDuplicates = true;
                    } else {
                        set.add(arr[i][j]);
                    }
                }
                if(hasDuplicates) {
                    cols += 1;
                }
            }
            sb.append("Case #"+k+": " + trace + " " + rows + " " + cols + "\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}