import java.util.*;
class Solution{
    public static void main(String args[])
    {
        int t;
        Scanner s=new Scanner(System.in);
        t=s.nextInt();
        int test=1;
        while(t-->0)
        {
            String str=s.next();
            String v="";
            int i,j,n=str.length(),k,fir=0;
            for(i=0;i<n;i++)
            {
                int sec=(int)(str.charAt(i)-'0');
                while(sec>fir)
                {
                    fir++;
                    v=v+'(';
                }
                while(sec<fir)
                {
                    fir--;
                    v=v+')';
                }
                v=v+str.charAt(i);
            }
            while(fir>0)
            {
                fir--;
                v=v+')';
            }
           System.out.println("Case #"+(test++)+": "+v);
        }
        s.close();
    }
}