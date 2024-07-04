import java.util.*;
class Trace{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int T,N,R,C,i,j,k,f,temp,count,sum,row,col;
T=sc.nextInt();
int[][] A=new int[T][3];
for(i=1;i<=T;i++){
sum=0;R=0;C=0;f=0;
N=sc.nextInt();
int[][] a=new int[N][N];
for(j=0;j<N;j++){
for(k=0;k<N;k++)
a[j][k]=sc.nextInt();
}
for(j=0,k=0;j<N;j++,k++)
sum+=a[j][k];
for(j=0;j<N;j++){
temp=j;count=1;f=0;row=a[j][0];
for(k=1;k<N;k++){
if(row==a[j][k]){
R++;f=1;break;
}
if(k==N-1&&f==0){
k=++temp;row=a[j][count++];
}
}
}
for(j=0;j<N;j++){
temp=j;count=1;f=0;col=a[0][j];
for(k=1;k<N;k++){
if(col==a[k][j]){
C++;f=1;break;
}
if(k==N-1&&f==0){
k=++temp;col=a[count++][j];
}
}
}
A[i][0]=sum;
A[i][1]=R;
A[i][2]=C;
}
for(i=0;i<T;i++){
System.out.print("case #");
System.out.print(i+1);
for(j=0;j<3;j++)
System.out.print(": "+A[i][j]);
System.out.println();
}
}
}