import java.io.*;
import java.util.*;
public class Solution {

   public static void main(String[] args) {

      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

      int numberOfTests = in.nextInt();
      for (int n = 1; n <= numberOfTests; ++n) {
         List<Shift> shiftsList = new ArrayList<>();
         int numberOfActivities = in.nextInt();
         for (int i = 0; i < numberOfActivities; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if (start > end || start < 0 || start > 1440 || end > 1440 || start == end){
               throw new IllegalArgumentException("nonono!");
            }
            Shift shift = new Shift(start, end);
            shiftsList.add(shift);
         }
         List<Shift> modified = merge(shiftsList);
         if (isPossibleToCreateTheSchedule(modified)) {
            buildSchedule(modified);
            StringBuilder resultSchedule = new StringBuilder();
            shiftsList.forEach(shift -> {
               if (shift.getSubShifts() == null) {
                  resultSchedule.append(shift.getAssignedTo());
               } else {
                  shift.getSubShifts().forEach(subShift -> resultSchedule.append(subShift.getAssignedTo()));
               }
            });
            System.out.println("Case #" + n + ": " + resultSchedule.toString());
         } else {
            System.out.println("Case #" + n + ": " + "IMPOSSIBLE");
         }
      }
   }

   private static void buildSchedule(List<Shift> modified) {
      if (modified.size() == 1){
         modified.get(0).setAssignedTo(getRandomName());
         populateSubShifts(modified.get(0), modified.get(0).getAssignedTo());
      }

      for (int i = 0; i < modified.size(); i++) {
         for (int j = i + 1; j < modified.size(); j++) {
            if (modified.stream().noneMatch(shift -> shift.getAssignedTo() == null)) {
               return;
            }
            Shift one = modified.get(i);
            Shift another = modified.get(j);
            if (one.isOverlap(another) && one.getAssignedTo() == null && another.getAssignedTo() == null) {
               one.setAssignedTo(getRandomName());
               populateSubShifts(one, one.getAssignedTo());
               another.setAssignedTo(getReversed(one.getAssignedTo()));
               populateSubShifts(another, getReversed(one.getAssignedTo()));
            } else if (!one.isOverlap(another)) {
               one.setAssignedTo(one.getAssignedTo() == null ? getRandomName() : one.getAssignedTo());
               populateSubShifts(one, one.getAssignedTo());
               another.setAssignedTo(one.getAssignedTo());
               populateSubShifts(another, another.getAssignedTo());
            }
         }
      }
   }


   private static void populateSubShifts(Shift shift, String assignee){
      if (shift.getSubShifts() != null) {
         shift.getSubShifts().forEach(val -> val.setAssignedTo(assignee));
      }
   }

   private static String getReversed(String name){
      return "C".equals(name) ? "J" : "C";
   }

   private static String getRandomName(){
      String[] names={"C", "J"};
      int randomNumber=new Random().nextInt(names.length);
      return names[randomNumber];
   }

   private static List<Shift> merge(List<Shift> shiftsList) {
      List<Shift> modified = new ArrayList<>();
      shiftsList.forEach(shift -> {
         if (modified.isEmpty()) {
            modified.add(shift);
            return;
         }
         for (int i = 0; i < modified.size(); i++) {
            if (modified.get(i).getStart() == shift.getEnd() && !modified.get(i).isOverlap(shift)) {
               int newStart = shift.getStart();
               int newEnd = modified.get(i).getEnd();
               Shift newShift = new Shift(newStart, newEnd);
               newShift.setSubShifts(Arrays.asList(modified.get(i), shift));
               modified.set(i, newShift);
               return;
            } else if (modified.get(i).getEnd() == shift.getStart() && !modified.get(i).isOverlap(shift)) {
               int newStart = modified.get(i).getStart();
               int newEnd = shift.getEnd();
               Shift newShift = new Shift(newStart, newEnd);
               if (modified.get(i).getSubShifts() != null){
                  List<Shift> shifts = new ArrayList<>(modified.get(i).getSubShifts());
                  shifts.add(shift);
                  newShift.setSubShifts(shifts);
               } else {
                  newShift.setSubShifts(Arrays.asList(modified.get(i), shift));
               }
               modified.set(i, newShift);
               return;
            }
         }
         modified.add(shift);
      });
      return modified;
   }


   private static boolean isPossibleToCreateTheSchedule(List<Shift> shiftsList) {
      for (int i = 0; i < shiftsList.size(); i++) {
         int numberOfOverlaps = 0;
         for (int j = i + 1; j < shiftsList.size(); j++) {
            Shift one = shiftsList.get(i);
            Shift another = shiftsList.get(j);
            if (one.isOverlap(another) && !(one.getStart() == another.getEnd() || one.getEnd() == another.getStart())) {
               numberOfOverlaps++;
               if (numberOfOverlaps > 1) {
                  return false;
               }
            }
         }
      }
      return true;
   }

   static class Shift implements Comparable<Shift> {

      private int start;
      private int end;
      private String assignedTo;
      private List<Shift> subShifts;

      public Shift(int start, int end) {
         this.start = start;
         this.end = end;
      }

      public int getStart() {
         return start;
      }

      public Shift setStart(int start) {
         this.start = start;
         return this;
      }

      public int getEnd() {
         return end;
      }

      public Shift setEnd(int end) {
         this.end = end;
         return this;
      }

      boolean isOverlap(Shift anotherShift) {
         return start < anotherShift.end && anotherShift.start < end;
      }

      public List<Shift> getSubShifts() {
         return subShifts;
      }

      public Shift setSubShifts(List<Shift> subShifts) {
         this.subShifts = subShifts;
         return this;
      }

      public String getAssignedTo() {
         return assignedTo;
      }

      public Shift setAssignedTo(String assignedTo) {
         this.assignedTo = assignedTo;
         return this;
      }

      @Override
      public int compareTo(Shift o) {
         return start - o.start;
      }
   }

}
