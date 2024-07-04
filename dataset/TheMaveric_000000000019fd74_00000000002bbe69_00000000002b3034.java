import java.util.*;
public class Solution1 {
    public String right(String[] s)
    {  int c=0;
        int l=0;
        String str="";
        for(int i=0 ; i<s.length ; i++)
        {            
            if(s[i].charAt(s[i].length()-1)=='*' && s[i].length()>l)
            {
                l=s[i].length();
                str=s[i];
        }
    }
    return str;
}
public String left(String[] s)
    {  int c=0;
        int l=0;
        String str="";
        for(int i=0 ; i<s.length ; i++)
        {            
            if(s[i].charAt(0)=='*' && s[i].length()>l)
            {
                l=s[i].length();
                str=s[i];
        }
    }
    return str;
}
    public static void main() {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        

        int b=0,k=0;
        while(b!=n)
        {   Solution1 obj=new Solution1();
            int m=in.nextInt();
            String[] sarr=new String[m];
            int flag=0;
            String rt,lt;
            int c=0,d=m-1;
            for(int i=0 ; i<m ; i++)
            {
                sarr[i]=in.next();
            }
            Arrays.sort(sarr,Collections.reverseOrder());
            for(int i=0 ; i<m ; i++)
            {
                System.out.println(sarr[i]);
            }
            rt=obj.right(sarr);
            lt=obj.left(sarr);
            if(rt.equals(""))
            {
                lt=lt.replace("*","");
                System.out.println("Case #"+(++b)+": "+lt);
            }
            else if(lt.equals(""))
            {
                rt=rt.replace("*","");
                System.out.println("Case #"+(++b)+": "+rt);
            }
            else
            System.out.println("Case #"+(++b)+": "+lt+rt);
            
        }
   }
}
