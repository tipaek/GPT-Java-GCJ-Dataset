import java.util.*;
import java.io.*;
public class Solution{
public static void main(String[] args){
Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
int t=in.nextInt();
int op[][]=new int[t][4];
for(int p=1;p<=t;p++){
int n=in.nextInt();

int ar[][]=new int[n][n];
int a[]=new int[n];
for(int q=0;q<n;q++)a[q]=0;
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
ar[i][j]=in.nextInt();
}}
int temp;
int trace=0;
for(int m=0;m<n;m++)trace=trace+ar[m][m];
int r=0,c=0;
for(int x=0;x<n;x++){
for(int y=0;y<n;y++){
temp=ar[x][y];
if(a[temp-1]==temp){r++;break;}
else a[temp-1]=temp;
}
for(int z=0;z<n;z++)a[z]=0;
}

for(int e=0;e<n;e++){
for(int f=0;f<n;f++){
temp=ar[f][e];
if(a[temp-1]==temp){c++;break;}
else a[temp-1]=temp;
}
for(int g=0;g<n;g++)a[g]=0;
}

op[p-1][0]=p;
op[p-1][1]=trace;
op[p-1][2]=r;
op[p-1][3]=c;
}
for(int s=0;s<t;s++){
System.out.println("Case #"+op[s][0]+":"+op[s][1]+","+op[s][2]+","+op[s][3]);
}
}
}


