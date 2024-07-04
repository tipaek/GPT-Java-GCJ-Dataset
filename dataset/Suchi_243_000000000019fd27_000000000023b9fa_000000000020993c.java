import java.util.*;
class Main
{
public static void main(String args[]){
Scanner in=new Scanner(System.in);
int t;
t=in.nextInt();
while(t>0)
{
t--;
int n=in.nextInt();
int m=n;
int[][] a=new int[n][m];
for(int i=0;i<n;i++)
for(int j=0;j<m;j++)
a[i][j]=in.nextInt();
daigonal(a);
System.out.print(countRows(a)+" ");
System.out.print(countCol(a));
}
System.out.println();
}
public static void daigonal(int a[][])
{
int sum=0;
for(int i=0;i<a.length;i++)
{ 
for(int j=0;j<a[i].length;j++)
{ 
if(i==j) 
{
sum = sum + a[i][j];
}
}
}
System.out.print(sum +" ");
}
public static int countRows(int a[][]) 
{ 
int count = 0; 
for (int i = 0; i < a.length; i++) { 
int first = a[i][0]; 
boolean allSame = true; 
for (int j = 1; j < a[i].length; j++) { 
if (a[i][j] != first) { 
allSame = false; 
break; 
} 
} 
if (allSame) 
count++; 
} 
return count; 
} 
public static int countCol(int a[][]) 
{ 
int count = 0; 
for (int i = 0; i < a.length; i++) { 
int first = a[0][i]; 
boolean allSame = true; 
for (int j = 1; j < a[i].length; j++) { 
if (a[j][i] != first) { 
allSame = false; 
break; 
}
} 
if (allSame) 
count++; 
} 
return count; 
} 
}