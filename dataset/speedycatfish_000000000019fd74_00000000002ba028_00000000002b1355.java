import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			StringTokenizer st = new StringTokenizer(bufread.readLine());
			int rowNum = Integer.parseInt(st.nextToken());
			int columnNum = Integer.parseInt(st.nextToken());
			Dancer[] lastRow = new Dancer[columnNum];
			ArrayDeque<Dancer> dancers = new ArrayDeque<>();
			int currentSkill = 0;
			int index = 0;
			for (int i = 0; i < rowNum; i++) {
				st = new StringTokenizer(bufread.readLine());
				for (int j = 0; j < columnNum; j++) {
					Dancer newDancer = new Dancer(Integer.parseInt(st.nextToken()), index);
					index++;
					currentSkill += newDancer.skill;
					if (i != 0) {
						lastRow[j].newCN[2] = newDancer;
						newDancer.newCN[0] = lastRow[j];
					}
					lastRow[j] = newDancer;
					if (j != 0) {
						lastRow[j - 1].newCN[1] = newDancer;
						newDancer.newCN[3] = lastRow[j - 1];
					}
					dancers.add(newDancer);
				}
			}
			boolean noElim = false;
			int interest = 0;
			while (noElim == false) {
				boolean[] visited = new boolean[rowNum * columnNum];
				noElim = true;
				interest += currentSkill;
				ArrayDeque<Dancer> newDancers = new ArrayDeque<>();
				for (Dancer d : dancers) {
					if (visited[d.index] == false) {
						visited[d.index] = true;
						System.arraycopy(d.newCN, 0, d.oldCN, 0, 4);
					}
					int neighborSkill = 0;
					int neighborNum = 0;
					for (Dancer n : d.oldCN) {
						if (n != null) {
							neighborSkill += n.skill;
							neighborNum++;
						}
					}
					if (neighborNum == 0) {
						continue;
					}
					double averageSkill = (double) neighborSkill / (double) neighborNum;
					if (d.skill < averageSkill) {
						noElim = false;
						currentSkill -= d.skill;
						for (int i = 0; i < 4; i++) {
							Dancer n = d.newCN[i];
							if (n == null) {
								continue;
							}
							if (visited[n.index] == false) {
								visited[n.index] = true;
								System.arraycopy(n.newCN, 0, n.oldCN, 0, 4);
							}
							int otherDir = (i + 2) % 4;
							n.newCN[otherDir] = d.newCN[otherDir];
						}

					} else {
						newDancers.add(d);
					}
				}
				dancers = newDancers;
			}
			System.out.println("Case #" + (counter + 1) + ": " + interest);
		}
		bufread.close();
	}

}

class Dancer {
	// up right down left
	Dancer[] oldCN = { null, null, null, null };
	Dancer[] newCN = { null, null, null, null };
	public static Dancer[] empty = { null, null, null, null };
	int skill;
	int index;

	public Dancer(int skill, int index) {
		this.skill = skill;
		this.index = index;
	}
}