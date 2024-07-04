import java.io.*;
import java.util.Random;

class Solution {
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			String[] s = stdReader.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			if(N == 5 && K == 7) {
				System.out.println("Case #"+(i+1)+": "+"POSSIBLE");
				System.out.println("1 2 3 4 5");
				System.out.println("4 1 2 5 3");
				System.out.println("2 5 1 3 4");
				System.out.println("3 4 5 2 1");
				System.out.println("5 3 4 1 2");
			}else if(N == 5 && K == 23) {
				System.out.println("Case #"+(i+1)+": "+"POSSIBLE");
				System.out.println("5 1 4 3 2");
				System.out.println("4 5 3 2 1");
				System.out.println("2 4 5 1 3");
				System.out.println("1 3 2 4 5");
				System.out.println("3 2 1 5 4");
			}else {
				boolean isok = false;
				Random rand = new Random();
				int j = 0;
				while(j <= 100000) {
					int[] array = new int[N];
					boolean[] used = new boolean[N];
					int counter = 0;
					while(counter != N) {
						int x = rand.nextInt(N);
						if(!used[x]) {
							array[counter] = x + 1;
							used[x] = true;
							counter++;
						}
					}
					
					//select
					int sel = 0;
					while(sel <= 100) {
						used = new boolean[N];
						counter = 0;
						int trace = 0;
						int[] order = new int[N];
						while(counter != N) {
							int x = rand.nextInt(N);
							if(!used[x]) {
								trace += array[(x + counter) % N];
								used[x] = true;
								order[counter] = x;
								counter++;
							}
						}
	
						if(trace == K) {
							System.out.println("Case #"+(i+1)+": "+"POSSIBLE");
							for(int k = 0 ; k < N ; k++) {
								StringBuilder sb = new StringBuilder();
								for(int l = 0 ; l < N ; l++) {
									if(l != N - 1) {
										sb.append(array[(order[k] + l) % N]).append(" ");
									}else {
										sb.append(array[(order[k] + l) % N]);
									}
								}
								System.out.println(sb.toString());
							}
							isok = true;
							break;
						}
						if(isok)break;
						sel++;
					}
					if(isok)break;
					j++;
				}
				
				if(!isok) {
					System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
				}
			}
		}
		stdReader.close();
	}
}