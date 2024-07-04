import java.util.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int n = 1; n<=cases; n++){
            int activities = sc.nextInt();
            boolean possible = true;
            Interval[] all = new Interval[activities];
            Interval[] allSorted = new Interval[activities];
            Interval lastc = null, lastj = null;
            Interval_Comparator comparator = new Interval_Comparator();

            for(int i = 0; i < activities; i++){
                Interval temp = new Interval(sc.nextInt(), sc.nextInt());
                all[i] = temp;
                allSorted[i] = temp;
            }

            Arrays.sort(allSorted, comparator);

            for(int i = 0; i < activities; i++){
                if(checkPossible(allSorted[i],lastc)){
                    allSorted[i].madeBy = 'C';
                    lastc = allSorted[i];
                    continue;
                }
                if(checkPossible(allSorted[i],lastj)){
                    allSorted[i].madeBy = 'J';
                    lastj = allSorted[i];
                    continue;
                }
                possible = false;
                break;
            };

            String result;
            if(possible){
                StringBuilder builder = new StringBuilder(activities);
                for(int i = 0; i < activities; i++){
                    builder.append(all[i].madeBy);
                }
                result = builder.toString();
            }else{
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + n + ": " + result);
        }
    }

    public static boolean checkPossible(Interval interval, Interval last){
        if(last == null) return true;
        if(last.end > interval.start) return false;
        return true;
    }
}

class Interval{
    int start;
    int end;
    char madeBy;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Interval_Comparator implements Comparator<Interval>{
    public int compare(Interval int1, Interval int2) 
    { 
        if(int1.start == int2.start) return int1.end - int2.end;
        return int1.start - int2.start;
    }
}