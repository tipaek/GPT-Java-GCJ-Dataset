
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution obj = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for( int t=1; t <= test; t++) {

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for( int i = 0; i < N ;i++) {
                String[] line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);
                arr[i][0] = start;
                arr[i][1] = end;
            }
            /*Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });*/
            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            boolean found = true;
            /*for( int i=0;i<N;i++) {
                System.out.println(arr[i][0]+" "+arr[i][1]);

            }*/
            StringBuilder ans = new StringBuilder();
            int J =-1;
            int C = -1;
            for( int i=0;i<N;i++) {
                if( arr[i][0] > J) {
                    J = arr[i][1]-1;
                    ans.append("J");
                } else if( arr[i][0] > C ){
                    C = arr[i][1]-1;
                    ans.append("C");
                } else {
                    found  = false;
                    break;
                }
            }
            if(!found) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": "+ans.toString());
            }
        }
    }
}
