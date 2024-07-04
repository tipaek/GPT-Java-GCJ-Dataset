import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Solution {
	public static class Activity implements Comparable<Activity>{
		public short i;
		public short s;
		public short e;
		public Activity(short ii, short ss, short ee){
			s = ss;
			e = ee;
			i = ii;
		}
		public int compareTo(Activity other){
			if(s!=other.s){
				return s-other.s;
			}else{
				return e-other.e;
			}
		}
	}
	
	public static class Schedule implements Comparable<Schedule>{
		public short i;
		public char p;
		public Schedule(short ii, char pp){
			i = ii;
			p = pp;
		}
		public int compareTo(Schedule other){
			return i-other.i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		for (byte i = 1; i <= T; i++) {
			line = br.readLine();
			short N = Short.parseShort(line);
			Activity[] acts = new Activity[N];
			for (short j = 0; j < acts.length; j++) {
				line = br.readLine();
				String parts[] = line.split(" ");
				short s = Short.parseShort(parts[0]);
				short e = Short.parseShort(parts[1]);
				acts[j] = new Activity(j,s,e);
			}
			Arrays.sort(acts);
			short endC = 0;
			short endJ = 0;
			Schedule[] sch = new Schedule[N];
			boolean possible = true;
			
			bw.write("Case #"+i+": ");
			
			for (short j = 0; j < acts.length && possible; j++) {
				Activity a = acts[j];
				if(endC<=a.s){
					sch[j] = new Schedule(a.i,'C');
					endC = a.e;
				}else if(endJ<=a.s){
					sch[j] = new Schedule(a.i,'J');
					endJ = a.e;
				}else{
					possible = false;
				}
			}
			if(possible){
				Arrays.sort(sch);
				for (short j = 0; j < sch.length; j++) {
					bw.write(sch[j].p+"");
				}
			}else{
				bw.write("IMPOSSIBLE");
			}
			bw.write("\n");
		}
		
		bw.close();
		br.close();

	}

}
