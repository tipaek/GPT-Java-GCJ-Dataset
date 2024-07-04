import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        long n = Long.parseLong(s.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] x = s.nextLine().split(" ");
            long nSlices = Long.parseLong(x[0]);
            long nPeople = Long.parseLong(x[1]);
            long[] slices = createArray(s.nextLine());
            Arrays.sort(slices);
            ArrayList<Slice> counts = new ArrayList<>();
            Slice sl = new Slice(slices[0], 1);
            counts.add(sl);
            for (int j = 1; j < slices.length; j++) {
                if(slices[j] == sl.size){
                    sl.count += 1;
                }
                else{
                    sl = new Slice(slices[j], 1);
                    counts.add(sl);
                }
            }
            Collections.sort(counts, new Comparator<Slice>() {
                @Override
                public int compare(Slice o1, Slice o2) {
                    if(o1.count == o2.count){
                        return (int)(o1.size-o2.size);
                    }
                    return (int)(o2.count-o1.count);
                }
            });
            for (int j = 0; j < counts.size(); j++) {
                Slice sli = counts.get(j);
                if(sli.count >= nPeople){
                    System.out.println("Case #" + i + ": " + 0);
                    break;
                }
                else if(nPeople-sli.count == 1){
                    System.out.println("Case #" + i + ": " + 1);
                    break;
                }
                else{
                    boolean found = false;
                    for (int k = j+1; k < counts.size(); k++) {
                        if(counts.get(k).size == sli.size * 2){
                            found = true;
                            break;
                        }
                        else if(counts.get(k).size > sli.size * 2){
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Case #" + i + ": " + 1);
                    }
                    else if(counts.size() == 1){
                        System.out.println("Case #" + i + ": " + 3);
                    }
                    else{
                        System.out.println("Case #" + i + ": " + 2);
                    }
                    break;
                }
            }

        }
        s.close();
    }
    public static long[] createArray(String s){
        String[] x = s.split(" ");
        long[] ret = new long[x.length];
        for(int i = 0; i < x.length; i++){
            ret[i] = Long.parseLong(x[i]);
        }
        return ret;
    }
    static class Slice{
        long size;
        long count;
        public Slice(long size, long count){
            this.size = size;
            this.count = count;
        }
    }
}
