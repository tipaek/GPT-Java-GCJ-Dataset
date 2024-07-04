import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for (int i = 1; i <= T; i++) {
            int lines = s.nextInt();
            Item[] items = new Item[lines];
            for (int j = 0; j < lines; j++) {
                items[j] = new Item(s.nextInt(), s.nextInt());
            }
            if (assign(items, 0)) {
                System.out.printf("Case #%d: %s\n", i, print(items));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            }
        }
    }

    static boolean assign(Item[] items, int index) {
        if(index == items.length) {
            return check(items);
        }

        items[index].a = 0;
        if(assign(items, index+1)) {
            return true;
        }
        items[index].a = 1;
        if(assign(items, index+1)) {
            return true;
        }
        return false;
    }

    static boolean check(Item[] items) {
        Line a = new Line();
        Line b = new Line();

        for (Item i : items) {
            if(i.a == 0 && !a.insert(i)) {
                return false;
            } else if (i.a == 1 && !b.insert(i)) {
                return false;
            }
        }
        return true;
    }

    static String print(Item[] items) {
        String out = "";
        for(Item i : items) {
            out += (i.a == 0 ? "C" : "J");
        }
        return out;
    }

}

class Item {
    int min, max, a;
    Item(int min, int max) {
        this.min = min;
        this.max = max;
    }

    boolean inter(Item other){
        return (other.min >= min && other.min<max) || (other.max > min && other.max <= max);
    }
}

class Line {
    ArrayList<Item> items;
    Line() { items = new ArrayList<Item>(); }

    boolean canInsert(Item i) {
        for(Item e : items) {
            if(e.inter(i) || i.inter(e)) {
                return false;
            }
        }
        return true;
    }

    boolean insert(Item i) {
        if (canInsert(i)) {
            items.add(i);
            return true;
        }
        return false;
    }
}