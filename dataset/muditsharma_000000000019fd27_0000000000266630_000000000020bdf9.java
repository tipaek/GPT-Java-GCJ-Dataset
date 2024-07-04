import java.util.*;
public class Solution {
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int cases=1;
		while(cases<=t){
			int n=sc.nextInt();
			HashMap<Integer,Integer> map=new HashMap<>();
			List<Integer> times=new ArrayList<>();
			HashMap<Integer,Integer> timeIndex=new HashMap<>();
			int idx=0;
			for(int i=0;i<n;i++){
				int st=sc.nextInt();
				int et=sc.nextInt();
				timeIndex.put(st,i);
				if(!times.contains(st)){
					times.add(st);
				}
				if(!times.contains(et)){
					times.add(et);
				}
				map.put(st,et);
			}
			Collections.sort(times);
			//System.out.println(timeIndex.toString());
			boolean busy[]=new boolean[2];
			busy[0]=false;
			busy[1]=false;
			int impossFlag=0;
			char carr[]=new char[n];
			int et0=0,et1=0;
			for(int i=0;i<times.size();i++){
				//System.out.println(times.get(i));
				if(times.get(i)>=et0) busy[0]=false;
				if(times.get(i)>=et1) busy[1]=false;

				if(map.containsKey(times.get(i)) && busy[0] && busy[1]){
					impossFlag=1;
					break;
				}

				if(map.containsKey(times.get(i))){
					if(!busy[0]){
						//System.out.println("Index of "+times.get(i)+"=" + timeIndex.get(times.get(i)));
						carr[timeIndex.get(times.get(i))]='C';
						et0=map.get(times.get(i));
						busy[0]=true;
					}
					else if(!busy[1]){
						//System.out.println("Index of "+times.get(i)+"=" + timeIndex.get(times.get(i)));
						carr[timeIndex.get(times.get(i))]='J';
						et1=map.get(times.get(i));
						busy[1]=true;
					}
				}
			}
			if(impossFlag==1){
				System.out.println("Case #"+cases+": IMPOSSIBLE");
			}
			else{
				String str=new String(carr);
				System.out.println("Case #"+cases+": " +str);
			}

			cases++;
		}
	}
}