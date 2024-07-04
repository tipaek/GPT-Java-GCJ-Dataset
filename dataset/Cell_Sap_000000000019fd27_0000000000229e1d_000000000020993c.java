import java.util.*;
public class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i <= t;i++){
            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            int dSum = 0, rCount = 0, cCount = 0;
            for(int j = 0;j < n;j++){
                for(int k = 0;k < n;k++){
                    ar[j][k] = sc.nextInt();
                    if(j == k)
                        dSum += ar[j][k];
                }
            }
            int temp[] = new int[100];
            for(int j = 0;j < n;j++){
                Arrays.fill(temp,0);
                for(int k = 0;k < n;k++){
                    temp[ar[j][k]]++;
                    if(temp[ar[j][k]] > 1){
                        rCount ++;
                        break;
                    } 
                }
            }
            
            for(int j = 0;j < n;j++){
                Arrays.fill(temp,0);
                for(int k = 0;k < n;k++){
                    temp[ar[k][j]]++;
                    if(temp[ar[k][j]] > 1){
                        cCount ++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i +": " + dSum + " "+ rCount +" " + cCount);
        }
    }
}