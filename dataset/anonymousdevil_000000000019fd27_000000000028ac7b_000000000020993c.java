import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t =s.nextInt();
        int ta=0;

        while (ta<t)
        {
            int n=s.nextInt();
            int a[][]=new int[n][n];
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    a[i][j]=s.nextInt();
                }
            }
            int r[][]=new int[n][n];
            int c[][]=new int[n][n];
            int sum=0;
            int store[]=new int[n];
            int store1[]=new int[n];
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    if(i==j)
                    {
                        sum=sum+a[i][j];
                    }
                }
            }
            for (int i = 0; i <n; i++) {
                for (int k = 0; k <n; k++) {
                    r[i][k]=-1;
                }
                for (int j = 0; j <n; j++) {
                    int aa=(a[i][j]-1);
                    r[i][aa]++;
                }
            }



            for (int i = 0; i <n; i++) {
                for (int k = 0; k <n; k++) {
                    c[i][k]=-1;
                }

                for (int j = 0; j <n; j++) {
                    int aa=(a[j][i]-1);
                    c[i][aa]++;
                }
            }

            for (int i = 0; i <n; i++) {
                int max=0;
                for (int j = 0; j <n; j++) {
                    if(r[i][j]>max)
                        max=r[i][j];
                }
                if(max==0)
                    store[i]=max;
                else
                    store[i]=max+1;

            }
            for (int i = 0; i <n; i++) {
                int max=0;
                for (int j = 0; j <n; j++) {
                    if(c[i][j]>max)
                        max=c[i][j];
                }
                if(max==0)
                store1[i]=max;
                else
                    store1[i]=max+1;


            }
            Arrays.sort(store);
            Arrays.sort(store1);


            System.out.println("Case #"+(ta+1)+": "+sum+" "+store[n-1]+" "+store1[n-1]);

            ta++;
        }
    }
}
