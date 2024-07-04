import java.io.*;
import java.util.*;
class Solution3
{
public Solution3()
{
Scanner sc=new Scanner(System.in);
int nots=sc.nextInt();
int[][] not=new int[nots][2];
for(int i=0;i<nots;++i)
{
not[i][0]=sc.nextInt();
not[i][1]=sc.nextInt();
}
for(int k=0;k<nots;++k)
{
int size=not[k][0];
int trace=not[k][1];
if(trace%size!=0 && trace<=(size*size))
{
System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
continue;
}
else
{
System.out.println("Case #"+(k+1)+": POSSIBLE");
int element=trace/size;
int start=element;
for(int i=0;i<size;++i)
{
int pe=start;
String ss="";
for(int j=0;j<size;++j)
{
ss=ss+pe+" ";
start=pe;
--pe;
if(pe<0) pe=size;
}
System.out.println(ss.trim());
}
}
}
}
public static void main(String gg[])
{
Solution3 solution=new Solution3();
}
}