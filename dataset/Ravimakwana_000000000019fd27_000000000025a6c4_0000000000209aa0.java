import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scan.nextInt();
            int r = scan.nextInt();
            int a[][] = new int[n][n];
            int l = 0;
            int z = 0;
            for (int k = 1; k <= n; k++) {
                z=0;
                for (int i = 0; i < n; i++) {
                    int j = i;
                    l = k;
                    while (j < n) {
                        if(l>n)
                            l=1;
                        a[i][j] = l++;
                        j++;
                    }
                    j = 0;
                    while (j < i) {
                        if(l>n)
                            l=1;
                        a[i][j] = l++;
                        j++;
                    }
                }
                int sum1=0,sum2=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(i==j)
                            sum1+=a[i][j];
                        if(i==n-j-1)
                            sum2+=a[i][j];
                    }
                }

                if(sum1==sum2 && sum2==r)
                {
                    System.out.println("Case #"+t+": POSSIBLE");
                    z=1;
                    for(int i=0;i<n;i++)
                    {
                        for(int j=0;j<n;j++)
                            System.out.print(a[i][j]+ " ");
                        System.out.println();
                    }
                    break;
                }
            }
            if(z==0)
                System.out.println("Case #"+t+": IMPOSSIBLE");
        }
    }
}
