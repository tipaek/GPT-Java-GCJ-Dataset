import java.util.*;
class Solution{
public static String Open(int n){
    String s="";
    for(int i=0;i<n;i++)
    s+="(";
    
    return s;
}
public static String Close(int n){
    String s="";
    n=-1*n;
    for(int i=0;i<n;i++)
    s+=")";
    
    return s;
}
public static String ConvertString(String s){

String s1="";

s1=s1+Open(Integer.parseInt(String.valueOf(s.charAt(0))))+s.charAt(0);
for(int i=1;i<s.length();i++){
int a=Integer.parseInt(String.valueOf(s.charAt(i)));
int b=Integer.parseInt(String.valueOf(s.charAt(i-1)));
int t=a-b;

if(t>0)
{
s1+=Open(t)+s.charAt(i);
}
if(t<=0)
{
s1+=Close(t)+s.charAt(i);
}
}
s1+=Close(-1*Integer.parseInt(String.valueOf(s.charAt(s.length()-1))));

return s1;
}
public static void main(String args[]){

Scanner sc= new Scanner(System.in);
int t=sc.nextInt();

for(int i=1;i<=t;i++){

String s=sc.next();

String s1= ConvertString(s);

System.out.println("Case #"+i+": "+s1);
}
}
}
