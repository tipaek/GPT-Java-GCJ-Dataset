import java.util.*;
public class Solution{
public static void main(String[] args){

Scanner scn=new Scanner(System.in);
int T=scn.nextInt();
for(int t=1;t<=T;t++){
int N=scn.nextInt();
int[][] A=new int[N][N];
int trace=0;
for(int i=0;i<N;i++){
for(int j=0;j<N;j++){
A[i][j]=scn.nextInt();
if(i==j){
trace=trace+A[i][j];
}
}
}

HashSet<Integer> hs=new HashSet<Integer>();
int row=0;
for(int i=0;i<N;i++){
for(int j=0;j<N;j++){
hs.add(A[i][j]);
}
if(hs.size()!=N){
row++;
}
hs.removeAll(hs);
}
int col=0;
for(int i=0;i<N;i++){
for(int j=0;j<N;j++){
hs.add(A[j][i]);
}
if(hs.size()!=N){
col++;
}
hs.removeAll(hs);
}

System.out.println("Case #" + t +": "+ trace+" " + row + " " + col);
}
}
}