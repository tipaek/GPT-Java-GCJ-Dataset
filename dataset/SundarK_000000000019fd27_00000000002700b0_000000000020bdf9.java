// coded by Krishna Sundar //

import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution {

    private static class Task {

        public int start;
        public int end;
        public int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return start == task.start &&
                    end == task.end &&
                    index == task.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, index);
        }
    }

    public void solve(Read input, Write output) throws Exception {
        int cases = input.readInt(), k=1;
        while (cases-->0) {
            int tasks = input.readInt();
            List<Task> task_list = new ArrayList<Task>();
            for (int i=0;i<tasks;i++) {
                task_list.add(new Task(input.readInt(), input.readInt(), i));
            }
            int[] result = new int[tasks];
            Collections.sort(task_list, new Comparator<Task>() {
                @Override
                public int compare(Task task1, Task task2) {
                    int result = Integer.compare(task1.start, task2.start);
                    if (result==0) {
                        result = Integer.compare(task1.end, task2.end);
                        if (result==0) {
                            result = Integer.compare(task1.index, task2.index);
                            return result;
                        } else {
                            return result;
                        }
                    } else {
                        return result;
                    }
                }
            });
            int c_endtime = -1, j_endtime = -1;
            boolean f = false;
            for (int i=0;i<tasks;i++) {
                int curr_starttime = task_list.get(i).start;
                int curr_endtime = task_list.get(i).end;
                int index = task_list.get(i).index;
                if (c_endtime<=curr_starttime) {
                    c_endtime = curr_endtime;
                    result[index] = 1;
                } else if (j_endtime<=curr_starttime) {
                    j_endtime = curr_endtime;
                    result[index] = 2;
                } else {
                    f = true;
                    break;
                }
            }
            if (f) {
                output.printLine("Case #"+k+": IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<tasks;i++) {
                    if (result[i]==1) {
                        sb.append('C');
                    } else {
                        sb.append('J');
                    }
                }
                output.printLine("Case #"+k+": "+sb.toString());
                output.flush();
            }
            k++;
        }
    }

    public static void main(String[] args) throws Exception {
        Read input = new Read();
        Write output = new Write();
        Solution D = new Solution();
        D.solve(input, output);
        output.flush();
        output.close();
    }

    // java fast io reader and writer
    // taken from various sources and customized

    static class Read {

        private byte[] buffer =new byte[10*1024];
        private int index;
        private InputStream input_stream;
        private int total;

        public Read() {
            input_stream = System.in;
        }

        public int read()throws IOException {
            if(total<0)
                throw new InputMismatchException();
            if(index>=total) {
                index=0;
                total= input_stream.read(buffer);
                if(total<=0)
                    return -1;
            }
            return buffer[index++];
        }

        public long readLong() throws IOException {
            long number=0;
            int n= read();
            while(isWhiteSpace(n))
                n= read();
            long neg=1l;
            if(n=='-') {
                neg=-1l;
                n= read();
            }
            while(!isWhiteSpace(n)) {
                if(n>='0'&&n<='9') {
                    number*=10l;
                    number+=(long)(n-'0');
                    n= read();
                }
                else throw new InputMismatchException();
            }
            return neg*number;
        }

        public int readInt() throws IOException {
            int integer=0;
            int n= read();
            while(isWhiteSpace(n))
                n= read();
            int neg=1;
            if(n=='-') {
                neg=-1;
                n= read();
            }
            while(!isWhiteSpace(n)) {
                if(n>='0'&&n<='9') {
                    integer*=10;
                    integer+=n-'0';
                    n= read();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }

        public double readDouble()throws IOException {
            double doub=0;
            int n= read();
            while(isWhiteSpace(n))
                n= read();
            int neg=1;
            if(n=='-') {
                neg=-1;
                n= read();
            }
            while(!isWhiteSpace(n)&&n!='.') {
                if(n>='0'&&n<='9') {
                    doub*=10;
                    doub+=n-'0';
                    n= read();
                }
                else throw new InputMismatchException();
            }

            if(n=='.') {
                n= read();
                double temp=1;
                while(!isWhiteSpace(n)) {
                    if(n>='0'&&n<='9') {
                        temp/=10;
                        doub+=(n-'0')*temp;
                        n= read();
                    }
                    else throw new InputMismatchException();
                }
            }
            return doub*neg;
        }

        public String readString()throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            while (!isWhiteSpace(n)) {
                sb.append((char)n);
                n = read();
            }
            return sb.toString();
        }

        private boolean isWhiteSpace(int n) {
            if(n==' '|| n=='\n'|| n=='\r'|| n=='\t'|| n==-1)
                return true;
            return false;
        }
    }

    static class Write {

        private final BufferedWriter bw;

        public Write() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(String str) throws IOException {
            bw.append(str);
        }
        public void printLine(String str) throws IOException {
            print(str);
            bw.append("\n");
        }
        public void close()throws IOException {
            bw.close();
        }
        public void flush()throws IOException {
            bw.flush();
        }
    }
}