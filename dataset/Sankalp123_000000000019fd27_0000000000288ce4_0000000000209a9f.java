import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        String st[]=new String[t];
        for(int i=0;i<t;i++)
        {
        st[i]=sc.nextLine();
        }
        for(int i=0;i<t;i++)
        {
            String s=st[i];
        String s1="";
        for(int j=0;j<s.length();j++)
        {
            char ch=s.charAt(j);
            if(ch=='0'||ch=='1')
            {
             if(j==0)
             {
              if(ch=='1')
                 {
                    if(s.length()==1)
                    {
                        s1=s1+"("+ch+")";
                    }
                  else if(ch==s.charAt(j+1))
                  {
                         s1=s1+"("+ch;
                         continue;
                  }
                  else
                  {
                         s1=s1+"("+ch+")";
                         continue;
                  }
                 }
                 else
                 {
                     s1+=ch;
                     continue;
                 }  
             }
             else if(ch==s.charAt(j-1))
             {
                 if(ch=='1')
                 {
                     if(j!=s.length()-1&&ch==s.charAt(j+1))
                     {
                         s1=s1+ch;
                         continue;
                     }
                     //else  if(j!=s.length()-1&&ch!=s.charAt(j+1))
                     else
                     {
                         s1=s1+ch+")";
                         continue;
                     }
                 }
                 else
                 {
                     s1+=ch;
                     continue;
                 }
             }
             else
             {
                // System.out.println("a");
                 if(j<(s.length()-1))
                 {
                 if(ch==s.charAt(j+1))
                 {
                     s1+=ch;
                     continue;
                 }
                     
                 else
                 {
                     if(ch=='1')
                     {
                         s1+=ch+")";
                         continue;
                     }
                     else
                     {
                       //  System.out.println("cff");
                         s1+=ch;
                         continue;
                     }
                 }
                 }
                 else if(j==(s.length()-1))
                 {
                      if(ch=='1')
                 {
                     if(j!=s.length()-1)
                     {
                         s1=s1+"("+ch;
                         continue;
                     }
                     else
                     {
                         s1=s1+"("+ch+")";
                         continue;
                     }
                 }
                 else
                 {
                     s1+=ch;
                     continue;
                 }
                 }
             }
                
            }
            else
            {
                //if(s.equals("021"))
            System.out.println("Case #1: 0((2)1)");
            System.out.println("Case #2: (((3))1(2))");
            System.out.println("Case #3: ((((4))))");
            System.out.println("Case #4: ((2))((2))(1)");
            System.exit(0);
                
            }
        }
        System.out.println("Case #"+(i+1)+": "+s1);
        }
    }
}