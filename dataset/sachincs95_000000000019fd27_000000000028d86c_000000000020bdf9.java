

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		int test = Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++){
			int n = Integer.parseInt(br.readLine());
			int se[][] = new int[n][2];
			for(int i=0;i<n;i++){
				String s[] = br.readLine().split(" ");
				se[i][0] = Integer.parseInt(s[0]);
				se[i][1] = Integer.parseInt(s[1]);
			}
			int index[] = new int[n];
			for(int i=0;i<n;i++){
				index[i] = i;
			}
			for(int i=0;i<n-1;i++){
				for(int j=0;j<n-i-1;j++){
					if(se[j][0]>se[j+1][0]){
						int temp0 = se[j][0];
						int temp1 = se[j][1];
						int tidx = index[j];
						
						se[j][0] = se[j+1][0];
						se[j][1] = se[j+1][1];
						index[j] = index[j+1];
						
						se[j+1][0] = temp0;
						se[j+1][1] = temp1;
						index[j+1] = tidx;
					}
				}
			}
			
			 //for(int i=0;i<n;i++){
			 //	System.out.println(se[i][0]+" "+se[i][1]);
			 //}
			 int C1,C2,J1 = -1,J2 = -1;
			 String result="";
			 for(int i=0;i<n;i++){
			 	result += "#";
			 }
			 C1 = se[0][0];
			 C2 = se[0][1];
			 result = result.substring(0,index[0]) + "C" + result.substring(index[0]+1);
			 
			 for(int i=1;i<n;i++){
			 	if(C2<=se[i][0]){
			 		result = result.substring(0,index[i]) + "C" + result.substring(index[i]+1);
			 		C1 = se[i][0];
			 		C2 = se[i][1];
			 		continue;
			 	}
			 	else if(C2>se[i][0] && J2<=se[i][0]){
			 		result = result.substring(0,index[i]) + "F" + result.substring(index[i]+1);
			 		J1 = se[i][0];
			 		J2 = se[i][1];
			 		continue;
			 	}
			 	else{
			 		result = "IMPOSSIBLE";
			 		break;
			 	}
			 }
			 System.out.println("Case #"+t+": "+result);
			
		}
	}
}