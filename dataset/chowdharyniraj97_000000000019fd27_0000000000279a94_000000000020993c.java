import java.util.*;
class Solution{
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        int k=0;
        while(t-->0){
            k++;
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=sc.nextInt();
                }
            }
        int ans[]=new int[3];
        vestigum(mat,n,ans);
        System.out.println("Case #"+k+": "+ans[0]+" "+ans[1]+" "+ans[2]);
        }
        
        
    }
    
    public  static void vestigum(int mat[][],int n,int ans[]){
        int row[][]=new int[n+1][n+1];
        int col[][]=new int[n+1][n+1];
        int trace=0;
        int r=0;
        int c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int val=mat[i][j];
                    if(row[i][val]==1){
                        r++;
                    }
                    if(col[val][j]==1){
                        c++;
                    }
                    row[i][val]++;
                    col[val][j]++;
                    if(i==j){
                        trace+=val;
                    }
                }
            }
            ans[0]=trace;
            ans[1]=r;
            ans[2]=c;
    }
}
