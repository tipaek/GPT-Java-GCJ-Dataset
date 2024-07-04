import java.util.*;
import java.io.*;

public class ParentingPartner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("parenting.in"));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numTasks = scanner.nextInt();
            List<Pair> cTasks = new ArrayList<>();
            List<Pair> jTasks = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder resultBuilder = new StringBuilder();
            
            for (int j = 0; j < numTasks; j++) {
                Pair task = new Pair(scanner.nextInt(), scanner.nextInt());
                
                if (hasOverlap(cTasks, task)) {
                    if (hasOverlap(jTasks, task)) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        jTasks.add(task);
                        resultBuilder.append("J");
                    }
                } else {
                    cTasks.add(task);
                    resultBuilder.append("C");
                }
            }
            
            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + resultBuilder.toString());
            }
        }
    }

    private static boolean hasOverlap(List<Pair> taskList, Pair newTask) {
        List<Pair> tempList = new ArrayList<>(taskList);
        tempList.add(newTask);
        tempList.sort(Comparator.comparingInt(Pair::getKey));
        
        for (int i = 1; i < tempList.size(); i++) {
            if (tempList.get(i - 1).getValue() > tempList.get(i).getKey()) {
                return true;
            }
        }
        return false;
    }
}

class Pair {
    private final int key;
    private final int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}