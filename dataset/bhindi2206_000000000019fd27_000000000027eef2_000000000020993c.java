import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        int[][] matr;
        int t = 0;
        while(t++<noOfTests){
            int n = sc.nextInt();
            matr = new int[n][n];
            int i=0,j=0,k=0,m=0;
            for(j=0;j<n;j++){
                for(k=0;k<n;k++){
                    matr[j][k] = sc.nextInt();
                    //System.out.print(matr[j][k] + "  ");
                }
                //System.out.println();
            }
            //System.out.println();
            int traceVal = 0;
            for(i=0;i<n;i++){
                traceVal+=matr[i][i];
            }
            int[] mapRow;
            int noRows = 0, noCols = 0;
            for(i=0;i<n;i++){
                mapRow = new int[n+1];
                for(m=0;m<n;m++){
                    if(++mapRow[matr[i][m]] > 1){
                         noRows++;
                         break;
                    }
                }
            }
            for(i=0;i<n;i++){
                mapRow = new int[n+1];
                for(m=0;m<n;m++){
                    if(++mapRow[matr[m][i]] > 1){
                         noCols++;
                         break;
                    }
                }
            }
            System.out.println("Case #" + (t) + ": "+traceVal+" "+noRows+" "+noCols);
        }
    }
}