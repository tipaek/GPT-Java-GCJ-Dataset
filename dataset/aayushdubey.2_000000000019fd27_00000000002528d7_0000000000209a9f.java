import java.util.*;
public class Solution
{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int test = in.nextInt();
in.nextLine();
for(int k=1;k<=test;k++){
int flag=0;
String name = in.nextLine();
String ans = "";
for(int i=0;i<name.length();i++){
int numStr = name.charAt(i);
int num = Character.getNumericValue(numStr);
if(flag==num){
ans=ans+num;

}
if(flag<num){
String testBrace="";
while(num!=flag){
testBrace=testBrace+"(";
flag=flag+1;
}
ans = ans+testBrace+num;
flag = num;

}

if(flag>num){
String testBrace="";
int numBrace = flag-num;
for(int m=0;m<numBrace;m++){
testBrace=testBrace+")";
flag=flag-1;
}
ans = ans+testBrace+num;
flag=num;
}
}
if(flag>0){
String testBrace="";
for(int m=0;m<flag;m++){
testBrace=testBrace+")";
}
ans = ans+testBrace;
}
System.out.println("Case #"+k+": "+ans);
}
}
}
