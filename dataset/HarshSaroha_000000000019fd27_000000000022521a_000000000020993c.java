import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
            for(int i = 0; i < T; i++)
        {
         int N = input.nextInt();
         int  M[][] = new int[N][N] ;
           for(int j=0;j<N;j++){
           for(int k=0;k<N;K++){
           M[j][K]=in.nextInt();
           int count=0;
           int fount=0;
           int sum=0;
        }}
         for(int j=0;j<N;j++)
     { 
      for(int K=0;K<N;K++)
      { 
 if(i==j) {
 sum=sum+M[i][j];}
 }
 }
 for(int j=0;j<N;j++){
 for(int d=1;d<N;d++){
 int k=0;
 if(M[j][k]==M[d][k]){
 count++;
 K++;
 break;
 }
 }
 }
 for(int k=0;k<N;k++){
 for(int d=1;d<N;D++){
 int j=0;
 if(M[j][k]==M[j][d]){
 fount++;
 j++;
 break;
 }
 }
 }
 System.out.println("Case #" + i+1 + ":" + sum + "" + count + "" + fount);
 }
 }}
 
 
 
 
 
 
