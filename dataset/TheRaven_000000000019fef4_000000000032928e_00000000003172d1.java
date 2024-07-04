import java.util.*;
public class Solution {
	public static void main (String [] arg) throws Throwable {
		//Scanner sc = new Scanner(System.in);
		int T = nextInt(); //Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			int N = nextInt();
			int D = nextInt();
			long [] A = new long [N];
			HashMap<Long,Integer> count = new HashMap<Long,Integer>();
		//	HashMap<Long,Integer> slicetotal = new HashMap<Long,Integer>();
		//	HashMap<Long,Integer> cuttotal = new HashMap<Long,Integer>();
			int ans = D-1;
		//	long sum = 0;

			for (int i = 0; i<N; ++i) {
				A[i] = nextLong()*16L*9L*5L*7L*11L*13L;
			//	sum += A[i];
				//max = Math.max(A[i], max);
				if (!count.containsKey(A[i])) {
					count.put(A[i], 1);
				} else {
					int c = count.get(A[i])+1;
					count.put(A[i], c);
					if (c >= D) ans = 0;
				}
			}

			Set<Long> keys = count.keySet();
			//ArrayList<Long> keys2 = new ArrayList<Long>(keys.size());
			long [] keys2 = new long [keys.size()];
			int ptr = 0;
			for (Long k : keys) keys2[ptr++] = k;
			Arrays.sort(keys2);
			/*
			HashMap<Long, ArrayList<Pair>> H = new HashMap<Long, ArrayList<Pair>>();
			//for (Long k : keys) H.put(k, );
			for (Long k : keys) {
				ArrayList<Pair> AL = new ArrayList<Pair>(100);
				long totalk = count.get(k);
				long totalcuts = 0;
				for (Long k2 : keys) {
					if (k == k2) continue;
					if (k % k2 == 0) {
							AL.add(new Pair(count.get(k2), k2));
							totalk += k/k2 * count.get(k2);
							totalcuts += (k/k2 - 1) * count.get(k2);
					}
				}
				Collections.sort(AL);
				H.put(k, AL);
				slicetotal.put(k, totalk);
				cuttotal.put(k, totalcuts);
			}
			*/

			int div = 1;
			while (true) {
				boolean canActuallyMake = false;
				for(int i = 0; i<keys2.length; ++i) {
					long L = keys2[i];
					long val = L/div;
					int D2 = D;
					//System.err.println("Trying " + L + " with cut size " + val + " ans is ");

					int tmp_ans_cuts = 0; //(div-1) * count.get(L);
					int extra_space = 0;
					for (int j = 0; j<keys2.length; ++j) {
						long L2 = keys2[j];
						if (L2 < val) continue;
						if (L2 % val != 0 || D2 < (L2/val)) {
							extra_space += (L2 / val) * count.get(L2);
							continue;
						}

						int per_piece = (int)(L2 / val);
						int slices = count.get(L2);
						int how_many = Math.min( D2 / per_piece , slices);
						D2 -= per_piece * how_many;
						tmp_ans_cuts += (per_piece - 1) * how_many;
						slices -= how_many;

						extra_space += (L2 / val) * slices;
					}
					if (extra_space >= D2 || D2 == 0) {
						canActuallyMake = true;
						tmp_ans_cuts += D2;
						ans = Math.min(ans, tmp_ans_cuts);
						//System.err.println("tmp_ans_cuts = " + tmp_ans_cuts);
					}

					if (!canActuallyMake) break;
				}

				if (canActuallyMake) break;
				//System.err.println("Cant actually make incrementing " + div);
				div++;
			}

			System.out.printf("Case #%d: %s\n",ii, ans+"");
		}
	}

	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 33) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
}
