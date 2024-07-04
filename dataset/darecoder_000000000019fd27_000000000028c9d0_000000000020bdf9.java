import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Element implements Comparable<Element> {
    int start;
    int end;
    int index;

    public Element(int s, int e, int i) {
        this.start = s;
        this.end = e;
        this.index = i;

    }

    @Override
    public int compareTo(Element elt) {
        return this.start - elt.start;
    }
}

class Solution {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int testCase = 1;
        while (t-- > 0){
            int n = s.nextInt();
            ArrayList<Element> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Element elt = new Element(s.nextInt(), s.nextInt(), i);
                list.add(elt);
            }

            Collections.sort(list);
            solve(list,n,testCase++);
        }
    }

    public static void solve(ArrayList<Element> list, int n, int testCase){

        char[] ans = new char[n];
        int start = -1;
        int end = -1;
        int from = list.get(0).start;
        int to = list.get(0).end;

        ans[list.get(0).index]='C';
        boolean flag = true;

        for (int i = 1; i < n; i++) {

            int s = list.get(i).start;
            int e = list.get(i).end;

            if (s >= to || e<= from) {
                from = Math.min(s, from);
                to = Math.max(e, to);
                ans[list.get(i).index]='C';
            }

            else if (start == -1 && end == -1) {
                start =s;
                end = e;
                ans[list.get(i).index]='J';
            }

            else if (s >= end || e <= start) {
                start = Math.min(s, start);
                end = Math.max(e, end);
                ans[list.get(i).index]='J';
            }

            else {
                flag = false;
                break;
            }
        }

        String result = new String(ans);
        if (!flag) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}
