import java.util.Arrays;
import java.util.Scanner;
 class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int tt=1;tt<=t;tt++){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                        trace+=arr[i][j];
                }
            }
            int rows=0;
            boolean vis[]=new boolean[n+1];
            for(int i=0;i<n;i++){
                Arrays.fill(vis,false);
                for(int j=0;j<n;j++){
                    if(!vis[arr[i][j]]){
                        vis[arr[i][j]]=true;
                    }
                    else{
                        rows++;
                        break;
                    }
                }
            }
            int cols=0;
            Arrays.fill(vis,false);
            for(int i=0;i<n;i++){
                Arrays.fill(vis,false);
                for(int j=0;j<n;j++){
                    if(!vis[arr[j][i]])
                        vis[arr[j][i]]=true;
                    else{
                        cols++;
                        break;
                    }
                }
            }

            System.out.println("Case #"+tt+": "+trace+" "+rows+" "+cols);

        }
    }
}
