
import java.io.*;
import java.util.*;

class node{
int i,j,value;
node(int i,int j,int value){
this.i = i;
this.j =j;
this.value = value;
}
}
public class Solution {
public static ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
public static void storePascal(int n) {
ArrayList<Integer> temp = new ArrayList<Integer>();
ArrayList<Integer> pre;
temp.add(1);
pascal.add(temp);
for(int i=1;i<=n;i++) {
pre = temp;
temp = new ArrayList<Integer>();
temp.add(1);
for(int j=1;j<pre.size();j++) {
temp.add(pre.get(j)+pre.get(j-1));
}
temp.add(1);
pascal.add(temp);
}
}
public static void printPascal() {
ArrayList<Integer> temp;
for(int i=0;i<pascal.size();i++) {
temp = pascal.get(i);
for(int j=0;j<temp.size() && j<2;j++) {
System.out.print(temp.get(j)+" ");
}
System.out.println();
}
}
public static List<node> ansFor1000(int sum) {
List<node> ans = new ArrayList<node>();
ArrayList<Integer> tempList = new ArrayList<Integer>();
// sum-496
ArrayList<Integer> x = new ArrayList<Integer>();
int temp = sum-496,c=0,count=0,i=0;
// x.add(496);
if(temp>0) {
if(temp-496>0) {
c = temp-496;
x.add(c);
temp = temp-c;
}
x.add(temp);
}
temp = 0;
c = 0; // current Raw index in pascal
while(temp<sum && c<pascal.size() && count<500) {
tempList = pascal.get(c);
if(c>0 && i<x.size() && tempList.get(tempList.size()-2).equals(x.get(i))) {
ans.add(new node(c+1,tempList.size()-1,tempList.get(tempList.size()-2)));
temp += tempList.get(tempList.size()-2);
i++;
}
else {
ans.add(new node(c+1,tempList.size(),tempList.get(tempList.size()-1)));
temp += tempList.get(tempList.size()-1);
c++;
}
count++;
}
// System.out.println(temp+"  "+sum+" count:"+count+"   c:"+c);
return ans;
}
public static void main(String[] args) throws IOException{
storePascal(500);
// printPascal();

BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
String buff[] = scan.readLine().split(" ");
int t = Integer.parseInt(buff[0]);
for(int p=0;p<t;p++) {
buff = scan.readLine().split(" ");
int sum = Integer.parseInt(buff[0]);
List<node> ans = ansFor1000(sum);
System.out.println("Case #"+(p+1)+":");
for(int i=0;i<ans.size();i++) {
System.out.println(ans.get(i).i+" "+ans.get(i).j);
}
// System.out.println();
}
}
}