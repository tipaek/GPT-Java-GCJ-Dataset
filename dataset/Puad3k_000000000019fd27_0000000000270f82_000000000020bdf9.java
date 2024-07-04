import java.util.*;

public class Solution {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int totalTests = Integer.parseInt(input.nextLine());

        int counter = 0;
        while(counter < totalTests){
            int N = Integer.parseInt(input.nextLine());
            Map<Time,Integer> position = new HashMap<>();
            //Time [] arrayTimes = new Time [N];
            List<Time> times = new ArrayList<>();
            for (int i=0; i<N; i++){
                String[] row = input.nextLine().split(" ");
                Time t =new Time(row);
                times.add(t);
                // arrayTimes[i] = t;
                position.put(t,i);

            }
            times.sort(Comparator.naturalOrder());
            List<Time> cList = new ArrayList<>();
            List<Time> jList = new ArrayList<>();

            for(int t=0; t<2; t++){

                int j= 0;
                while (j<times.size()){

                    Time time = times.get(j);

                    if (checkList(time, cList)){
                        times.remove(time);
                        cList.add(time);
                    } else if(checkList(time, jList)){
                        times.remove(time);
                        jList.add(time);
                    } else{
                        break;
                    }


                }
            }

            if(cList.size() + jList.size()<N){
                System.out.printf("Case #%d: IMPOSSIBLE\n",counter+1);
            }else if(cList.size()+jList.size() == N){
                char[] cArr = new char [N];
                for(Time c: cList){
                    cArr[position.get(c)] = 'C';
                }
                for(Time j: jList){
                    cArr[position.get(j)] = 'J';
                }
                System.out.printf("Case #%d: %s\n", counter+1,new String(cArr));
            }

            counter++;
        }
    }

    private static boolean checkList(Time time, List<Time> list){
        boolean timeAllowed= true;
        if(list.isEmpty())
            return timeAllowed=true;

        for (Time t: list){
            if(time.overlap(t) || t.overlap(time)){
                timeAllowed = false;
                break;
            }
        }
        return timeAllowed;
    }

}
class Time implements  Comparable<Time>{
    long start;
    long end;

    public Time(long start, long end){
        this.start = start;
        this.end = end;
    }
    public Time(String start, String end){
        this(Long.parseLong(start), Long.parseLong(end));
    }
    public Time(String row[]){
        this(row[0],row[1]);
    }

    @Override
    public boolean equals (Object o){
        Time t = (Time)o;
        return this.start == t.start && this.end == t.end;
    }

    @Override
    public String toString(){
        return String.format("Time(start:%d, end:%d)",start, end);
    }

    public boolean overlap (Time t){
        //boolean overlap = this.start < t.end  && t.start < this.end;

        if(this.start== t.start && this.end == t.end){
            return true;
        }

        boolean overlap = (this.start < t.start && t.start < this.end)
                || (this.start < t.end && t.end <this.end)
                || (t.start <this.start && this.start<t.end )
                || (t.start < this.end && this.end <t.end);
        return overlap;
    }

    @Override
    public int compareTo(Time o) {

        if(Long.compare(this.start, o.start) == 0){
            return Long.compare(this.end, o.end);
        }

        return Long.compare(this.start,o.start);
    }
}