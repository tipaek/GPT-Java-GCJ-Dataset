import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args)throws Exception {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());int c=0;
while(t>0){
c++;

String s=br.readLine();

StringBuilder newString=new StringBuilder();


int open=0;
int preVal=0;
int greatest=-1;
for(int i=0;i<s.length();i++)
{
  int val=Integer.parseInt(String.valueOf(s.charAt(i)));
  if(i==0)
  {
    newString.append(generateParaOpen(val));
    newString.append(String.valueOf(s.charAt(i)));
    open+=val;
    preVal=val;
    greatest=val;
  }
  else if(preVal==val){
    newString.append(String.valueOf(s.charAt(i)));
  }else if(preVal>val)
  {
    if(val==0)
    {
    newString.append(generateParaClose(open));
    open-=open;
    greatest=val;
    newString.append(generateParaOpen(val));
    newString.append(String.valueOf(s.charAt(i)));
    open+=val;
    preVal=val;
    }else{
        int newVal=open-val;
     open-=newVal;
     newString.append(generateParaClose(newVal));
     newString.append(val);
     preVal=val;
    }
  }else if(preVal<val)
  {
    if(val>greatest)
    {
    newString.append(generateParaClose(open));
    open-=open;
    greatest=val;
    newString.append(generateParaOpen(val));
    newString.append(String.valueOf(s.charAt(i)));
    open+=val;
    preVal=val;
    }else{
      newString.append(generateParaOpen(Math.abs(open-val)));
      newString.append(String.valueOf(s.charAt(i)));
      open+=Math.abs(open-val);
      preVal=val;
    }
  }
}
newString.append(generateParaClose(open));
System.out.println("Case #"+c+": "+newString);

t--;

}

}
public static String generateParaOpen(int n)
{
  String s="";
  for(int i=0;i<n;i++)
  {
    s+="(";
  }
  return s;
}
public static String generateParaClose(int n)
{
  String s="";
  for(int i=0;i<n;i++)
  {
    s+=")";
  }
  return s;
}
}