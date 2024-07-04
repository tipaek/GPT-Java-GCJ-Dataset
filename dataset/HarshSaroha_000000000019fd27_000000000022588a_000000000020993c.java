 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Vestigium{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
            for(int i = 0; i < T; i++)
        {
         int N = in.nextInt();
         int  M[][] = new int[N][N] ;
           for(int j=0;j<N;j++){
           for(int k=0;k<N;k++){
           M[j][k]=in.nextInt();
           }}
           int count=0;
           int fount=0;
           int sum=0;
        
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
 k++;
 break;
 }
 }
 }
 for(int k=0;k<N;k++){
 for(int d=1;d<N;d++){
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
 
 
 
