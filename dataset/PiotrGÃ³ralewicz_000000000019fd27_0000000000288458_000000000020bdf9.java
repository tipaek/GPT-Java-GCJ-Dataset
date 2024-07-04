
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
            boolean possible = true;

            // move all possible to C
            Node last = pq[0];
            last.nanny = 'C';
            for(int i = 1; i < N; i++){
                if(!pq[i].isOverlapping(last)){
                    last = pq[i];
                    last.nanny = 'C';
                }
            }

            // find first for J
            for(int i = 0; i < N; i++){
                if(pq[i].nanny != 'C'){
                    last = pq[i];
                    last.nanny = 'J';
                    break;
                }
            }

            // check if J can take care of left activities and move them to J
            if(last.nanny == 'J')
            for(int i = 1; i < N; i++){
                if(pq[i].nanny != 'C' && pq[i].nanny != 'J'){
                    if(pq[i].isOverlapping(last)){
                        possible = false;
                        break;
                    }else{
                        last = pq[i];
                        last.nanny = 'J';
                    }
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

        boolean isOverlapping(Node n){
            if(n.stop <= start || n.start >= stop) return false;
            return true;
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
