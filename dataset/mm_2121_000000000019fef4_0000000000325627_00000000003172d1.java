import java.util.*;
public class Solution {
    public static int maxFrequency(ArrayList<Long> list)
    {
        Set<Long> st = new HashSet<Long>(list);
        int max=0;
        for (Long s : st) {
            if (Collections.frequency(list, s) > max) {
                max = Collections.frequency(list, s);
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int z=1; z<=t; z++){
            int n=s.nextInt(), d=s.nextInt();
            ArrayList<Long> a=new ArrayList<Long>();
            for(int i=0; i<n; i++){
                a.add(s.nextLong());
            }
            if(d==1){
                System.out.println("Case #"+z+": 0");
                continue;
            }
            if(n==1){
                System.out.println("Case #"+z+": "+(d-1));
                continue;
            }
            Collections.sort(a);
            int max=maxFrequency(a);
            int cut=0;
            if(d==max){
                System.out.println("Case #"+z+": 0");
                continue;
            }
            long min=a.get(0);
            while(d!=0){
                if(a.get(0)==min){
                    d--;
                   a.remove(0);
                }
                else{
                    cut++;
                    d--;
                    a.set(0, a.get(0)-min);
                    if(a.get(0)<=0)
                        a.remove(0);
                }
            }
            System.out.println("Case #"+z+": "+cut);
        }
    }
}