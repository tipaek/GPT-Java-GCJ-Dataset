    import java.util.*;
    import java.io.*;
    public class Solution {
          static class Interval{
        int begin;
        int end;
        Interval(int begin, int end){
            this.begin= begin;
            this.end = end;
        }
        public String toString(){
            return "["+begin + " "+ end+"]";
        }
    }
    static String divideIntervals(List<Interval> list)
    {
        ArrayList<Interval> sortedList = new ArrayList<>();
        sortedList.addAll(list);

        Collections.sort(sortedList, Comparator.comparingInt(t -> t.end));

        ArrayList<Interval> list1 = new ArrayList();
        HashSet<Interval> set = new HashSet<>();
        ArrayList<Interval> list2 = new ArrayList();

        int r1 = sortedList.get(0).end;
        list1.add(sortedList.get(0));
        set.add(sortedList.get(0));

        for (int i = 1; i < sortedList.size(); i++) {
            int l1 = sortedList.get(i).begin;
            int r2 = sortedList.get(i).end;
            if (l1 >= r1) {
                list1.add(sortedList.get(i));
                set.add(sortedList.get(i));
                r1 = r2;
            }else{
                if(list2.size() == 0 || l1 >= list2.get(list2.size()-1).end)
                    list2.add(sortedList.get(i));
                else {
                    return "IMPOSSIBLE";
                }
            }
        }

        String output ="";
        for(int i=0; i<list.size(); i++){
            if(set.contains(list.get(i))){
                output+="C";
            }else{
                output+="J";
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++){
            int count = scanner.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();
            for(int j=0; j<count; j++)
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            System.out.println("Case #"+(i+1)+": " +divideIntervals(intervals));
        }
    }
    }
      