//package coding_challenge;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
static StringBuilder ans = new StringBuilder();
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner inp = new Scanner(System.in);
int queries= in.nextInt();
int N = 0;
int M[][] ;
int trace=0;
Set<Integer> temp;
int rowNo = 0;
int colNo=0;
for(int i=0;i<queries;i++)
{
N = in.nextInt();
M= new int[N][N];
trace=0;
rowNo=0;
for (int j= 0;j<N;j++)
{

temp= new HashSet<Integer>();
for(int k=0;k<N;k++)
{
M[j][k] = in.nextInt();

if (j==k)
trace+= M[j][j];
temp.add(M[j][k]);

}
if(temp.size()!=N)
rowNo++;
}
colNo=findColDuplicate(M,N);
ans.append("Case #"+(i+1)+": ");
ans.append((Integer.toString(trace)+" "+Integer.toString(rowNo)+" "+Integer.toString(colNo)+("\n")));
}
System.out.print(ans);
in.close();

}
private static int findColDuplicate(int[][] m, int n) {
// TODO Auto-generated method stub

int colNo=0;
Set<Integer> temp;
for (int j= 0;j<n;j++)
{
temp = new HashSet<Integer>();
for(int k=0;k<n;k++)
{
temp.add(m[k][j]);
}
if(temp.size()!=n)
colNo++;
}
return colNo;
}

}