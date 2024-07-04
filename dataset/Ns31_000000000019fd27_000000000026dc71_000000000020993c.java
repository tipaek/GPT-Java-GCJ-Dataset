

import java.util.*;
class Trace{


public static void main(String args[])
{
Scanner sc=new Scanner(System.in);

int T=sc.nextInt();
for(int k=0;k<T;k++)
{
int N=sc.nextInt();
int M[][]=new int[N][N];
for(int i=0;i<N;i++)
{
for(int j=0;j<N;j++)
{
M[i][j]=sc.nextInt();


}

}
int r=0,t=0,c=0;
for(int i=0;i<N;i++)
{


t=t+M[i][i];



}
int flag=0,flag1=0;
for(int i=0;i<N;i++)
{
for(int j=0;j<N;j++)
{
for(int a=(j+1);a<N;a++){
if(M[i][j]==M[i][a]){
flag=1;
break;
}
}
if(flag==1)
{
    r++;
    flag=0;
    break;
}

}


}
for(int i=0;i<N;i++)
{
for(int j=0;j<N;j++)
{
for(int a=(j+1);a<N;a++){
if(M[j][i]==M[a][i]){
flag1=1;
break;
}
}
if(flag1==1)
{
    c++;
    flag1=0;
    break;
}
}

}

System.out.println("Case "+ "#"+(k+1)+": "+t+" "+r+" "+c);

}
}

}
