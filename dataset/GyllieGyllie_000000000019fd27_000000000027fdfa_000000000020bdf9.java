import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int amountCases = in.nextInt();

        for (int i = 1; i <= amountCases; ++i) {
            int amountActivities = in.nextInt();

            List<Pair<Integer, Integer>> activities = new ArrayList<>();

            for (int t = 0; t < amountActivities; t++) {
                activities.add(new Pair<>(in.nextInt(), in.nextInt()));
            }

            activities.sort(Comparator.comparingInt(Pair::getKey));

            int jEnd = 0;
            int cEnd = 0;

            StringBuilder builder = new StringBuilder();

            for (Pair<Integer, Integer> activity : activities) {
                if (jEnd <= activity.getKey()) {
                    builder.append("J");
                    jEnd = activity.getValue();
                } else if (cEnd <= activity.getKey()) {
                    builder.append("C");
                    cEnd = activity.getValue();
                } else {
                    builder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + builder.toString());
        }
    }
}

class Pair<T1, T2> {

    private final T1 key;
    private final T2 value;

    public Pair (T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }
}