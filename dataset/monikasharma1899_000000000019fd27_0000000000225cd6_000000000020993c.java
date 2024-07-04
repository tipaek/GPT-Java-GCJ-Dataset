import java.util.*;
class Solution{
    public static void vestigium(int matrix[][], int n){
        
        int d_sum=0;
        int max1=0, max2=0, m1=0,  m2=0;
        for(int i=0;i<n;i++){
            int c1_arr[]=new int[n+1];
            int c2_arr[]=new int[n+1];
            for(int j=0;j<n;j++){
                if(i==j){
                    d_sum+=matrix[i][j];
                }
                c1_arr[matrix[i][j]]++;
                c2_arr[matrix[j][i]]++;
                if(c1_arr[matrix[i][j]]==2 && m1==max1){
                    max1++;
                }
                if(c2_arr[matrix[j][i]]==2 && m2==max2){
                    max2++;
                }
            }
            m1=max1; m2=max2;
        }
        
        System.out.println(d_sum+" "+max1+" "+max2);
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int n= sc.nextInt();
            int matrix[][]= new int[n][n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            System.out.print("Case #"+t+": ");
            vestigium(matrix,n);
            
        }
    }
}