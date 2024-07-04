import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
         int testCase = 1;
        while(t>0){
            int n = scanner.nextInt();
           
            int trace = 0;
            int rows = 0;
            int columns = 0;
            int[][] arr = new int[n][n];
            for(int i = 0;i< n; i++){
                for(int j = 0; j< n; j++){
                    arr[i][j] = scanner.nextInt();
                    if(i == j){
                        trace += arr[i][j];
                    }
                }
            }
            for(int i = 0; i<n;i++){
                boolean flagR = false;
                boolean flagC = false;
                for(int j = 0;j<n;j++){
                    for(int k = j+1;k<n;k++){
                        if(arr[i][j]==arr[i][k] && !flagR){
                            rows++;
                            flagR = true;
                        }if(arr[j][i] == arr[k][i] && !flagC){
                            columns++;
                            flagC = true;
                        }
                        if(flagR && flagC){
                            break;
                        }
                    }
                    if(flagR && flagC){
                        break;
                    }
                }
            }
            System.out.println("Case #" + testCase 
            + ": " + trace + " " + rows + " " +
            columns);
            testCase++;
            t--;
        }
    }
}