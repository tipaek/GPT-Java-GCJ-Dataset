import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class QuerySoggestion {
    private final int index;

    public void addToValue(int value) {
        this.value += value;
    }

    private int value;

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value > 0 ? value : -1 * value;
    }

    QuerySoggestion(int index) {
        this.index = index;
        value = 0;
    }
}

class ProbableArray {
    private final Integer[] array;

    public boolean isEliminated() {

        return isEliminated;
    }

    private boolean isEliminated;

    public ProbableArray(Integer[] array) {
        this.array = array;
    }

    public int getFirstNullPosition() {
        for (int i = 0; i < array.length; i++)
            if (array[i] == null)
                return i + 1;
        return -1;
    }

    public ProbableArray getComplement() {
        Integer[] complementArray = array.clone();
        for (int i = 0; i < complementArray.length; i++) {
            if (complementArray[i] != null)
                complementArray[i] = complementArray[i] == 0 ? 1 : 0;
        }
        return new ProbableArray(complementArray);
    }

    public ProbableArray getReverse() {
        Integer[] reverseArray = array.clone();
        Integer temp;
        for (int i = 0, j = reverseArray.length - 1; i < j; i++, j--) {
            temp = reverseArray[i];
            reverseArray[i] = reverseArray[j];
            reverseArray[j] = temp;
        }
        return new ProbableArray(reverseArray);
    }

    public ProbableArray getReverseComplement() {
        Integer[] reverseArray = array.clone();
        Integer temp;
        for (int i = 0, j = reverseArray.length - 1; i < j; i++, j--) {
            temp = reverseArray[i];
            if (reverseArray[j] == null)
                reverseArray[i] = null;
            else
                reverseArray[i] = reverseArray[j] == 0 ? 1 : 0;
            if (temp == null)
                reverseArray[j] = null;
            else
                reverseArray[j] = temp == 0 ? 1 : 0;
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
        ProbableArray array1 = (ProbableArray) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : array) {
            sb.append(i);
        }
        return sb.toString();
    }
}

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;
    private static Comparator<QuerySoggestion> byValue = Comparator.comparing(QuerySoggestion::getValue, Comparator.reverseOrder());

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = readInt();
        int B = readInt();

        String result;
        int j, newValue;
        int nextQuery = 0;
        Stack<QuerySoggestion> querySoggestions = new Stack<>();
        List<ProbableArray> current = new ArrayList<>();
        Set<ProbableArray> probableArrays = new HashSet<>();
        for (int t = 1; t <= T; t++) {
            readFirstTenNumbers(B, probableArrays);
            j = 11;
            while (j <= 150 && (probableArrays.size() != 1 || probableArrays.stream().anyMatch(pa -> pa.getFirstNullPosition() != -1))) {
                if (j % 10 == 1) {
                    addNewProbables(probableArrays);
                    querySoggestions.clear();
                }
                current = probableArrays.stream().collect(Collectors.toList());
                if (j <= B) {
                    nextQuery = j;
                } else {
                    if (querySoggestions.isEmpty()) {
                        addSuggestions(querySoggestions, current, B);
                    }
                    nextQuery = querySoggestions.pop().getIndex();
                }


                queryAndProcess(nextQuery, current);
                probableArrays = current.stream().filter(pa -> !pa.isEliminated()).collect(Collectors.toSet());
                j++;

            }
            for (ProbableArray array : probableArrays) {
                System.out.println(array);
                break;
            }
            System.out.flush();
            result = nextLine();
            if (result.equals("N"))
                break;
        }
    }

    private static void addNewProbables(Set<ProbableArray> probableArrays) {
        List<ProbableArray> current = probableArrays.stream().collect(Collectors.toList());
        for (ProbableArray arr : current) {
            ProbableArray reverse = arr.getReverse();
            if (!probableArrays.contains(reverse))
                probableArrays.add(reverse);
            ProbableArray compliment = arr.getComplement();
            if (!probableArrays.contains(compliment))
                probableArrays.add(compliment);
            ProbableArray reverseCompliment = arr.getReverseComplement();
            if (!probableArrays.contains(reverseCompliment))
                probableArrays.add(reverseCompliment);

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

    private static void addSuggestions(Stack<QuerySoggestion> querySuggestions, List<ProbableArray> current, int b) {
        List<QuerySoggestion> suggestions = new ArrayList<>();
        for (int i = 0; i < current.size(); i++) {
            if (current.get(i).isEliminated())
                continue;
            for (int j = 1; j <= b; j++) {
                if (suggestions.size() < j)
                    suggestions.add(new QuerySoggestion(j));
                if(current.get(i).get(j)!=null)
                    suggestions.get(j - 1).addToValue(current.get(i).get(j) == 0 ? -1 : 1);
            }
        }
        suggestions.sort(byValue);
        querySuggestions.addAll(suggestions);
    }

    private static void queryAndProcess(int j, List<ProbableArray> current) throws IOException {
        int newValue;
        System.out.println(j);
        System.out.flush();
        newValue = readInt();
        for (ProbableArray arr : current) {
            if (arr.isEliminated())
                continue;
            if (arr.get(j) == null) {
                arr.set(j, newValue);
                continue;
            }
            if (arr.get(j) != newValue)
                arr.eliminate();
        }
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException {
        String s = br.readLine();
        if (s == null) {
            exitImmediately();
        }
        st = null;
        return s;
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
        }
        return st.nextToken();
    }

}