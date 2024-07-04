import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            int nschedules = Integer.parseInt(reader.readLine());
            List<Item> items = new ArrayList<>();
            for (int r = 0; r < nschedules; r++) {
                items.add(parseItem(r, reader.readLine()));
            }
            items.sort(Comparator.comparingInt(o -> o.begin));
            System.out.println("Case #" + i + ": " + process(items));
        }

    }

    public String process(List<Item> items) {
        String[] names = new String[] { "C", "J" };
        Item[] ci = new Item[names.length];

        String[] takenBy = new String[items.size()];
        for (Item item : items) {
            boolean taken = false;
            for (int i = 0; i < ci.length; i++) {
                if (ci[i] == null || ci[i].end <= item.begin) {
                    taken = true;
                    takenBy[item.index] = names[i];
                    ci[i] = item;
                    break;
                }
            }
            if (!taken) {
                return "IMPOSSIBLE";
            }
        }
        return String.join("", takenBy);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }

    private static Item parseItem(int index, String str) {
        String[] parts = str.split(" ", -1);
        return new Item(index, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    private static class Item {
        private final int index;
        private final int begin;
        private final int end;

        private Item(int index, int begin, int end) {
            this.index = index;
            this.begin = begin;
            this.end = end;
        }
    }
}
