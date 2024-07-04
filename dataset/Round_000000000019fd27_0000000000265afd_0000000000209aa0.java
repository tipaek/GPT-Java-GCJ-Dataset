import java.util.*;
import java.io.*;

class Solution{
    private static int[][] matrix;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNo = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCaseNo ; i++){
            System.out.print("Case #"+i+": ");
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            matrix = new int[n][n];
            if(solve(0,0,n,k,new int[n])){
                System.out.println("POSSIBLE");
                for(int j = 0 ; j < n ; j++){
                    for(int z = 0 ; z < n ; z++){
                        System.out.print(matrix[j][z]+" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static Boolean solve(int sum, int index, int n, int k, int[] trace){
        if(index >= n){
            if(sum == k){
                return makeMatrix(n,trace);
            }else
                return false;
        }

        for(int i = 1 ; i <= n ; i++){
            trace[index] = i;
            if(solve(sum+i, index+1, n,k,trace))
                return true;
        }
        return false;
    }

    private static Boolean makeMatrix(int n, int[] trace){
        for(int i = 0 ; i < n ; i++){
            matrix[i][i] = trace[i];
            int index = i-1;
            while(index >= 0){
                int vertical = checkVertical(n,i,index);
                int horizon = checkHorizontal(n,i,index);

                if(vertical < 0 || horizon < 0)
                    return false;
                matrix[index][i] = vertical;
                matrix[i][index] = horizon;
                index--;
            }
        }
        return true;
    }

    private static int checkVertical(int n, int i, int index){
        for(int j = n ; j >0 ; j--){
            Boolean is = false;
            for(int z = i; z > index ; z--){
                if(matrix[z][i] == j){
                    is = true;
                    break;
                }
            }
            if(!is) {
              for(int z = i-1;z>=0;z--){
                if(matrix[index][z] == j){
                  is = true;
                  break;
                }
              }
            }
            if(!is) return j;
        }
        return -1;
    }
    private static int checkHorizontal(int n, int i, int index){
        for(int j = n ; j > 0; j--){
            Boolean is = false;
            for(int z = i; z > index ; z--){
                if(matrix[i][z] == j){
                    is = true;
                    break;
                }
            }
            if(!is){
              for(int z = i-1;z>=0;z--){
                if(matrix[z][index] == j){
                  is = true;
                  break;
                }
              }
            }
            if(!is) return j;
        }
        return -1;
    }
}
