import java.util.*;
class test{
    static int diag(int[][] arr, int n){
        int diag = 0;
        for(int i=0;i<n;i++){
            diag+=arr[i][i];
        }
        return diag;
    }
    static int checkCol(int[][] arr, int n){
        int cols = 0;
        for(int i=0;i<n;i++){
            Loop:
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[j][i] == arr[k][i]){
                        cols++;
                        break Loop;
                    }
                }
            }
        }
        return cols;
    }
    static int checkRow(int[][] arr, int n){
        int rows = 0;
        for(int i=0;i<n;i++){
            Loop:
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i][j] == arr[i][k]){
                        rows++;
                        break Loop;
                    }
                }
            }
        }
        return rows;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTest = sc.nextInt();
        for(int test = 1;test<=nTest;test++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j] = sc.nextInt();
            int diag = diag(arr, n);
            int row = checkRow(arr, n);
            int col = checkCol(arr, n);
            System.out.println("Case #"+test+": "+diag+" "+row+" "+col);
        }
    }
}