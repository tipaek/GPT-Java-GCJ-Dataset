//package code;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
static StringBuilder ans = new StringBuilder();
public static void main(String[] args) {

Scanner scn = new Scanner(System.in);
int T= scn.nextInt();
int N = 0;
int arr[][] ;
int dia=0;
Set<Integer> temp;
int row = 0;
int col=0;
for(int i=0;i<T;i++)
{
N = scn.nextInt();
arr= new int[N][N];
dia=0;
row=0;
for (int j= 0;j<N;j++)
{

temp= new HashSet<Integer>();
for(int k=0;k<N;k++)
{
arr[j][k] = scn.nextInt();

if (j==k)
dia+=arr[j][j];
temp.add(arr[j][k]);

}
if(temp.size()!=N)
row++;
}
col=dupilcates(arr,N);
ans.append("Case #"+(i+1)+": ");
ans.append((Integer.toString(dia)+" "+Integer.toString(row)+" "+Integer.toString(col)+("\n")));
}
System.out.print(ans);
scn.close();

}
private static int dupilcates(int[][] array, int m) {

int colno=0;
Set<Integer> keySet;
for (int j= 0;j<m;j++)
{
 keySet= new HashSet<Integer>();
for(int k=0;k<m;k++)
{
keySet.add(array[k][j]);
}
if(keySet.size()!=m)
colno++;
}
return colno;
}

}