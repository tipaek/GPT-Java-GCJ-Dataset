import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution 
{
public static void main(String[] args)
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String s=" ";
int lst=-1,num=0;
int ocnt=0;
String out=null;
StringBuffer op=new StringBuffer();
int j=0;
int cases=0,c=0;
try
{
cases=Integer.parseInt(br.readLine().trim());
StringBuffer sb;
for(c=0;c<cases;c++)
{
lst=-1;
ocnt=0;
out=br.readLine().trim();
sb=new StringBuffer();
for(int i=0;i<out.length();i++)
{
num=Integer.parseInt(out.substring(i,i+1));
if(lst==num)
{
sb.append(lst);
continue;
}

if(num==0)
{
for(j=0;j<ocnt;j++)
{
sb.append(")");
}
ocnt=0;
sb.append(num);
lst=num;
continue;
}

if(ocnt==0)
{
ocnt=num;
for(j=0;j<num;j++)
{
sb.append("(");
}
}else if(ocnt>num)
{
for(j=0;j<(ocnt-num);j++)
{
sb.append(")");
}
ocnt-=num;
}else if(ocnt<num)
{
for(j=0;j<(num-ocnt);j++)
{
sb.append("(");
}
ocnt=ocnt+(num-ocnt);
}
sb.append(num);
lst=num;
}
for(j=0;j<ocnt;j++)
{
sb.append(")");
}

op.append("Case #"+(c+1)+": "+sb.toString()+"\n");

}//caseEnd
System.out.print(op.toString());
}catch(IOException e)
{
e.printStackTrace();
}
}
}

