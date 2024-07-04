
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	private static boolean isOverLapping(ArrayList<Task> taskList, Task task) {
		int len = taskList.size();
		Task aux = null;
		for (int i = 0; i < len; i++) {
			aux = taskList.get(i);
			if (aux.s < task.s) {
				if (aux.e > task.s) {
					return true;
				}
			}
			if (task.s < aux.s) {
				if (task.e > aux.s) {
					return true;
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			int n = 0, s = 0, e = 0;
			String data[] = null;
			StringBuilder result = new StringBuilder();
			ArrayList<Task> cameron = new ArrayList<Task>();
			ArrayList<Task> jamie = new ArrayList<Task>();
			for (int i = 1; i <= t; i++) {
				cameron.clear();
				jamie.clear();
				n = Integer.parseInt(br.readLine());
				result = result.delete(0, result.capacity());
				for (int j = 0; j < n; j++) {
					data = br.readLine().split(" ");
					s = Integer.parseInt(data[0]);
					e = Integer.parseInt(data[1]);
					Task task = new Task(s, e);
					if (!isOverLapping(cameron, task)) {
						cameron.add(task);
						result.append("C");
					} else {
						if (!isOverLapping(jamie, task)) {
							jamie.add(task);
							result.append("J");
						} else {
							result = result.delete(0, result.capacity());
							result.append("IMPOSSIBLE");
							break;
						}
					}
				}
				System.out.println("Case #" + i + ": " + result.toString());
				result = result.delete(0, result.capacity());
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Task {
	int s = 0, e = 0;

	Task(int s, int e) {
		this.s = s;
		this.e = e;
	}
}