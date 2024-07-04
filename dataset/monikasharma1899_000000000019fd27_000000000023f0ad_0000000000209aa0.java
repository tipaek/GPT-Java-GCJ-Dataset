import java.util.*;
class Solution{
    public static void indicium(int n, int k){
        int matrix[][]=new int[n][n];
        int d_sum=0;
        for(int i=0;i<n;i++){
            int c=i+1;
            for(int j=0;j<n;j++){
                matrix[i][j]=c;
                if(i==j){
                    d_sum+=c;
                }
                c++;
                if(c%(n+1)==0)
                    c=1;
            }
        }
        if(d_sum==k){
            System.out.println("POSSIBLE");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
        
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int n= sc.nextInt();
            int k= sc.nextInt();
            System.out.print("Case #"+t+": ");
            indicium(n,k);
            
        }
    }
}