        import java.util.*;
import java.io.*;
public class Solution{
public static void main(String[]args){
inputanner input=new inputanner(System.in);
         int testcase=input.nextInt();
		for(int i=0;i<testcase;i++) {
			int arr[][];
			int N=input.nextInt();
			a=new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					arr[r][c]=input.nextInt();
				}
			}
			int k=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(r==c) {
						k=k+arr[r][c];
					}
				}
			}
			int nor=0,noc=0;
			
			int trr[]=new int[N];int trc[]=new int[N];
			for(int c=0;c<N;c++) {
			    trr[c]=arr[r][c];
			    trc[c]=arr[c][r];
			}
			Arrays.sort(trr);
			Arrays.sort(trc);
			for(int p=0;p<trr.length;p++) {
				
				for(int p1=0;p1<trr.length;p1++) {
					if(Arrays.binarySearch(trr,trr[p1])==p && p!=p1) {
						nor++; p1=trr.length+p1;
						p=p+trr.length;
					}
					
				}
			}
			       for(int p=0;p<trr.length;p++) {
				
				for(int p1=0;p1<trr.length;p1++) {
					if(Arrays.binarySearch(trc,trc[p1])==p && p!=p1) {
						noc++; p1=trc.length+p1;
						p=p+trc.length;
					}
					
				}
			}
			System.out.println("Case #"+(i+1)+": "+k+" "+nor+" "+noc);
	}


}}