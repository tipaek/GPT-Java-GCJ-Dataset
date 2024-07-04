import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner fr=new Scanner(System.in);
        int t=fr.nextInt();
        for(int x =1;x<=t;x++) {
            int n = fr.nextInt();
            int[][] a=new int[n][n];
            int trace=0;
            int row=0,column=0;
            for(int i=0;i<n;i++)
            {
                for (int j=0;j<n;j++)
                {
                    a[i][j]=fr.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                }
            }
            for(int i=0;i<n;i++)
            {
                int[] r_check=new int[n+1];
                int[] c_check=new int[n+1];
                int rr=0,cr=0;
                for (int j=0;j<n;j++)
                {
                    int r=a[i][j];
                    int c=a[j][i];
                    r_check[r]++;
                    c_check[c]++;
                    if (r_check[r]>1)
                        rr=1;
                    if (c_check[c]>1)
                        cr=1;
                }
                row+=rr;
                column+=cr;
            }
            System.out.print("Case #"+x+": ");
            System.out.println(trace+" "+row+" "+column);
        }
    }
}
