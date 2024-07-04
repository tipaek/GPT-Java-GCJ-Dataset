import java.util.*;
import java.io.*;
public class Solution {
	public static int x=0, y=0;
	public static String[] connect;
	public static void conSt(int t,int num, String s,int cx, int cy) {
		if(cx == x && cy==y) {
			connect[t] = s;
			return;
		}
		t++;
		if(t == 15 ) {
			return;
		}
		if(((x * cx) >0)&&(Math.abs(cx)>Math.abs(x))) {
			return;
		}
		if(((y * cy) >0)&&(Math.abs(cy)>Math.abs(y))) {
			return;
		}
		else if( cx == x) {
			conSt(t,num*2, s+"S", cx , cy-num);
    		conSt(t,num*2, s+"N", cx , cy+num);
		}
		else if(cy == y) {
			conSt(t,num*2, s+"E", cx+num , cy);
    		conSt(t,num*2, s+"W", cx-num , cy);
		}
		else {
			conSt(t,num*2, s+"S", cx , cy-num);
    		conSt(t,num*2, s+"N", cx , cy+num);
    		conSt(t,num*2, s+"E", cx+num , cy);
    		conSt(t,num*2, s+"W", cx-num , cy);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		for(int i=0; i<n;i++){
		    x = sc.nextInt();
		    y = sc.nextInt();
		    System.out.print("Case #" + (i+1) + ": ");
		    connect = new String[101];
		    if((x + y) % 2 ==0) {
		    	System.out.println("IMPOSSIBLE");
		    }
		    else {
		    	if(x % 2 ==0) {
		    		conSt(1,2, "S", 0 , -1);
		    		conSt(1,2, "N", 0 , 1);
		    	}
		    	else {
		    		conSt(1,2, "E", 1 , 0);
		    		conSt(1,2, "W", -1 , 0);
		    	}
		    	for(int j=0;j<101;j++) {
		    		if(connect[j] != null) {
		    			System.out.println(connect[j]);
		    			break;
		    		}
		    		if(j == 100) {
		    			System.out.println("IMPOSSIBLE");
		    		}
		    	}
		    }
		    
		}
		

	}

}

