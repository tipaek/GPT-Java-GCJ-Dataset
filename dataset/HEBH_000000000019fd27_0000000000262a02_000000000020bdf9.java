
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houssem
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            LinkedList<Task> tl = new LinkedList();
            LinkedList<Task> tl2 = new LinkedList();
            LinkedList<Task> tl3 = new LinkedList();
            Task task;
//            Task[] tt = new Task[n];
//            Task[] tt2;

//            boolean test = false;
            for (int i = 0; i < n; i++) {
                tl.add(new Task(sc.nextInt(), sc.nextInt()));

            }
            tl2 = (LinkedList<Task>) tl.clone();
//            Arrays.sort(tt);

            tl.sort(new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.endTime - o2.endTime;
                }
            });
            if (!tl.isEmpty()) {
                task = tl.getFirst();
                task.doer = 'J';
                int previousEndTime = task.endTime;
                tl.remove(task);
                for (Task task1 : tl) {
                    if (task1.startTime >= previousEndTime) {
                        task1.doer = 'J';
                        previousEndTime = task1.endTime;
                        
                    }else{
                        tl3.add(task1);
                    }
                }
            }
            boolean test=true;
            if (!tl3.isEmpty()) {
                task = tl3.getFirst();
                task.doer = 'C';
                int previousEndTime = task.endTime;
                tl3.remove(task);
                for (Task task1 : tl3) {
                    if (task1.startTime >= previousEndTime) {
                        task1.doer = 'C';
                        previousEndTime = task1.endTime;
                    }else{
                        test=false;
                        break;
                    }
                }
            }
           if (test){
               String ch = "";
               for (Task task1 : tl2) {
                   ch=ch+task1.doer;
               }
               pw.println("Case #" + (t + 1) + ": " + ch);
           }else{
               pw.println("Case #" + (t + 1) + ": IMPOSSIBLE");
           }
            
//            for (int i = 0; i < n; i++) {
//                ch = ch + tt2[i].doer;
//
//            }
//            pw.println("Case #" + (t + 1) + ": " + ch);

//            pw.println("Case #" + (t + 1) + ": " + res);
        }
        pw.close();
        // TODO code application logic here
    }

    static class Task /*implements Comparable<Task>*/ {

        int startTime;
        int endTime;
        char doer;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

//        @Override
//        public int compareTo(Task o) {
//            return this.endTime >= o.endTime ? 1 : -1;
//        }
    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
