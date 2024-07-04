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
l=s[j].length();
if(l>m)
{
if(m>p)
p=m;
m=l;
n=j;
}
}//j
for(int j=0;j<a[i];j++)
{
s=0;
if(n==j)
break;
for(int k=1;k<s[j].length();k++)
{
if(s[n].indexOf(s[j].charAt(0))>-1)
{
if(s[n].indexOf(s[j].charAt(k))<s[n].indexOf(s[j].charAt(k-1)))
{
if(s[j].charAt(0)=='*'||s[j].charAt(s[j].length()-1)=='*')
{
z=1;
break;
}
else
{
z=2;
break;
}
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
System.out.println("Case #"+i+": "+s[n].replace('*',' '));
break;
}
if(z==1)
{
System.out.println("Case #"+i+": "+s[m].substring(0,s[m].length())+s[p].substring(0));
}
}
s.clear();
}//i
}
