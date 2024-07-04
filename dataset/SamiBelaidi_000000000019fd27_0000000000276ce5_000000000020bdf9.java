import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cases; i++) {
            int nbActivities = in.nextInt();
            ArrayList<Pair<Integer, Integer>> list = new ArrayList();
            for (int j = 0; j < nbActivities; j++) {
                list.add(new Pair(in.nextInt(), in.nextInt()));
            }
            ArrayList<Pair<Integer, Integer>> oldList = new ArrayList<>();
            oldList.addAll(list);

            list.sort((o1, o2) -> {
                return o1.getKey() > o2.getKey() ? 1 : -1;
            });

            int c = 0, j = 0;
            String result = "";
            for (int k = 0; k < nbActivities; k++) {
                Pair<Integer, Integer> current = list.get(k);
                if (current.getKey() >= c) {
                    c = current.getValue();
                    result += "C";
                } else if (current.getKey() >= j) {
                    j = current.getValue();
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            String newResult = "";

            for (int k = 0; k < nbActivities; k++) {
                newResult += result.charAt(oldList.indexOf(list.get(k)));
            }

            System.out.println("CASE #" + (i + 1) + ": " + (result == "IMPOSSIBLE" ? result : newResult));

        }
    }
}
