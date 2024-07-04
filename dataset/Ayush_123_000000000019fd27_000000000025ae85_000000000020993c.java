import java.util.*;
 public class CJ
{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
int sum=0,count=0,count1=0,cr=0,cc=0;
int[] k=new int[t];
int[] r=new int[t];
int[] c=new int[t];
for(int l=0;l<t;l++){
int n=sc.nextInt();
int[][][] arr_sub=new int[t][n][n];
int[] check=new int[n];
int[] check1=new int[n];
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
arr_sub[l][i][j]=sc.nextInt();
if(i==j){
sum=sum+arr_sub[l][i][j];
}


check[j]=arr_sub[l][i][j];

}
for(int m=0;m<n-1;m++){
for(int p=m+1;p<n;p++){
if(check[m]==check[p]){
count=1;
}
}
}
if(count==1){
cr++;
count=0;
}

}

//latest
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
check1[j]=arr_sub[l][j][i];
}
for(int m=0;m<n-1;m++){
for(int p=m+1;p<n;p++){
if(check1[m]==check1[p]){
count1=1;
}
}
}
if(count1==1){
cc++;
count1=0;
}
}
k[l]=sum;
sum=0;
r[l]=cr;
cr=0;
c[l]=cc;
cc=0;
}

for(int i=0;i<t;i++){
System.out.println("Case #"+(i+1)+": "+k[i]+" "+r[i]+" "+c[i]);
}
}
}
