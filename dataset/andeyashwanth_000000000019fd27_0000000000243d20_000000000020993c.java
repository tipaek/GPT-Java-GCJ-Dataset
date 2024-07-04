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
            int[] map = new int[n+1];
            for(int j=0;j<n;j++){
                if(map[arr[j][i]]>0){
                    cols++;
                    break;
                }
                map[arr[j][i]]++;
            }
        }
        return cols;
    }
    static int checkRow(int[][] arr, int n){
        int rows = 0;
        for(int i=0;i<n;i++){
            int[] map = new int[n+1];
            for(int j=0;j<n;j++){
                if(map[arr[i][j]]>0){
                    rows++;
                    break;
                }
                map[arr[i][j]]++;
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