import java.util.*;
class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n, K, t, i, j, k, sum, z, flag;
        int[][] m = new int[50][50];
        t = sc.nextInt();
        for(i=1;i<=t;i++){
            n = sc.nextInt();
            K = sc.nextInt();
            for(j=0;j<n;j++){
                m[0][j] = j+1;
            }
            for(j=1;j<n;j++){
                for(k=0;k<n;k++){
                    m[j][k] = m[j-1][(k+1)%n];
                }
            }
            sum = 0;
            flag = 0;
            for(z=0;z<=n;z++){
                sum = 0;
                for(j=0;j<n;j++)
                    sum += m[j][j];
                if(sum==K){
                    System.out.println("Case #"+i+": POSSIBLE");
                    for(j=0;j<n;j++){
                        for(k=0;k<n;k++)
                            System.out.print(m[j][k]+" ");
                        System.out.println();
                    }
                    flag = 1;
                    break;
                }
                for(j=0;j<n;j++){
                    for(k=0;k<n-1;k++){
                        m[j][k] = m[j][k] + m[j][k+1];
                        m[j][k+1] = m[j][k] - m[j][k+1];
                        m[j][k] = m[j][k] - m[j][k+1];
                    }
                }
            }
            if(flag==0)
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}