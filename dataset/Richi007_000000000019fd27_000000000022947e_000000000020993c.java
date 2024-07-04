import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int sum1 =0;
            int row = 0;
            int col = 0;
            int a = sc.nextInt();
            int mat[][] = new int[a][a];
            for(int j = 0;j<a;j++){
                for(int k = 0;k<a;k++){
                    mat[j][k] = sc.nextInt();
                    if(j == k){
                        sum1+=mat[j][k];
                    }
                    for(int m = 0;m<a;m++){
                        if(mat[j][k] == mat[j][m] && m!=k){
                            row+=1;
                        } 
                    }
                    for(int m = 0;m<a;m++){
                        if(mat[j][k] == mat[m][k] && m!=j){
                            col+=1;
                        } 
                    }
                    
                }
            }
            System.out.println(sum1+" "+row+" "+col);
        }
    }
}