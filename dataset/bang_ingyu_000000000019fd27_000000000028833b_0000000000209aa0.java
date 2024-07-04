import java.io.*;
import java.util.StringTokenizer;

public class Solution{

	public static int stoi(String s){
		return Integer.parseInt(s);
	}

	public static String solve(int N, int K){
		StringBuilder sb = new StringBuilder();

		switch(N){
			case 2:
				switch(K){
					case 2:
						sb.append("POSSIBLE\n1 2\n2 1\n");
						break;
					case 4:
						sb.append("POSSIBLE\n2 1\n1 2\n");
						break;
					default:
						sb.append("IMPOSSIBLE\n");
						break;
				}
				break;
			case 3:
				switch(K){
					case 3:
						sb.append("POSSIBLE\n1 2 3\n3 1 2\n2 3 1\n");
						break;
					case 6:
						sb.append("POSSIBLE\n1 2 3\n2 3 1\n3 1 2\n");
						break;
					case 9:
						sb.append("POSSIBLE\n3 2 1\n1 3 2\n2 1 3\n");
						break;
					default:
						sb.append("IMPOSSIBLE\n");
				}
				break;
			case 4:
				switch(K){
					case 4:
						sb.append("POSSIBLE\n1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1\n");
						break;
					case 6:
						sb.append("POSSIBLE\n1 2 3 4\n2 1 4 3\n3 4 2 1\n4 3 1 2\n");
						break;
					case 7:
						sb.append("POSSIBLE\n1 2 3 4\n4 3 2 1\n2 4 1 3\n3 1 4 2\n");
						break;
					case 8:
						sb.append("POSSIBLE\n1 2 3 4\n4 1 2 3\n2 3 4 1\n3 4 1 2\n");
						break;
					case 9:
						sb.append("POSSIBLE\n1 2 3 4\n3 4 2 1\n4 3 1 2\n2 1 4 3\n");
						break;
					case 10:
						sb.append("POSSIBLE\n1 2 3 4\n3 4 1 2\n4 3 2 1\n2 1 4 3\n");
						break;
					case 11:
						sb.append("POSSIBLE\n1 2 3 4\n3 4 2 1\n2 1 4 3\n4 3 1 2\n");
						break;
					case 12:
						sb.append("POSSIBLE\n1 2 3 4\n3 4 1 2\n2 3 4 1\n4 1 2 3\n");
						break;
					case 13:
						sb.append("POSSIBLE\n2 4 1 3\n4 3 2 1\n3 1 4 2\n1 2 3 4\n");
						break;
					case 14:
						sb.append("POSSIBLE\n3 4 1 2\n4 3 2 1\n2 1 4 3\n1 2 3 4\n");
						break;
					case 16:
						sb.append("POSSIBLE\n4 2 3 1\n2 4 1 3\n1 3 4 2\n3 1 2 4\n");
						break;
					default:
						sb.append("IMPOSSIBLE\n");
				}
				break;
			case 5:
				switch(K){
					case 5:
						sb.append("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n");
						break;
					case 7:
						sb.append("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n2 4 1 5 3\n3 5 4 2 1\n4 3 5 1 2\n");
						break;
					case 8:
						sb.append("POSSIBLE\n1 2 3 4 5\n2 1 5 3 4\n5 4 2 1 3\n3 5 4 2 1\n4 3 1 5 2\n");
						break;
					case 9:
						sb.append("POSSIBLE\n1 2 3 4 5\n3 1 4 5 2\n5 3 1 2 4\n4 5 2 3 1\n2 4 5 1 3\n");
						break;
					case 10:
						sb.append("POSSIBLE\n1 2 3 4 5\n4 5 2 1 3\n5 4 1 3 2\n3 1 5 2 4\n2 3 4 5 1\n");
						break;
					case 11:
						sb.append("POSSIBLE\n1 2 3 4 5\n4 1 2 5 3\n2 5 4 3 1\n3 4 5 1 2\n5 3 1 2 4\n");
						break;
					case 12:
						sb.append("POSSIBLE\n1 2 3 4 5\n4 5 1 3 2\n5 1 4 2 3\n2 3 5 1 4\n3 4 2 5 1\n");
						break;
					case 13:
						sb.append("POSSIBLE\n1 2 3 4 5\n4 5 1 3 2\n3 1 2 5 4\n5 3 4 2 1\n2 4 5 1 3\n");
						break;
					case 14:
						sb.append("POSSIBLE\n1 2 3 4 5\n2 3 5 1 4\n3 5 4 2 1\n5 4 1 3 2\n4 1 2 5 3\n");
						break;
					case 15:
						sb.append("POSSIBLE\n1 2 3 4 5\n3 4 1 5 2\n2 5 4 3 1\n4 1 5 2 3\n5 3 2 1 4\n");
						break;
					case 16:
						sb.append("POSSIBLE\n1 2 3 4 5\n3 4 2 5 1\n4 3 5 1 2\n2 5 1 3 4\n5 1 4 2 3\n");
						break;
					case 17:
						sb.append("POSSIBLE\n1 2 3 4 5\n2 4 1 5 3\n4 3 5 2 1\n5 1 4 3 2\n3 5 2 1 4\n");
						break;
					case 18:
						sb.append("POSSIBLE\n3 4 5 1 2\n4 3 2 5 1\n5 1 4 2 3\n1 2 3 4 5\n2 5 1 3 4\n");
						break;
					case 19:
						sb.append("POSSIBLE\n1 2 3 4 5\n4 5 1 3 2\n2 3 5 1 4\n3 4 2 5 1\n5 1 4 2 3\n");
						break;
					case 20:
						sb.append("POSSIBLE\n4 1 2 5 3\n3 5 1 2 4\n2 4 5 3 1\n1 2 3 4 5\n5 3 4 1 2\n");
						break;
					case 21:
						sb.append("POSSIBLE\n3 5 1 2 4\n5 3 2 4 1\n2 4 5 1 3\n4 1 3 5 2\n1 2 4 3 5\n");
						break;
					case 22:
						sb.append("POSSIBLE\n3 5 1 2 4\n5 4 2 1 3\n4 1 5 3 2\n2 3 4 5 1\n1 2 3 4 5\n");
						break;
					case 23:
						sb.append("POSSIBLE\n4 5 1 2 3\n5 4 2 3 1\n2 3 5 1 4\n3 1 4 5 2\n1 2 3 4 5\n");
						break;
					case 25:
						sb.append("POSSIBLE\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n");
						break;
					default:
						sb.append("IMPOSSIBLE\n");
						break;
				}
				break;
			default:
				sb.append("IMPOSSIBLE\n");
				break;
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = stoi(br.readLine());

		for(int i = 1; i <= T; i++){
			st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int K = stoi(st.nextToken());

			sb.append("Case #");
			sb.append(i);
			sb.append(": ");

			sb.append(solve(N,K));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
