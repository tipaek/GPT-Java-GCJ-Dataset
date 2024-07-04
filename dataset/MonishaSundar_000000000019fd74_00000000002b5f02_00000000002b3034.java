import java.util.*;

public class Solution
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int n1;
        String s=new String[n1];
        int t=1;
        for(int i=0;i<n;i++)
        {
            n1=sc.nextInt();
            s=new String[n1];
            s[i]=sc.nextLine();
        }
        for(int i=0;i<s.length();i++)
        {
            if(!s.contains(Character.toString(s[0].charAt(i))))
                   s[0]=s[0]+Character.toString(s[0].charAt(i));
        }
      for(int j=0;j<s.length();j++)
        {
            if(!s.contains(Character.toString(s[1].charAt(i))))
                   s[1]=s[1]+Character.toString(s[1].charAt(i));
        }
        char a[]=s[0].toCharArray();
        char a1[]=s[1].toCharArray();
        
        Arrays.sort(a);
        Arrays.sort(a1);
        
        String st1=Arrays.toString(a);
        String st2=Arrays.toString(a1);
        
        if(a.contains(a1))
           System.out.println("Case #"+(t++)+": "+a);
        else
           System.out.println("Case #"+(t++)+": "+"*");
}
}