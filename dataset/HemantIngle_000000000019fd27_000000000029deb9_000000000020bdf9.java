import java.util.*;
class Solution
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int T,N,x,i;
int M[][];
char kid='J';
char y[];
Boolean IMP;
T=sc.nextInt();
Stack<int []> stack1;
Stack<int []> stack2;
for(x=1;x<=T;x++)
{
N=sc.nextInt();
M=new int[N][2];
kid='C';
IMP=false;
y=new char[N];
stack1=new Stack<>();
stack2=new Stack<>();
HashMap<int [],Integer> map=new HashMap<>();
for(i=0;i<N;i++)
{
M[i][0]=sc.nextInt();
M[i][1]=sc.nextInt();
map.put(M[i],i);
}
Arrays.sort(M,(left,right)->{return left[0]-right[0];});
for(i=0;i<N;i++)
{
y[map.get(M[i])]=kid;
if(i<N-1 && M[i][1]>M[i+1][0])
{
if(kid=='C')
{
stack1.push(M[i]);
kid='J';
if(!stack2.isEmpty() && stack2.peek()[1]>M[i+1][0])
{
IMP=true;
break;
}
}
else
{
stack2.push(M[i]);
kid='C';
if(!stack1.isEmpty() && stack1.peek()[1]>M[i+1][0])
{
IMP=true;
break;
}
}
}
else
{
if(kid=='C') stack1.push(M[i]);
if(kid=='J') stack2.push(M[i]);
}
}
System.out.println("Case #"+x+": "+((IMP)?"IMPOSSIBLE":String.valueOf(y)));
}
}
}