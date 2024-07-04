import java.util.*;
public class Solution{
    public static void main(String args[]) {
int t,n,i,j;
Scanner sc=new Scanner(System.in);
t=sc.nextInt();
String s="",s1="";
int x=1;
while(t-->0)
{
    s1="";
s=sc.next();
String a[]={"","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
String b[]={"",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
s1=s1+a[s.charAt(0)-'0']+s.charAt(0);
for(i=1;i<s.length();i++)
{
    if(s.charAt(i)-s.charAt(i-1)<0)
    {
        s1=s1+b[s.charAt(i-1)-'0'-(s.charAt(i)-'0')]+s.charAt(i)+"";
    }
    else
    {
        s1=s1+a[s.charAt(i)-'0'-(s.charAt(i-1)-'0')]+s.charAt(i)+"";
    }
}
 s1=s1+b[s.charAt(i-1)-'0'];
System.out.println("Case #"+x+": "+s1);
x++;    
}


}
}








