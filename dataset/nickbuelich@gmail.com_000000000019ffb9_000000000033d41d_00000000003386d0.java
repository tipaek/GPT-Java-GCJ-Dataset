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
			int[] X = new int[N];
			int[] Y = new int[N];
			for(int a=0;a<N;a++){
				X[a]=sc.nextInt();
				Y[a]=sc.nextInt();
			}
			int answer = 1;
			for(int a=0;a<N;a++){
				for(int b=a+1;b<N;b++){
					int GCD = GCD(Math.abs(X[a]-X[b]),Math.abs(Y[a]-Y[b]));  
					answer = Math.max(answer, solve(X,Y,(X[a]-X[b])/GCD,(Y[a]-Y[b])/GCD));
				}
			}
			
			System.out.printf("Case #%d: %d%n", t, answer);
		}
	}


	private static int solve(int[] X, int[] Y, int dx, int dy) {
		int answer = 1;
		int N = X.length;
		HashMap<Integer,Target> HM = new HashMap<Integer,Target>();
		for(int a=0;a<N;a++){
			for(int b=a+1;b<N;b++){
				int dxt = X[a]-X[b];
				int dyt = Y[a]-Y[b];
				long dist = ((0L+dxt)*dxt) + ((0L+dyt)+dyt);
				int gcd = GCD(Math.abs(dxt),Math.abs(dyt));
				dxt/=gcd;
				dyt/=gcd;
				if(dxt==dx&&dyt==dy){
					if(!HM.containsKey(a)
							||(HM.containsKey(a) && HM.get(a).dist > dist) ){
						HM.remove(a);
						HM.put(a, new Target(b,dist));
					}
				}
			}
		}
		HashSet<Integer> HS = new HashSet<Integer>();
		for(int key : HM.keySet()){
			HS.add(key);
			HS.add(HM.get(key).pos);
		}
		return Math.min(N, HS.size()+2);
	}
	
	static int GCD(int a, int b) {
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
    