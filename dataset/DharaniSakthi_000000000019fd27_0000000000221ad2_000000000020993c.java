import java.io.*;
import java.util.*;
public class Solution {
public static void main(String args[])throws IOException{
    Scanner s=new Scanner(System.in);
    int t=s.nextInt();
    for(int i=1;i<=t;i++){
    int n=s.nextInt();
    int a[][]=new int[n][n];
    int sm=0,r=0,c=0,j,k,m=0;
    for(j=0;j<n;j++)
    for(k=0;k<n;k++){
    a[j][k]=s.nextInt();if(a[j][k]<1||a[j][k]>n){
        //throw new IllegalArgumentsException();
    k--;continue;}}
    for(j=0;j<n;j++)
    sm+=a[j][j];
    for(j=0;j<n;j++)do{
    for(k=1;k<n;k++){if(k==m)continue;
    if(a[j][m]==a[j][k])r++;}m++;}while(m<n-1);
    for(j=0;j<n;j++)do{
    for(k=1;k<n;k++){if(k==m)continue;
    if(a[m][j]==a[k][j])c++;}m++;}while(m<n-1);
    
     System.out.println("Case #"+t+": "+s+" "+r+" "+c);
    }
    }
}