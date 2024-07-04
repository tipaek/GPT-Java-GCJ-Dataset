/*package whatever //do not write package name here */

//import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	for(int q=1;q<=t;q++){
	    int r=sc.nextInt();
	    int c=sc.nextInt();
	    int a[][]=new int[r][c];
	    int b[][]=new int[r][c];
	    int sum=0;
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            a[i][j]=sc.nextInt();
	            b[i][j]=0;
	            sum=sum+a[i][j];
	        }
	    }
	    
	    while(true){
	    int el=0; 
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            int count=0;
	            if(a[i][j]>0){
	            int x1=getrightrowne(i,j,a);if(x1>0) count++;
	            int x2=getupcolne(i,j,a);if(x2>0) count++;
	            int x3=getleftrowne(i,j,a);if(x3>0) count++;
	            int x4=getdowncolne(i,j,a);if(x4>0) count++;
	            
	            int sum1=x1+x2+x3+x4;
	            if(count>0){
	            int ch=(int)(Math.ceil(sum1/count));
	            //System.out.println(sum1+"  ");
	            if(ch>a[i][j]){
	                el=el+1;
	                b[i][j]=0;
	                
	            }
	            }
	           // sum=sum+a[i][j];
	        }
	        }
	    }
	    if(el>0){
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            //a[i][j]=sc.nextInt();
	            //b[i][j]=0;
	            sum=sum+b[i][j];
	            a[i][j]=b[i][j];
	        }
	    }
	        
	    }
	    if(el==0)
	        break;
	    }
	  
	     System.out.println("Case #"+q+": "+sum);
	        
	    }
	    
	}
	static int getrightrowne(int i,int j,int arr[][]){
	    for(int p=j-1;p>=0;p--){
	        if(arr[i][p]!=0)
	            return arr[i][p];
	    }
	    return 0;
	}
	static int getleftrowne(int i,int j,int arr[][]){
	    int n=arr[0].length;
	    for(int p=j+1;p<n;p++){
	        if(arr[i][p]!=0)
	            return arr[i][p];
	    }
	    return 0;
	}
	static int getupcolne(int i,int j,int arr[][]){
	    //int n=a[0].length;
	    for(int p=i-1;p>0;p--){
	        if(arr[p][j]!=0)
	            return arr[p][j];
	    }
	    return 0;
	}
	static int getdowncolne(int i,int j,int arr[][]){
	    int n=arr.length;
	    for(int p=i+1;p<n;p++){
	        if(arr[p][j]!=0)
	            return arr[p][j];
	    }
	    return 0;
	}
}
