import java.util.*;
class Solution
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int i,j,k;
    for(i=0;i<t;i++)
    {
        String str=sc.nextLine();
        String r="";
        int count=0;
        for(j=0;j<str.length();j++)
        {
            if(str.charAt(j)=='1'&&count==0)
            {
                count++;
                r=r+"("+Character.toString(str.charAt(j));
            }
            else if(str.charAt(j)=='0'&&count==1||count==1&&j==str.length()-1)
            {
                count--;
                r=r+")"+Character.toString(str.charAt(j));
            }
            else
            r=r+Character.toString(str.charAt(j));
        }
        System.out.println("Case #"+(i+1)+": "+r);
    }
    }
}