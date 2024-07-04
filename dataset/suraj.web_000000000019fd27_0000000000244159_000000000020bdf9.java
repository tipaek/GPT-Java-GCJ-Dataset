import java.util.*;

class Solution  {
    
    public static void main(String args[])  {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int j=0; j<T; j++)  {

            int N=in.nextInt();
            int noe = N*2;

            int a[] = new int[noe];

            for (int i=0; i<noe; i++)  {
                a[i]=in.nextInt();
            }

            String res = "C";
            String curr= "C";
            int currc=0, currj=0, flag=0;
            for (int i=0; i<N; i+=2)  {
                if (curr=="C")  {
                    if (a[i+1]>=a[i+2])  {
                        if (currj<=a[i+2]) {
                            currc=a[i+1];
                            curr="J";
                            res=res+curr;
                            currj=a[i+3];
                        }
                        else {
                            flag=1;
                        }

                    }
                    else  {
                        curr="C";
                        currc=a[i+3];
                        res=res+curr;
                    }
                }
                else if (curr=="J")  {
                    if (currc<=a[i+2]) {
                        curr="C";
                        currc=a[i+3];
                        currj=a[i+1];
                        res=res+curr;
                    }

                    else  if (currj<=a[i+2]){
                        curr="J";
                        currj=a[i+3];
                        res=res+curr;
                    }

                    else
                        flag=1;
                }
            }

            if (flag==1)
                System.out.println("Case #" + j+1 +": IMPOSSIBLE");
            else
                System.out.println("Case #" + j+1 +": " + res);






        }
        in.close();
    }
}