import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();
        
        for(int i = 1; i <= totalTestCases; i++)
        {
            int totalIntervals = scanner.nextInt();
            
            List<Interval> intervalList = new ArrayList<>(totalIntervals);
            for(int j = 1; j <= totalIntervals; j++)
            {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervalList.add(new Interval(start, end));
            }
            
            String result = new ResultComputer(intervalList).compute();
            
            System.out.println(String.format("Case #%d: %s", i, result));
        }
    }
    
    private static class ResultComputer
    {
        private List<Interval> intervals;
        
        ResultComputer(List<Interval> intervals)
        {
            this.intervals = intervals;
        }
        
        String compute()
        {
            //note down each interval's initial positions
            Map<Interval,Integer> inputPositionsOfIntervals = new HashMap<>(intervals.size());
            
            for(int i = 0; i < intervals.size(); i++)
            {
                inputPositionsOfIntervals.put(intervals.get(i), i);
            }
            
//            System.out.println(inputPositionsOfIntervals);
    
            Collections.sort(intervals);
            
            int minAfterWhichJWillBeFree = 0;
            int minAfterWhichCWillBeFree = 0;
            
            Map<Interval,Character> parenting = new HashMap<>(intervals.size());
            
            for(int i = 0; i < intervals.size(); i++)
            {
                Interval interval = intervals.get(i);
                if(interval.start >= minAfterWhichJWillBeFree)
                {
                    parenting.put(interval, 'J');
                    minAfterWhichJWillBeFree = interval.end;
                }
                else if(interval.start >= minAfterWhichCWillBeFree)
                {
                    parenting.put(interval, 'C');
                    minAfterWhichCWillBeFree = interval.end;
                }
                else
                {
                    return "IMPOSSIBLE";
                }
            }
            
//            System.out.println(parenting);
            char[] resultArray = new char[intervals.size()];
    
            for(Map.Entry<Interval,Integer> entrySet : inputPositionsOfIntervals.entrySet())
            {
                int inputPosition = entrySet.getValue();
                Interval interval = entrySet.getKey();
                resultArray[inputPosition] = parenting.get(interval);
            }
            
            //should output with original intervals not with sorted intervals
            return new String(resultArray);
        }
    }
    
    private static class Interval implements  Comparable<Interval>
    {
        private int start;
        private int end;
        
        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    
        @Override
        public int compareTo(Interval other)
        {
            if(this.start < other.start)
            {
                return -1;
            }
            if(this.start > other.start)
            {
                return 1;
            }
            return Integer.compare(this.end, other.end);
        }
    
        @Override
        public boolean equals(Object o)
        {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
        
            Interval interval = (Interval)o;
        
            if(start != interval.start) return false;
            return end == interval.end;
        }
    
        @Override
        public int hashCode()
        {
            int result = start;
            result = 31*result + end;
            return result;
        }
    
        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("Interval{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }
}
