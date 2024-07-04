import java.util.Scanner;
public class Solution 
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        scan.nextLine();
        int p=0;
        while(p<t)
        {
            String str=scan.nextLine();
            String ans="";
            int inke_andhr_hai=0;
            for(int i=0;i<str.length();i++)
            {
                int no=str.charAt(i)-'0';
                if(inke_andhr_hai<=no)
                {
                    int braces_to_be_added=no-inke_andhr_hai;
                    inke_andhr_hai+=braces_to_be_added;
                    while(braces_to_be_added!=0)
                    {
                        ans+='(';
                        braces_to_be_added-=1;
                    }
                    ans+=str.charAt(i);
                }
                else 
                {
                    int braces_to_be_removed=inke_andhr_hai-no;
                    inke_andhr_hai-=braces_to_be_removed;
                    while(braces_to_be_removed!=0)
                    {
                        ans+=')';
                        braces_to_be_removed-=1;
                    }
                    ans+=str.charAt(i);
                }
            }
            
            while(inke_andhr_hai!=0)
            {
                ans+=")";
                inke_andhr_hai-=1;
            }
             System.out.println("Case #"+(p+1)+": "+ans);
             p+=1;
        }
    }
}