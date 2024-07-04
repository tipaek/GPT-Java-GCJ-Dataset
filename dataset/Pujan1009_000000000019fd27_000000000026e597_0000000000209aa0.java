import java.util.Scanner;
import java.util.Arrays;
public class  Solution
{
    static int n,k;
    static Integer a[][];
    static boolean done;
    static Scanner scan = new Scanner(System.in);



    static void LALULALPURWALA()
    {
        a=new Integer[n][n];
        for(int i=0;i<n;i++) Arrays.fill(a[i],0);
        done=false;
    }

    
    static void PUJANLALPURWALA()
    {
        if(done==true) return;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    for(int p=1;p<=n;p++)
                    {
                        boolean lalu=true;
                        for(int l=0;l<n;l++)
                        {
                            if(a[i][l]==p || a[l][j]== p)  { lalu=false; break; }
                        }
                        if(lalu==true)
                        {
                            a[i][j]=p;  PUJANLALPURWALA();  a[i][j]=0;
                        }
                    }
                    return;
                }
            }
        }

        int ans1=0,ans2=0;
        for(int i=0;i<n;i++) { ans1+=a[i][i];  ans2+=a[i][n-i-1]; }
        if(ans1==k)
        {
            done=true; System.out.println("POSSIBLE");
            //PrintInNormalManner();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++) System.out.print(a[i][j]+" ");
                System.out.println();
            }
        }
        else if(ans2==k)
        {
            done=true; System.out.println("POSSIBLE");
            //PrintInReverseManner();
            for(int i=0;i<n;i++)
            {
                for(int j=n-1;j>=0;j--) System.out.print(a[i][j]+" ");
                System.out.println();
            }
        }
    }




    public static void main(String[] stp) throws Exception
    {

        int t=scan.nextInt(),i;

        int ncase=1;
        while(t-- > 0)
        {
            n=scan.nextInt();k=scan.nextInt();
            LALULALPURWALA();
            System.out.print("Case #"+ncase+": ");
            ncase++;
            if(n==5)
            {
                if(k <= 4|| k == 6 || k == 24 || k >=26);
                else PUJANLALPURWALA();
            }
            else PUJANLALPURWALA();
            if(done==false) System.out.println("IMPOSSIBLE");
        }
    }





}