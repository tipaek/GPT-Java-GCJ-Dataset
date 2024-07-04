import java.util.*;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }

public class Solution{

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int tc = sc.nextInt();
    
    for(int i=1;i<=tc;i++){
        
        int size = sc.nextInt();
        int endOfJ=0,startOfJ=0,endOfC = 0,startOfC=0;
     ArrayList<Interval> arr = new ArrayList<>();
     ArrayList<Interval> result = new ArrayList<>();
     StringBuilder sb = new StringBuilder();
     sb.append("J");
        for(int j=0;j<size;j++){
        Interval interval = new Interval(sc.nextInt(),sc.nextInt());
           arr.add(interval);
        
        }
    Collections.sort(arr, new IntervalComparator()); 
       result.add(arr.get(0));
       endOfJ = arr.get(0).end;
       startOfJ = arr.get(0).start;
       for(int j=1;j<size;j++){
          Interval r = arr.get(j);
          
        if(result.get(j-1).end>r.start){
              if(sb.charAt(j-1)=='J')
            sb.append("C");
            else
             sb.append("J");
             
             System.out.println(j);
            result.add(j,r);
          } 
          
       
           
       }
       System.out.println("Case #"+i+": "+sb.toString()); 
    }//main for loop
}
}//solution class end

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval i1, Interval i2)
    {
        return i1.start - i2.start;
    }
}