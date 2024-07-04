import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                boolean[][] rows = new boolean[n][n];
                boolean[][] columns = new boolean[n][n];
                boolean[] rep_rows = new boolean[n];
                boolean[] rep_cols = new boolean[n];
                int num_rep_rows=0;
                int num_rep_cols=0;
                int trace_sum=0;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        int elem = in.nextInt();
                        if(j==k)
                            trace_sum=trace_sum+elem;
                        elem=elem-1;
                        if(rows[j][elem] && !rep_rows[j]){
                            num_rep_rows=num_rep_rows+1;
                            rep_rows[j]=true;
                        }else{
                            rows[j][elem]=true;
                        }
                        if(columns[k][elem] && !rep_cols[k]){
                            num_rep_cols=num_rep_cols+1;
                            rep_cols[k]=true;
                        }else{
                            columns[k][elem]=true;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " +trace_sum+" "+num_rep_rows+" "+num_rep_cols);
            }
        }

}