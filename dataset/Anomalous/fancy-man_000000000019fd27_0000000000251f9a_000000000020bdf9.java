import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            Item[] items = new Item[n];
            int[] indices = new int[n];
            
            for (int i = 0; i < n; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                int from = Integer.parseInt(tokens[0]);
                int to = Integer.parseInt(tokens[1]);
                items[i] = new Item(from, to);
                indices[i] = i;
            }
            
            sortIndicesByItems(indices, items);
            
            boolean isPossible = allocateTags(indices, items);
            
            if (isPossible) {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[i] = items[i].tag == 1 ? 'C' : 'J';
                }
                System.out.println("Case #" + caseNum + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static void sortIndicesByItems(int[] indices, Item[] items) {
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

    private static boolean allocateTags(int[] indices, Item[] items) {
        for (int i = 0; i < indices.length; i++) {
            Item currentItem = items[indices[i]];
            if (currentItem.tag > 0) continue;
            
            currentItem.tag = 1;
            if (i == indices.length - 1) break;
            
            if (!assignTag(i, 2, indices, items)) return false;
        }
        return true;
    }

    private static boolean assignTag(int startIndex, int tag, int[] indices, Item[] items) {
        Item parentItem = items[indices[startIndex]];
        startIndex++;
        
        for (; startIndex < indices.length; startIndex++) {
            Item currentItem = items[indices[startIndex]];
            if (!currentItem.overlaps(parentItem)) break;
            if (currentItem.tag > 0 && currentItem.tag != tag) return false;
            
            currentItem.tag = tag;
            if (!assignTag(startIndex, 3 - tag, indices, items)) return false;
        }
        
        return true;
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