import java.io.*;
class Solution
{
    public static void move(int A[],int B[],int x,int shift)
    {
        //System.out.println(shift);
        /*
        for(int i=0;i<A.length;i++)
        {
            System.out.println("**"+A[i]+" "+B[i]);
        }
        System.out.println("***************");
        */
        int s1[]=new int [shift];
        int s2[]=new int [shift];
        int k=0;
        for(int i=x-shift+1;i<=x;i++)
        {
            s1[k]=A[i];
            s2[k]=B[i];
            k++;            
        }
        for(int i=x;i>=shift;i--)
        {
            A[i]=A[i-shift];
            B[i]=B[i-shift];
        }
        for(int i=0;i<shift;i++)
        {
            A[i]=s1[i];
            B[i]=s2[i];
        }
        /*
        for(int i=0;i<A.length;i++)
        {
            System.out.println("**"+A[i]+" "+B[i]);
        }
        System.out.println("######################");
        */
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader
        (System.in));
        int T=Integer.parseInt(br.readLine());
        int aa=1;
        while(aa<=T)
        {
            String s1[]=br.readLine().split(" ");
            int R=Integer.parseInt(s1[0]);
            int S=Integer.parseInt(s1[1]);
            int A[]=new int[R*S];
            int B[]=new int[R*S];
            String a="";
            String b="";
            int k=0;
            int moves=0;
            for(int i=1;i<=S;i++)
            {
                for(int j=1;j<=R;j++)
                {
                    A[k]=j;
                    B[k]=i;
                    k++;
                }
            }
            k = (R*S)-1;
            int shift=R-1;
            int x=S-1;
            while(shift >0)
            {
                
                
                if(x!=0)
                {
                    move(A,B,k-1,shift);
                    int m=k-shift;
                    a=a+m+" ";
                    b=b+shift+" ";
                    k--;
                    x--;
                    moves++;
                }
                else
                {
                    k--;
                    shift--;
                    x=S-1;
                }
            }
            a.trim();
            b.trim();
            String a1[]=a.split(" ");
            String b1[]=b.split(" ");
            System.out.println("Case #"+aa+": "+moves);
            for(int i=0;i<moves;i++)
            {
                System.out.println(a1[i]+" "+b1[i]);
            }
            aa++;
        }
        
    }
}