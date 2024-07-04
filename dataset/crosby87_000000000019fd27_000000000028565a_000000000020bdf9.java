import java.util.*;

public class Solution {
    public static class Event{
        int start;
        int end;

        public Event (int a, int b){
            this.start = a;
            this.end = b;
        }
    }

    public static class sorter implements Comparator<Event>
    {
        public int compare(Event a, Event b)
        {
            if (a.start > b.start){
                return 1;
            }
            else return -1;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int a = 1; a <= T; a++){
            System.out.print("Case #" + a + ": ");
            int N = sc.nextInt();
            Event[] e = new Event[N];

            HashMap<Event, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                Event e1 = new Event(x, y);
                e[i] = e1;
                map.put(e1, i);
            }

            Arrays.sort(e, new sorter());


            ArrayList<Integer> c  = new ArrayList<>();
            ArrayList<Integer> j = new ArrayList<>();
            c.add(0);
            j.add(1);

            boolean works = true;

            for (int i = 2; i < N; i++){
                if (e[j.get(j.size()-1)].end <= e[i].start){
                    j.add(i);
                }
                else if (e[c.get(c.size()-1)].end <= e[i].start){
                    c.add(i);
                }
                else{
                    System.out.println("IMPOSSIBLE");
                    works = false;
                }
            }

            ArrayList<Event> ce  = new ArrayList<>();
            ArrayList<Event> je = new ArrayList<>();

            for (int i : c){
                ce.add(e[i]);
            }

            for (int i : j){
                je.add(e[i]);
            }

            c = new ArrayList<>();
            j = new ArrayList<>();

            for (Event i : ce){
                c.add(map.get(i));
            }

            for (Event i : je){
                j.add(map.get(i));
            }

            if (works){
                for (int i = 0; i < N; i++){
                    if (c.contains(i)){
                        System.out.print('C');
                    }
                    else{
                        System.out.print('J');
                    }
                }
                System.out.println();
            }




        }
    }
}
