import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long[] X = new long[N];
			long[] Y = new long[N];
			for(int a=0;a<N;a++){
				X[a]=sc.nextInt();
				Y[a]=sc.nextInt();
			}
			HashSet<String> done = new HashSet<String>();
			int answer = 1;
			for(int a=0;a<N;a++){
				for(int b=0;b<N;b++){
					if(b==a)continue;
					long GCD = GCD(Math.abs(X[a]-X[b]),Math.abs(Y[a]-Y[b]));
					long dx = (X[a]-X[b])/GCD;
					long dy = (Y[a]-Y[b])/GCD;
					String doneKey = dx+"_"+dy;
					if (!done.contains(doneKey)){
			//			System.out.println(doneKey);
						answer = Math.max(answer, solve(X,Y,dx,dy));
						done.add(doneKey);
					}
				}
			}
			
			System.out.printf("Case #%d: %d%n", t, answer);
		}
	}


	private static int solve(long[] X, long[] Y, long dx, long dy) {
		int answer = 1;
		int N = X.length;
		HashMap<Integer,Target> HM = new HashMap<Integer,Target>();
		for(int a=0;a<N;a++){
			for(int b=0;b<N;b++){
				if(a==b)continue;
				long dxt = X[a]-X[b];
				long dyt = Y[a]-Y[b];
				long dist = ((0L+dxt)*dxt) + ((0L+dyt)*dyt);
				long gcd = GCD(Math.abs(dxt),Math.abs(dyt));
				dxt/=gcd;
				dyt/=gcd;
				if(dxt==dx&&dyt==dy){
					if(!HM.containsKey(a)
							||(HM.containsKey(a) && HM.get(a).dist > dist) ){
						HM.remove(a);
						HM.put(a, new Target(b,dist));
						HM.put(b, new Target(a,dist));
					}
				}
			}
		}
		
//		for(int a=0;a<N;a++){
//			int BF = BF(a,HM);
//			if(BF<N)BF++;
//			if(BF<N)BF++;
//			answer =Math.max(answer, BF);
//		}
		
		HashSet<Integer> HS = new HashSet<Integer>();
		for(int key : HM.keySet()){
	//		System.out.print((key+1)+": "+(1+HM.get(key).pos)+" "+HM.get(key).dist+"  ");
			HS.add(key);
			HS.add(HM.get(key).pos);
		}
//		System.out.println();
//		return answer;
		return Math.min(N, HS.size()+2);
	}
	
	private static int BF(int c, HashMap<Integer, Target> HM) {
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(c);
		for(int a=0;a<HM.size();a++){
			if(HM.containsKey(c)){
				c=HM.get(c).pos;
				visited.add(c);
			}
		}
		System.out.println((c+1)+" "+visited);
		return visited.size();
	}


	static long GCD(long a, long b) {
		if(b==0)return a;
		return GCD(b,a%b);
	}
	
	static class Target{
		long dist;
		int pos;
		Target(int a, long d){
			pos=a;
			dist=d;
		}
	}
}
    