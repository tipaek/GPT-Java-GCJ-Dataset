import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberInstances = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberInstances; ++i) {
                StringBuilder sb = new StringBuilder();
                String[] arguments = br.readLine().split(" ");
                int ranks = Integer.parseInt(arguments[0]);
                int suits = Integer.parseInt(arguments[1]);
                int[] allRanks = new int[ranks * suits];

                int currentRank = 1;
                for (int j = 0; j < ranks * suits; j++) {
                    allRanks[j] = currentRank;
                    currentRank = (currentRank % ranks) + 1;
                }

                currentRank = ranks - 1;
                int movedToFront = 0;
                if (currentRank == 1) movedToFront++;
                int counter = 0;
                for (int j = ranks * suits - 1; j >= 0; j--) {
                    if (allRanks[j] == currentRank && movedToFront < suits - 1) {
                        allRanks = reorder(allRanks, j, 1);
                        counter++;
                        sb.append("\n").append(j).append(" ").append(1);
                        movedToFront++;
                        j++;
                    } else if (allRanks[j] == currentRank && movedToFront == suits - 1) {
                        if (allRanks[j - 1] == currentRank - 1) {
                            allRanks = reorder(allRanks, j - 1, 2);
                            counter++;
                            movedToFront = 1;
                            sb.append("\n").append(j - 1).append(" ").append(2);
                        } else {
                            allRanks = reorder(allRanks, j, 1);
                            counter++;
                            movedToFront = 0;
                            sb.append("\n").append(j).append(" ").append(1);
                        }
                        currentRank--;
                        if (currentRank == 1) movedToFront++;
                        j = ranks * suits - 1;
                    }
                }
                System.out.println("Case #" + i + ": " + counter + sb.toString());
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] reorder(int[] allRanks, int a, int b) {
        int[] storage = new int[b];
        System.arraycopy(allRanks, a, storage, 0, b);
        System.arraycopy(allRanks, 0, allRanks, b, a);
        System.arraycopy(storage, 0, allRanks, 0, b);
        return allRanks;
    }
}