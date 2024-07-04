

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
public static boolean check(Point[] p , Point x) {
	int i=0;
	if (x.x>x.y) {
		return false;
	}
	while(p[i]!=null) {

if(p[i].y-x.y>=0  && p[i].x-x.y<0 ) {
	return false;
}
if(x.x-p[i].x >=0 && x.x-p[i].y<0) {
	return false;
}
		
		
		/*
		if(x.x<p[i].x && x.y>p[i].x ) {
			System.out.println("fuc");

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
		*/
		

		i++;
	}
	
	
	
	return true;
}
	
	
	
	
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //    String[] st =new String[t];
		    for (int i = 1; i <= t; ++i) {
		   int n=in.nextInt();
		   
		    Point [] ar=new Point[n];
		    Point [] c=new Point[n];
		    Point [] j=new Point[n];
		    int csize=0;
	    	int jsize=0;
		    String r="";
               int flag=0;
	    	for(int l=0; l<n;l++) {
		    	ar[l]=new Point();
		    	int x=in.nextInt();
		    	int y=in.nextInt();
		    	Point tr =new Point(x,y);
		          if(tr.x>24*60 || tr.y>24*60){
		              flag=1;
		          }
		    	
		    	 if(check(j,tr ) && flag==0) {
			    	 j[jsize]=new Point();
				    j[jsize].setLocation(tr.x,tr.y);	

			        r+="J";	
			      jsize++;	
		        }
		    	else if(check(c,tr ) && flag==0) {
		    	 c[csize]=new Point();
		        	
		        c[csize].setLocation(tr.x,tr.y);	
		    	 r+="C";
		    	 csize++;
		        }
		        
		        else {
		        	r="IMPOSSIBLE";
		        // break;
		        flag=1;
		        }
		    
		    	
		    	
		    	//ar[l].x=x;
		    	//ar[l].y=y;
		    }
		    
		    
		   /* 
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
		    	
		    	
		    }*/
		    //st[i-1]="Case #"+i+": "+r;
		    System.out.println("Case #"+i+": "+r);
	  }
			//for(int i=0; i<st.length; i++) {  
		    
		     //System.out.println(st[i]);
			//}
		}}