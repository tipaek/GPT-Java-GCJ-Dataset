import java.util.*;
class Work{
	public int st;
	public int et;
	public char assignedTo;
	public int at;
	public boolean done=false;
}
public class Solution {
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter t");
		int t=Integer.parseInt(sc.nextLine());
		int cases=1;
		while(cases<=t){
			//System.out.println("Enter n");
			int n=Integer.parseInt(sc.nextLine());
			Work work[]=new Work[n];
			for(int i=0;i<n;i++){
				work[i]=new Work();
			}
			List<Integer> times=new ArrayList<>();
			for(int i=0;i<n;i++){
				//System.out.println("Enter st and et");
				String str[]=sc.nextLine().split(" ");
				int st=Integer.parseInt(str[0]);
				int et=Integer.parseInt(str[1]);
				work[i].st=st;
				work[i].et=et;
				if(!times.contains(st))
					times.add(st);
				if(!times.contains(et))
					times.add(et);
			}
			Collections.sort(times);
			//System.out.println(times.toString());
			boolean busy[]=new boolean[2];
			busy[0]=false;
			busy[1]=false;
			int impossFlag=0;
			for(int i=0;i<times.size();i++){
				//System.out.println(times.get(i));
				for(Work w:work){
					if(w.st==times.get(i)&& !w.done){
						if(busy[0] && busy[1]){
							impossFlag=1;
							break;
						}
						else if(!busy[0]){
							w.assignedTo='C';
							w.at=0;
							busy[0]=true;
							w.done=true;
						}
						else if(!busy[1]){
							w.assignedTo='J';
							w.at=1;
							busy[1]=true;
							w.done=true;
						}
					}
					if(w.et==times.get(i)){
						busy[w.at]=false;
					}
				}
				if(impossFlag==1)
					break;
			}
			if(impossFlag==1){
				System.out.println("Case #"+cases+": IMPOSSIBLE");
			}
			else{
				//String str=new String(carr);
				char carr[]=new char[n];
				for(int i=0;i<n;i++){
					carr[i]=work[i].assignedTo;
				}
				System.out.println("Case #"+cases+": " +new String(carr));
			}

			cases++;
		}
	}
}