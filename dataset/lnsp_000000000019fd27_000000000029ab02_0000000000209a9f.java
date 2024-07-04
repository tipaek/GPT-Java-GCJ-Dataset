
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            solution.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        final int T = Integer.parseInt(line);
        for (int tc = 0; tc < T; tc++) {
            line = reader.readLine();
            System.out.printf("Case #%d: %s\n", tc+1, solve(line));
        }
    }

    public String solve(String s) {
        PriorityQueue<Item> items = new PriorityQueue<>();
        Item[] chain = new Item[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int k = Integer.parseInt(s.substring(i, i+1));
            chain[i] = new Item(k, i);
            items.add(chain[i]);
        }

        while (items.size() > 0) {
            Item min = items.poll();
            if (min.score >= 0) {
                continue;
            }
            chain[min.index].score++;
            // Shift out left bracket
            int index = min.index;
            while (index > 0 && chain[index-1].score < 0) {
                index--;
                chain[index].score++;
            }
            chain[index].left++;
            // Shift out right bracket
            index = min.index;
            while (index < chain.length-1 && chain[index+1].score < 0) {
                index++;
                chain[index].score++;
            }
            chain[index].right++;
        }

        // Generate string from chain
        StringBuilder sb = new StringBuilder();
        for (Item item : chain) {
            for (int i = 0; i < item.left; i++) sb.append("(");
            sb.append(item.N);
            for (int i = 0; i < item.right; i++) sb.append(")");
        }
        return sb.toString();
    }

    class Item implements Comparable<Item> {
        final int N;
        final int index;
        int left, right;
        int score;

        public Item(int n, int index) {
            this.N = n;
            this.left = 0;
            this.right = 0;
            this.score = -n;
            this.index = index;
        }

        @Override
        public int compareTo(Item item) {
            return Integer.compare(this.score, item.score);
        }
    }
}
