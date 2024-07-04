import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tests=sc.nextInt();
        for(int t=1;t<=tests;t++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int grid[][]=new int[n][n];
            boolean ans=matrix(grid,k);
            
            if(ans==true){
                System.out.println("Case #"+t+": POSSIBLE");
            for(int i=0;i<grid.length;i++){
                    for(int j=0;j<grid.length;j++){
                        System.out.print(grid[i][j]+" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
    
    public static boolean isValid(int no,int arr[][],int r,int c){
        for(int i=0;i<arr.length;i++){
            if(i==r)
            continue;
            if(arr[i][c]==no)
            return false;
        }
        for(int i=0;i<arr.length;i++){
            if(i==c)
            continue;
            if(arr[r][i]==no)
            return false;
        }
        return true;
    }
    
    public static int[] getRows(int grid[][]){
        
        int arr[]=new int[3];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==0){
                 arr[0]=1;
                 arr[1]=i;
                 arr[2]=j;
                 break;
                }
            }
        }
        return arr;
    }
    public static boolean matrix(int grid[][],int k){
        int a[]=getRows(grid);
        if(a[0]==0){
            int trace=0;
            for(int i=0;i<grid.length;i++)
            trace+=grid[i][i];
            if(trace==k)
            {
                return true;
            }else{
                return false;
            }
        }
        int row=a[1];
        int col=a[2];
        for(int i=1;i<=grid.length;i++){
            if(isValid(i,grid,row,col)){
                grid[row][col]=i;
                if(matrix(grid,k))
                return true;
                
                grid[row][col]=0;
            }
        }
        return false;
    }
}