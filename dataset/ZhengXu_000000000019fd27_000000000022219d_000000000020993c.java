import java.io.*;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
           int  N = Integer.parseInt(reader.readLine());
           int [][] M = new int[N][N];
           for(int j=0;j<N;j++) {
               String [] temp  = reader.readLine().split("[ ]");
               for(int k=0;k<N;k++) {
                   M[j][k] = Integer.parseInt(temp[k]);
               }
           }
            String result = solution(N, M);
            System.out.println("Case #" + i + ": " + result);

        }
        reader.close();
    }

    public static String solution(int N, int [][] M) {
       int trace = 0;
       for(int i=0;i<N;i++) {
           trace+= M[i][i];
       }
       int rows=0;
       for(int i=0;i<N;i++) {
           if(!isValid(M, N, i,0, 0,1)) {
               rows++;
           }
       }
       int cols =0;
       for(int i=0;i<N;i++) {
           if(!isValid(M,N, 0, i, 1, 0)) {
               cols++;
           }
       }
       return trace +" " + rows +" " + cols;
    }

    private static boolean isValid(int [][] M,int N, int i, int j, int x, int y) {
        HashSet<Integer> set =new HashSet<>();
        while(i<N && j<N) {
            if(set.contains(M[i][j])) {
                return false;
            }
            set.add(M[i][j]);
            i+=x;
            j+=y;
        }
        return true;
    }

}
