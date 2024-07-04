import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        printOutput(fio);
        fio.close();
    }

    public static void printOutput(FastIO fio) {
        Comparator<Task> comparator = new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                if(a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            }
        };
        List<Task> list;
        PriorityQueue<Task> q;

        int numTest = fio.nextInt();

        for(int i = 1; i <= numTest; i++) {
            list = getList(fio);
            q = getQueue(list, comparator);
            if(canDo(q)) {
                fio.println("Case #" + i + ": " + getString(list));
            } else {
                fio.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
    }

    public static List<Task> getList(FastIO fio) {
        List<Task> list = new ArrayList<>();
        int num = fio.nextInt();
        for(int i = 0; i < num; i++) {
            list.add(new Task(fio.nextInt(), fio.nextInt()));
        }
        return list;
    }

    public static PriorityQueue<Task> getQueue(List<Task> list, Comparator comparator) {
        PriorityQueue<Task> q = new PriorityQueue<>(list.size(), comparator);
        int size = list.size();
        for(int i = 0; i < size; i++) {
            q.add(list.get(i));
        }
        return q;
    }

    public static boolean canDo(PriorityQueue<Task> q) {
        int c = 0;
        int j = 0;

        while(q.size() != 0) {
            Task t = q.poll();

            if(t.start >= c) {
                t.parent = 'C';
                c = t.end;
            } else if (t.start >= j) {
                t.parent = 'J';
                j = t.end;
            } else {
                return false;
            }
        }

        return true;
    }

    public static String getString(List<Task> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for(int i = 0; i < size; i++) {
            sb.append(list.get(i).parent);
        }
        return sb.toString();
    }
}

class Task {
    int start;
    int end;
    char parent;

    Task(int a, int b) {
        start = a;
        end = b;
    }
}

class FastIO extends PrintWriter {

    BufferedReader br;

    StringTokenizer st;


    public FastIO() {

        super(new BufferedOutputStream(System.out));

        br = new BufferedReader(new

                InputStreamReader(System.in));

    }


    String next() {

        while (st == null || !st.hasMoreElements()) {

            try {

                st = new StringTokenizer(br.readLine());

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return st.nextToken();

    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}