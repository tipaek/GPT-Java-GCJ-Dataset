import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);
       int tc = sc.nextInt();
       int[][] nums = new int[100][100];
       for(int t = 1;t <= tc;t++){
           int n = sc.nextInt();
           int trace = 0,r = 0,c = 0;

           for(int i =0;i < n;i++){
                for(int j = 0;j <n;j++){
                    int x = sc.nextInt();
                    nums[i][j] = x;
                    if(i == j) trace +=x;
                }
           }
            
           for(int i = 0;i < n;i++){
               boolean[] con = new boolean[n + 1];
                for(int j = 0;j <n;j++){
                    if(con[nums[i][j]] == true){
                        r++;
                        break;
                    }
                    con[nums[i][j]] = true; 
                }
            }

            for(int j = 0;j < n;j++){
                boolean[] con = new boolean[n + 1];
                for(int i = 0;i < n;i++){
                    if(con[nums[i][j]] == true){
                        c++;
                        break;
                    } 
                    con[nums[i][j]] = true; 
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);

       }

    }
}