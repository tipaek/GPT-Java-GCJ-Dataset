import java.util.*;
import java.io.*;
class Ideone {
	public static void main (String[] args) {
		Scanner z = new Scanner(System.in);
		int p,t,i,s=0,tn,j;
		t = z.nextInt();
		String a="",b="";
		for(p=1;p<=t;p++) {
    		a = z.next();
    		int nd=a.charAt(0)-'0';
    		int l = a.length();
    		for(i=0;i<nd;i++)
    			b=b+'(';
    		b=b+nd;

    		for(i=1;i<l;i++) {
    			tn=a.charAt(i)-'0';
    			if(tn<(a.charAt(i-1)-'0')) {
    				for(j=0;j<nd-tn;j++)
    					b=b+')';
    				b=b+tn;
    				nd=tn;
    			}
    			else if(tn>(a.charAt(i-1)-'0')) {    
    				for(j=0;j<tn-nd;j++)
    					b=b+'(';
    				b=b+tn;
    				nd=tn;
    			}
    			else {
    				b=b+tn;
    				nd=tn;
    			}
    		}
    		
    		for(i=0;i<nd;i++)
    			b=b+')';

    		System.out.println("Case #"+p+": "+b);
    		b="";
		}
	}
}