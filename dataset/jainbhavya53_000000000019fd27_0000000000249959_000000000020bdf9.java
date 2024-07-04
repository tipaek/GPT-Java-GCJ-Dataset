import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author bhavya.jain
 */
class Solution {
    public static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
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
            String temp = "";
            try {
                temp = br.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
            }
            return temp;
        }
    }

    public static PrintWriter out;

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<Course> courseList = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                Course tempCourse = new Course(in.nextInt(), in.nextInt(), j);
                courseList.add(tempCourse);
            }
            courseList.sort(new StartComparator());
            int counter = 0;
            boolean result = false;
            int cStart = -1;
            int jStart = -1;
            while (counter < n && !result) {
                Course currCourse = courseList.get(counter);
                if (cStart <= currCourse.start) {
                    cStart = currCourse.end;
                    currCourse.player = 'C';
                } else if (jStart <= currCourse.start) {
                    jStart = currCourse.end;
                    currCourse.player = 'J';
                } else {
                    result = true;
                }
                counter++;
            }
            if (result) {
                out.printf("Case #%d: IMPOSSIBLE\n", i + 1);
            } else {
                courseList.sort(new SeqComparator());
                StringBuilder sb = new StringBuilder();
                for (Course c : courseList) {
                    sb.append(c.player);
                }
                out.printf("Case #%d: %s\n", i + 1, sb.toString());
            }
        }
    }

    public static class Course {
        int start;
        int end;
        char player;
        int rowId;

        public Course(int start, int end, int rowId) {
            this.start = start;
            this.end = end;
            this.rowId = rowId;
        }
    }

    public static class SeqComparator implements Comparator<Course> {
        public int compare(Course c1, Course c2) {
            return Integer.compare(c1.rowId, c2.rowId);
        }
    }

    public static class StartComparator implements Comparator<Course> {
        public int compare(Course c1, Course c2) {
            int output = Integer.compare(c1.start, c2.start);
            if (output == 0) {
                return Integer.compare(c1.end, c2.end);
            }
            return output;
        }
    }
}
