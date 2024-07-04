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
            int i,j,n=str.length(),k;
            for(i=0;i<n;)
            {
                for(k=0;k<Character. getNumericValue(str.charAt(i));k++)
                v=v+'(';
                v=v+str.charAt(i);
                for(j=i+1;j<n;j++)
                {
                    if(str.charAt(j)==str.charAt(i))
                    {
                    v=v+str.charAt(i);
                    }
                    else
                    break;
                }
                for(k=0;k<Character. getNumericValue(str.charAt(i));k++)
                v=v+')';
                if(str.charAt(i)==str.charAt(j-1))
                i=j;
                else
                i++;
             }
             
               
             
            System.out.println("Case #"+(test++)+": "+v);
        }
        s.close();
    }
}