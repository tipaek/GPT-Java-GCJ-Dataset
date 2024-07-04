import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int size = sc.nextInt();
            int[][] lines = new int[size][2];
            int[][] sorted = lines.clone();
            char person = 'J';
            char[] chars = new char[size];
            Stack<int[]> j = new Stack<>();
            Stack<int[]> c = new Stack<>();
            boolean imp = false;

            Map<int[], Integer> map = new HashMap<>();

            for (int a = 0; a < size; a++) {
                lines[a][0] = sc.nextInt();
                lines[a][1] = sc.nextInt();
                map.put(lines[a], a);
            }
            Arrays.sort(sorted, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            for(int a = 0; a < sorted.length; a++){
                chars[map.get(sorted[a])] = person;


                if(a < sorted.length - 1 && doesOverlap(sorted[a], sorted[a+1])){
                    if(person == 'J'){
                        j.push(sorted[a]);
                        person = getPerson(person);

                        if(!c.isEmpty() && doesOverlap(c.peek(), sorted[a+1])){
                            imp = true;
                            break;
                        }
                    }else{
                        c.push(sorted[a]);
                        person = getPerson(person);

                        if(!j.isEmpty() && doesOverlap(j.peek(), sorted[a+1])){
                            imp = true;
                            break;
                        }
                    }
                }else{
                    if(person == 'J'){
                        j.push(sorted[a]);
                    }else {
                        c.push(sorted[a]);
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + (imp ? "IMPOSSIBLE" : new String(chars)));
        }
    }
    private static char getPerson(char p){
        return  p == 'J' ? 'C' : 'J';
    }

    public static boolean doesOverlap(int[] a, int[] b){
        return a[1] > b[0];
    }
}

