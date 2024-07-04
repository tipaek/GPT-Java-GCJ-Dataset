import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ii = 1; ii <= tt; ++ii) {
      int n = in.nextInt();
      int arr[][]=new int[n][n];
      int sum=0;
	  int count=0;
	  int count2=0;
	  for(int i=0;i<n;i++){
		    for(int j=0;j<n;j++){
		       	arr[i][j]=in.nextInt(); 
	  }}
	  for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				if(x==y) {
					sum=sum+arr[x][y];
				}}}
		int aa=0;
		int z=0;
		for(int s=0;s<n;s++) {
			for(int t=0;t<n;t++) {
				int temp=arr[s][t];
				for(int k=0;k<n;k++) {
					if(k==t)
						continue;
					if(temp==arr[s][k]) {
						 count++;
						 aa=1;
						break;
					}}
			if (aa==1){
				aa=0;
				break;
			}}}
			for(int r=0;r<n;r++) {
			for(int c=0;c<n;c++) {
				int temp2=arr[c][r];
				for(int l=0;l<n;l++) {
					if(l==c)
						continue;
					if(temp2==arr[l][r]) {
						count2++;
						z=1;
						break;
					}}				
			if(z==1) {
				z=0;
				break;
			}}}	
      System.out.println("Case #" + ii + ": " + sum + " " + count + " " +count2);
    }}}
 

