import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] q = new int[m][m];
            int trace = 0;
            int row_count = 0;
            int col_count = 0;

                for (int i = 0; i < m; i++) {
                    String[] qItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    for (int j = 0; j < m; j++){
                        int qItem = Integer.parseInt(qItems[j]);
                        q[i][j] = qItem;
                    }
                }

                //sol_arr = solve(q, m);

                for (int j = 0; j < m; j++){
                    trace += q[j][j];
                }
                int flag =0;
        
                for (int i=0;i<m;i++){
                    for (int j=0;j<m;j++){
                        for (int k=j+1;k<m;k++){
                            if(q[i][j]==q[i][k]){
                                row_count++;
                                flag =1;
                                break;
                            }
                        }
                        if (flag==1){
                            flag=0;
                            break;      
                        }
                    }
                }
                for (int i=0;i<m;i++){
                    for (int j=0;j<m;j++){
                        for (int k=j+1;k<m;k++){
                            if(q[j][i]==q[k][i]){
                                col_count++;
                                flag =1;
                                break;
                            }
                        }
                        if (flag==1){
                            flag=0;
                            break;      
                        }
                    }
                }
                System.out.println("Case #"+(tItr+1)+": "+trace+" "+row_count+" "+col_count);
        }
        scanner.close();
    }
}
