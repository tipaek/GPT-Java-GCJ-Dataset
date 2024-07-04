import java.util.Arrays;
import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            int[] st = new int[n];
            for(int j=0;j<n;j++)st[j]=(j+1);
            int tr = 0;
            int r=0;
            int c=0;
            int[] a = new int[n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[k]= in.nextInt();
                    mat[j][k]=a[k];
                    if(j==k)tr+=mat[j][k];
                }
                Arrays.sort(a);
                if(!Arrays.equals(a,st))r++;
            }
            int[] col = new int[n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    col[k]=mat[k][j];
                }
                Arrays.sort(col);
                if(!Arrays.equals(col, st))c++;
            }
            System.out.println("Case"+" "+ "#"+(i+1)+":"+" "+tr+" "+r+" "+c);
//            System.out.println(r);
//            System.out.println(c);
        }
    }
}
