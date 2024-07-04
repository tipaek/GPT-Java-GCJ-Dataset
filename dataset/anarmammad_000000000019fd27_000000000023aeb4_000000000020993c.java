import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer tk;
        for (int x = 1; x <= T; x++) {
            int N = Integer.parseInt(br.readLine());
            int[][] M = new int[N][N];
            int k = 0;
            for (int i = 0; i < N; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    M[i][j] = Integer.parseInt(tk.nextToken());
                    if(i == j)
                        k += M[i][j];
                }
            }

            HashSet<Integer> r = new HashSet<>(), c = new HashSet<>();

            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowElements = new HashSet<>();
                for (int j = 0; j < N; j++){
                    if(rowElements.contains(M[i][j])) r.add(i);
                    rowElements.add(M[i][j]);
                }
            }

            for (int j = 0; j < N; j++){
                HashSet<Integer> columnElements = new HashSet<>();
                for (int i = 0; i < N; i++){
                    if(columnElements.contains(M[i][j])) c.add(j);
                    columnElements.add(M[i][j]);
                }
            }

            bw.write("#" + x + ": " + k + " " + r.size() + " " + c.size() + "\n");
        }
        bw.flush();
    }
}
