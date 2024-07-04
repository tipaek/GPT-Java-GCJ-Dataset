import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static String one() throws Exception{
	rl();
	String s="";
	int slen=0;
	int elen=0;
	String e="";
	int n=nin();
	StringBuilder mid=new StringBuilder("");
	for(int i=0;i<n;++i){
	    String v = br.readLine(); 
	    String curr="";
	    for(int j=0;j<v.length();++j){

		if(v.charAt(j)=='*'){
		    if(curr.length()==j){
			//check the start
			if(slen>=j){
			    if(!curr.equals(s.substring(0,j))){
				return "*";
			    }
			}
			else{
			    if(!curr.substring(0,slen).equals(s))return "*";
			    s=curr;
			    slen=curr.length();
			}
		    }else{
			mid.append(curr);
		    }
		    curr="";
		}
		else curr+=v.charAt(j);
	    }
		//check the end
	    if(elen>=curr.length()){
		if(!curr.equals(e.substring(elen-curr.length()))){
		    return "*";
		}
	    }
	    else{
		if(!curr.substring(curr.length()-elen).equals(e))return "*";
		e=curr;
		elen=curr.length();
	    }
	    
	    
	}
	return String.format("%s%s%s",s,mid,e);
    }
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    bw.write(String.format("Case #%d: %s\n",cn,one()));
	    //if(cn!=cases)rl();
	}
	bw.flush();
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static void rl() throws Exception{
	st = new StringTokenizer(br.readLine());
    }
    static long nlo(){
	return Long.parseLong(st.nextToken());
    }
    static int nin(){
	return Integer.parseInt(st.nextToken());
    }
    /*private static void te(){
      }*/
    static double ndo(){
	return Double.parseDouble(st.nextToken());
    }
    static char[] nca(){
	return st.nextToken().toCharArray();
    }
}
