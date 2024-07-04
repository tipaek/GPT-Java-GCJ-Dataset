import java.util.regex.*;
import java.util.Scanner;
 class rut{
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=0;
        int v=1;
        t=sc.nextInt();
        while(t!=0)
        {
            int sn=0;
            String ss[]=new String[sn];
            for(int i=0;i<sn;i++)
            {
                ss[i]=sc.next();
                
            }
            int ss1[]=new int[sn];
            int max=0;
            int maxt=-1;
            for(int i=0;i<sn;i++)
            {
                ss1[i]=ss[i].length();
                if(max<ss[i].length())
                {
                    max=ss[i].length();
                    maxt=i;
                }
            }
            StringBuilder sf=new StringBuilder();
            sf.append(ss[maxt]);
            sf=sf.deleteCharAt(0);
            String g=sf.toString();
          
System.out.println("Case #"+v+": "+g);


            
            t--;
        }
    }
}

