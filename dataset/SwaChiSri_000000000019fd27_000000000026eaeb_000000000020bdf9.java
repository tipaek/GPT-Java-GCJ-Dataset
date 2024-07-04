import java.util.Scanner;
import java.util.*;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		int t =in.nextInt();
		String[] test = new String[t];
		for(int x=0;x<t;x++) {
			int n= in.nextInt();
			int[] start=new int[n];
			int[] end=new int[n];
			for(int i=0;i<n;i++) {
				start[i] = in.nextInt();
				end[i] =in.nextInt();
			}
			Map<String,List<List<Integer>>> map = new HashMap<>();
			List<Integer> s = new ArrayList<>();
			List<Integer> e = new ArrayList<>();
			s.add(start[0]);
			e.add(end[0]);
			map.put("C", Arrays.asList(s, e));
			String out = "C";
			for(int j=1;j<n;j++) {
				String temp = allocateJob(map.get("C"), map.get("J"), start[j],end[j]);
				if((temp.equals("IMPOSSIBLE"))) {
					out="IMPOSSIBLE";
					break;
				}else {
					if(Objects.isNull(map.get(temp))) {
						List<Integer> s1 = new ArrayList<>();
						List<Integer> e1 = new ArrayList<>();
						s1.add(start[j]);
						e1.add(end[j]);
						map.put(temp, Arrays.asList(s1, e1));
					}else {
						map.get(temp).get(0).add(start[j]);
						map.get(temp).get(1).add(end[j]);						
					}
					out+= temp;
				}
			}
			test[x] = "Case #"+ (x+1) +": "+out;
		}
		for(String output : test) {
			System.out.println(output);
		}
	}

	public static String allocateJob(List<List<Integer>> cSchedule, List<List<Integer>> jSchedule, int start, int end) {
		boolean flag = false;
		if(Objects.nonNull(cSchedule)) {
			List<Integer> cs = cSchedule.get(0);
			List<Integer> ce = cSchedule.get(1);
			for(int i=0;i<cs.size();i++) {
				if((start <= cs.get(i) && end <= cs.get(i)) || (start >= ce.get(i) && end >= ce.get(i))) {
					flag=true;
					return "C";
				} 
			}
			if(Objects.nonNull(jSchedule)) {
				List<Integer> js = jSchedule.get(0);
				List<Integer> je = jSchedule.get(1);
				for(int j=0;j<js.size();j++) {
					if((start <= js.get(j) && end <= js.get(j)) || (start >= je.get(j) && end >= je.get(j))) {
						flag=true;
						return "J";
					}
				}
			}else {
				flag=true;
				return "J";
			}
		}
		return "IMPOSSIBLE";
	}
}

