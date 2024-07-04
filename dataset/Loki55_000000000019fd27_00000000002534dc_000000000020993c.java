import java.util.*;
import java.lang.*;
class Main{
public static void main(String args[]){
int t,n,i,j,k;
Scanner sc = new Scanner(System.in);
t=sc.nextInt();
int b[]=new int[t];
int c[]=new int[t];
int d[]=new int[t];
int e[]=new int[t];
for(i=1;i<=t;i++){
    int h=i;
n=sc.nextInt();
int s=n*n;
int a[][]=new int[s][s];
for(i=1;i<=n;i++){
  for(j=1;j<=n;j++){
  a[i][j]=sc.nextInt();
  }
 } int tr=0,r=0,col=0;
 for(i=1;i<=n;i++){
   int flag=0;
   for(j=1;j<=n;j++){
   if(i==j){
      tr=tr+a[i][j];
           }
    for(k=1;k<=n;k++){
    if(a[i][j]==a[i][k] && j!=k){
      flag=1;
      }
     }
     } if(flag==1)
     { r=r+1;
     }
  }
   
for(i=1;i<=n;i++){
  int flag2=0;
  for(j=1;j<=n;j++){
  for(k=1;k<=n;k++){
  if(a[j][i]==a[k][i] && j!=k){
     flag2=1;
   }
  } 
  }if(flag2==1)
   { col=col+1;
   }
}  
i=h;
b[i-1]=t;
c[i-1]=tr;
d[i-1]=r;
e[i-1]=col;
}
 for(i=0;i<=t-1;i++){
     System.out.println("Case #"+(i+1)+":"+" "+c[i]+" "+d[i]+" "+e[i]);
    }
}
}										    