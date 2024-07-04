import java.util.*;
import java.io.*;
class Sample{
static int [][][]a=new int[10][100][100];;
static  int []p;
static int T,N,i,j,k,sum,count,R,C,f,row,col,temp;
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
    T=sc.nextInt();
    p=new int[T];
    for(i=0;i<T;i++){
       N=sc.nextInt();
       p[i]=N;
      
       for(j=0;j<p[i];j++){
       for(k=0;k<p[i];k++)
       a[i][j][k]=sc.nextInt();
       }
    }	
  for(i=0;i<T;i++){
      sum=0;R=0;C=0;f=0;
      for(j=0,k=0;j<p[i];j++,k++)
      sum+=a[i][j][k];

      for(j=0;j<p[i];j++){
temp=j;count=1;f=0;row=a[i][j][0];
for(k=1;k<p[i];k++){
if(row==a[i][j][k]){
R++;f=1;break;
}
if(k==N-1&&f==0){
k=++temp;row=a[i][j][count++];
}
}
}
for(j=0;j<p[i];j++){
temp=j;count=1;f=0;col=a[i][0][j];
for(k=1;k<p[i];k++){
if(col==a[i][k][j]){
C++;f=1;break;
}
if(k==N-1&&f==0){
k=++temp;col=a[i][count++][j];
}
}
}
      System.out.print("case #");
      System.out.print(i+1+":");
      System.out.print(" "+sum);
      System.out.print(" "+R);
      System.out.println(" "+C);
  }
}
}