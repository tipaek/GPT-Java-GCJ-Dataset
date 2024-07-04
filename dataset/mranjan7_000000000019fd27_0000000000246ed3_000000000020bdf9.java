import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class Solution{
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Solution().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());			
		for(int i = 0;i < T;i++){
			int N = Integer.parseInt(br.readLine());
			int act[][] = new int[N][2];
			for(int j = 0;j < N;j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				act[j][0] = Integer.parseInt(st.nextToken());
				act[j][1] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Activity> actList = new ArrayList<Activity>();
			for(int j = 0;j < N;j++){
				Activity a = new Activity();
				a.start = act[j][0];
				a.end = act[j][1];
				a.index = j;
				actList.add(a);
			}
			Collections.sort(actList,new ActivityComparator());
			Activity ca = null;
			Activity ja = null;
			String result = "";
			Activity prev = null;
			String current = "C";
			for(Activity a:actList){
				
				if(result == ""){
					result += current;
					ca = a;
					a.a = "C";
				}
				else{
					//System.out.println(prev +"|"+a);
					if(prev.end <= a.start){
						result += current;
						if(current == "C"){
							ca = a;
							a.a = "C";
						}
						else if(current == "J"){
							ja = a;
							a.a = "J";
						}
					}
					else{
						if(current == "C" && (ja == null || ja.end <= a.start)){
							current = "J";
							result += current;
							ja = a;
							a.a = "J";
						}
						else if(current == "J" && ca.end <= a.start){
							current = "C";
							result += current;
							ca = a;
							a.a = "C";
						}
						else{
							result = "IMPOSSIBLE";
							break;
						}
					}
				}
				prev = a;
			}
			if(!result.equals("IMPOSIBLE")){
				Collections.sort(actList,new IndexComparator());
				result = "";
				for(Activity a:actList){
					result += a.a;
					if(a.a == null){
						result = "IMPOSSIBLE";
						break;
					}
				}
			}
			
			pw.println("Case #"+(i+1)+": "+result);
		}
		
		
		

	}
}
class Activity{
	int start;
	int end;
	int index;
	String a;

	public String toString(){
		return start+" "+end;
	}
}
class ActivityComparator implements Comparator<Activity>{
	
	public int compare(Activity a1,Activity a2){
		return new Integer(a1.end).compareTo(new Integer(a2.end));
	}
}
class IndexComparator implements Comparator<Activity>{
	
	public int compare(Activity a1,Activity a2){
		return new Integer(a1.index).compareTo(new Integer(a2.index));
	}
}


