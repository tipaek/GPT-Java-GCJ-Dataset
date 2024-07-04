import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[][] rowCheck = new int[100][100];
        int [][] colCheck = new int[100][100];
        int print=1;
        while(testCase-->0){
            int n= sc.nextInt();
            int[][] arr = new int[n][n];
            //store the value to the array
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            // now lets take the sum of the diagonal
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++){
                k = k + arr[i][i];
            }
            // now count "r" - number of rows of the matrix that contain repeated elements
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int indexValue = arr[i][j];
                    rowCheck[i][indexValue-1] += 1;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(rowCheck[i][j] == 0){
                        r++;
                        break;
                    }
                }
            }
            // now count "l" - number of columns of the matrix that contain repeated elements
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int indexValue = arr[j][i];
                    colCheck[indexValue-1][i] += 1;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(colCheck[j][i] == 0){
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+print+": "+k+" "+r+" "+c);     //Case #1: 4 0 0
            print++;
            for (int i =0;i<100;i++){
                for(int j=0;j<100;j++){
                    rowCheck[i][j] = 0;
                    colCheck[i][j] = 0;
                }
            }
        }
    }
}