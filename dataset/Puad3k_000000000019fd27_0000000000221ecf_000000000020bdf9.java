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

            for(int t=0; t<2; t++){

                char currentParent='J';
                if(t==0)
                    currentParent = 'J';
                else if(t==1)
                    currentParent = 'C';

                Time currentTimeChecker =null;
                if(times.size()>0){
                     currentTimeChecker = times.get(0);
                    map.put(currentTimeChecker,currentParent);
                    times.remove(0);
                }

                for (int j =0; j<times.size(); j++){

                    if(!currentTimeChecker.overlap(times.get(j))){
                        map.put(times.get(j),currentParent);
                        currentTimeChecker = times.get(j);
                        times.remove(j);
                        j--;
                    }
                }
            }

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