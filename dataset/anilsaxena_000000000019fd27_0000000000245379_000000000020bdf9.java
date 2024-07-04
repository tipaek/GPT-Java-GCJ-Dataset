import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N;
    private static Slot[] slots;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            slots = new Slot[N];
            for(int i = 0; i < N; i++) {
                slots[i] = new Slot(sc.nextInt(), sc.nextInt());
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        Slot[] orginalSlots = Arrays.copyOf(slots, slots.length);
        Arrays.sort(slots, new Comparator<Slot>() {
            @Override
            public int compare(Slot o1, Slot o2) {
                return o1.start - o2.start;
            }
        });

        for(int i = 0; i < slots.length; i++){
            Slot slot = slots[i];
            for(int j = i + 1; j < slots.length; j++){
                Slot other = slots[j];
                if(other.start < slot.end) {
                    slot.childen.add(other);
                    other.childen.add(slot);
                }
            }
        }

        for(Slot slot: slots) {
            printDebug(slot + "\t" + slot.childen);
        }

        for(Slot slot: slots){
            if(slot.assignment == null) {
                slot.assignment = "C";
            }
            if(!visitSlot(slot)){
                return "IMPOSSIBLE";
            }
        }
        StringBuilder result = new StringBuilder();
        for(Slot slot: orginalSlots){
            result.append(slot.assignment);
        }
        return result.toString();
    }

    private static boolean visitSlot(Slot slot){
        for(Slot child: slot.childen){
           if(child.assignment == null){
               child.assignment = slot.assignment.equals("C") ? "J" : "C";
               visitSlot(child);
           }else{
               if(child.assignment.equals(slot.assignment)){
                   return false;
               }
           }
        }
        return true;
    }

    private static String joinValues(List<? extends Object> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        List<Object> list = new ArrayList<>();
        for (Object value : arr) {
            list.add(value);
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static int[] readInts(Scanner sc, int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    private static class Slot{
        String assignment;
        int start, end;
        Set<Slot> childen = new HashSet<>();
        public Slot(int start, int end){
            this.start = start;
            this.end = end;
        }

      /*  @Override
        public int compareTo(Slot o) {
            if(start == o.start){
                if(end == o.end){
                    return super.hashCode() - o.hashCode();
                }else{
                    return o.end - end;
                }
            }
            return start - o.start;
        }
*/
        @Override
        public String toString(){
            return start + "-" + end;
        }
    }

    public static void main(String[] args) throws Exception {
       // generateTestCases(100);
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }

    public static void generateTestCases(int count){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(count + "\n");
        for(int i = 0; i < count; i++){
            int N = 2 + rand.nextInt(9);
            builder.append(N + "\n");
            int start = 0;
            for(int j = 0; j < N; j++) {
                start = start + rand.nextInt(5);
                int end = start + 1 + rand.nextInt(5);
                builder.append(start + " " + end);
                builder.append("\n");
            }
        }
        try {
            FileWriter writer = new FileWriter("input.in");
            writer.write(builder.toString());
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
