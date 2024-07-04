

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            for(int t=0;t<tc;t++)
            {
                int r = sc.nextInt();
                int s=sc.nextInt();
                int A[]=new int[r*s];
                int B[]=new int[r*s];
                int C[]=new int[r*s];
                if(r>=s)
                {
                    int total = r*s;
                    int b =r-1;
                    int a=total-1-b;
                    for(int i = 0 ; i<(r-1)*(s-1);i++)
                    {
                        B[i]=b;
                        A[i]=a;
                        a--;
                        if((i+1)%(s-1)==0)
                        {
                            b--;
                        }
                    }

                }


                if(r>s)
                {

                }


                System.out.println("Case #"+(t+1)+": "+(r-1)*(s-1));
                for(int i = 0 ; i < (r-1)*(s-1);i++)
                {
                    System.out.println(A[i]+" "+B[i]);
                }
            }
        }
    }
}
