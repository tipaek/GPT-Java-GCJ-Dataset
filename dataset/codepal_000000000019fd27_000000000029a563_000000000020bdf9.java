
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
public class Solution {
    static String ans="";
    static boolean flag=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
		        int n=scn.nextInt();
		        int [][]arr=new int[n][3];
		        for(int j=0;j<n;j++){
		            int s=scn.nextInt();
		            int e=scn.nextInt();
		            arr[j][0]=s;
		            arr[j][1]=e;
		            //arr[j][2]=j;
		        }
		      //  Arrays.sort(arr,new Comparator<int []>(){
		      //      @Override
		      //      public int compare(int []a,int []b){
		      //          if(a[1]>b[1]){
		      //              return 1;
		      //          }else if(a[1]<b[1])
		      //              return -1;
		      //          return 0;
		      //      }
		      //  });
		        ans="";
		        flag=false;
		        solve(arr,"C",0,-1,1);
		        System.out.println("Case #"+(i+1)+": "+ans);
		    }
	}
	
	public static void solve(int [][]arr,String str,int c,int j,int k){
	    if(k==arr.length){
	        ans=str;
	        flag=true;
	        return;
	    }
	        
        if(!flag){
            if(j>0&&arr[k][0]<arr[c][1]&&arr[k][1]>arr[c][0]&&arr[k][0]<arr[j][1]&&arr[k][1]>arr[j][0]){
              ans="IMPOSSIBLE";
              return ;  
            }
    	    if(j==-1){
                if(arr[k][0]<arr[c][1]&&arr[k][1]>arr[c][0]){
                    j=k;
                    solve(arr,str+"J",c,j,k+1);
                }else{
                    c=k;
                    j=k;
                    solve(arr,str+"C",c,j,k+1);
                    if(!flag)
                    solve(arr,str+"J",c,j,k+1);
                }
            }else{
                if(arr[k][0]<arr[c][1]&&arr[k][1]>arr[c][0]){
                    j=k;
                    solve(arr,str+"J",c,j,k+1);
                }else if(arr[k][0]<arr[j][1]&&arr[k][1]>arr[j][0]){
                    c=k;
                    solve(arr,str+"C",c,j,k+1);
                }else{
                    c=k;
                    j=k;
                    solve(arr,str+"C",c,j,k+1);
                    if(!flag)
                    solve(arr,str+"J",c,j,k+1);
                }
            }
        }
	    
	}
}
