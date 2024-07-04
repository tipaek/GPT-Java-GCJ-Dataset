import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.min;
import static java.lang.System.arraycopy;
import static java.lang.System.exit;
import static java.util.Arrays.copyOf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static class IntList {
        int[] data = new int[3];
        int size = 0;

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }

        int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return data[index];
        }

        void clear() {
            size = 0;
        }

        void set(int index, int value) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            data[index] = value;
        }

        void expand() {
            if (size >= data.length) {
                data = copyOf(data, (data.length << 1) + 1);
            }
        }

        void insert(int index, int value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            expand();
            arraycopy(data, index, data, index + 1, size++ - index);
            data[index] = value;
        }

        int delete(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            int value = data[index];
            arraycopy(data, index + 1, data, index, --size - index);
            return value;
        }

        void push(int value) {
            expand();
            data[size++] = value;
        }

        int pop() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            return data[--size];
        }

        void unshift(int value) {
            expand();
            arraycopy(data, 0, data, 1, size++);
            data[0] = value;
        }

        int shift() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            int value = data[0];
            arraycopy(data, 1, data, 0, --size);
            return value;
        }
    }

    static class Entry implements Comparable<Entry> {
        long cost, cap;

        Entry(long cost, long cap) {
            this.cost = cost;
            this.cap = cap;
        }

        @Override
        public int compareTo(Entry o) {
            return Long.compare(o.cost, cost);
        }
    }

    static IntList[] children;

    static void solve() throws Exception {
        int n = scanInt();
        children = new IntList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new IntList();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanInt() - 1, b = scanInt() - 1, cap = scanInt(), cost = scanInt();
            children[a].push(b);
            children[a].push(cap);
            children[a].push(cost);
        }
        PriorityQueue<Entry> res = go(0);
        long ansCap = 0, ansCost = 0;
        for (Entry e = res.poll(); e != null; e = res.poll()) {
            ansCap += e.cap;
            ansCost += e.cap * (e.cost + retAdjCost);
        }
        if (ansCap != retTotalCap) {
            throw new AssertionError();
        }
        printCase();
        out.println(ansCap + " " + ansCost);
    }

    static long retTotalCap, retAdjCost;
    static PriorityQueue<Entry> go(int cur) {
        PriorityQueue<Entry> res = null;
        long resTotalCap = 0, resAdjCost = 0;
        IntList ch = children[cur];
        for (int i = 0; i < ch.size; i += 3) {
            int next = ch.data[i], cap = ch.data[i + 1], cost = ch.data[i + 2];
            PriorityQueue<Entry> nextRes = go(next);
            long nextTotalCap = retTotalCap, nextAdjCost = retAdjCost + cost;
            long insertCap = cap;
            if (nextRes != null) {
                while (!nextRes.isEmpty()) {
                    Entry e = nextRes.remove();
                    nextTotalCap -= e.cap;
                    if (e.cost + nextAdjCost >= cost) {
                        continue;
                    }
                    if (nextTotalCap < cap) {
                        e.cap = min(e.cap, cap - nextTotalCap);
                        nextTotalCap += e.cap;
                        nextRes.add(e);
                        break;
                    }
                }
                insertCap -= nextTotalCap;
                if (res == null) {
                    res = nextRes;
                    resTotalCap = nextTotalCap;
                    resAdjCost = nextAdjCost;
                } else {
                    if (nextRes.size() > res.size()) {
                        PriorityQueue<Entry> tempRes = res;
                        res = nextRes;
                        nextRes = tempRes;
                        long tempCap = resTotalCap;
                        resTotalCap = nextTotalCap;
                        nextTotalCap = tempCap;
                        long tempCost = resAdjCost;
                        resAdjCost = nextAdjCost;
                        nextAdjCost = tempCost;
                    }
                    for (Entry e = nextRes.poll(); e != null; e = nextRes.poll()) {
                        e.cost += nextAdjCost - resAdjCost;
                        res.add(e);
                    }
                    resTotalCap += nextTotalCap;
                }
            }
            if (insertCap != 0) {
                if (res == null) {
                    res = new PriorityQueue<>();
                }
                res.add(new Entry(cost - resAdjCost, insertCap));
                resTotalCap += insertCap;
            }
        }
        retTotalCap = resTotalCap;
        retAdjCost = resAdjCost;
        return res;
    }

    static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}