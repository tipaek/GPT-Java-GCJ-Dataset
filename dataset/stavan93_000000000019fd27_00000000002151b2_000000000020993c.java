import java.util.*;

class Solution {

    static int k_value(int n, int [][] mat){
        int k = 0;
        while(n > 0){
            k += mat[n-1][n-1];
            n--;
        }
        return k;
    }

    static int r_value(int n, int [][] mat){

        int r = 0;
        for(int j = 0; j < n; j++){
            HashSet<Integer> set = new HashSet<>();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = mat[j][i];
            }
            for(int num : arr){
                if(!set.add(num)){
                    r++;
                    break;
                }
            }
        }
        return r;
    }

    static int c_value(int n, int [][] mat){

        int c = 0;
        for(int j = 0; j < n; j++){
            HashSet<Integer> set = new HashSet<>();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = mat[i][j];
            }
            for(int num : arr){
                if(!set.add(num)){
                    c++;
                    break;
                }
            }
        }
        return c;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int k = 1; k <= t; k++){
            int n = scan.nextInt();
            int[][] mat = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = scan.nextInt();
                }
            }

            System.out.println("Case #" + k +": " + k_value(n,mat) + " " + r_value(n,mat) + " " + c_value(n,mat));

        }
    }

}
