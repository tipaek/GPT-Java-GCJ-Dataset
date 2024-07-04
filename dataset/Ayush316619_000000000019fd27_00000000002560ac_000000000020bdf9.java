
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[])throws Exception {
        InputStreamReader ab = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ab);

        int t = Integer.parseInt(in.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(in.readLine().trim());
            Data[] data = new Data[n];
            for (int i =0;i<n;i++) {
                String s[] = in.readLine().trim().split(" ");
                int start = Integer.parseInt(s[0]);
                int end= Integer.parseInt(s[1]);
                data[i] = new Data(start, end, i);
            }
            Arrays.sort(data, new DataSort());

            Data cam = new Data(data[0].start, data[0].end, data[0].index);
            boolean notPossible = false;

            Data jam = new Data(-1, -1, -1);

            char arr[] = new char[n];
            arr[cam.index] = 'C';
            for (int i=1;i<n;i++) {
                Data curr = data[i];
                int newStart = curr.start;
                int newEnd = curr.end;

                if (cam.end <= newStart) {
                    cam.start = newStart;
                    cam.end = newEnd;
                    arr[curr.index] = 'C';
                } else if (jam.start == -1) {
                    jam.start = newStart;
                    jam.end = newEnd;
                    arr[curr.index] = 'J';
                } else if (jam.end<=newStart) {
                    jam.start = newStart;
                    jam.end = newEnd;
                    arr[curr.index] = 'J';
                } else {
                    notPossible = true;
                    break;
                }

            }

            if(notPossible) {
                System.out.println("Case #" + tc + ": " + "IMPOSSIBLE" );
            } else {
                System.out.println("Case #" + tc + ": " + new String(arr) );
            }
        }
    }

    static  class Data {
        int start;
        int end;
        int index;
        public Data(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class DataSort implements Comparator<Data> {
        @Override
        public int compare(Data a, Data b) {
            if (a.end < b.end) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
