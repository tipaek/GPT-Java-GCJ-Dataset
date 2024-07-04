package coding_challenge;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium_trace {
static StringBuilder answer = new StringBuilder();
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int query= in.nextInt();
int N = 0;
int M[][] ;
int trace=0;
Set<Integer> tempSet;
int rowNo = 0;
int colNo=0;
for(int i=0;i<query;i++)
{
N = in.nextInt();
M= new int[N][N];
trace=0;
rowNo=0;
for (int j= 0;j<N;j++)
{

tempSet= new HashSet<Integer>();
for(int k=0;k<N;k++)
{
M[j][k] = in.nextInt();

if (j==k)
trace+= M[j][j];
tempSet.add(M[j][k]);

}
if(tempSet.size()!=N)
rowNo++;
}
colNo=findColDuplicate(M,N);
answer.append("Case #"+(i+1)+": ");
answer.append((Integer.toString(trace)+" "+Integer.toString(rowNo)+" "+Integer.toString(colNo)+("\n")));
}
System.out.print(answer);
in.close();

}
private static int findColDuplicate(int[][] m, int n) {
// TODO Auto-generated method stub

int colNo=0;
Set<Integer> tempSet;
for (int j= 0;j<n;j++)
{
tempSet = new HashSet<Integer>();
for(int k=0;k<n;k++)
{
tempSet.add(m[k][j]);
}
if(tempSet.size()!=n)
colNo++;
}
return colNo;
}

}