import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class QuerySuggestion {
    private final int index;
    private int value;

    public QuerySuggestion(int index) {
        this.index = index;
        this.value = 0;
    }

    public void addToValue(int value) {
        this.value += value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return Math.abs(value);
    }
}

class ProbableArray {
    private final Integer[] array;
    private boolean isEliminated;

    public ProbableArray(Integer[] array) {
        this.array = array;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public int getFirstNullPosition() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i + 1;
            }
        }
        return -1;
    }

    public ProbableArray getComplement() {
        Integer[] complementArray = array.clone();
        for (int i = 0; i < complementArray.length; i++) {
            if (complementArray[i] != null) {
                complementArray[i] = complementArray[i] == 0 ? 1 : 0;
            }
        }
        return new ProbableArray(complementArray);
    }

    public ProbableArray getReverse() {
        Integer[] reverseArray = array.clone();
        for (int i = 0, j = reverseArray.length - 1; i < j; i++, j--) {
            Integer temp = reverseArray[i];
            reverseArray[i] = reverseArray[j];
            reverseArray[j] = temp;
        }
        return new ProbableArray(reverseArray);
    }

    public ProbableArray getReverseComplement() {
        Integer[] reverseArray = array.clone();
        for (int i = 0, j = reverseArray.length - 1; i < j; i++, j--) {
            Integer temp = reverseArray[i];
            reverseArray[i] = reverseArray[j] == null ? null : (reverseArray[j] == 0 ? 1 : 0);
            reverseArray[j] = temp == null ? null : (temp == 0 ? 1 : 0);
        }
        return new ProbableArray(reverseArray);
    }

    public Integer get(int i) {
        return array[i - 1];
    }

    public void set(int j, int newValue) {
        array[j - 1] = newValue;
    }

    public void eliminate() {
        isEliminated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProbableArray that = (ProbableArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining());
    }
}

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;
    private static final Comparator<QuerySuggestion> byValue = Comparator.comparing(QuerySuggestion::getValue, Comparator.reverseOrder());

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = readInt();
        int B = readInt();

        for (int t = 1; t <= T; t++) {
            Set<ProbableArray> probableArrays = new HashSet<>();
            readFirstTenNumbers(B, probableArrays);

            int j = 11;
            while (j <= 150 && (probableArrays.size() != 1 || probableArrays.stream().anyMatch(pa -> pa.getFirstNullPosition() != -1))) {
                if (j % 10 == 1) {
                    addNewProbables(probableArrays);
                }

                List<ProbableArray> current = new ArrayList<>(probableArrays);
                int nextQuery = determineNextQuery(j, B, current);

                queryAndProcess(nextQuery, current);
                probableArrays = current.stream().filter(pa -> !pa.isEliminated()).collect(Collectors.toSet());
                j++;
            }

            for (ProbableArray array : probableArrays) {
                System.out.println(array);
                break;
            }
            System.out.flush();
            String result = nextLine();
            if (result.equals("N")) {
                break;
            }
        }
    }

    private static void addNewProbables(Set<ProbableArray> probableArrays) {
        List<ProbableArray> current = new ArrayList<>(probableArrays);
        for (ProbableArray arr : current) {
            addProbableArray(probableArrays, arr.getReverse());
            addProbableArray(probableArrays, arr.getComplement());
            addProbableArray(probableArrays, arr.getReverseComplement());
        }
    }

    private static void addProbableArray(Set<ProbableArray> probableArrays, ProbableArray newArray) {
        if (!probableArrays.contains(newArray)) {
            probableArrays.add(newArray);
        }
    }

    private static void readFirstTenNumbers(int b, Set<ProbableArray> probableArrays) throws IOException {
        Integer[] array = new Integer[b];
        for (int j = 1; j <= 10; j++) {
            System.out.println(j);
            System.out.flush();
            array[j - 1] = readInt();
        }
        probableArrays.add(new ProbableArray(array));
    }

    private static int determineNextQuery(int j, int b, List<ProbableArray> current) {
        if (j <= b) {
            return j;
        } else {
            Stack<QuerySuggestion> querySuggestions = new Stack<>();
            addSuggestions(querySuggestions, current, b);
            return querySuggestions.pop().getIndex();
        }
    }

    private static void addSuggestions(Stack<QuerySuggestion> querySuggestions, List<ProbableArray> current, int b) {
        List<QuerySuggestion> suggestions = new ArrayList<>();
        for (ProbableArray array : current) {
            if (array.isEliminated()) {
                continue;
            }
            for (int j = 1; j <= b; j++) {
                if (suggestions.size() < j) {
                    suggestions.add(new QuerySuggestion(j));
                }
                Integer value = array.get(j);
                if (value != null) {
                    suggestions.get(j - 1).addToValue(value == 0 ? -1 : 1);
                }
            }
        }
        suggestions.sort(byValue);
        querySuggestions.addAll(suggestions);
    }

    private static void queryAndProcess(int j, List<ProbableArray> current) throws IOException {
        System.out.println(j);
        System.out.flush();
        int newValue = readInt();
        for (ProbableArray array : current) {
            if (array.isEliminated()) {
                continue;
            }
            Integer value = array.get(j);
            if (value == null) {
                array.set(j, newValue);
            } else if (!value.equals(newValue)) {
                array.eliminate();
            }
        }
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException {
        String line = br.readLine();
        if (line == null) {
            exitImmediately();
        }
        st = null;
        return line;
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
        }
        return st.nextToken();
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }
}