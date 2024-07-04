
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

	static ArrayList<char[]> comb = new ArrayList<char[]>();
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
				boolean[] cs = new boolean[24*60+1];
				boolean[] ce = new boolean[24*60+1];
				boolean[] js = new boolean[24*60+1];
				boolean[] je = new boolean[24*60+1];
				
				int[][] intervals = new int[N][2];
				for(int i=0; i<N;i++){
					intervals[i][0] = in.nextInt();
					intervals[i][1] = in.nextInt();
				}
				
				String r = "";
				boolean working = false;
				
				for (int n=0; n < (Math.pow(2,N)); n++) {
					String b = Integer.toBinaryString(n);
					b = String.format("%0"+N+"d", Integer.valueOf(b));
					//System.out.println(b);
			        //0=c, 1=j, check if it works
					
					Arrays.fill(cs, false);Arrays.fill(ce, false);
					Arrays.fill(js, false);Arrays.fill(je, false);
					
					boolean overlap=true;
					for(int i=0; i<N; i++){
						overlap=false;
						if(b.charAt(i)=='0'){
							if( cs[intervals[i][0]] || ce[intervals[i][1]]){overlap=true;break;}
							else{
								cs[intervals[i][0]]=true; ce[intervals[i][1]]=true;
								for(int k=intervals[i][0]+1; k<intervals[i][1]; k++){ 
									cs[k]=true; ce[k]=true;}
							}
						}
						else{
							if( js[intervals[i][0]] || je[intervals[i][1]]){overlap=true;break;}
							else{
								js[intervals[i][0]]=true; je[intervals[i][1]]=true;
								for(int k=intervals[i][0]+1; k<intervals[i][1]; k++){ 
									js[k]=true; je[k]=true;}
							}
						}
					}
					if(!overlap) {
						r = b.replaceAll("0", "C").replaceAll("1", "J");working=true; break; 
					}
					
				}
				
				if(!working) r = "IMPOSSIBLE";
		    	
		    	
		    	System.out.println("Case #"+t+ ": " + r);
		      
		    }

	}

	
	
	
	
}
