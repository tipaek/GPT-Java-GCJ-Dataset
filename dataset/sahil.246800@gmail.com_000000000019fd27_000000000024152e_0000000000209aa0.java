import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int in=1; in<=t; in++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m%n==0){
                System.out.println("Case #"+in+": POSSIBLE");
                int k = m/n;
                int[][] a = new int[n][n];
                for(int i=0; i<n; i++){
                    a[i][i] = k;
                    for(int j=1,flag=1; j<n; j++,flag++){
                        if(flag==k)
                            flag++;
                        a[i][(i+j)%n] = flag;
                    }
                }
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        System.out.print(a[i][j]+" ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Case #"+in+": IMPOSSIBLE");
            }
        }
    }
}