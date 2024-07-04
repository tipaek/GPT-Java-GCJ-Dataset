import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
      int test=scan.nextInt();
      int i=0,j=0,k=0,s1=0,s2=0,x=0,y=0,z=0,a=0;
      for(k=0;k<test;k++) {
    	  StringBuffer s=new StringBuffer(scan.next());
    	  int l=s.length();
    	// System.out.println(l);
    	  for(i=0;i<l;i++) {
    		  
	    	if(i==0) {x=0;}
	    	else {
	    		j=i-1;
	    		while(s.charAt(j)==')') {
	    			j--;
	    		}
	    		x = Character.getNumericValue(s.charAt(j));
	    	}
	    	y = Character.getNumericValue(s.charAt(i));
	 	    if(i+1==l) {z=0;}
	 	    else {
	 	    	z = Character.getNumericValue(s.charAt(i+1));
	 	    }
	 	//    System.out.println("xyz "+x+y+z+" "+s);
	 	    s1=y-x;
	 	    s2=z-y;
	 	//    System.out.println("s1s2 "+s1+s2+i+l+" "+s);
	 	    if(s1>0) {
	 	    	a=s1;
	 	    	while(a>0) {
	 	    		s.insert(i,'(');
	 	    		i++;
	 	    		l++;
	 	    		a--;
	 	    	}
	 	    }
	 //	    System.out.println("loop1"+s+" "+i+l);
	 	    if(s2<0) {
	 	    	a=0-s2;
	 	    	while(a>0) {
	 	    		s.insert((i+1), ')');
	 	    		i++;
	 	    		l++;
	 	    		a--;
	 	    	}
	 	    }
	 	 //  System.out.println("loop2 "+s+" "+i+l);
	 	   
	    	  
    	  }
    	  
    	  System.out.println("Case #"+(k+1)+": "+s);
      }	
		scan.close();
  }
  }
