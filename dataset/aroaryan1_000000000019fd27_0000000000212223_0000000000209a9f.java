import java.util.*;
public class Solution
{
public static void main(String[] args)
 {
Scanner sc= new Scanner(System.in);
int h=sc.nextInt();
for(int l=1;l<=h;l++)
  {
    String str=sc.next();
    str=str.trim();
    str="0"+str+"0";
    String s="";
    for(int i=1;i<str.length()-1;i++)
    {
        char ch=str.charAt(i);
        if(ch!='0')
        {
            if(str.charAt(i-1)=='0')
            {
                s=s+'('+ch;
                if(str.charAt(i+1)=='0')
            {
                s=s+')';
            }
                
            }
            if(str.charAt(i+1)=='0'&& str.charAt(i-1)!='0')
            {
                s=s+ch+')';
            }
            if(str.charAt(i+1)!='0'&&str.charAt(i-1)!='0')
            {
                s=s+ch;
            }
            
        }
        else
        {
            s=s+ch;
        }
        
    }
    System.out.println("Case #"+l+": "+s);
  }
 }
}