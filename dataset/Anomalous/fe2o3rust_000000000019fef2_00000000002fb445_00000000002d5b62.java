import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numCases; i++) {
            CaseInputs inputs = readCase(reader);
            CaseOutputs outputs = processCase(inputs);
            printOutput(i + 1, outputs);
        }
    }

    private static CaseOutputs processCase(CaseInputs inputs) {
        StringBuilder result = new StringBuilder();
        CaseInputs tempLocation = new CaseInputs(inputs.x, inputs.y);

        if (bothEven(inputs) || bothOdd(inputs)) {
            return new CaseOutputs("IMPOSSIBLE");
        }

        while (!isZero(tempLocation)) {
            if (canMove(tempLocation, result, "E", -1, 0) ||
                canMove(tempLocation, result, "W", 1, 0) ||
                canMove(tempLocation, result, "N", 0, -1) ||
                canMove(tempLocation, result, "S", 0, 1)) {
                tempLocation = halve(tempLocation);
            } else {
                return new CaseOutputs("IMPOSSIBLE");
            }
        }

        return new CaseOutputs(result.toString());
    }

    private static boolean canMove(CaseInputs location, StringBuilder result, String direction, int dx, int dy) {
        if (dx != 0 && location.x % 2 == 0) return false;
        if (dy != 0 && location.y % 2 == 0) return false;

        CaseInputs changed = new CaseInputs(location.x + dx, location.y + dy);
        changed = halve(changed);

        if (isChanged(location, changed) && (isZero(changed) || (!bothOdd(changed) && !bothEven(changed)))) {
            result.append(direction);
            location.x += dx;
            location.y += dy;
            return true;
        }

        return false;
    }

    private static CaseInputs readCase(BufferedReader reader) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        return new CaseInputs(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }

    private static void printOutput(int caseNum, CaseOutputs outputs) {
        System.out.printf("Case #%d: %s%n", caseNum, outputs.result);
    }

    public static class CaseInputs {
        public int x;
        public int y;

        public CaseInputs() {
        }

        public CaseInputs(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class CaseOutputs {
        public String result;

        public CaseOutputs(String result) {
            this.result = result;
        }
    }

    private static boolean bothOdd(CaseInputs ci) {
        return ci.x % 2 != 0 && ci.y % 2 != 0;
    }

    private static boolean bothEven(CaseInputs ci) {
        return ci.x % 2 == 0 && ci.y % 2 == 0;
    }

    private static CaseInputs halve(CaseInputs ci) {
        return new CaseInputs(ci.x / 2, ci.y / 2);
    }

    private static boolean isZero(CaseInputs ci) {
        return ci.x == 0 && ci.y == 0;
    }

    private static boolean isChanged(CaseInputs ci1, CaseInputs ci2) {
        return ci1.x != ci2.x || ci1.y != ci2.y;
    }
}