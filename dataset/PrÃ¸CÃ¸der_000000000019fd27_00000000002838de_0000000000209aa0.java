import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class LatinSquare {
	Scanner in;
	int cases;
	public LatinSquare() {
		 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 cases=in.nextInt();
		 for(int c=0;c<cases;c++) {
			 try {
				 int n=in.nextInt();
				 int k=in.nextInt();
		 int[]numbs=getNumbs(n,k);
		 int[][]squ=createSquare(numbs);
		 boolean possible=true;
		 int g=0;
		 for(int i=0;i<numbs.length;i++) {
			 g+=squ[i][i];
		 }
		 System.out.println(g);
		 int h=0;
		 for(int i=0;i<numbs.length;i++) {
			 h+=squ[i][numbs.length-1-i];
		 }
		
		if(g!=k&&h!=k)possible=false;
		 if(possible) {
		 System.out.println("Case #"+c+": POSSIBLE");
		 for(int i=0;i<numbs.length;i++) {
			 for(int e=0;e<numbs.length;e++) {
				 System.out.print(squ[i][e]+" ");
			 }
			 System.out.println("");
		 }
		 }
		else {System.out.println("Case #"+c+": IMPOSSIBLE");}
			 }
			 catch(Exception e) {
				 System.out.println("Case #"+c+": IMPOSSIBLE");
			 }
		 }
	}
	
	public int[] getNumbs(int n, int k){
		boolean f=true;
		boolean possible =true;
		int t=k;
		int r=0;
		int numbs[]=new int[n];
		while(f) {
			
			if(t==0) { 
				f=false;
				possible=false;
			}
			else if(((float)t/(float)n)-(int)(t/n)==0) {
				f=false;
			}
			else t--;
			
		}
		f=true;
		
		for(int e=0;e<numbs.length;e++) {
			numbs[e]=t/n;
		}
		
		r=k-t;
		
		numbs[n-1]=numbs[n-1]+r;
		
		while(f) {
			f=false;
			for(int i=0;i<numbs.length;i++) {
				for(int e=0;e<numbs.length;e++) {
					if(i!=e) {
						if(numbs[i]==numbs[e]) {
							f=true;
							numbs[i]+=1;
							numbs[e]-=1;
						}
					}
				}
			}
		}
		
		if(!possible)return null;
		else return numbs;
	}
	public int[][] createSquare(int[] numbs){
		int[][]sqr=new int[numbs.length][numbs.length];
		
		for(int i=0;i<numbs.length;i++) {
		int h=numbs[0];
			for(int e=0;e<numbs.length;e++) {
				if(e==numbs.length-1)numbs[numbs.length-1]=h;
				else numbs[e]=numbs[e+1];
				sqr[i][e]=numbs[e];
			}
			
		}
		return sqr;
	}
	
	
	
	
	public static void main(String[] args) {
		new LatinSquare();
	}
}
