import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class Solution {
public static boolean check(Point[] p , Point x) {
	int i=0;
	if (x.x>x.y || x.x==x.y || x.x>24*60 || x.y> 24*60) {
		return false;
	}
	while(p[i]!=null) {

		if(x.x==x.y) {
			if(x.x==p[i].x || x.y==p[i].y) {
				return false;
				
			}
		}
		if(x.x<p[i].y  && x.y>p[i].x ) {
			return false;
		}
		if(x.x<p[i].x  && x.y>p[i].x) {
			return false;
		}
		
		
		i++;
	}
	
	
	
	return true;
}
	
	
	
	
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            String[] st =new String[t];
		    for (int i = 1; i <= t; ++i) {
		   int n=in.nextInt();
		   
		    Point [] ar=new Point[n];
		    Point [] c=new Point[n];
		    Point [] j=new Point[n];

		    for(int l=0; l<n;l++) {
		    	ar[l]=new Point();
		    	int x=in.nextInt();
		    	int y=in.nextInt();
		    	ar[l].x=x;
		    	ar[l].y=y;
		    }
		    
		    
		    String r="";
		    
			int csize=0;
	    	int jsize=0;
		    for(int g=0; g<n;g++) {
		    
		    
		        if(check(j,ar[g] )) {
		    	 j[csize]=new Point();
		        	j[csize].x=ar[g].x;
		    	 j[csize].y=ar[g].y;
		        	r+="J";
		    	 csize++;
		        }
		        else if(check(c,ar[g] )) {
			    	 c[jsize]=new Point();
			        	c[jsize].x=ar[g].x;
			    	 c[jsize].y=ar[g].y;
			        r+="C";	
			      jsize++;	
		        }
		        else {
		        	r="IMPOSSIBLE";
		         break;
		        }
		    	
		    	
		    }
		    //st[i-1]="Case #"+i+": "+r;
		    System.out.println("case #"+i+": "+r);
		    
	  }
		//	for(int i=0; i<st.length; i++) {  
		    
		  //   System.out.println(st[i]);
			//}
		}}