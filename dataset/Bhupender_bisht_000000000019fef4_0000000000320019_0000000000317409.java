import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        int cse=1;
        while(t-->0) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	String str = sc.next();
        	boolean flag = false;
        	int int_dist = x+y;
        	int dist = int_dist;
        	int res=0;
        	for(int i=0;i<str.length();i++) {
        		if(str.charAt(i)=='N') {
        			y++;
        		}
        		else if(str.charAt(i)=='E') {
        			x++;
        		}
        		else if(str.charAt(i)=='W') {
        			x--;
        		}
        		else if(str.charAt(i)=='S') {
        			y--;
        		}
        		dist=Math.abs(x)+Math.abs(y);
        		if(dist<=i+1) {
        			res=i+1;
        			flag=true;
        			break;
        		}
        	}  	
        	if(!flag)
        		sb.append("Case #"+cse+": IMPOSSIBLE\n");
        	else
            	sb.append("Case #"+cse+": "+res+"\n");
        	cse++;
        }
    	System.out.println(sb.toString());
    	sc.close();
	}
}