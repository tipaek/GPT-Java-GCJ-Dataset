
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder(); // string with final result
            int N = sc.nextInt(); // number of activities
            Node[] arr = new Node[N]; // array holding activities in order of input
            Node[] pq = new Node[N];

            for (int i = 0; i < N; i++) {
                Node n = new Node(sc.nextInt(), sc.nextInt());
                arr[i] = n;
                pq[i] = n;
            }

            qsort(pq, 0, N - 1);

            boolean possible = true; // bool
            Node a, b, c; // three latest activities
            boolean ccc = true; // who is currently parenting

            // first two activities
            b = pq[0];
            b.nanny = 'C';
            c = pq[1];
            if (b.stop > c.start) {
                // change nanny
                ccc = false;
                c.nanny = 'J';
            } else c.nanny = 'C';

            // analysing activities distribution
            for (int i = 2; i < N; i++) {
                a = b;
                b = c;
                c = pq[i];

                if (a.stop > c.start && b.stop > c.start) {
                    possible = false;
                    break;
                }

                if (b.stop > c.start) {
                    // we have to change nanny
                    ccc = !ccc;
                    if (ccc) c.nanny = 'C';
                    else c.nanny = 'J';
                } else {
                    // we don't have to change nanny
                    if (ccc) c.nanny = 'C';
                    else c.nanny = 'J';
                }
            }

            if (possible) {
                for (int i = 0; i < N; i++) sb.append(arr[i].nanny);
            } else {
                sb = new StringBuilder("IMPOSSIBLE");
            }


            System.out.println(String.format("Case #%d: %s", t, sb.toString()));
        }

    }

    private static class Node {
        int start, stop;
        char nanny;

        Node(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }

    private static void qsort(Node [] arr, int left, int right){
        int i = left, j = right;
        int v = arr[(i + j) / 2].start;

        do{
            while(arr[i].start < v) i++;
            while(arr[j].start > v) j--;

            if(i <= j){
                Node n = arr[i];
                arr[i] = arr[j];
                arr[j] = n;

                i++;
                j--;
            }
        }while(i <= j);

        if(left < j) qsort(arr, left, j);
        if(i < right) qsort(arr, i, right);
    }
}
