///* package codechef; // don't place package name! */
//package random;
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
///* Name of the class has to be "Main" only if the class is public. */
//public class asdf
//{
//     static int countset(int x)
//{
//    x ^= x>>16;
//    x ^= x>>8;
//    x ^= x>>4;
//    x ^= x>>2;
//    x ^= x>>1;
//
//    return (x & 1);
//}
//     static int findmax(pair arr[],int n) {
//    	 int ind=arr[0].val;
//    	 int ii=0;
//    	 for(int i=1;i<n;i++) {
//    		 if(arr[i].val>ind) {
//    			 ind=arr[i].val;
//    			 ii=i;
//    		 }
//    	 }
//    	 return ii;
//     }
//     static class pair{
//    	 int val,o,c;
//    	 pair(int a,int b,int c){
//    		 val=a;
//    		 o=b;
//    		 c=c;
//    	 }
//     }
//     static String ao(int tot) {
//    	 String a="";
//    	 for(int i=0;i<tot;i++) {
//    		 a+="(";
//    	 }
//    	 return a;
//     }
//     static String ac(int tot) {
//    	 String a="";
//    	 for(int i=0;i<tot;i++) {
//    		 a+=")";
//    	 }
//    	 return a;
//     }
//	public static void main (String[] args) throws java.lang.Exception
//	{
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		int t=Integer.parseInt(br.readLine());
//		int test=1;
//		while(t-->0)
//		{
//			String dig=br.readLine().trim();
//			int n=dig.length();
//			pair arr[]=new pair[n];
//		    
//		    for(int i=0;i<n;i++)
//            {
//		    	arr[i]=new pair(dig.charAt(i)-'0',0,0);
//            }
//		    System.out.println(n);
//		    int max=findmax(arr,n);
//		    arr[max].o=arr[max].val;
//		    arr[max].c=arr[max].val;
//		    for(int j=max-1;j>=0;j--) {
//		    	int constribute=arr[j+1].o;
//		    	int need=arr[j].val;
//		    	if(constribute>=need) {
//		    		arr[j+1].o=constribute-need;
//		    		arr[j].o=need;
//		    	}
//		    	else{
//		    		arr[j+1].o=0;
//		    		arr[j].c=need-constribute;
//		    		arr[j].o=need;
//		    		
//		    	}
//		    }
//		    for(int j=max+1;j<n;j++) {
//		    	int constribute=arr[j-1].c;
//		    	int need=arr[j].val;
//		    	if(constribute>=need) {
//		    		arr[j-1].c=constribute-need;
//		    		arr[j].c=need;
//		    	}
//		    	else{
//		    		arr[j-1].c=0;
//		    		arr[j].o=need-constribute;
//		    		arr[j].c=need;
//		    		
//		    	}
//		    }
//		    String ans="";
//		    for(int i=0;i<n;i++) {
//		    	ans+=ao(arr[i].o)+arr[i].val+ac(arr[i].c);
//		    }
//		    System.out.println("Case #"+test+++": "+ans);
//        }
//	}
//}

//package random;
//import java.util.*;
//import java.io.*;
//
//
//public class asdf{
//
//static class pans{
//	char c;
//	int i;
//	pans(char a,int b){
//		c=a;
//		i=b;
//	}
//}
//	static 	class pair{
//		int s,e,i;
//		pair(int a,int b,int c){
//			s=a;
//			e=b;
//			i=c;
//		}
//	}
//	static String re(pair p[] ) {
//		int cend=0;
//		int eend=0;
//		ArrayList<pans> res=new ArrayList<pans>();
//		for(int i=0;i<p.length;i++) {
//			int start=p[i].s;
//			int end=p[i].e;
//			int ind=p[i].i;
//			 if( start < cend && start < eend){
//				 return "IMPOSSIBLE";
//			 }
//			 if (start >= cend) {
//				res.add(new pans('C', ind));
//		            cend =end;
//		        
//			 }
//			 else{
//				   res.add(new pans('J',ind));
//				   	eend = end;
//			 }
//		         
//		}
//		String ans="";
//		Collections.sort(res,new as());
//		for(int i=0;i<res.size();i++) {
//			ans+=res.get(i).c;
//		}
//		
//		
//		return ans;
//		
//	}
//	
//	public static void main (String[] args) throws java.lang.Exception
//	{
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		int t=Integer.parseInt(br.readLine().trim());
//		int test=1;
//		while(t-->0)
//		{
//			int n=Integer.parseInt(br.readLine().trim());
//			ArrayList<pair> c=new ArrayList<>();
//			ArrayList<pair> j=new ArrayList<>();
//			String ans="";
//			pair pa[]=new pair[n];
//			for(int i=0;i<n;i++)
//            {
//				StringTokenizer tok=new StringTokenizer(br.readLine()," ");
//				int s=Integer.parseInt(tok.nextToken());
//				int e=Integer.parseInt(tok.nextToken());
//				pa[i]=new pair(s,e,i);
//            }
//			
//			Arrays.sort(pa,new ss());
////          
//			System.out.println("Case #"+test+++": "+re(pa));
//	
//		}
//	}
//	static class ss implements Comparator<pair>{
//		public int compare(pair a,pair b) {
//			if(a.s>b.s)return 1;
//			else if(a.s<b.s)return -1;
//			else return 0;
//					
//		}
//	}
//
//static 	class as implements Comparator<pans>{
//		public int compare(pans a,pans b) {
//			if(a.i>b.i)return 1;
//			else if(a.i<b.i)return -1;
//			else return 0;
//					
//		}
//	}
//}

// package random;
import java.util.*;
import java.io.*;

public class Solution{

	static int sq[][]=new int[60][60],n=0,k=0;
	static boolean safecol[][]=new boolean[60][60];
	static void solvekrkeaw(int r,int c,int tempk,int t) {
		if(!solved && r==n && c==n+1 && tempk==k) {
			solved=true;
			System.out.println("Case #"+t+++": POSSIBLE");
			    for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					System.out.print(sq[i][j]+" ");
				}
				System.out.println();
			    }
			return;
		}
		else if(r>n)return;
		else if(c>n) {
			solvekrkeaw(r+1,1,tempk,t);
		}
		for(int i=1;i<=n && !solved;i++) {
			if(!saferow[r][i] && !safecol[i][c]) {
				saferow[r][i]=true;
				safecol[i][c]=true;
				if(r==c) {
					tempk+=i;
					
				}
				sq[r][c]=i;
				solvekrkeaw(r,c+1,tempk,t);
				saferow[r][i]=false;
				safecol[i][c]=false;
				if(r==c) {
					tempk-=i;
					
				}
				sq[r][c]=0;
				
			}
		}
	}
	static int countset(int x)
	{
	    x ^= x>>16;
	    x ^= x>>8;
	    x ^= x>>4;
	    x ^= x>>2;
	    x ^= x>>1;
	
	    return (x & 1);
	}
	static boolean saferow[][]=new boolean[60][60],solved=false;
			public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int test=1;
		int faltume=countset(1222);
		while(t-->0)
		{
			 faltume=countset(1222);
			StringTokenizer tok=new StringTokenizer(br.readLine()," ");
			n=Integer.parseInt(tok.nextToken());
			k=Integer.parseInt(tok.nextToken());
			solvekrkeaw(1,1,0,test);
			if(!solved) {
				System.out.println("Case #"+test+++": IMPOSSIBLE");
			}
			else {
				test++;
			}
			
			    
			
			
			faltume=countset(1222);
			sq=new int[60][60];
			saferow=new boolean[60][60];
			safecol=new boolean[60][60];
		    solved=false;

		}
		faltume=countset(1222);
	}
}