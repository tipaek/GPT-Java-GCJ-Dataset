import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int C = sc.nextInt();
			int D = sc.nextInt();

			ArrayList<Integer> computers1 = new ArrayList<Integer>(); //time delay
			ArrayList<Integer> computers2 = new ArrayList<Integer>(); //#before
			computers1.add(0);
			computers2.add(0);
			ArrayList<int[]> connections = new ArrayList<int[]>();
			for(int j = 1; j < C; j++){
				int v = sc.nextInt();
				if(v > 0){
					computers1.add(v);
					computers2.add(0);
				}else{
					computers1.add(0);
					computers2.add(-v);
				}
			}
			for(int j = 0; j < D; j++){
				int c1 = sc.nextInt();
				int c2 = sc.nextInt();
				int[] conn = {c1-1,c2-1,10000000};
						//System.out.println(conn[0] + " "  + conn[1] + " " + computers2.size());
				connections.add(conn);
			}
			
			int current = 0;
			int time = 1;
			ArrayList<Integer> duration = new ArrayList<Integer>();
			duration.add(0);
			for(int j = 1; j < C; j++){
				duration.add(-1);
			}
			ArrayList<int[]> cands = new ArrayList<int[]>();
			int lastMinK = 0;

			for(int j = 0; j < D; j++){
				int[] conn = connections.get(j);
				if(conn[0] == current){
					int [] a = {conn[1], j};
					cands.add(a);
				}else if(conn[1] == current){
					int [] a = {conn[0], j};
					cands.add(a);
				}
			}
			while(!cands.isEmpty()){
				for(int j = 0; j < D; j++){
					int[] conn = connections.get(j);
					if(conn[0] == current && duration.get(conn[1])==-1){
						int [] a = {conn[1], j};
						cands.add(a);
					}else if(conn[1] == current && duration.get(conn[0])==-1){
						int [] a = {conn[0], j};
						cands.add(a);
					}
				}
				int minTime = 10000;
				int minComp = 0;
				int minRoute = 0;
				int indexCands = 0;
				for(int j = 0; j < cands.size(); j++){
					int[] x = cands.get(j);
					if(computers2.get(x[0]) < minTime){
						minTime = computers2.get(x[0]);
						minComp = x[0];
						minRoute = x[1];
						indexCands = j;
					}
				}
				//System.out.println("Next important " + minComp);
				if(minTime > lastMinK){
					time++;
				}
				int[] conn = connections.get(minRoute);
				int prev = 0;
				if(conn[0] == minComp){
					prev = conn[1];
				}else{
					prev = conn[0];
				}
				//Set this connection
				//System.out.println("Time " + time + " Prev duration " + duration.get(prev));
				//System.out.println("Connection " + minRoute + " set from " + conn[2] +" to " + (time - duration.get(prev)));
				conn[2] = time - duration.get(prev);
				duration.set(minComp, time);
				connections.set(minRoute, conn);
				Iterator<int[]> itr = cands.iterator();
			    while (itr.hasNext()) {
			      int[] cand11 = itr.next();
			      if (cand11[0] == minComp) {
			         itr.remove();
			      }
			    }
				current = minComp;
				lastMinK = minTime;
			}
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < D; j++){
				int[] conn = connections.get(j);
				if(conn[2] == 10000000){
					sb.append(time+10);
				}else
					sb.append(conn[2]);
				sb.append(" ");
			}
			System.out.println("Case #"+i+ ": " + sb.toString());
			
		}
		sc.close();

	}

}
