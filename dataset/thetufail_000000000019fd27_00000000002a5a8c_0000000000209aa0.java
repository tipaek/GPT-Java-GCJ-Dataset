import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int indi[][] = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int sum = 0;
        int a[][] = null;
        boolean flag = true;

        if (T >= 1 && T <= 100) {

            for (int i = 1; i <= T; i++) {


                int N = sc.nextInt();
                int D = sc.nextInt();
                if (N >= 2 && N <= 50) {
                    a = new int[N][N];
                }

                if (D >= N && D <= N*N) {
                    indi = new int[N][N];
                    while(sum != D) {
                        genRanMax(N);
                        System.out.println();
                        sum = 0;
                        for (int m = 0; m < N; m++) {
                            for (int n = 0; n < N; n++) {
                                if (m == n)
                                    sum += indi[m][n];
                            }
                        }
                    }

                    int statusR,statusC,real_countR=0,real_countC=0;
                    int b[] = new int[N];
                    int col[] = new int[N];
                    for(int j=0; j< N; j++) {
                        for (int k = 0; k < N; k++) {
                            b[k]=indi[j][k];
                            col[k]=indi[k][j];
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
                    if((real_countC == 0 && real_countR == 0) && sum == D) {
                        System.out.println("Case #" + i + ": " + "POSSIBLE");
                        for(int j=0; j< N; j++) {
                            for (int k = 0; k < N; k++) {
                                System.out.print(indi[j][k] + " ");
                            }
                            System.out.println();
                        }

                    } else {
                        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                    }
                }

                a = null;
                indi=null;
                sum = 0;
            }
        }
        sc.nextLine();
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


    public static void genRanMax(int N) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int[][] a=new int[N][N];
        indi=new int[N][N];
        for(int i=0;i<N;i++) {

            for (int p = 1; p <= N; p++) {
                list.add(p);
            }

            Collections.shuffle(list);
            for (int j = 0; j < N; j++) {
                int x = (list.get(j));
                a[i][j] = x;
                indi[i][j] = x;
            }
        }
    }
}
