package codejam;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        A obj = new A();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for( int t=1; t <= test; t++) {
            int N = Integer.parseInt(br.readLine());
            int trace = 0;
            int r = 0;
            int c = 0;
            int[][] arr = new int[N][N];
            for(int i=0; i < N; i++) {
                String[] line0 = br.readLine().split(" ");

                int row[] = new int[N+1];
                boolean found = false;
                for(int j=0; j<N; j++) {
                    int val = Integer.parseInt(line0[j]);
                    if( i == j ) {
                        trace += val;
                    }
                    arr[i][j] = val;
                    row[val]++;
                    if(row[val] > 1 && !found) {
                        found =true;
                        r++;
                    }
                }
            }
            for( int i=0;i<N;i++) {
                int[] col = new int[N+1];
                for(int j=0;j<N;j++) {
                    int val = arr[j][i];
                    col[val]++;
                    if( col[val] > 1 ) {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
        }
    }
}