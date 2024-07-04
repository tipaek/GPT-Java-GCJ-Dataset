import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int map[][] = new int[N][N];
            int k=0;
            int r=0;
            int c=0;
            HashSet<Integer> checkRow = new HashSet<>();
            HashSet<Integer> checkCol = new HashSet<>();
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i==j) {
                        k += map[i][j];
                    }
                }
            }

            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){
                    checkCol.add(map[i][j]);
                    checkRow.add(map[j][i]);
                }
                if(checkCol.size()!=N){
                    r++;
                }
                if(checkRow.size()!=N){
                    c++;
                }
                checkCol.clear();
                checkRow.clear();
            }
            System.out.println("Case #"+tc+": "+k+" "+r+" "+c);
        }
    }
}
