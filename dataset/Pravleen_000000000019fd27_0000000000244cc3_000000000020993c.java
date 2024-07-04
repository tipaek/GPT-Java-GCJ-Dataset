import java.util.*;
import java.io.*;

class Solution{

static int trace(int matrix[][],int r,int c){
int sum = 0;
for (int i=0;i<r;i++){
for (int j=0;j<c;j++){
if (i==j){
sum+=matrix[i][i];
}
}
}
return sum;
}
static int duplicaterow(int matrix[][],int r,int c){
int count=0;
int c1=0;
for (int i=0;i<r;i++){
	count=0;
for (int j=0;j<c;j++){
for(int k=j+1;k<c;k++){
if (matrix[i][j]==matrix[i][k]&& count==0){
count = count +1;
c1++;

}

}

}

}
return c1;
}

static int duplicatecol(int matrix[][],int r,int c){
int count1=0,c1=0;
for (int i=0;i<r;i++){
	count1=0;
for (int j=0;j<c;j++){
for(int k=j+1;k<r;k++){
if (matrix[j][i]==matrix[k][i] && count1==0){
count1+=1;
c1++;
}
}
}
}
return c1;
}


public static void main(String args[]) {
Scanner s = new Scanner(System.in);
int a,i,j,r,c,t;
t=s.nextInt();
for (a=0;a<t;a++){
r=s.nextInt();
c=r;
int matrix[][]=new int[r][c];
for (i=0;i<r;i++){
for (j=0;j<c;j++){
matrix[i][j]=s.nextInt();
}
}

System.out.println("Case #"+(a+1)+": "+ trace(matrix,r,c)+" "+ duplicaterow(matrix,r,c)+" "+ duplicatecol(matrix,r,c));
}
}
}