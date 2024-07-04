import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Solution {

    static void solve() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i=0;i<t;i++) {
            int n = scan.nextInt();
            List<Pair> pairs = new ArrayList<>(n);
            for (int j=0;j<n;j++) {
                int v1 = scan.nextInt();
                int v2 = scan.nextInt();
                Pair p = new Pair(v1, v2, j);
                pairs.add(p);
            }
            solveCase(i, n, pairs);
        }
    }

    static void solveCase(int t, int n, List<Pair>pairs) {
        pairs.sort(new PairComparator());
        String imp = "IMPOSSIBLE";
        int lastCEnd = -1;
        int lastJEnd = -1;
        char[] charr = new char[n];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<pairs.size();i++) {
            int end = pairs.get(i).end;
            int start = pairs.get(i).start;
            int index = pairs.get(i).index;
            if(lastCEnd <= start) {
                charr[index] = 'C';
                lastCEnd = end;
            }else if(lastJEnd <= start) {
                charr[index] = 'J';
                lastJEnd = end;
            }else{
                System.out.println("Case #" + (t+1) + ": " + imp);
                return;
            }
        }
        for(int i=0;i<n;i++) {
            sb.append(charr[i]);
        }
        System.out.println("Case #" + (t+1) + ": " + sb.toString());
    }


    public static void main(String[] args) {

        solve();

        //        Main m = new Main();
        //        Scanner scan = new Scanner(System.in);

        //        long n = scan.nextLong();
        //        long r = scan.nextLong();
        //        List<Long> list = new ArrayList<>();
        ////        int[] arr = new int[n];
        //        for (long i=0;i<n;i++){
        //            list.add(scan.nextLong());
        //        }
//            System.out.println(ch);
        //        solve(n, arr);
        //        scan.close();
    }


    static class Pair {
        int start;
        int end;
        int index;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }


    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.start>=o2.start) {
                return 1;
            }
            return -1;
        }
    }


//
//    class Counter extends HashMap<Integer, Integer> {
//        public int get(int k) {
//            return containsKey(k) ? super.get(k) : 0;
//        }
//
//        public void add(int k, int v) {
//            put(k, get(k) + v);
//        }
//    }



//    static class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
//    }

//    static class Node {
//        int key;
//        int data;
//        Node next;
//        Node prev;
//
//        Node(int key, int data) {
//            this.key = key;
//            this.data = data;
//        }
//    }

//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    static class Trie {
//        void add(String word) {
//
//        }
//
//        boolean search(String w) {
//            return false;
//        }
//    }
//
//    static class Node1 {
//        public int val;
//        public List<Node1> children;
//
//        public Node1() {
//        }
//
//        public Node1(int _val, List<Node1> _children) {
//            val = _val;
//            children = _children;
//        }
//    }
//
//    ;
//
//    static class TrieNode {
//
//    }
//
//    static class KvNode implements Comparable<KvNode> {
//        String key;
//        int freq;
//
//        public KvNode(String key, int freq) {
//            this.key = key;
//            this.freq = freq;
//        }
//
//        @Override
//        public int compareTo(KvNode o) {
//            if (this.key.equals(o.key)) {
//                return 0;
//            }
//            return Integer.compare(o.freq, this.freq);
//        }
//    }
//
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
}
