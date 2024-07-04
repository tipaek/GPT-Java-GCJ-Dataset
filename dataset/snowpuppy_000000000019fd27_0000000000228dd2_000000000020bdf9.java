import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
            int n=sc.nextInt();
	        int timeArray[][]=new int[n][3];
	        char ans[]=new char[n];
            for(int j=0;j<n;j++){
                timeArray[j][0]=sc.nextInt();
		        timeArray[j][1]=sc.nextInt();
		        timeArray[j][2]=j;
            }
	        java.util.Arrays.sort(timeArray, java.util.Comparator.comparingInt(a -> a[0]));
	        int ct=0,jt=0;boolean resp=true;
	        for(int j=0;j<n;j++){
	            int t0=timeArray[j][0];
	            int t1=timeArray[j][1];
	            int t2=timeArray[j][2];
		        if(ct<=t0){
		            ct=t1;
		            ans[t2]='C';
		        }
		        else if(jt<=t0){
		            jt=t1;
		            ans[t2]='J';
		        }
		        else{resp=false;}
	        }
	        System.out.print("Case #"+t+": ");
	        if(resp){
	    	    System.out.println(new String(ans));}
	        else{
		        System.out.println("IMPOSSIBLE");
	        }
        }
    }
}