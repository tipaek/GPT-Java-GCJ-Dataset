import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int c = 1;
        while(t-- > 0){
            int n = scan.nextInt();
            int trace = 0;
            int row = 0;
            int col = 0;
            int[][] arr = new int[n][n];
            
            for(int i=0; i<n; i++){
                boolean[] check = new boolean[n];
                for(int j=0; j<n; j++){
                   arr[i][j] = scan.nextInt();
                   if(i == j)   trace += arr[i][j];
                   check[arr[i][j]-1] = true;
                }
                
                for(int k=0; k<n; k++){
                    if(check[k] == false){
                        row += 1;
                        break;
                    }
                }
                
                //System.out.println();
            }
            
            for(int i=0; i<n; i++){
                boolean[] check1 = new boolean[n];
                for(int j=0; j<n; j++){
                    check1[arr[j][i] - 1] = true;
                }
                for(int k=0; k<n; k++){
                    if(check1[k] == false){
                        col += 1;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + c + ": " + trace + " " + row + " " + col);
            c++;
        }
    }
}