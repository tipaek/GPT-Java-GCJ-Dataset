import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            int m[][]=new int[3][n];
            int jj[][]=new int[3][n];
            int cc[][]=new int[3][n];
            for(int j=0;j<n;j++)
            {
                m[0][j]=sc.nextInt();
                m[1][j]=sc.nextInt();
                m[2][j]=j;

                jj[0][j]=-1;
                cc[0][j]=-1;
            }

            m=sort(m,0,n-1);

            char ans[]=new char[n];


            jj[0][0]=m[0][0];
            jj[1][0]=m[1][0];
            jj[2][0]=m[2][0];

            int flag=0;

            int n1=1,n2=0;
            int x;

            for(int j=1;j<n;j++)
            {
                jj[0][n1]=m[0][j];
                jj[1][n1]=m[1][j];
                jj[2][n1]=m[2][j];
                n1+=1;
                x=check(jj,n1);
                if(x==1)
                {
                    n1-=1;
                    jj[0][n1]=-1;
                    jj[1][n1]=-1;
                    jj[2][n1]=-1;

                    cc[0][n2]=m[0][j];
                    cc[1][n2]=m[1][j];
                    cc[2][n2]=m[2][j];
                    n2+=1;
                    x=check(cc,n2);
                    if(x==1)
                    {
                        flag=1;
                        break;
                    }
                }
            }

            for(int k=0;k<n1;k++)
                ans[jj[2][k]]='J';
            for(int k=0;k<n2;k++)
                ans[cc[2][k]]='C';

            if(flag==1)
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else
            {
                String s="";
                for(int k=0;k<n;k++)
                {
                    s=s+ans[k];
                }

                System.out.println("Case #"+(i+1)+": "+s);
            }


        }




    }

    static int check(int arr[][], int n)
    {
        int f=0;
        if(n<2)
            return f;
        for(int i=1;i<n;i++)
        {
            if(arr[0][i]==-1)
                break;

            if(arr[1][i-1]>arr[0][i])
                return 1;
        }
        return f;
    }

    static int[][] sort(int arr[][], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

        return arr;
    }

    static int[][] merge(int arr[][], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[][] = new int [3][n1];
        int R[][] = new int [3][n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            L[0][i] = arr[0][l + i];
            L[1][i] = arr[1][l + i];
            L[2][i]=arr[2][l+i];
        }
        for (int j=0; j<n2; ++j) {
            R[0][j] = arr[0][m + 1 + j];
            R[1][j] = arr[1][m + 1 + j];
            R[2][j]=arr[2][m+1+j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[0][i] <= R[0][j])
            {
                arr[0][k] = L[0][i];
                arr[1][k]=L[1][i];
                arr[2][k]=L[2][i];
                i++;
            }
            else
            {
                arr[0][k] = R[0][j];
                arr[1][k]=R[1][j];
                arr[2][k]=R[2][j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[0][k] = L[0][i];
            arr[1][k]=L[1][i];
            arr[2][k]=L[2][i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[0][k] = R[0][j];
            arr[1][k]=R[1][j];
            arr[2][k]=R[2][j];
            j++;
            k++;
        }

        return arr;
    }
}