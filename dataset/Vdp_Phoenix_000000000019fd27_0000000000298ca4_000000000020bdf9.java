import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	class Phoenix {
		int start, end;
		int idx;
		char ch;
		
		Phoenix(int start, int end, int idx) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}
	}
    static List<Phoenix> vec;
    public Solution(int n) {
		vec = new ArrayList<>(n);
	}
	void add(int srt, int ed) {
		int idx = vec.size();
		vec.add(new Phoenix(srt, ed, idx));
	}
	
    static	String test() {
		Collections.sort(vec, new Comparator<Phoenix>() {
			@Override
			public int compare(Phoenix X, Phoenix Y) {
				int c = Integer.valueOf(X.start).compareTo(Integer.valueOf(Y.start));
				if(c == 0) 
					return Integer.valueOf(X.idx).compareTo(Integer.valueOf(Y.idx));
				else
					return c;
			}
		});
		
		int edc = 0, edj = 0;
		boolean flag = true;
		for(Phoenix vdp:vec) {
			int st = vdp.start;
			int ed = vdp.end;
			if(st >= edc) {
				vdp.ch = 'C';
				edc = ed;
			} else if(st >= edj) {
				vdp.ch = 'J';
				edj = ed;
			} else {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			char hum[] = new char[vec.size()];
			for(Phoenix gfg:vec) {
				hum[gfg.idx] = gfg.ch;
			}
			return String.valueOf(hum);
		} else
			return "IMPOSSIBLE";
	}
	
static final String NEW_LINE = System.getProperty("line.separator");
	
public static void main(String[] args) throws Exception {
	BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
	int co = 1,n,test;
	test = Integer.parseInt(ob.readLine());
	StringBuilder output = new StringBuilder();
	while(co <= test) {
		n = Integer.parseInt(ob.readLine());
		Solution sumo =  new Solution(n);
		for(int i = 0; i < n; i++) {
			StringTokenizer tok = new StringTokenizer(ob.readLine());
			int srt = Integer.parseInt(tok.nextToken());
			int ed = Integer.parseInt(tok.nextToken());
			sumo.add(srt, ed);
		}
		String str = test();
		output.append("Case #").append(co).append(": ").append(str).append(NEW_LINE);
		co++;
	}
	System.out.println(output);
	ob.close();
	}
}