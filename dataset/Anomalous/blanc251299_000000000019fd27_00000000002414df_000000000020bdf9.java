import java.util.*;

class TimeSlot {
    int start, end;

    TimeSlot(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

class FreeSlot {
    char person;
    int availableAt;

    FreeSlot(char person, int availableAt) {
        this.person = person;
        this.availableAt = availableAt;
    }

    @Override
    public String toString() {
        return person + " " + availableAt;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            List<TimeSlot> timeSlots = new ArrayList<>();
            List<Integer> startTimes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                startTimes.add(start);
                TimeSlot timeSlot = new TimeSlot(start, scanner.nextInt());
                timeSlots.add(timeSlot);
            }

            timeSlots.sort(Comparator.comparingInt(t1 -> t1.start));

            int[] indexMapping = new int[n];
            for (int i = 0; i < startTimes.size(); i++) {
                for (int j = 0; j < timeSlots.size(); j++) {
                    if (startTimes.get(i) == timeSlots.get(j).start) {
                        indexMapping[i] = j;
                        break;
                    }
                }
            }

            List<Character> availablePersons = new ArrayList<>(Arrays.asList('C', 'J'));
            StringBuilder solution = new StringBuilder();
            List<FreeSlot> freeSlots = new ArrayList<>();

            for (TimeSlot timeSlot : timeSlots) {
                freeSlots.removeIf(freeSlot -> freeSlot.availableAt <= timeSlot.start);
                for (FreeSlot freeSlot : freeSlots) {
                    availablePersons.add(freeSlot.person);
                }

                if (availablePersons.isEmpty()) {
                    solution = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    availablePersons.sort(Comparator.naturalOrder());
                    char assignedPerson = availablePersons.remove(0);
                    solution.append(assignedPerson);
                    freeSlots.add(new FreeSlot(assignedPerson, timeSlot.end));
                }
            }

            if (solution.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (t + 1) + ": " + solution);
            } else {
                StringBuilder result = new StringBuilder();
                for (int index : indexMapping) {
                    result.append(solution.charAt(index));
                }
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        }
    }
}