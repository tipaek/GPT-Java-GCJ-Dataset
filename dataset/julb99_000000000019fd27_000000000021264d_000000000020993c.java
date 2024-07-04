import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tk;
    static Set<Integer> rSet;
    static Set<Integer> cSet;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int N = 0;
        for (int t = 0; t < T ; t++){
            N = Integer.parseInt(br.readLine());
            rSet = new HashSet<>();
            cSet = new HashSet<>();
            int[][] mat = new int[N][N];
            int sum = 0;
            int r = 0;
            for (int i = 0; i < N; i++){
                tk = new StringTokenizer(br.readLine());
                int j = 0;
                boolean rp = false;
                while(tk.hasMoreTokens()){
                    mat[i][j] = Integer.parseInt(tk.nextToken());
                    if (i == j){
                        sum += mat[i][j];
                    }
                    if (!rSet.contains(mat[i][j])){
                        rSet.add(mat[i][j]);
                    }
                    else {
                        rp = true;
                    }
                    j++;
                }
                if (rp) r++;
                rSet.clear();
            }

            int c = 0;

            for (int i = 0 ; i < N; i++){
                boolean rp = false;
                for(int j = 0; j < N; j++){
                    if (!cSet.contains(mat[j][i])){
                        cSet.add(mat[j][i]);
                    }
                    else {
                        rp = true;
                    }
                }
                if (rp) c++;
                cSet.clear();
            }


            System.out.println("Case #"+ (t+1) +": " + sum + " " + r + " " + c );

        }
    }

}