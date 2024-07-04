import java.util.*;

class Vestigium{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int c=1;c<=t;c++){
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = in.nextInt();
                }
            }
            int[] checkdupes = new int[n+1];
            int rows = 0;
            for(int i=0;i<n;i++){
                checkdupes = new int[n+1];
                for(int j=0;j<n;j++){
                    if(checkdupes[arr[i][j]] != 0){
                        rows++;
                        break;
                    }
                    checkdupes[arr[i][j]] = 1;   
                }
            }
            checkdupes = new int[n+1];
            int columns = 0;
            for(int i=0;i<n;i++){
                checkdupes = new int[n+1];
                for(int j=0;j<n;j++){
                    if(checkdupes[arr[j][i]] != 0){
                        columns++;
                        break;
                    }
                    checkdupes[arr[j][i]] = 1;
                }
            }
            //calculate trace
            int trace = 0;
            int i=0,j=0;
            while(i<n && j<n){
                trace += arr[i][j];
                i++;
                j++;
            }
            System.out.println("Case #" + c + ": " + trace + " " + rows + " " + columns);
        }
    }
}