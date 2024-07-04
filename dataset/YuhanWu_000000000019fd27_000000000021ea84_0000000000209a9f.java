import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Harry on 4/3/20.
 */
public class Solution {
    public static class Node{
        int v;
        String s;
        public Node(int v){
            this.v = v;
            this.s = ""+v;
        }
    }

    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = scanner.next();
            List<Node> list = new ArrayList<>();
            List<Node> nextList = new ArrayList<>();
            int maxVal = 0;
            for(char c : s.toCharArray()){
                int val = (int)(c-'0');
                list.add(new Node(val));
                maxVal = Math.max(maxVal, val);
            }

            while(maxVal>0){
                nextList.clear();
                int lo = 0;
                while(lo<list.size()){
                    int hi = lo;
                    while(hi<list.size() && list.get(hi).v==maxVal){
                        hi++;
                    }
                    if(hi>lo){
                        Node next = MergeAndLower(list, lo, hi);
                        nextList.add(next);
                        lo = hi;
                    }
                    else{
                        nextList.add(list.get(lo));
                        lo++;
                    }
                }
                maxVal--;
                List<Node> temp = list;
                list = nextList;
                nextList = temp;
            }
            System.out.println("Case #"+t+": "+list.get(0).s);
        }
    }

    public static Node MergeAndLower(List<Node> list, int lo, int hi){
        int curV = list.get(lo).v;
        StringBuilder sb = new StringBuilder();
        if(curV>0){
            sb.append('(');
        }
        for(int i=lo; i<hi; i++){
            sb.append(list.get(i).s);
        }
        if(curV>0){
            sb.append(')');
        }
        Node res = new Node(curV==0 ? 0 : curV-1);
        res.s=sb.toString();
        return res;
    }

}
