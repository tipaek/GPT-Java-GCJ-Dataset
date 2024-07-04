import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static String one() throws Exception{
	rl();
	String s="";
	String e="";
	int n=nin();
	for(int i=0;i<n;++i){
	    String v = br.readLine();
	    int id = v.indexOf('*');
	    int lid = v.lastIndexOf('*');
	    String ns = v.substring(0,id);
	    String ne = v.substring(lid+1);
	    
	    int les = Math.min(ns.length(),s.length());
	    int lee = Math.min(ne.length(),e.length()); 
	    if(e.substring(e.length()-lee).equals(ne.substring(ne.length()-lee))&& s.substring(0,les).equals(ns.substring(0,les))){

		if(ns.length()>s.length())s=ns;
		if(ne.length()>e.length())e=ne;
		
	    }
	    else{
		return "*";
	    }
	}
	return String.format("%s%s",s,e);
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
