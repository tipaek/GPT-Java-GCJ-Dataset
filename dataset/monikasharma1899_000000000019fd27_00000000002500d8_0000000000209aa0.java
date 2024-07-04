import java.util.*;
class Solution{
   
    public static boolean perm(int matrix[][],int n,int k, int l, int r){
        if(l==r){
            int d=0;
            for(int i=0;i<n;i++){
                    d+=matrix[i][i];
            }
            
            if(d==k){
                System.out.println("POSSIBLE");
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                      System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println();
                }
                return true;
            }
            else return false;
        }
        else{
            int temp[]=new int[n];
            for (int i = l; i <= r; i++)  
            {  
                for(int j=0;j<n;j++){
                    temp[j]=matrix[j][i];
                    matrix[j][i]=matrix[j][l];
                    matrix[j][l]=temp[j];
                }
                // Recursion called  
                boolean ans=perm(matrix,n,k,l+1,r);
                if(ans==true)
                    return ans;
            
                for(int j=0;j<n;j++){
                    temp[j]=matrix[j][i];
                    matrix[j][i]=matrix[j][l];
                    matrix[j][l]=temp[j];
                }
            }
        }
        return false;
        
    }
    public static void indicium(int n, int k){
        int matrix[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            int c=i+1;
            for(int j=0;j<n;j++){
                matrix[i][j]=c;
                c++;
                if(c%(n+1)==0)
                    c=1;
            }
        }
        boolean ans=perm(matrix,n,k,0,n-1);
       
        if(ans==false){
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