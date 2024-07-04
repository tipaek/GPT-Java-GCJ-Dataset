import java.io.*;
import java.util.*;
public class Solution {
public static void main(String args[])throws IOException{
    Scanner s=new Scanner(System.in);
    int t=s.nextInt();
    for(i=1;i<=t;i++){
    int n=s.nextInt();
    int a[][]=new int[n][n];
    int sm=0,r=0,c=0;
    for(j=0;j<n;j++)
    for(k=0;k<n;k++)
    a[j][k]=s.nextInt();
    for(j=0;j<n;j++)
    sm+=a[j][j];
    for(j=0;j<n;j++)
    for(k=0;k<n-1;k++)
    if(a[j][k]==a[j][k+1])r++;
    for(j=0;j<n-1;j++)
    for(k=0;k<n;k++)
     if(a[j][k]==a[j+1][k])c++;
     System.out.println("Case #"+t+": "+s+" "+r+" "+c);
    }
    }
}