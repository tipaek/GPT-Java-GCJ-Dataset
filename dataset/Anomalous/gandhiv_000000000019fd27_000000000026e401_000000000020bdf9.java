import java.util.*;

class Pair implements Comparable<Pair> {
    private Integer id;
    private Integer start;
    private Integer finish;
    private Character name;

    Pair(int id, int start, int finish) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.name = 'N';
    }

    public void setName(Character name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getFinish() {
        return finish;
    }

    public Character getName() {
        return name;
    }

    @Override
    public int compareTo(Pair other) {
        return this.start.compareTo(other.start);
    }

    @Override
    public String toString() {
        return "" + name;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            List<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();
                pairs.add(new Pair(i + 1, start, finish));
            }

            List<Pair> sortedPairs = new ArrayList<>(pairs);
            Collections.sort(sortedPairs);

            List<Pair> assignedToC = new ArrayList<>();
            List<Pair> unassignedPairs = new ArrayList<>(sortedPairs);

            Pair firstPair = sortedPairs.get(0);
            firstPair.setName('C');
            assignedToC.add(firstPair);
            unassignedPairs.remove(firstPair);

            int lastIndexC = 0;
            for (int j = 1; j < n; j++) {
                if (sortedPairs.get(j).getStart() >= sortedPairs.get(lastIndexC).getFinish()) {
                    Pair currentPair = sortedPairs.get(j);
                    currentPair.setName('C');
                    assignedToC.add(currentPair);
                    unassignedPairs.remove(currentPair);
                    lastIndexC = j;
                }
            }

            if (!unassignedPairs.isEmpty()) {
                Pair firstUnassigned = unassignedPairs.get(0);
                firstUnassigned.setName('J');
                int lastIndexJ = 0;

                for (int j = 1; j < unassignedPairs.size(); j++) {
                    if (unassignedPairs.get(j).getStart() >= unassignedPairs.get(lastIndexJ).getFinish()) {
                        Pair currentPair = unassignedPairs.get(j);
                        currentPair.setName('J');
                        lastIndexJ = j;
                    }
                }
            }

            boolean impossible = false;
            for (Pair pair : sortedPairs) {
                if (pair.getName() == 'N') {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + caseNum + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Pair pair : pairs) {
                    System.out.print(pair.getName());
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}