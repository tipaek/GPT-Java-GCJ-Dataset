import java.util.*;

class Vestigium{
    public static int ferb(int[][] x){
        int r = 0;
        for(int i = 0;i<x.length;i++){
            int[] count = new int[x.length+1];
            for(int j=0;j<x.length+1;j++){
                count[j] = 0;
            }
            for(int k=0;k<x.length;k++){
                if(count[x[i][k]]==1){
                    r++;
                    break;
                }else{
                    count[x[i][k]] = 1;
                }
            }
        }
        return r;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++){
            int n = scan.nextInt();
            int k = 0;
            int[][] x = new int[n][n];
            for(int j = 0;j < n; j++){
                for(int l=0; l<n;l++){
                    x[j][l] = scan.nextInt();
                }
                k+=x[j][j];
            }
            int r = ferb(x);
            int[][] y = new int[n][n];
            for(int l=0;l<n;l++){
                for(int m=0;m<n;m++){
                    y[l][m] = x[m][l];
                }
            }
            System.out.println(k+" "+r+" "+ferb(y));
            r=0;
        }
    }
}
