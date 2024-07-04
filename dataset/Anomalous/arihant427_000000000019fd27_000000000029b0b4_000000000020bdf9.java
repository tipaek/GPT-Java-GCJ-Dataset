import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    class Nested {
        Integer sequence;
        int startTime;
        int endTime;
        String name;
        String assignTo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSequence() {
            return sequence;
        }

        public void setSequence(Integer sequence) {
            this.sequence = sequence;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public String getAssignTo() {
            return assignTo;
        }

        public void setAssignTo(String assignTo) {
            this.assignTo = assignTo;
        }
    }

    class Dto {
        Integer times;
        List<Nested> nested = new ArrayList<>();

        public Integer getTimes() {
            return times;
        }

        public void setTimes(Integer times) {
            this.times = times;
        }

        public List<Nested> getNested() {
            return nested;
        }

        public void setNested(List<Nested> nested) {
            this.nested = nested;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        List<Dto> dtoList = new ArrayList<>();
        Solution solution = new Solution();

        for (int i = 0; i < t; i++) {
            int size = scn.nextInt();
            Dto dto = solution.new Dto();
            dto.setTimes(size);

            for (int j = 0; j < dto.getTimes(); j++) {
                int startTime = scn.nextInt();
                int endTime = scn.nextInt();
                Nested nested = solution.new Nested();
                nested.setStartTime(startTime);
                nested.setEndTime(endTime);
                nested.setSequence(j);
                nested.setName(null);
                dto.getNested().add(nested);
            }
            dtoList.add(dto);
        }

        for (int i = 0; i < dtoList.size(); i++) {
            boolean isPossible = true;
            Dto dto = dtoList.get(i);
            List<Nested> arihant = new ArrayList<>();
            List<Nested> rajat = new ArrayList<>();

            dto.getNested().get(0).setName("C");
            arihant.add(dto.getNested().get(0));

            for (int j = 1; j < dto.getTimes(); j++) {
                Nested current = dto.getNested().get(j);
                if (!isValid(current, arihant)) {
                    if (isValid(current, rajat)) {
                        current.setName("J");
                        rajat.add(current);
                    }
                }
            }

            for (int j = 1; j < dto.getTimes(); j++) {
                Nested current = dto.getNested().get(j);
                if (current.getName() == null || current.getName().isEmpty()) {
                    if (isValid(current, arihant)) {
                        current.setName("C");
                        arihant.add(current);
                    } else if (isValid(current, rajat)) {
                        current.setName("J");
                        rajat.add(current);
                    } else {
                        System.out.println("CASE #" + (i + 1) + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                List<Nested> finalList = new ArrayList<>(arihant);
                finalList.addAll(rajat);
                finalList.sort(Comparator.comparing(Nested::getSequence));
                System.out.print("CASE #" + (i + 1) + ": ");
                finalList.forEach(data -> System.out.print(data.getName()));
                System.out.println();
            }
        }
    }

    static boolean isValid(Nested test, List<Nested> list) {
        int startTime = test.getStartTime();
        int endTime = test.getEndTime();
        for (Nested nested : list) {
            if (endTime > nested.getStartTime() && nested.getEndTime() > startTime) {
                return false;
            }
        }
        return true;
    }
}