import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt(); int tt=1;
        while(t-->0)
        {
            String st="C",stt="";char ch='C';
            int n=in.nextInt(),i,j,temp;
            int ts[]=new int[1500];
            int te[]=new int[1500];
            int tss[]=new int[1500];
            int tee[]=new int[1500];
            for(i=0;i<n;i++)
            {
                ts[i]= in.nextInt();
                te[i]= in.nextInt();
                tss[i]=ts[i];
                tee[i]=tee[i];
            }
            for(i=0; i<(n-1); i++)
            {
                for(j=0; j<(n-i-1); j++)
                {
                    if(ts[j] > ts[j+1])
                    {
                        temp = ts[j];
                        ts[j] = ts[j+1];
                        ts[j+1] = temp;
                        //array2
                        temp = te[j];
                        te[j] = te[j+1];
                        te[j+1] = temp;
                    }
                }
            }
            for(i=1;i<n;i++)
            {
                if(te[0]>ts[n-1])
                {
                    st="IMPOSSIBLE";
                    break;
                }
                if(ts[i]<te[i-1])
                {
                    if(ch=='C')
                    ch='J';
                    else
                    ch='C';
                }
                st+=ch;                
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(tss[i]==ts[j])
                    stt+=st.charAt(j);
                }
            }
            if(st.equals("IMPOSSIBLE"))
            System.out.println("Case #"+tt+": "+st);
            else
            System.out.println("Case #"+tt+": "+stt);
            tt++;
        }
    }
}