import java.util.*;
public class Solution{
	

	public static void main(String[] args) {
		int T=0;
		Scanner sc=new Scanner(System.in);
if(sc.hasNext()) {
	T=sc.nextInt();
	}
	ArrayList<String> al=new ArrayList<String>();

for(int i=0;i<T;i++) {
	int X=0,Y=0;
	
	if(sc.hasNext()) {
		X=sc.nextInt();
		Y=sc.nextInt();
		
	}
	
	if((X+Y)%2==0) {
		al.add("IMPOSSIBLE");
		
	}
	else {
		if(X==0) {
			 if(Y<0) {
				Y=Math.abs(Y);
			}
			 

				int a=(Y/2);
				ArrayList<Integer> al1=new ArrayList<Integer>();
				for(int j=0;j<=a;j++) {
					al1.add((int)Math.pow(2, j));
				}
				a=0;
				for(int c: al1) {
					a+=c;
					if(a==Y) {
						
					}
				}
				a=Y;
				for(int j=0;j<=al1.size();j++) {
					a-=al1.get(j);
					if(a==Y) {
						
					}
				}
			 
		}
		else if(Y==0) {
			
			if(X<0) {
				X=Math.abs(X);
			}
			
			int a=(X/2);
			ArrayList<Integer> al1=new ArrayList<Integer>();
			for(int j=0;j<=a;j++) {
				al1.add((int)Math.pow(2, j));
			}
			a=0;
			for(int c: al1) {
				a+=c;
				if(a==X) {
					
				}
			}
			a=X;
			for(int j=0;j<=al1.size();j++) {
				a-=al1.get(j);
				if(a==X) {
					
				}
			}
		}
		else {
			if(X%2==0) {
			
				if(X>Y) {
					int a=X/2;
					ArrayList<Integer> al1=new ArrayList<Integer>();
					for(int j=0;j<a;j++) {
						
					}
					
					
					
				}
				else if(Y>X) {
					
				}
				
			}
			else if(Y%2==0) {
				if(X>Y) {
					
				}
				else if(Y>X) {
					
				}
			}
			
			
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
}
sc.close();



	}
	
	
	
	
	
}