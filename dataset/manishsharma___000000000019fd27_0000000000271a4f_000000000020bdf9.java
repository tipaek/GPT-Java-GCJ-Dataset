
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		for(int ie=0;ie<t;ie++) {
			StringBuilder sb=new StringBuilder();
	        int n=s.nextInt();
	        pair [] arr=new pair[n];
	        for(int i=0;i<n;i++) {
	        	int a=s.nextInt();
	        	int b=s.nextInt();
	        	pair ob=new pair(a,b,i,0);
	        	arr[i]=ob;
	        }
	        
	        Arrays.sort(arr,new comp());
			
	       int c=-1;//1
	       int j=-1;//2
	       int flag=0;
	       
	       for(int i=0;i<n;i++) {
	    	   if(c==-1||c<=arr[i].st) {
	    		   arr[i].ans=1;
	    		   c=arr[i].end;
	    	   }else if(j==-1||j<=arr[i].st) {
	    	        arr[i].ans=2;
	    	        j=arr[i].end;
	    	   }else {
	    		   flag=1;
	    		   break;
	    	   }
	    		   
	       }
	      
	       
			
			if(flag==1) {
				sb.append("IMPOSSIBLE");
			}else {
				Arrays.sort(arr,new comp1());
				for(int i=0;i<n;i++) {
					if(arr[i].ans==1) {
						sb.append("C");
					}else if(arr[i].ans==2) {
						sb.append("J");
					}
				}
			}
			
			
			
			System.out.println("Case "+"#"+(ie+1)+": "+sb);
		}
		
	}
	
}

class pair{
	int st;
	int end;
	int index;
	int ans;
	public pair(int st,int end,int index,int ans) {
		this.st=st;
		this.end=end;
		this.index=index;
		this.ans=ans;
	}
}


class comp implements Comparator<pair>
{
	public int  compare(pair h,pair j) {
		if(h.st<j.st) {
			return -1;
		}else if(h.st==j.st) {
			if(h.end<j.end)
			{
				return -1;
			}else if(h.end==j.end) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 1;
		}
		
	}

	
}
class comp1 implements Comparator<pair>
{
	public int  compare(pair h,pair j) {
		if(h.index<j.index) {
			return -1;
		
		}else {
			return 1;
		}
		
	}

	
}
