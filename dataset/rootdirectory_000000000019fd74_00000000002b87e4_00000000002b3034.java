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
            StringBuilder sr=new StringBuilder();
            int sn=0;
            sn=sc.nextInt();
            String sss[]=new String[sn];
            for(int i=0;i<sn;i++)
            {
                sss[i]=sc.next();
            }
            for(int i=0;i<sn-1;i++){
            Pattern p1=Pattern.compile(sss[i]);
            Matcher m=p1.matcher(sss[i+1]);
            while(matcher.find())
            {
                sr.replace(matcher.group());
}
System.out.println("Case #"+v+": "+sr);

}
            
            t--;
        }
    }
}

