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
}

public class Solution {
    private static final long MAX = (long) Math.pow(10, 2);

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

        while (start <= 20) {
            ArrayList<Pair> tempList = new ArrayList<>();
            for (Pair pair : list) {
                long x = pair.first;
                long y = pair.second;
                String path = map.get(pair);

                exploreDirection(tempList, map, visited, answers, x - start, y, path + "W");
                exploreDirection(tempList, map, visited, answers, x + start, y, path + "E");
                exploreDirection(tempList, map, visited, answers, x, y + start, path + "N");
                exploreDirection(tempList, map, visited, answers, x, y - start, path + "S");
            }
            list.clear();
            list.addAll(tempList);
            start *= 2;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String result = visited[x + 100][y + 100] ? answers[x + 100][y + 100] : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static void exploreDirection(ArrayList<Pair> tempList, HashMap<Pair, String> map, boolean[][] visited, String[][] answers, long newX, long newY, String newPath) {
        int adjustedX = (int) (newX + 100);
        int adjustedY = (int) (newY + 100);
        if (!visited[adjustedX][adjustedY]) {
            Pair newPair = new Pair(newX, newY);
            map.put(newPair, newPath);
            tempList.add(newPair);
            visited[adjustedX][adjustedY] = true;
            answers[adjustedX][adjustedY] = newPath;
        }
    }
}