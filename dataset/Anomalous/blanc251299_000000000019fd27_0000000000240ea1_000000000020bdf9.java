import java.util.*;

class TimeSlot {
    int start, end;

    TimeSlot(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return this.start + " " + this.end;
    }
}

class FreeSlot {
    char person;
    int endTime;

    FreeSlot(char person, int endTime) {
        this.person = person;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.person + " " + this.endTime;
    }
}

public class Solution {

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
                timeSlots.add(new TimeSlot(start, scanner.nextInt()));
            }

            timeSlots.sort(Comparator.comparingInt(ts -> ts.start));

            int[] originalOrder = new int[n];
            for (int i = 0; i < startTimes.size(); i++) {
                for (int j = 0; j < timeSlots.size(); j++) {
                    if (startTimes.get(i) == timeSlots.get(j).start) {
                        originalOrder[i] = j;
                        break;
                    }
                }
            }

            List<Character> availablePersons = new ArrayList<>(Arrays.asList('C', 'J'));
            StringBuilder solution = new StringBuilder();
            List<FreeSlot> freeSlots = new ArrayList<>();

            for (TimeSlot timeSlot : timeSlots) {
                freeSlots.removeIf(freeSlot -> {
                    if (freeSlot.endTime <= timeSlot.start) {
                        availablePersons.add(freeSlot.person);
                        return true;
                    }
                    return false;
                });

                if (availablePersons.isEmpty()) {
                    solution = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    Collections.sort(availablePersons);
                    char assignedPerson = availablePersons.remove(0);
                    solution.append(assignedPerson);
                    freeSlots.add(new FreeSlot(assignedPerson, timeSlot.end));
                }
            }

            if (solution.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (t + 1) + ": " + solution);
            } else {
                StringBuilder finalSolution = new StringBuilder();
                for (int index : originalOrder) {
                    finalSolution.append(solution.charAt(index));
                }
                System.out.println("Case #" + (t + 1) + ": " + finalSolution);
            }
        }
    }
}