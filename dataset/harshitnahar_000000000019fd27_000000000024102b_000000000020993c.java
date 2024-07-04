import java.io.*;
import java.util.*;
class Solution
{
public Solution()
{
Scanner sc=new Scanner(System.in);
int nots=sc.nextInt();
int[][] notc=new int[nots][3];
for(int i=0;i<nots;++i)
{
int size=sc.nextInt();
int[][] array=new int[size][size];
for(int m=0;m<size;++m)
{
for(int n=0;n<size;++n)
{
array[m][n]=sc.nextInt();
}
}
notc[i][0]=trace(array,size);
notc[i][1]=sameRow(array,size);
notc[i][2]=sameColumn(array,size);
}
for(int i=1;i<=nots;++i) System.out.println("Case #"+i+": "+notc[i-1][0]+" "+notc[i-1][1]+" "+notc[i-1][2]);
}
public static void main(String gg[])
{
Solution solution=new Solution();
}
public int trace(int[][] array,int size)
{
int trc=0;
for(int i=0;i<size;++i) trc=trc+array[i][i];
return trc;
}
public int sameRow(int[][] array,int size)
{
int count=0;
int element;
for(int i=0;i<size;++i)
{
element=0;
for(int j=0;(j<size && element!=-1);++j)
{
element=array[i][j];
for(int k=j+1;k<size;++k)
{
if(element==array[i][k])
{
element=-1;
++count;
break;
}
}
}
}
return count;
}
public int sameColumn(int[][] array,int size)
{
int count=0;
int element;
for(int i=0;i<size;++i)
{
element=0;
for(int j=0;(j<size && element!=-1);++j)
{
element=array[j][i];
for(int k=j+1;k<size;++k)
{
if(element==array[k][i])
{
element=-1;
++count;
break;
}
}
}
}
return count;
}
}