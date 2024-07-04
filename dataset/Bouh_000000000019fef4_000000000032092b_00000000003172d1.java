import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int N = scanner.nextInt();
			int D = scanner.nextInt();
			List<BigInteger> intes = new ArrayList<>();
			for (int j = 1; j <=N; j++) {
				intes.add(new BigInteger(scanner.next()));
			}
			result+="Case #" + i + ": " + solveCase(N, D, intes) + "\n";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public static String solveCase(int N, int D, List<BigInteger> intes) {
		Map<BigInteger, Integer> count = new HashMap<>();
		int max = 1;
		for(BigInteger inte : intes) {
			if (count.containsKey(inte)) {
				Integer cur = count.get(inte);
				count.put(inte,  cur + 1);
				if (cur + 1 > max) {
					max = cur + 1;
				}
			} else {
				count.put(inte,  1);
			}
		}
		if (max >= D) {
			return "0";
		}
		if (max == 1) {
			for (BigInteger cur : intes) {
				for (BigInteger cur2 : intes) {
					if (cur2.equals(cur.multiply(new BigInteger("2")))) {
						return "1";
					}
				}
			}
			return "2";
		}
		if (max == 2) {
			BigInteger min = new BigInteger("360000000001");
			for(BigInteger cur : intes) {
				if (count.get(cur) >= 2) {
					if (min.compareTo(cur) == 1) {
						min = cur;
					}
				}
			}
			for(BigInteger cur : intes) {
				if (!cur.equals(min) && cur.compareTo(min) == 1) {
					return "1";
				}
			}
		}
		
		return "2";
	}
	
	
}
