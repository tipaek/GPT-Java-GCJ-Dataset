import java.util.Scanner;

class Vestigium {
    public  static  void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n= sc.nextInt();
            int [][] mat= new int [n][n];
            int [][] copy_mat= new int [n][n];
            int dRow=0,dCol=0;
            int trace=0;
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    mat[j][k] = sc.nextInt() ;
                    copy_mat[j][k]=mat[j][k];
                    if(j==k)
                        trace+=mat[j][k];
                }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int x=Math.abs(mat[j][k])-1;
                    if(mat[j][x]<0){
                        dRow++;
                        break;
                    }
                    else
                        mat[j][x]=-mat[j][x];
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int x=Math.abs(copy_mat[k][j])-1;
                    if(copy_mat[x][j]<0){
                        dCol++;
                        break;
                    }
                    else
                        copy_mat[x][j]=-copy_mat[x][j];                }
            }
            System.out.println("Case #"+i+": "+trace+" "+dRow+" "+dCol);
        }
    }
}
