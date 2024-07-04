
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class Interval {
        int start, end;
        int work;

        public Interval(int start, int end, int work) {
            this.start = start;
            this.end = end;
            this.work = work;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        ArrayList<String> lists = new ArrayList<>();
        for (int j = 1; j <= t; j++) {
            int n = s.nextInt();
            List<Interval> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int S = s.nextInt();
                int E = s.nextInt();
                list.add(new Interval(S, E, i));
            }
            String ans = check(list, n);
            lists.add("case #" + j + ": " + ans);
        }
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
        s.close();
    }

    private static String check(List<Interval> list, int n) {

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        char[] arr=new char[n];
        int c=0,j=0;
        for (int i = 0; i <n ; i++) {
            int val=0;
            if (c<=list.get(i).start){
                c=list.get(i).end;
                val=list.get(i).work;
                arr[val]='C';
            }else if (j<=list.get(i).start){
                j=list.get(i).end;
                val=list.get(i).work;
                arr[val]='J';
            }else {
                return "IMPOSSIBLE";
            }
        }
        String val="";
        for(int i=0;i<arr.length;i++){
            val+=arr[i];
        }
        return val;
    }

}
