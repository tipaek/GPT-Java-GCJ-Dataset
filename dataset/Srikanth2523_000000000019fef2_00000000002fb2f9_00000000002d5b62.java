import java.util.*;
class Solution
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int t=sc.nextInt();
for(int a=1;a<=t;a++)
{
int x=sc.nextInt();
int y=sc.nextInt();
if(x%2==0 && y%2==0 ||  x%2!=0 && y%2!=0)
System.out.println("Case #"+a+":"+" IMPOSSIBLE");
}
}
}