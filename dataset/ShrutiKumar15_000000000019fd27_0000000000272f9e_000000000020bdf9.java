//package competitive;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
    	Scanner sc =  new Scanner(System.in);
		if(sc.hasNext()) {
			long t =sc.nextLong();
			for(long tt =0; tt<t; tt++) {
				int n = sc.nextInt();
				int[][] c = new int[n][2];
				int[][] j = new int[n][2];
				int[][] ar = new int[n][2];
				for(int i=0; i<n; i++) {
					for(int k=0; k<2; k++) {
						ar[i][k]=sc.nextInt();
					}
				}
				int ccount=1;
				int jcount=0;
				int aflag=0;
				for(int i=0; i<n; i++) {
					int flag=0;
					if(i==0) {
						for(int k=0; k<2; k++) {
							c[i][k]=ar[i][k];
						}
					}
					else {
								int no2 =ar[i][1];
								int no1 =ar[i][0];
								 flag=0;
								for(int l=0; l<n; l++) {
									if(c[l][0]==0 && c[l][1]==0) {
										
										break;
									}
									else if(no1>c[l][0] && no1<c[l][1]) {
										
										flag=1;
										break;
									}
									else if(no2>c[l][0] && no2<c[l][1]) {
										
										flag=1;
										break;
									}
									else if(c[l][0]>no1 && c[l][0]<no2) {
										flag=1;
										break;
									}
									else if(c[l][1]>no1 && c[l][1]<no2) {
										flag=1;
										break;
									}
								}
								if(flag==0) {
									c[ccount][0]=no1;
									c[ccount][1]=no2;
									ccount+=1;
								}
								else if(flag==1) {
									for(int a=0; a<n; a++) {
										if(j[a][0]==0 && j[a][1]==0) {
											j[jcount][0]=no1;
											j[jcount][1]=no2;
											jcount+=1;
											break;
										}
										else if(no1>j[a][0] && no1<j[a][1]) {
											
											flag=2;
											break;
										}
										else if(no2>j[a][0] && no2<j[a][1]) {
											
											flag=2;
											break;
										}
										else if(j[a][0]>no1 && j[a][0]<no2) {
											
											flag=2;
											break;
										}
										else if(j[a][1]>no1 && j[a][1]<no2) {
											
											flag=2;
											break;
										}
									}
								}
						
					}
					if(flag==2) {
						System.out.println("Case #"+(tt+1)+": "+"IMPOSSIBLE");
						aflag=1;
						break;
					}
				}
				if(aflag==0) {
					String s="";
					ccount=0;
					jcount=0;
					for(int i=0; i<n; i++) {
						if(ar[i][0]==c[ccount][0]) {
							s+="C";
							ccount+=1;
						}
						else if(ar[i][0]==j[jcount][0]){
							s+="J";
							jcount+=1;
						}
					}
					System.out.println("Case #"+(tt+1)+": "+s);
				}
						
			}
        }
    }
 }
