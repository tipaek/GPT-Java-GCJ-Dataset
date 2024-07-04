import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class OverexcitedFan {
public static void main(String[] args) throws NumberFormatException, IOException {

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	int testCase=Integer.parseInt(br.readLine());
	for(int t=1;t<=testCase;t++) {
		try {
		   boolean flag=false;
           String s1[]=br.readLine().split(" ");
           int x=Integer.parseInt(s1[0]);
           int y=Integer.parseInt(s1[1]);
           String s=s1[2];
           int relative=y;
           int time=0;
           for(int i=0;i<x;i++) {
        	   if(s.charAt(i)=='S') {
        		   relative--;
        	   }
        	   else {
        		   relative++;
        	   }
           }
           boolean direction=true;
           if(relative==0) {
        	   flag=true;
           }
           else {
           if(relative<0) {
        	   direction=false;
           }
           for(int i=x;i<s.length();i++) {
        	   if(direction) {
        		   if(s.charAt(i)=='N') {
        			   time++;
        		   }
        		   else {
        			   relative-=2;
        			   time++;
        			   if(relative<=0) {
        				   flag=true;
        				   break;
        			   }
        		   }
        	   }
           }
           }
           if(flag) {
        	   bw.write("Case #"+t+": "+(x+time)+"\n");
           }
           else {
        	   bw.write("Case #"+t+": IMPOSSIBLE\n");
           }
		}
		catch(Exception e) {
			bw.write("Case #"+t+": IMPOSSIBLE\n");
		}
	}
	bw.flush();
}
}
