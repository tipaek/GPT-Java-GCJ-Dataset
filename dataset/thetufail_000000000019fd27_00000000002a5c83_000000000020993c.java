import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int sum = 0;
        int a[][] = null;

        if (T >= 1 && T <= 100) {

            for (int i = 1; i <= T; i++) {


                int N = sc.nextInt();
                if (N >= 2 && N <= 100) {
                    a = new int[N][N];
                }
                
                for(int j=0; j< N; j++)
                {
                    for(int k=0; k< N; k++)
                    {
                        a[j][k]=sc.nextInt();
                        if (a[j][k] < 1 || a[j][k] > N) {
                            System.exit(0);
                        } else {
                            a[j][k] = a[j][k];
                        }
                    }
                }

                for(int m =0; m < N; m ++)
                {
                    for(int n = 0;n < N; n++)
                    {
                        if(m == n)
                            sum += a[m][n];
                    }
                }
                
                int statusR,statusC,real_countR=0,real_countC=0;
                int b[] = new int[N];
                int col[] = new int[N];
                for(int j=0; j< N; j++) {
                    for (int k = 0; k < N; k++) {
                        b[k]=a[j][k];
                        col[k]=a[k][j];
                    }
                    statusR=countDup(b);
                    if(statusR==0) {
                        real_countR++;
                    }
                    statusC=countDup(col);
                    if(statusC==0) {
                        real_countC++;
                    }
                }
                System.out.println("Case #" + i + ": " + sum + " " + real_countR + " " + real_countC);
                a = null;
                sum = 0;
            }
        }
    }
    
    public static int countDup(int arr[])
    {
        int f=0,l=arr.length,i,j,count=0;
        int temp[]=new int[l];
        for(i=0;i<l;i++)
        {
            for(j=0;j<count;j++) {
                if (arr[i] == temp[j]) {
                    f = 1;
                    break;
                }
            }
            if (f == 1) {
                break;
            }
            if (j == count) {
                temp[count] = arr[i];
                count++;
            }
        }
        if (f == 1) {
            f = 0;
            return 0;
        }
        else
            return 1;
    }
}