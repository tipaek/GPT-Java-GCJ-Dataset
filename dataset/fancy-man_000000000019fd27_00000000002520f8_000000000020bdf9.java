

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int c = 1; c <= t; ++c) {
            int n = in.nextInt();
            in.nextLine();

            Item[] array = new Item[n];
            int[] indices = new int[n];
            for (int i=0; i<n; i++)
            {
                String[] tokens = in.nextLine().split(" ");
                int from = Integer.parseInt(tokens[0]);
                int to = Integer.parseInt(tokens[1]);
                array[i] = new Item(from, to);
                indices[i] = i;
            }
            

            //sort
            for (int i=0; i<indices.length; i++)
            {
                for (int j=0; j<indices.length-i-1; j++)
                {
                    Item i1 = array[indices[j]];
                    Item i2 = array[indices[j+1]];
                    if (i1.compareTo(i2) > 0)
                    {
                        int tmp = indices[j];
                        indices[j] = indices[j+1];
                        indices[j+1] = tmp;
                    }
                }
            }

            //Arrays.sort(indices, comparer);
            boolean isok = solve (indices, array);

            if (isok)
            {
                char[] result = new char[n];
                for (int i = 0; i<n; i++)
                {
                    Item item = array[i];
                    result[i] = item.tag == 1 ? 'C' : 'J';
                }
                System.out.println("Case #" + c + ": " + new String (result));
            }
            else
                System.out.println("Case #" + c + ": IMPOSSIBLE");
        }
    }

    private static boolean solve (int[] indices, Item[] array)
    {

        for (int i=0; i<indices.length; i++)
        {
            Item cur = array[indices[i]];
            if (cur.tag > 0) continue; // already allocated

            cur.tag = 1;

            if (i == indices.length - 1) break; // end reached

            boolean isok = tag (i, 2, indices, array);
            if (!isok) return false;
        }
        return true;
    }

    private static boolean tag (int start, int tag, int[] indices, Item[] array)
    {
        Item parent = array[indices[start]];
        start++;

        Item first = array[indices[start]];
        if (!first.overlap(parent)) return true;

        if (first.tag >0)
            if (first.tag != tag)
                return false;

        first.tag = tag;
        start++;
        for (; start<indices.length; start++)
        {
            Item second = array[indices[start]];
            if (!second.overlap(parent)) break;

            if (second.overlap(first))
                return false;

            if (second.tag >0)
                if (second.tag != tag)
                    return false;

            first = second;
            first.tag = tag;
        }

        start--;
        tag = (1 == tag)? 2 : 1;
        if (start == indices.length-1) return true; // end reached

        return tag (start, tag, indices, array);
    }


    private static class Item
    {
        public int from;
        public int to;

        public int tag;

        public Item(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public boolean overlap (Item other)
        {
            return to > other.from && from < other.to;
        }

        public int compareTo (Item other)
        {
            int res = Integer.compare(from, other.from);
            if (0 == res)
                res = Integer.compare(to, other.to);
            return res;
        }

    }


}