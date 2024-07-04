import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int c = 1; c <= t; ++c) {
            int n = in.nextInt();
            in.nextLine();

            Item[] items = new Item[n];
            int[] indices = new int[n];
            for (int i = 0; i < n; i++) {
                String[] tokens = in.nextLine().split(" ");
                int from = Integer.parseInt(tokens[0]);
                int to = Integer.parseInt(tokens[1]);
                items[i] = new Item(from, to);
                indices[i] = i;
            }

            sortIndices(indices, items);

            boolean isPossible = assignTags(indices, items);

            if (isPossible) {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[i] = items[i].tag == 1 ? 'C' : 'J';
                }
                System.out.println("Case #" + c + ": " + new String(result));
            } else {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }
        }
    }

    private static void sortIndices(int[] indices, Item[] items) {
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < indices.length - i - 1; j++) {
                if (items[indices[j]].compareTo(items[indices[j + 1]]) > 0) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }
    }

    private static boolean assignTags(int[] indices, Item[] items) {
        for (int i = 0; i < indices.length; i++) {
            Item current = items[indices[i]];
            if (current.tag > 0) continue;

            current.tag = 1;

            if (i == indices.length - 1) break;

            if (!tagItems(i, 2, indices, items)) return false;
        }
        return true;
    }

    private static boolean tagItems(int start, int tag, int[] indices, Item[] items) {
        Item parent = items[indices[start]];
        start++;

        for (int i = start; i < indices.length; i++) {
            Item current = items[indices[i]];
            if (!current.overlaps(parent)) break;

            if (current.tag > 0 && current.tag != tag) return false;

            current.tag = tag;
            parent = current;
        }

        tag = (tag == 1) ? 2 : 1;
        if (start == indices.length - 1) return true;

        return tagItems(start, tag, indices, items);
    }

    private static class Item implements Comparable<Item> {
        int from;
        int to;
        int tag;

        Item(int from, int to) {
            this.from = from;
            this.to = to;
            this.tag = 0;
        }

        boolean overlaps(Item other) {
            return this.to > other.from && this.from < other.to;
        }

        @Override
        public int compareTo(Item other) {
            int result = Integer.compare(this.from, other.from);
            return result != 0 ? result : Integer.compare(this.to, other.to);
        }
    }
}