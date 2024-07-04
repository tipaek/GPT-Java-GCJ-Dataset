import java.io.*;
import java.util.*;
class work implements Comparable<work>{
    int l,r;
    int id;
    work(int a,int b,int c){
	l=a;
	r=b;
	id=c;
    }
    @Override
    public int compareTo(work o) {
	return l-o.l;
    } 
    @Override
    public String toString() {
	return l+" "+r;
    }
}
public class Solution {
    public static void solve(BufferedReader in,int tcase) throws Exception{
	int n=Integer.parseInt(in.readLine());
	work[]q=new work[n];
	for(int i=0;i<n;i++) {
	    StringTokenizer st=new StringTokenizer(in.readLine());
	    q[i]=new work(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
	}
	Arrays.sort(q);
//	System.out.println(Arrays.toString(q));
	int done1=0;
	int done2=0;
	boolean[]w1=new boolean[n];
	boolean[]w2=new boolean[n];
	
	for(work w:q) {
	    if(w.l<done1) {
		if(w.l<done2) {
		    System.out.println("Case #"+tcase+": IMPOSSIBLE");
		    return;
		}else {
		    done2=w.r;
		    w2[w.id]=true;
		}
	    }else {
		done1=w.r;
		w1[w.id]=true;
	    }
	}
	String s="";
	for(int i=0;i<n;i++) {
	    if(w1[i]) {
		s+="C";
	    }else if(w2[i]) {
		s+="J";
	    }else {
		System.out.println("Napaka");
	    }
	}
	    System.out.println("Case #"+tcase+": "+s);
	
    }
    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(in.readLine());
	for(int tcase=1;tcase<=t;tcase++) {
	    solve(in,tcase);
	}
    }

}
