
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
public static boolean check(Point[] p , Point x) {
	int i=0;
	
	while(p[i]!=null) {

	
		if(x.x<p[i].x && x.y>p[i].x ) {
			return false;
		}
		
		
			
		else if((x.x>=p[i].x && x.x<p[i].y)) {
			return false;
		}
		
		
		else if(x.x==p[i].x && x.y==p[i].y) {
			return false;
		}
		
		else if(x.x==p[i].x && x.x!=x.y) {
			return false;
			
		}
		else if(x.y==p[i].y && x.y!=x.y) {
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
		   
		    Point [] ar=new Point[50];
		    Point [] c=new Point[50];
		    Point [] j=new Point[50];

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
			    	 j[jsize]=new Point();
				    j[jsize].setLocation(ar[g].x,ar[g].y);	

			        r+="J";	
			      jsize++;	
		        }
		    	else if(check(c,ar[g] )) {
		    	 c[csize]=new Point();
		        	
		        c[csize].setLocation(ar[g].x,ar[g].y);	
		    	 r+="C";
		    	 csize++;
		        }
		        
		        else {
		        	r="IMPOSSIBLE";
		         break;
		        }
		    	
		    	
		    }
		    st[i-1]="Case #"+i+": "+r;
		   // System.out.println("Case #"+i+": "+r);
	  }
			for(int i=0; i<st.length; i++) {  
		    
		     System.out.println(st[i]);
			}
		}}