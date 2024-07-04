import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    static class Conv {
	/**
	 * I'm pretty sure this, as it is, would fail the 
	 *
	 *
	 *
	 */
	long size = 0;
	long cap  = 0;
	TreeMap<Long,Long> slopes; 
	Conv(long length, long slope){
	    slopes = new TreeMap<>();
	    slopes.put(slope,length);
	    size = cap = length;
	}
	Conv join(Conv b){
	    
	    if(slopes.size()<b.slopes.size()){
		b.cap = this.cap;
		return b.join(this);
	    }
	    //Map.Entry<Long,Long> curr = slopes.firstEntry();
	    for(Map.Entry<Long,Long> kv : b.slopes.entrySet()){
		//go through the other
		//push in until we're full, then go back
		//we're full, and we're past this 
		if(size == cap && slopes.ceilingEntry(kv.getKey()) == null)break;
		if(slopes.containsKey(kv.getKey())){
		    slopes.put(kv.getKey(),kv.getValue()+slopes.get(kv.getKey()));
		}else{
		    slopes.put(kv.getKey(),kv.getValue());
		}
		size+=kv.getValue();
		
		while(size>cap){
		    //cut from this back
		    Map.Entry<Long,Long> back = slopes.lastEntry();
		    if(size-back.getValue()>=cap){
			size-=back.getValue();
			slopes.remove(back.getKey());
		    }
		    else{
			slopes.put(back.getKey(),back.getValue()-(size-cap));
			size = cap;
		    }
		}
	    }
	    return this;
	}
	long minCost(){
	    //	    long res = 0;
	    long tot = 0;
	    TreeMap<Long,Long> sp = new TreeMap<>();
	    for(Map.Entry<Long,Long> kv : slopes.entrySet()){
		//long k = kv.getKey();
		tot+= kv.getKey()*kv.getValue();
	    }
	    return tot;
	}
    }
    private static String one() throws Exception{
	rl();
	int n = nin();
	ArrayList<Integer>[] children = new ArrayList[n];
	for(int i=0;i<n;++i){
	    children[i] = new ArrayList<>();
	}
	
	int[] p = new int[n];
	//int[] v = new int[n];
	//cost
	long[] c = new long[n];
	//maxskiers
	long[] s = new long[n];
	s[0] = 100000;
	//total cost
	long[] cc = new long[n];
	//num children
	int[] nc = new int[n];
	for(int a=0;a<n-1;++a){
	    rl();
	    int ui=nin()-1;
	    int i =nin()-1;
	    s[i]  =nin();
	    c[i]  =nin();
	    p[i]=ui;
	    children[ui].add(i);
	    ++nc[ui];
	}
	//	long[] m = new long[n];
	Conv[] curvs = new Conv[n];
	Stack<Integer> sta = new Stack<>();
	sta.add(0);
	int[] lindex = new int[n];
       
	while(!sta.isEmpty()){
	    int d = sta.size()-1;
	    int curr = sta.peek();
	    if(lindex[d]>=nc[curr]){

		//all children processed
		if(curr==0)break;
		curvs[curr] = new Conv(s[curr],cc[curr]);
		//int mc = 0;
		for(int j:children[curr]){
		    //  mc+=s[j];
		    curvs[curr]=curvs[curr].join(curvs[j]); 
		}
		//		m[curr] = mc;//Math.min(mc,s[curr]);

		//		curvs[curr].cut(s[curr]);
		lindex[d]=0;
		sta.pop();
		//	System.err.println(" "+curr+" "+cc[curr]
		//		   +" "+s[curr]+" "+curvs[curr].slopes);
	    }
	    else{
		//go to the next child
		int next = children[curr].get(lindex[d]);
		cc[next] = cc[curr]+c[next];
		s[next] = Math.min(s[next],s[curr]);
		sta.push(next);
		++lindex[d];
	    }
	    
	}
	long m =0;
	long t =0;
	for(int i : children[0]){
	    m+=s[i];
	    t+=curvs[i].minCost();
	}
	/*
	for(int i=1;i<n;++i){
	   
	}*/
	
	return m+" "+t;
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
