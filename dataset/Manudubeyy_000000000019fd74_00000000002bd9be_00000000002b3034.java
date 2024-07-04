import java.util.*;
class q
{
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
List<String> s = new ArrayList<>();
int t;
t=sc.nextInt();
int l=0,m=0,n=0,z=0,p=0;
int[] a=new int[t];
for(int i=0;i<t;i++)
{
a[i]=sc.nextInt();
l=0;m=0;
for(int j=0;j<a[i];j++)
{
s.add(sc.nextLine());
l=s.get(j).length();
if(l>m)
{

m=l;
n=j;
}
}//j
for(int j=0;j<a[i];j++)
{
if(n==j)
continue;
for(int k=1;k<s.get(j).length();k++)
{
if(s.get(n).indexOf(s.get(j).charAt(0))>-1)
{
if(s.get(n).indexOf(s.get(j).charAt(k))!=-1 && s.get(n).indexOf(s.get(j).charAt(k))<s.get(n).indexOf(s.get(j).charAt(k-1)))
{
z=2;
break;
}
}
}//k

if(z==2)
{
System.out.println("Case #"+i+": *");
break;
}

}//j
if(z==0)
{
System.out.println("Case #"+i+": "+s.get(n).replace('*',' '));
break;
}
if(z==1)
{
System.out.println("Case #"+i+": "+s.get(m).substring(0,s.get(m).length())+s.get(p).substring(0));
}
s.clear();
z=0;m=0;p=0;n=0;
}
}//i
}
