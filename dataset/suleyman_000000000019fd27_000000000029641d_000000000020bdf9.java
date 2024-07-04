import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int size = 1440;
    static int[] t = new int[size];
    static int[] cam = new int[size];
    static int[] jam = new int[size];
    static int N;
    static int T;
    static char[] order;

    static void print(int[] a) {
        for(int i=0; i<size; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    static String assign(Data[] data) {

        String imp = "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder(N);

        for(int i=0; i<N; i++) {    // each activity

            for(int j=data[i].start; j<data[i].end; j++) {  // possibility check

                t[j]++;
                if(t[j] > 2)
                    return imp;
            }

            boolean canCam = true;

            for(int j=data[i].start; j<data[i].end; j++) {  // try assigning to cameron

                cam[j]++;
                if(cam[j] > 1) {
                    canCam = false;
                    //break;
                }
            }

            if(canCam) {    // assign to cameron

                //sb.append('C');
                order[data[i].index] = 'C';
            }
            else {   // assign to jamie

                for(int j=data[i].start; j<data[i].end; j++) {

                    cam[j]--;   // remove cameron
                    jam[j]++;   // add jamie
                }

                //sb.append('J');
                order[data[i].index] = 'J';
            }

//            print(cam);
//            print(jam);
//            print(t);
//            System.out.println();
        }

        return String.valueOf(order);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for(int c=1; c<=T; c++) {    // each case

            for(int i=0; i<size; i++) {   // init time, cameron, and jamie
                t[i] = 0;
                cam[i] = 0;
                jam[i] = 0;
            }

            N = scanner.nextInt();
//            int[] s = new int[N];
//            int[] e = new int[N];
            Data[] data = new Data[N];
            order = new char[N];

            for(int i=0; i<N; i++) {    // each activity
                data[i] = new Data();
                //data[i].start = 0;
            }

            for(int i=0; i<N; i++) {    // each activity

                data[i].start = scanner.nextInt();
                data[i].end = scanner.nextInt();
                data[i].index = i;
            }

            Arrays.sort(data);

            String result = assign(data);
            System.out.println("Case #" + c + ": " + result);
        }
    }

    public static class Data implements Comparable<Data> {
        int start;
        int end;
        int index;

        public Data() {
            start = 0;
            end = 0;
        }

        @Override
        public int compareTo(Data data) {
            return this.start - data.start;
        }
    }
}
