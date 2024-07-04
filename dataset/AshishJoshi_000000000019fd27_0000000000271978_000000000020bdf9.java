import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i=1; i<=t; i++) {
		    int n = scan.nextInt();
		    int cstart = 0,cend = 0,jstart = 0,jend = 0;
		    cstart = scan.nextInt();
		    cend = scan.nextInt();
		    jstart = scan.nextInt();
		    jend = scan.nextInt();
		    StringBuilder str = new StringBuilder();
		    str.append("CJ");
		    boolean possible = true;
		    int start = 0,end = 0;
		    for (int j=0; j<n-2; j++) {
		        start = scan.nextInt();
		        end = scan.nextInt();
		        if (start>=cend) {
		            str.append("C");
		            cstart = start;
		            cend = end;
		            jend = end-cend;
		            if (jend<0) 
		                jend = 0;
		        } else if (start>=jend) {
		            str.append("J");
		            jstart = start;
		            jend = end;
		            cend = end-jend;
		            if (cend<0) 
		                cend = 0;
		        } else {
		            possible = false;
		            break;
		        }
		    }
		    if (possible) 
		        System.out.println("Case #"+i+": "+str.toString());
		    else 
		        System.out.println("Case #"+i+": "+"IMPOSSIBLE");
		}
    }
}