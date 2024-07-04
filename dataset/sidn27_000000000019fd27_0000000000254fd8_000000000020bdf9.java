import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    static class Task implements Comparable<Task> {
        int start;
        int end;
        char assignee;
        int index;

        public Task() {

        }

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public boolean overlaps2(Task t) {
            return t.start < this.end || this.start < t.end;
        }

        public boolean overlaps(Task t) {
            return between(this.start, this.end, t.start) || between(t.start, t.end, this.start);
        }

        private boolean between(int s, int e, int x) {
            return x > s && x <e;
        }

        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        outer: for(int i=1; i<=t; i++) {

            int n = in.nextInt();

            Task tasks[] = new Task[n];
            for(int x=0; x<n; x++) {
                int s = in.nextInt();
                int e = in.nextInt();
                tasks[x] = new Task(s, e, x);
            }

            Arrays.sort(tasks);

            char C = 'C';
            char J = 'J';

            ArrayList<Task> cTasks = new ArrayList<>();
            ArrayList<Task> jTasks = new ArrayList<>();
            
            int index = 0;
            Task currentTask = null;
            do {
                currentTask = tasks[index];
                currentTask.assignee = C;
                cTasks.add(currentTask);
                index++;
            }while(index<n && checkPossible(cTasks, currentTask));
            
            if(index != n) {
                tasks[index].assignee = J;
                jTasks.add(tasks[index]);
                for (int x = index + 1; x < n; x++) {
                    
                    boolean cPossible = checkPossible(cTasks, tasks[x]);
                    boolean jPossible = checkPossible(jTasks, tasks[x]);
                    if(!cPossible && !jPossible) {
                        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                        continue outer;
                    }
                    else if(jPossible && !cPossible) {
                        tasks[x].assignee = J;
                        jTasks.add(tasks[x]);
                    }
                    else {
                        tasks[x].assignee = C;
                        cTasks.add(tasks[x]);
                    }
                }
            }

            char outs[] = new char[n];
            for(int x=0; x<n; x++) {
                outs[tasks[x].index] = tasks[x].assignee;
            }
            String answer = new String(outs);

            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static boolean checkPossible(ArrayList<Task> tasks, Task t) {
        boolean ret = true;
        for(int x=0; x<tasks.size(); x++) {
            ret = ret && tasks.get(x).overlaps(t);
        }
        return ret;
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

}
