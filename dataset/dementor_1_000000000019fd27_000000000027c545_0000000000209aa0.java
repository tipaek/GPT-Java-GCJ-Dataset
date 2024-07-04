
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ayush1 on 04-04-2020
 */

class Solution {
    static boolean fillmatrix(int i,int j,int k,int n,int b[][],int row[][],int col[][],int count)
    {
        boolean check;
        for (int l = i; l < n; l++) {
            for (int m = j; m < n; m++) {
                if(b[l][m]!=-1)
                    continue;
                for (int o = k; o <=n; o++) {
                    count+=1;
                    //System.out.println(l+" "+m+" "+o+" "+count);
                    if(o==n&&(row[l][o]==1||col[m][o]==1))
                    {
                        return false;
                    }
                    else if(row[l][o]==1||col[m][o]==1)
                        continue;
                    else
                    {
                        b[l][m]=o;
                        row[l][o]=1;
                        col[m][o]=1;
                        if(m+1<n)
                            check = fillmatrix(l,m+1,1,n,b,row,col,count);
                        else
                            check = fillmatrix(l+1,0,1,n,b,row,col,count);
                        if(!check)
                        {
                            b[l][m]=-1;
                            row[l][o]=0;
                            col[m][o]=0;
                            if(o==n)
                                return false;
                        }
                        else
                            break;
                    }
                }
            }
        }
        //System.out.println("count "+count);
        return true;
    }
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int n,tr,a[],sum,b[][],row[][],col[][];
        String s[];
        for (int i = 1; i <=test ; i++) {
            s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            tr = Integer.parseInt(s[1]);
            if(n==2&&tr==3)
            {
                System.out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
                continue;
            }
            else if(n==2&&tr==2)
            {
                System.out.printf("Case #%d: %s\n", i, "POSSIBLE");
                System.out.println("1 2");
                System.out.println("2 1");
                continue;
            }
            else if(n==2&&tr==4)
            {
                System.out.printf("Case #%d: %s\n", i, "POSSIBLE");
                System.out.println("2 1");
                System.out.println("1 2");
                continue;
            }
            else if(n==3&&(tr==4||tr==5||tr==7||tr==8))
            {
                System.out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
                continue;
            }
            else if(n==3&&tr==6)
            {
                System.out.printf("Case #%d: %s\n", i, "POSSIBLE");
                System.out.println("1 2 3");
                System.out.println("2 3 1");
                System.out.println("3 1 2");
                continue;
            }
            else if(n==3&&tr==9)
            {
                System.out.printf("Case #%d: %s\n", i, "POSSIBLE");
                System.out.println("3 1 2");
                System.out.println("2 3 1");
                System.out.println("1 2 3");
                continue;
            }
            if(tr<n||tr==n+1||tr==n*n-1) {
                System.out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
                continue;
            }
            else if(tr==n)
            {
                b = new int[n][n];
                for (int j = 0; j <n; j++) {
                    b[0][j] = j+1;
                }
                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        b[j][k] = b[j-1][(n-1+k)%n];
                    }
                }
            }
            else
            {
                a = new int[n];
                b = new int[n][n];
                row = new int[n+1][n+1];
                col = new int[n+1][n+1];
                for (int j = 0; j <n-2 ; j++) {
                    a[j]=1;
                }
                a[n-2] = 2;
                a[n-1] = 2;
                sum = n-2+4;
                tr-=sum;
                for (int j = n-1; tr!=0 ; j--) {
                    if(j==-1)
                    {
                        j=n-1;
                    }
                    if(a[j]+1<=n)
                    {
                        a[j]++;
                        tr--;
                    }
                }
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        b[j][k]=-1;
                    }
                }
                for (int j = 0; j < n; j++) {
                    b[j][j] = a[j];
                    row[j][a[j]]=1;
                    col[j][a[j]]=1;
                }
                //long time1 = System.currentTimeMillis();
                fillmatrix(0,0,1,n,b,row,col,0);
                //System.out.println("time "+(System.currentTimeMillis()-time1));
            }
            System.out.printf("Case #%d: %s\n", i, "POSSIBLE");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(b[j][k]+" ");
                }
                System.out.println("");
            }
        }
    }
}
