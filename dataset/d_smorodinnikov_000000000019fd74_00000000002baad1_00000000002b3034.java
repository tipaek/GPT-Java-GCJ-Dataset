import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class Solution {

    static void solve() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i=0;i<t;i++) {
            int n = scan.nextInt();
            String[] strs = new String[n];
            for (int j=0;j<n;j++) {
                strs[j] = scan.next();
            }
            solveCase(i, n, strs);
        }
    }

    static void solveCase(int t, int n, String[] strs) {
        Arrays.sort(strs, (a, b)->Integer.compare(a.length(), b.length()));
        String max = strs[strs.length-1];
        for (int i=0;i<strs.length-1;i++) {
            String s = strs[i];
            if(!isValid(max, s)) {
                System.out.println("Case #" + (t+1) + ": " + "*");
                return;
            }
        }
        System.out.println("Case #" + (t+1) + ": " + max.substring(1))  ;
    }

    static boolean isValid(String s, String candidate) {
        int ls = s.length()-1;
        int cl = candidate.length()-1;
        while (cl>0) {
            if(s.charAt(ls) != candidate.charAt(cl)) {
                return false;
            }
            cl--;
            ls--;
        }
        return true;
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
