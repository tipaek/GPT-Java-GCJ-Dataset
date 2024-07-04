import java.util.*;

public class Solution{
    static class Task{
        Integer s;
        Integer e;
        Integer p;
        public Task(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
    static class SortByS implements Comparator<Task>{
        public int compare(Task a, Task b){
            return (a.s.compareTo(b.s)==0) ? a.e.compareTo(b.e) : a.s.compareTo(b.s);
        }
    }
    static class Pair{
        int p;
        char c;
        public Pair(int p, char c){
            this.p = p;
            this.c = c;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int z=1; z<=T; z++){
            int n = in.nextInt();
            ArrayList<Task> arr = new ArrayList<>();
            for(int i=0; i<n; i++){
                int s = in.nextInt();
                int e = in.nextInt();
                arr.add(new Task(s, e, i));
            }
            Collections.sort(arr, new SortByS());
           /* for(int i=0; i<arr.size(); i++){
                System.out.println(arr.get(i).s + " " + arr.get(i).e);
            }*/
            boolean possible = true;
           // StringBuilder sb = new StringBuilder();
            ArrayList<Pair> pos = new ArrayList<>();
            Task t1=arr.get(0), t2=arr.get(1);
            //sb.append("CJ");
            pos.add(new Pair(arr.get(0).p, 'C'));
            pos.add(new Pair(arr.get(1).p, 'J'));
            int num =0, n1_end=Integer.MAX_VALUE, n2_end=Integer.MAX_VALUE, j=0;
            for(int i=2; i<arr.size(); i++){
                Task t = arr.get(i);
                if(t.s>=t1.e){
                    t1 = t;
                    pos.add(new Pair(t.p, 'C'));
                    continue;
                }else if(t.s>=t2.e){
                    t2 = t;
                    pos.add(new Pair(t.p, 'J'));
                    continue;
                }else{
                    possible = false;
                }
            }
            if(possible){
                char[] ans = new char[n];
                for(int i=0; i<pos.size(); i++){
                    Pair a = pos.get(i);
                    ans[a.p] = a.c;
                }
                String aa = new String(ans);
                System.out.println("Case #" + z + ": " + aa);
            }else{
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            }
        }
    }
}