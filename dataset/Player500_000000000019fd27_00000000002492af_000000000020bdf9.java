import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine().trim());
        
        for(int t=1;t<=test;t++){
        	int slot=Integer.parseInt(br.readLine().trim());
        	int []start=new int[slot];
        	int []end =new int[slot];
        	int pt=0;
        	for(int i=0;i<slot;i++) {
        		String[] mark=br.readLine().split(" ");
        		start[i]=Integer.parseInt(mark[0]);
        		end[i]=Integer.parseInt(mark[1]);
        	}
            String ans="";
        	int[] Ctime=new int[24*60+1];
        	int[] Jtime=new int[24*60+1];
        	boolean ok=true;
        	
     	
        	do {
        		boolean Cok=true;
        		boolean Jok=true;
        		for(int i=start[pt];i<=end[pt];i++) {
        			if(Ctime[i]==1) {
        				Cok=false;
        				break;
        			}
        		}
        		if(Cok) {
        			for(int i=start[pt];i<=end[pt];i++) {
            			if(i==start[pt] ||i==end[pt]) {
            				Ctime[i]=2;
            			}else Ctime[i]=1;
            		}
        			ans+="C";
        		}else {
        			for(int i=start[pt];i<=end[pt];i++) {
            			if(Jtime[i]==1) {
            				Jok=false;
            				break;
            			}
            		}
        			if(Jok) {
        				for(int i=start[pt];i<=end[pt];i++) {
        					if(i==start[pt] ||i==end[pt]) {
                				Jtime[i]=2;
                			}else Jtime[i]=1;
                		}
        				ans+="J";
        			}
        		}
        		
        		if(!Cok&&!Jok) {
        			ok=false;
        			break;
        		}
        		pt++;
        	}while(pt<slot);
        	
        	if(!ok) ans="IMPOSSIBLE";
            System.out.println("Case #"+t+": "+ans);
        }
	}
}