import java.io.*;
import java.util.*;
import java.math.*;


public class Main
{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int cas = 1;cas <= T;cas ++){
            int n,sum = 0,sum1 = 0,sum2 = 0;
            n = sc.nextInt();
            int [][] a = new int [105][105];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    int x = sc.nextInt();
                    a[i][j] = x;
                    // System.out.print(a[i][j]+" ");
                }
                // System.out.println();
            }
            for(int i=1;i<=n;i++){
                sum += a[i][i];
            }
            for(int i=1;i<=n;i++){
                int flag = 0;
                int [] mp = new int [105];
                for(int j=0;j<=104;j++){
                    mp[j] = 0;
                }
                for(int j=1;j<=n;j++){
                    if(mp[a[i][j]]>=1){
                        flag = 1;
                    }
                    mp[a[i][j]] += 1;
                }
                sum1 += flag;
            }
            for(int i=1;i<=n;i++){
                int flag = 0;
                int [] mp = new int [105];
                for(int j=0;j<=104;j++){
                    mp[j] = 0;
                }
                for(int j=1;j<=n;j++){
                    if(mp[a[j][i]]>=1){
                        flag = 1;
                    }
                    mp[a[j][i]] += 1;
                }
                sum2 += flag;
            }
            // System.out.println(sum1);
            System.out.println("Case #"+ cas +":" + sum + " " + sum1 +" "+ sum2);
        }
    }

}