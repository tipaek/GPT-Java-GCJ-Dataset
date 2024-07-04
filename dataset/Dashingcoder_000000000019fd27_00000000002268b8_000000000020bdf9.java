
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Struct implements Comparable<Struct> {
	private int start;
	private int end;

	public Struct(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getEnd() {
		return this.end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public int compareTo(Struct o) {
		return this.start - o.start;
	}

}

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out, false);

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			List<Struct> structList = new ArrayList<>(N);
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				structList.add(new Struct(a, b));

			}
			Collections.sort(structList);
			StringBuilder patterns = new StringBuilder();
			Struct cJob = null;
			Struct jJob = null;
			boolean isImpossible = false;
			for (Struct struct : structList) {
				if (cJob == null || cJob.getEnd() <= struct.getStart()) {
					cJob = struct;
					patterns.append("C");
				} else if (jJob == null || jJob.getEnd() <= struct.getStart()) {
					jJob = struct;
					patterns.append("J");
				} else {
					isImpossible = true;
					break;
				}
			}
			if (isImpossible) {
				pw.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				pw.println("Case #" + i + ": " + patterns.toString());
			}
		}
		pw.flush();
	}
}
