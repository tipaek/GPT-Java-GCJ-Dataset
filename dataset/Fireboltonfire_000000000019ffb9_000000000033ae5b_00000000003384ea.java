import java.util.*;
import java.io.*;

import java.util.function.Function;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    
	    for(int i=1;i<=t;i++){
	        long l = in.nextLong();
	        long r = in.nextLong();
	        System.out.print("Case #"+i+": ");
	        dos(l,r);
	    }
	    in.close();
	}
	
	public static void dos(long l, long r){
	    long diff = Math.abs(l-r);
	    Function<Long, Long> f = n -> (n *(n+1))/2;
	    long init = bs(0,2_000_000_000L,diff, f);
	   // System.out.println(init);
	    long val = f.apply(init);
	    if(r> l ){
	        r -= val;
	    }else{
	        l-= val;
	    }
	    if(Math.max(l,r) < init + 1){
            System.out.println(init+ " "+l+ " "+r);
            return;
        }
        Function<Long, Long> f1 = n -> ((init + n)*n);
        Function<Long, Long> f2 = n -> ((init +1+ n)*n);
        boolean flag = false;
        if(r > l){
            long temp = l;
            l=r;
            r=temp;
            flag = true;
        }
        Long bf1 = bs(0,2_000_000_000L,l,f1);
        Long bf2 = bs(0,2_000_000_000L,r,f2);
        if(bf1 >= bf2){
            bf1 = Math.min(bf1,bf2+1);
        }else{
            bf2 = bf1;
        }
        l -= f1.apply(bf1);
        r -= f2.apply(bf2);
        long numb = init+ bf1 +bf2;
        if(flag){
            System.out.println(numb+" "+r+" "+l);
        }else{
            System.out.println(numb+" "+l+" "+r);
        }
	}
	
	public static long bs(long left, long right, long n, Function<Long, Long> f){
	    if(left == right) return left;
	    long mid = (left + right + 1)/2;
	    long num = f.apply(mid);
	    if(n < num){
	        return bs(left,mid-1,n,f);
	    }else{
	        return bs(mid,right,n,f);
	    }
	}
	
}