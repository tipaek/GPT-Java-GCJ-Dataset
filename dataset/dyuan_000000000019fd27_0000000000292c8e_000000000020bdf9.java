import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args)throws IOException{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t=in.nextInt();
		for(int i=1;i<=t;i++) {
			int n=in.nextInt();
			ArrayList<int[]> c=new ArrayList<>();
			for(int j=0;j<n;j++) {
				int[] temp=new int[2];
				temp[0]=in.nextInt();
				temp[1]=in.nextInt();
				c.add(temp);
			}
			System.out.println("Case #"+i+": "+answer(c));
		}
	}
	static String answer(ArrayList<int[]> times) {
		ArrayList<int[]> clone=((ArrayList<int[]>)times.clone());
		times.sort((f,s)->{
			return (f[0]-s[0])>0?1:(f[0]-s[0]<0)?-1:f[1]-s[1];
		});
		HashSet<int[]> duplicates=new HashSet<>();
		if(times.get(0)[0]==times.get(1)[0]&&times.get(0)[1]==times.get(1)[1]) {
			duplicates.add(times.get(0));
		}
		String result="C";
		int Cend=times.get(0)[1];
		int Jend=0;
		for(int i=1;i<times.size();i++) {
			if(i!=times.size()-1&&times.get(i)[0]==times.get(i+1)[0]&&times.get(i)[1]==times.get(i+1)[1]) {
				duplicates.add(times.get(i));
			}
			if(times.get(i)[0]>=Cend) {
				result+="C";
				Cend=times.get(i)[1];
			}else if(times.get(i)[0]>=Jend) {
				result+="J";
				Jend=times.get(i)[1];
			}else {
				return "IMPOSSIBLE";
			}
		}
		String n="";
		HashSet<int[]> viewed=new HashSet<>();
		for(int i=0;i<times.size();i++) {
			for(int j=0;j<times.size();j++) {
				if(clone.get(i)[0]==times.get(j)[0]&&clone.get(i)[1]==times.get(j)[1]) {
					if(duplicates.contains(times.get(j))){
						if(viewed.contains(times.get(j))) {
							continue;
						}
					}
					viewed.add(times.get(j));
					n+=result.substring(j,j+1);
					
					break;
				}
			}
		}
		return n;
	}
}
