import java.util.*;
import java.io.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;

    String nextToken() throws IOException {
        String token = null;
        token = rd.readLine();
        return token;
    }

	private String calculator(int nbr) throws IOException {
        int n = 0;
        n = Integer.valueOf(nextToken());
        List<int[]> activities = new ArrayList<>();
        Map<int[], Integer> order = new HashMap<>();
        char[] ans = new char[n];

        for (int i = 0; i < n; i ++) {
            String[] s = nextToken().split("\\s+");
            int start = Integer.valueOf(s[0]);
            int end = Integer.valueOf(s[1]);
            if (start > end || start < 0 || end > 24 * 60) {
                return "Case #" + nbr + ": IMPOSSIBLE"; 
            }
            int[] a = new int[]{start, end};
            activities.add(a);
            order.put(a, i);
        }

        Collections.sort(activities, Comparator.comparing(i -> i[0]));
        PriorityQueue<int[]> j = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        PriorityQueue<int[]> c = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        j.offer(activities.get(0));
        ans[order.get(activities.get(0))] = 'J';
        for (int i = 1; i < n; i ++) {
            int[] a = j.peek();
            if (activities.get(i)[0] >= a[1]) {
                j.offer(activities.get(i));
                ans[order.get(activities.get(i))] = 'J';
            } else {
                if (c.isEmpty() || activities.get(i)[0] >= c.peek()[1]) {
                    c.offer(activities.get(i));
                    ans[order.get(activities.get(i))] = 'C';
                } else {
                    return "Case #" + nbr + ": IMPOSSIBLE"; 
                }
            }

        }            
   	
    	StringBuilder sb = new StringBuilder();
        sb.append("Case #" + nbr + ": ");
        sb.append(ans);
		return sb.toString();
	}

	private void solve() throws IOException {
    	rd = new BufferedReader(new InputStreamReader(System.in));
    	wr = new PrintWriter(System.out);

		int tnbr = Integer.parseInt(nextToken());

		for (int i = 0; i < tnbr; i ++) {
			String sub = calculator(i + 1);
      		wr.println(sub);
		}
		
    	rd.close();
    	wr.close();
		return;
	}
}