import java.util.*;

public class Solution {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int totalTests = Integer.parseInt(input.nextLine());

        int counter = 0;
        while(counter < totalTests){
            int N = Integer.parseInt(input.nextLine());
            List<Time> times = new ArrayList<>();
            for (int i=0; i<N; i++){
                String[] row = input.nextLine().split(" ");
                    times.add(new Time(row));

            }
            times.sort(Comparator.naturalOrder());
            //System.out.println(times);
            Map<Time,Character> map = new HashMap<>();

            Time currentTime = times.get(0);
            char currentParent = 'C';
            int i=1;
            while (i<times.size()){
                if(!currentTime.overlap(times.get(i))){
                    Time formerTime = currentTime;
                    currentTime = times.get(i);
                    times.remove(formerTime);
                    map.put(formerTime,currentParent);
                    //System.out.println(times);
                    i--;
                }


                if(i==times.size()-1 && currentParent == 'C'){
                    currentParent = 'J';
                    Time formerTime = currentTime;
                    currentTime = times.get(0);
                    times.remove(formerTime);
                    map.put(formerTime,'C');
                    i=0;
                    //System.out.println(times);
                }else if(i==times.size()-1 && currentParent == 'J'){
                    if(currentTime.overlap(times.get(i))){
                        map.put(currentTime,'J');
                        times.remove(times.get(i));

                    }
                }
                else
                {
                    i++;
                  //  System.out.println(times);
                }

                //System.out.println("Current I :"+i);
            }
           // System.out.println(map);
            if(map.size()<N){
                System.out.printf("Case #%d: IMPOSSIBLE\n",counter+1);
            }else{
                StringBuilder builder =new StringBuilder();
                for(Character c: map.values()){
                    builder.append(c);
                }
                System.out.printf("Case #%d: %s\n", counter+1,builder.toString());
            }

            counter++;
        }
    }


}
class Time implements  Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end){
        this.start = start;
        this.end = end;
    }
    public Time(String start, String end){
        this(Integer.parseInt(start), Integer.parseInt(end));
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
        return this.end>t.start;
    }

    @Override
    public int compareTo(Time o) {
        return Integer.compare(this.start,o.start);
    }
}