import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_test_case = Integer.parseInt(br.readLine());
        for(int t = 1; t <= total_test_case; t++){
            int n = Integer.parseInt(br.readLine());
            int k = 0;
            int r = 0;
            int c = 0;
            int [][]m = new int[n][n];
            for(int i = 0; i < n; i++){
                String []str = br.readLine().split(" ");
                int array[] = new int[n+1];
                for(int j = 0; j < n; j++){
                    m[i][j] = Integer.parseInt(str[j]);
                    array[m[i][j]]++;
                    if(i==j){
                        k += m[i][j];
                    }
                }
                for(int j = 1; j <= n; j++){
                    if(array[j]!=1){
                        r++;
                        break;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                int array[] = new int[n+1];
                for(int j = 0; j < n; j++){
                    array[m[j][i]]++;
                    if(array[m[j][i]]>1){
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
        }

    }
}
