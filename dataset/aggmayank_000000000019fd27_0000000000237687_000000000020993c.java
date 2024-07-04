import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int c=1;c<=t;c++){
            int k=0;
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = in.nextInt();
                    if(i==j)
                        k+=arr[i][j];
                }
            }
            int[] cdup = new int[n+1];
            int rows = 0;
            for(int i=0;i<n;i++){
                cdup = new int[n+1];
                for(int j=0;j<n;j++){
                    if(cdup[arr[i][j]] > 1){
                        rows++;
                    }
                    cdup[arr[i][j]]++;  
                }
            }
            int columns = 0;
            for(int i=0;i<n;i++){
                cdup = new int[n+1];
                for(int j=0;j<n;j++){
                    if(cdup[arr[j][i]] >1){
                        columns++;
                    }
                    cdup[arr[j][i]]++;
                }
            }
            System.out.println("Case #" + c + ": " + k + " " + rows + " " + columns);
        }
    }
}