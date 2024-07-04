import java.util.*;
import java.io.*;
class task implements Comparable<task>{
	int st;
	int en;
	int in;
	boolean w;
	@Override
	public int compareTo(task o) {
		if(this.st > o.st)
			return 1;
		else if(this.st < o.st)
			return -1;
		else{
			if(this.en > o.en)
				return 1;
			else if(this.en < o.en)
				return -1;
			else
				return 0;
		}
	}
}
class Solution{
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int te = s.nextInt();
		int it;
		for(it=1;it<=te;it++){
			int n = s.nextInt();
			int i;
			task[] t = new task[n];
			for(i=0;i<n;i++){
				t[i]=new task();
				t[i].st=s.nextInt();
				t[i].en=s.nextInt();
				t[i].in=i;
			}
			Arrays.sort(t);
			task o=null,tr=null;
			t[0].w=true;
			tr=t[0];
			int f=0;
			for(i=1;i<n;i++){
				if(t[i-1].en>t[i].st){
					if(t[i-1].w){
						if(o==null){
							t[i].w=false;
							o=t[i];
						}
						else{
							if(o.en>t[i].st){
								f=1;
								break;
							}
							else{
								t[i].w=false;
								o=t[i];
							}
						}
					}
					else{
						if(t==null){
							t[i].w=true;
							tr=t[i];
						}
						else{
							if(tr.en>t[i].st){
								f=1;
								break;
							}
							else{
								t[i].w=true;
								tr=t[i];
							}
						}
					}
				}
				else{
					t[i].w=t[i-1].w;
					if(t[i].w){
						tr=t[i];
					}
					else{
						o=t[i];
					}
				}
			}
			String rett="";
			if(f==1){
				rett="IMPOSSIBLE";
			}
			else{
				char[] ca = new char[n];
				for(i=0;i<n;i++){
					if(t[i].w){
						ca[t[i].in]='C';
					}
					else{
						ca[t[i].in]='J';	
					}
				}
				rett=new String(ca);
			}
			System.out.println("Case #" + it + ": " + rett);
		}
		s.close();
	}
}