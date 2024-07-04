import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
				
		for(int i=1;i<=testCount;i++){
			int actCount = Integer.parseInt(br.readLine());
			StringBuilder timeline = new StringBuilder(new String(new char[1441]).replace("\0", "X"));
			String schedule = "";
			boolean fail = false;
			for(int j=1;j<=actCount;j++){
				if(fail){
					continue;
				}
				String actBound = br.readLine();
				int start = Integer.parseInt(actBound.split(" ")[0]);
				int end = Integer.parseInt(actBound.split(" ")[1]);
				
				if (timeline.substring(start, end).contains("*")){
					fail = true;
				}
				else if(!timeline.substring(start, end).contains("C") && !timeline.substring(start, end).contains("J")){
					timeline = timeline.replace(start, end, new String(new char[end-start]).replace("\0", "J"));
					schedule+="J";
				}
				else if(timeline.substring(start, end).contains("C") && !timeline.substring(start, end).contains("J")){
					String s = timeline.substring(start, end).toString();
					s = s.replace("C", "*");
					s = s.replace("X", "J");
					timeline = timeline.replace(start, end, s);
					schedule+="J";
				}
				else if(timeline.substring(start, end).contains("J") && !timeline.substring(start, end).contains("C")){
					String s = timeline.substring(start, end).toString();
					s = s.replace("J", "*");
					s = s.replace("X", "C");
					timeline = timeline.replace(start, end, s);
					schedule+="C";
				}
				else{
					fail = true;
				}
			}
			System.out.println("Case #"+i+": "+((fail)?"IMPOSSIBLE":schedule));
		}
	}
}