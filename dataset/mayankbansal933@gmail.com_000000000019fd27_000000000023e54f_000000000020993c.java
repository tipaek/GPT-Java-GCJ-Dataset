import java.io.*;
class Solution{
    public static void main(String []arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int T=1;T<=t;T++){
            int n = Integer.parseInt(br.readLine());
            int [][]matrix = new int[n][n];
            int trace = 0;
            for(int i=0;i<n;i++){
                String []s = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    matrix[i][j] = Integer.parseInt(s[j]);
                    if(i == j){
                        trace += matrix[i][j];
                    }
                }
            }
            int col = 0;
            int row = 0;
            for(int i=0;i<n;i++){
                int []a = new int[n+1];
                for(int j=0;j<n;j++){
                    if(a[matrix[i][j]] == 1){
                        row ++;
                        break;
                    }
                    a[matrix[i][j]] ++;
                }
            }
            for(int i=0;i<n;i++){
                int []a = new int[n+1];
                for(int j=0;j<n;j++){
                    if(a[matrix[j][i]] == 1){
                        col ++;
                        break;
                    }
                    a[matrix[j][i]] ++;
                }
            }
            System.out.println("Case #" + T + ": " + trace + " " + row + " " + col);
        }
    }
}