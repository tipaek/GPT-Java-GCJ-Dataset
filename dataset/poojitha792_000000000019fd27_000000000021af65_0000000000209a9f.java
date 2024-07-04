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
            int i,j,n=str.length();
            for(i=0;i<n;)
            {
                if(str.charAt(i)=='1')
                {
                    v=v+'('+'1';
                for(j=i+1;j<n;j++)
                {
                    if(str.charAt(j)=='1'){
                    v=v+'1';
                    }
                    else
                    break;
                }
                v=v+')';
                
                i=j;
               }
               else{
               v=v+'0';
               i++;
               }
               
             }
            System.out.println("Case #"+(test++)+": "+v);
        }
        s.close();
    }
}