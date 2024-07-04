import java.util.*;
public class Solution{
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int l=0;l<t;l++){
            int n=in.nextInt(),k=in.nextInt();
            int d=k/n,sum=0;
            int mat[][]=new int[n][n];
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-1;j++)
                    mat[i][j]=d;
                    sum+=d;
            }
            mat[n-1][n-1]=k-sum;
            create(mat,d,n);
            
            
            if(check(mat,n)){
                System.out.println("Case #"+l+": POSSIBLE");
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++)
                       System.out.print(mat[i][j]+" ");
                    System.out.println();
                }
            }
            else{
                System.out.println("Case #"+l+": IMPOSSIBLE");
            }
        }
    }
    
    static void create(int mat[][],int d,int n){
        for(int i=0;i<n;i++){
            int x=d;
            for(int j=i+1;j<n;j++){
                mat[j][i]=x+1;
                x=(x+1)%n;
            }
            for(int j=0;j<i;j++){
                mat[j][i]=x+1;
                x=(x+1)%n;
            }
        }
    }
    
    static boolean check(int mat[][],int n){
        boolean uni=true;
        for(int i=0;i<n;i++){
            int cnt[]=new int[n];
            for(int j=0;j<n;j++){
                cnt[mat[i][j]-1]++;
            }
            for(int j=0;j<n;j++)
                if(cnt[j]>1){
                    uni=false;
                    break;
                }
            if(!uni)
                break;
        }
            
        for(int i=0;i<n;i++){
            int cnt[]=new int[n];
            for(int j=0;j<n;j++){
                cnt[mat[j][i]-1]++;
            }
            for(int j=0;j<n;j++)
                if(cnt[j]>1){
                    uni=false;
                    break;
                }
            if(!uni)
                break;
        }
        return uni;
    }
}