	import java.util.*;
	import java.io.*;
	import java.util.regex.*;
	import java.lang.Math;
	public class Solution {
	    public static void main(String[] args) {
	        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int t = in .nextInt();
	        for (int i = 1; i <= t; i++) {
	            int a=in.nextInt();
	            int b=in.nextInt();
	            int sum=Math.abs(a)+Math.abs(b);
	            int sumx=Math.abs(a);
	            int sumy=Math.abs(b);
	           int temp=0,count=0;
	            ArrayList < Integer > arr = new ArrayList < Integer > ();
	            String res="";
	    while(sumx>0 || sumy>0){
	        if(sumx>0){
	        sumx=plusfun(sumx,count);
	        
	        res+="E";
	        count++;}
	        if(sumy>0){
	        sumy=plusfun(sumy,count);
	        res+="N";
	        count++;}
	        sum=sumx+sumy;
	        //System.out.println("x=="+sumx);
	        //System.out.println("y=="+sumy);
	        
	    }
	    if(sum==0){
	    System.out.println("Case #"+i+": "+res);
		continue;}
	    
	    //
	    res="";
	    count=0;
	    sum=Math.abs(a)+Math.abs(b);
	            sumx=Math.abs(a);
	            sumy=Math.abs(b);
	     
	    while(sumx>0 || sumy>0){
	        if(sumy>0){
	        sumy=plusfun(sumy,count);
	        
	        res+="N";
	        count++;}
	        if(sumx>0){
	        sumx=plusfun(sumx,count);
	        res+="E";
	        count++;}
	        sum=sumx+sumy;
	        //System.out.println("xmm=="+sumx);
	        //System.out.println("y=="+sumy);
	        
	    }
	    if(sum==0){
	    System.out.println("Case #"+i+": "+res);
		continue;}
	    //
	    
	    //Case2
	    res="";
	      sum=Math.abs(a)+Math.abs(b);
	            sumx=Math.abs(a);
	            sumy=Math.abs(b);
	     count=0;
	          
	      while(sumx>0 || sumy>0){
	        if(sumx>0){
	            if(count==0){
	        sumx=minusfun(sumx,count);
	        res+="W";}
	        else{
	        sumx=plusfun(sumx,count);
	        res+="E";}
	        
	        
	        count++;}
	        if(sumy>0){
	        sumy=plusfun(sumy,count);
	        res+="N";
	        count++;}
	        sum=sumx+sumy;
	        ////System.out.println("x33=="+sumx);
	        ////System.out.println("y33=="+sumy);
	        
	    }
	    
	    
	    if(sum==0){
	        System.out.println("Case #"+i+": "+res);
			continue;}
	  //case4
	  res="";
	      sum=Math.abs(a)+Math.abs(b);
	            sumx=Math.abs(a);
	            sumy=Math.abs(b);
	     count=0;
	          
	      while(sumx>0 || sumy>0){
	        if(sumy>0){
	            if(count==0){
	        sumy=minusfun(sumy,count);
			if(b>0)
	        res+="S";
			else
			res+="N";
			}
	        else{
	        sumy=plusfun(sumy,count);
	        if(b>0)
			res+="N";
			else
			res+="S";
			}
	        
	        
	        count++;}
	        if(sumx>0){
	        sumx=plusfun(sumx,count);
			if(a>0)
	        res+="E";
			else
			res+="W";
	        count++;}
	        sum=sumx+sumy;
	        ////System.out.println("x44=="+sumx);
	        ////System.out.println("y44=="+sumy);
	        
	    }
	    
	    
	    if(sum==0){
	        System.out.println("Case #"+i+": "+res);
			continue;}
			else{
			System.out.println("Case #"+i+": IMPOSSIBLE");
			}
	  //
	  
	    }
	    
	    
	    } 
	    public static int plusfun(int sum,int r)
	    {
	        return sum=sum-(int)Math.pow(2,r);
	    }
	    
	    public static int minusfun(int sum,int r)
	    {
	        return sum=sum+(int)Math.pow(2,r);
	    }
	    
	    
	    
	}