
import java.util.*;
public class Solution {
    static class Interval {
        public int begin;
        public int end;
        public Interval(int b, int e) {
            this.begin = b;
            this.end = e;
        }
    }

    static class Node {
        public Interval i;
        public int end;
        public Node r, l;

        public Node(Interval i) {
            this.i = i;
            this.end = i.end;
            this.l = this.r = null;
        }

    }

    public static Node insert(Node root, Interval i) {
        if (root == null) {
            root = new Node(i);
            return root;
        }
        int low = root.i.begin;
        if (i.begin < low) {
            root.l = insert(root.l, i);
        } else {
            root.r = insert(root.r, i);
        }
        if (root.end < i.end) {
            root.end = i.end;
        }
        return root;
    }

    public static void inorder(Node root)
    {
        if (root == null) return;

        inorder(root.l);
        System.out.println("[" + root.i.begin + ", " + root.i.end
        + "] max = " + root.end);

        inorder(root.r);
    }

    public static boolean findoverlap(Node root, Interval i) {
        if (root == null) {
            return false;
        }
        if (isoverlapping(root.i, i)) {
            return true;
        }
        if (root.l != null && root.l.end >= i.begin) {
            return findoverlap(root.l, i);
        }
        return findoverlap(root.r, i);
    }

    public static boolean isoverlapping(Interval i1, Interval i2) {
        if ((i1.begin < i2.end && i2.begin < i1.end)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // intervals
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c=0;c<cases;c++) {
            int acount = sc.nextInt();
            Interval[] activities = new Interval[acount];
            ArrayList<Interval> reference = new ArrayList<>();
            char[] res = new char[acount];
            for (int a=0;a<acount;a++) {
                activities[a] = new Interval(sc.nextInt(), sc.nextInt());
                reference.add(activities[a]);
            }
//            Arrays.sort(activities, new Comparator<Interval>() {
//                public int compare(Interval i1, Interval i2) {
//                    if ((i1.end - i1.begin) > (i2.end - i2.begin)) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                }
//            });
            boolean impossible = false;
            Node ctree = null;
            Node jtree = null;
            for (Interval i : activities) {
//                System.out.println(i.end - i.begin);
                if (!findoverlap(ctree, i)) {
                    if (ctree == null) {
//                        System.out.println("ctree was null before");
                        ctree = new Node(i);
                    } else {
//                        System.out.println("ctree was not null before");
                        insert(ctree, i);
//                        System.out.println("ctree was not null before insert done");

                    }
                    int index = reference.indexOf(i);
                    String t = "C";
                    res[index] = t.charAt(0);
                } else if  (!findoverlap(jtree, i)){
                    if (jtree == null) {
                        jtree = new Node(i);
                    } else {
                        insert(jtree, i);
                    }
                    int index = reference.indexOf(i);
                    String t = "J";
                    res[index] = t.charAt(0);
                } else {
                    impossible = true;
                    break;
                }
            }
//            inorder(ctree);
//            inorder(jtree);
            if (impossible) {
                System.out.println("Case #" + (c+1) + ": " + "IMPOSSIBLE");
            } else {
                String r = new String(res);
                System.out.println("Case #" + (c+1) + ": " + r);
            }

        }
    }

}
