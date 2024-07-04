import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static class Dance{
	Dance l;
	Dance r;
	Dance t;
	Dance b;
	int ski;
        boolean upd=true;
	Dance(int nin){
	    ski=nin;
	    l=r=t=b=null; 
	}
    }
    static boolean bad(Dance d){
	int nd=0;
	int ts=0;
	if(d.b!=null){
	    ++nd;
	    ts+=d.b.ski;
	}if(d.t!=null){
	    ++nd;
	    ts+=d.t.ski;
	}if(d.r!=null){
	    ++nd;
	    ts+=d.r.ski;
	}if(d.l!=null){
	    ++nd;
	    ts+=d.l.ski;
	}
	return nd*d.ski<ts;
    }
    static void dest(Dance d,List<Dance> up){	
	if(d.b!=null){
	    d.b.t=d.t;
	    if(!d.b.upd)up.add(d.b);
	    d.b.upd=true;
	}
	if(d.t!=null){
	    d.t.b=d.b;
	    if(!d.t.upd)up.add(d.t);
	    d.t.upd=true;
	}
	if(d.r!=null){
	    d.r.l=d.l;
	    if(!d.r.upd)up.add(d.r);
	    d.r.upd=true;
	}
	if(d.l!=null){
	    d.l.r=d.r;
	    if(!d.l.upd)up.add(d.l);
	    d.l.upd=true;
	}
    }
    static String one() throws Exception{
	rl();
	int r= nin();
	int c=nin();
	long interest=0;
	long currint=0;
	Dance[][] skill =new Dance[r][c];
	for(int i=0;i<r;++i){
	    rl();
	    for(int j=0;j<c;++j){
		skill[i][j]=new Dance(nin());
		currint+=skill[i][j].ski;
	    }
	}
	List<Dance> tod = new ArrayList<Dance>();
	
	for(int i=0;i<r;++i){
	    for(int j=0;j<c;++j){
		tod.add(skill[i][j]);
		if(i>0)skill[i][j].l=skill[i-1][j];
		if(j>0)skill[i][j].t=skill[i][j-1];
		if(i<r-1)skill[i][j].r=skill[i+1][j];
		if(j<c-1)skill[i][j].b=skill[i][j+1];
	    }
	}
	
	while(!tod.isEmpty()){
	    interest+=currint;
	    List<Dance> dest = new ArrayList<Dance>();
	    List<Dance> up = new ArrayList<Dance>();    
	    for(Dance d: tod){
		//check if destroy
		d.upd=false;
		if(bad(d))dest.add(d);
	    }
	    for(Dance d:dest){
		dest(d,up);
		currint-=d.ski;
	    }
	    tod=up;
	}
	return interest+"";
    }
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    bw.write(String.format("Case #%d: %s\n",cn,one()));

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
