import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int[] arrivalTimes = new int[C];
        List<ArrivalInfo> timeInfo = new ArrayList<>();
        List<ArrivalInfo> rankInfo = new ArrayList<>();
        List<ArrivalInfo> combinedInfo = new ArrayList<>();

        rankInfo.add(new ArrivalInfo(1, 0, 0));

        for (int i = 2; i <= C; i++) {
            int input = scanner.nextInt();
            if (input >= 0) {
                timeInfo.add(new ArrivalInfo(i, input, -1));
            } else {
                rankInfo.add(new ArrivalInfo(i, -1, -input));
            }
        }

        Collections.sort(timeInfo);
        Collections.sort(rankInfo);

        int timePointer = 0;
        for (ArrivalInfo rank : rankInfo) {
            while (combinedInfo.size() < rank.rank) {
                combinedInfo.add(timeInfo.get(timePointer++));
            }
            combinedInfo.add(rank);
        }

        int currentTime = 0;
        for (int i = 0; i < C; i++) {
            if (combinedInfo.get(i).time == -1) {
                int start = i;
                while (i < C - 1 && combinedInfo.get(i + 1).time == -1
                        && combinedInfo.get(i + 1).rank == combinedInfo.get(start).rank) {
                    i++;
                }
                int end = i;
                for (int j = start; j <= end; j++) {
                    arrivalTimes[combinedInfo.get(j).id - 1] = currentTime;
                }
                currentTime++;
            } else {
                currentTime = combinedInfo.get(i).time;
                arrivalTimes[combinedInfo.get(i).id - 1] = currentTime;
                currentTime++;
            }
        }

        System.out.print("Case #" + caseId + ":");
        for (int i = 0; i < D; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int distance = Math.abs(arrivalTimes[u] - arrivalTimes[v]);
            if (distance == 0) {
                distance = 1;
            }
            System.out.print(" " + distance);
        }
        System.out.println();
    }

    private static class ArrivalInfo implements Comparable<ArrivalInfo> {
        int id;
        int time;
        int rank;

        ArrivalInfo(int id, int time, int rank) {
            this.id = id;
            this.time = time;
            this.rank = rank;
        }

        @Override
        public int compareTo(ArrivalInfo other) {
            if (this.time == -1) {
                return Integer.compare(this.rank, other.rank);
            }
            return Integer.compare(this.time, other.time);
        }

        @Override
        public String toString() {
            return "[" + id + "," + time + "," + rank + "]";
        }
    }
}