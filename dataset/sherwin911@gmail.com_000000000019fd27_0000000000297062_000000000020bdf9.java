import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        List<List<SchedulingSlot>> inputs = new ArrayList<List<SchedulingSlot>>();
        for (int i = 0; i < testcases; i++) {
            int numOfSlots = sc.nextInt();
            List<SchedulingSlot> slots = new ArrayList<SchedulingSlot>();
            for(int j = 0; j < numOfSlots ; j++){
                slots.add(new SchedulingSlot(sc.nextInt(),sc.nextInt(), j)) ;
            }
            inputs.add(slots);
        }
        sc.close();
        int count = 1;
        for (List<SchedulingSlot> input : inputs) {
            System.out.println("Case #" + count++ + ": " + solve(input));
        }
    }
    public static String solve(List<SchedulingSlot> slots){
        Collections.sort(slots);
        SchedulingSlot assignedToC = null;
        SchedulingSlot assignedToJ = null;
        boolean isJFree = true;

        for(SchedulingSlot slot : slots){
            if(assignedToC == null || !assignedToC.isOverlapping(slot) ){
                slot.setAssigned("C");
                assignedToC = slot;
            }else if(assignedToJ == null || !assignedToJ.isOverlapping(slot) ){
                slot.setAssigned("J");
                assignedToJ = slot;
            }else{
                return "IMPOSSIBLE";
            }

            //System.out.println(slot.toString());
        }
        Collections.sort(slots,SchedulingSlot.SchedulingSlotComparator);
        StringBuilder builder = new StringBuilder();
        for(SchedulingSlot slot : slots){
            builder.append(slot.assigned);
        }
        return builder.toString();
    }
}
class SchedulingSlot implements Comparable<SchedulingSlot>{
    int startTime;
    int endTime;
    Integer order;
    String assigned;

    public SchedulingSlot(int startTime, int endTime, int order){
        this.startTime = startTime;
        this.endTime = endTime;
        this.order = order;
    }

    public String toString(){
        return this.startTime + " " + this.endTime;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getAssigned() {
        return assigned;
    }

    public boolean isOverlapping(SchedulingSlot schedulingSlot){
        return (this.startTime <= schedulingSlot.startTime && this.endTime > schedulingSlot.startTime);
    }

    @Override
    public int compareTo(SchedulingSlot schedulingSlot) {
        return this.startTime - schedulingSlot.startTime;
    }

    public static Comparator<SchedulingSlot> SchedulingSlotComparator
            = new Comparator<SchedulingSlot>() {

        @Override
        public int compare(SchedulingSlot schedulingSlot, SchedulingSlot t1) {
            return schedulingSlot.order.compareTo(t1.order);
        }
    };
}



