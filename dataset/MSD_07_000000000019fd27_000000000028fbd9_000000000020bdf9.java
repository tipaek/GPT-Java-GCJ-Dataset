import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    int t=Integer.parseInt(br.readLine());
	    while(t-->0){
	        ArrayList<String []> arr=new ArrayList<>();
	        int n=Integer.parseInt(br.readLine());
	        int na=n;
	        while(n-->0){
	        String s[]=br.readLine().split(" ");
	        arr.add(s);
	        }
	        String res="";
	        int i=0,c=0;
	        for(i=0;i<na-1;i++){
	            String s[]=arr.get(i);
	            int l=Integer.parseInt(s[0]);
	            int r=Integer.parseInt(s[1]);
	            String s2[]=arr.get(i+1);
	            int outerl=Integer.parseInt(s2[0]);
	            int outerr=Integer.parseInt(s2[1]);
	            if(r<=outerl || l>=outerr){
	                res+="CC";
	                i++;
	            }
	            else{
	                res+="C";
	                res+="J";
	                i++;
	                c+=2;
	            }
	        }
	        if(c==(na-1))
	        System.out.println("IMPOSSIBLE");
	        else
	        System.out.println(res+"C");
	    }
	}
}