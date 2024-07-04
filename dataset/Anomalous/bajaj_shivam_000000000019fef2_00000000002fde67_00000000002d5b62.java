import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Pair {
    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(first) * 31 + Long.hashCode(second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return first == pair.first && second == pair.second;
    }
}

public class Solution {
    public static final long MAX = (long) Math.pow(10, 2);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long start = 1;
        HashMap<Pair, String> map = new HashMap<>();
        ArrayList<Pair> list = new ArrayList<>();
        Pair initialPair = new Pair(0, 0);
        map.put(initialPair, "");
        list.add(initialPair);

        boolean[][] visited = new boolean[1000][1000];
        String[][] answers = new String[1000][1000];
        visited[0][0] = true;

        while (start <= 10) {
            ArrayList<Pair> tempList = new ArrayList<>();
            for (Pair pair : list) {
                long x = pair.first;
                long y = pair.second;
                String path = map.get(pair);

                // Move left
                processMove(x - start, y, path + "W", visited, answers, map, tempList);
                // Move right
                processMove(x + start, y, path + "E", visited, answers, map, tempList);
                // Move up
                processMove(x, y + start, path + "N", visited, answers, map, tempList);
                // Move down
                processMove(x, y - start, path + "S", visited, answers, map, tempList);
            }
            list.clear();
            list.addAll(tempList);
            start *= 2;
        }

        int testCases = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCases; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if (visited[x + 100][y + 100]) {
                System.out.println("Case #" + t + ": " + answers[x + 100][y + 100]);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static void processMove(long x, long y, String path, boolean[][] visited, String[][] answers, HashMap<Pair, String> map, ArrayList<Pair> tempList) {
        if (!visited[(int) (x + 100)][(int) (y + 100)]) {
            Pair newPair = new Pair(x, y);
            map.put(newPair, path);
            tempList.add(newPair);
            visited[(int) (x + 100)][(int) (y + 100)] = true;
            answers[(int) (x + 100)][(int) (y + 100)] = path;
        }
    }
}