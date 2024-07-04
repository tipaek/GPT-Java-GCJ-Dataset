import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{
   private static Scanner sc;
   static int tn=1;
   
   public static void main(String[] args)
{
sc=new Scanner(System.in);
int t1=sc.nextInt();
sc.nextLine();
while(t1-->0)
{
  solv();
}
}
  private static void solv()
{
String s=sc.nextLine();
StringBuilder sa=new StringBuilder();
char[] chars=s.toCharArray();
int num=0;
int brackets=0;
int first=Character.getNumericValue(chars[0]);
num=first;
brackets=first;
for(int i=0;i<first;i++)
{ sa.append('(');
}
sa.append(first);
for(int i=1;i<chars.length;i++)
{
int d=Character.getNumericValue(chars[i]);
if(d==num)
{sa.append(d);
}
else if(d>num)
{int diff=d-num;
for(int j=0;j<diff;j++)
{
sa.append('(');
brackets++;
}
sa.append(d);
}else{
int diff=num-d;
for(int j=0;j<diff;j++)
{
sa.append(')');
brackets--;
}
sa.append(d);
}
num=Character.getNumericValue(chars[i]);
}
while(brackets-->0)
{
sa.append(')');
}
System.out.println("Case #"+(tn++)+": "+sa.toString());
}
}