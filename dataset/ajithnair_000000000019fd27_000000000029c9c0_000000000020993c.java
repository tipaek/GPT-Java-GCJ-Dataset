import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] res = new String[T];

        for(int i=0; i< T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] M = new int[N][N];
            int trace = 0;

            for(int j=0; j<N; j++){
                String input = br.readLine();
                String[] ips = input.trim().split(" ");
                for(int k=0; k<N; k++){
                    M[j][k] = Integer.parseInt(ips[k]);
                    if(j == k)
                        trace += M[j][k];
                }
            }
            int rowCount = 0, colCount = 0;
            //compute for rows
            for(int n=0; n<N; n++){
                HashSet<Integer> hs1 = new HashSet<>(); //for rows
                HashSet<Integer> hs2 = new HashSet<>(); //for cols
                for(int l=0; l< N; l++){
                    hs1.add(M[n][l]);
                    hs2.add(M[l][n]);
                }
                if(hs1.size() != N)
                    rowCount++;
                if(hs2.size() != N)
                    colCount++;
            }

            res[i] = "Case #"+ (i+1) + ": " + trace + " " + rowCount + " " + colCount;
        }

        for(int i=0; i< T; i++)
            System.out.println(res[i]);
    }
}
