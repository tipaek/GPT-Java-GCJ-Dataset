
import java.util.Scanner;

public class Solution {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            StringBuilder sb = new StringBuilder(); // string with final result
            int N = sc.nextInt(); // number of activities
            Node [] arr = new Node [N]; // array holding activities in order of input
            PQ pq = new PQ(N); // priority queue, holding activities in different order

            for(int i = 0; i < N; i++){
                Node n = new Node(sc.nextInt(), sc.nextInt());
                arr[i] = n;
                pq.push(n);
            }


            boolean possible = true; // bool
            Node a, b, c; // three latest activities
            boolean ccc = true; // who is currently parenting

            // first two activities
            b = pq.pop();
            b.nanny = 'C';
            c = pq.pop();
            if(b.stop > c.start){
                // change nanny
                ccc = false;
                c.nanny = 'J';
            }else c.nanny = 'C';

            // analysing activities distribution
            for(int i = 2; i < N; i++){
                a = b;
                b = c;
                c = pq.pop();

                if(a.stop > c.start && b.stop > c.start){
                    possible = false;
                    break;
                }

                if(b.stop > c.start){
                    // we have to change nanny
                    ccc = !ccc;
                    if(ccc) c.nanny = 'C';
                    else c.nanny = 'J';
                }else{
                    // we don't have to change nanny
                    if(ccc) c.nanny = 'C';
                    else c.nanny = 'J';
                }
            }

            if(possible){
                for(int i = 0; i < N; i++) sb.append(arr[i].nanny);
            }else{
                sb = new StringBuilder("IMPOSSIBLE");
            }


            System.out.println(String.format("Case #%d: %s", t, sb.toString()));
        }

    }


    private static class Node{
        int start, stop;
        char nanny;
        Node(int start, int stop){
            this.start = start;
            this.stop = stop;
        }
    }
    
    private static class PQ{
        // using MIN heap
        Node [] arr;
        int size;

        PQ(int N){
            arr = new Node [N];
            size = 0;
        }

        void push(Node n){
            arr[size] = n;
            bubbleUp(size++);
        }

        Node pop(){
            if(size < 0) return null;
            Node n = arr[0];
            arr[0] = arr[--size];
            arr[size] = null;
            bubbleDown(0);
            return n;
        }

        void bubbleUp(int index){
            int parent = getParentIndex(index);
            while (parent >= 0 && arr[parent].start > arr[index].start) {
                Node n = arr[parent];
                arr[parent] = arr[index];
                arr[index] = n;

                index = parent;
                parent = getParentIndex(index);
            }
        }

        void bubbleDown(int index){
            int left = getLeftChildIndex(index), right = getRightChildIndex(index);

            while (true) {
                if (left >= size) {
                    // node has no children
                    break;
                }
                else if (right >= size) {
                    // node has only one child

                    if (arr[left].start < arr[index].start) {
                        Node n = arr[left];
                        arr[left] = arr[index];
                        arr[index] = n;
                    }

                    break;
                }
                else {
                    // node has two children

                    if (arr[left].start < arr[right].start) {
                        if (arr[left].start < arr[index].start) {
                            Node n = arr[left];
                            arr[left] = arr[index];
                            arr[index] = n;

                            index = left;
                        }
                        else break;
                    }
                    else {
                        if (arr[right].start < arr[index].start) {
                            Node n = arr[right];
                            arr[right] = arr[index];
                            arr[index] = n;

                            index = right;
                        }
                        else break;
                    }

                    left = getLeftChildIndex(index);
                    right = getRightChildIndex(index);
                }
            }
        }

        int getParentIndex(int index){
            return (index - 1) / 2;
        }

        int getLeftChildIndex(int index){
            return index * 2 + 1;
        }

        int getRightChildIndex(int index){
            return index * 2 + 2;
        }
    }
}
