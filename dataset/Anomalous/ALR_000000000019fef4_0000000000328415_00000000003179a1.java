import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    static class Request {
        int M;
        String[] R;

        public Request(int m, String r) {
            this.M = m;
            this.R = r.split("");
        }

        @Override
        public String toString() {
            return "Request [M=" + M + ", R=" + Arrays.toString(R) + "]";
        }
    }

    static class RequestComparator implements Comparator<Request> {
        @Override
        public int compare(Request r1, Request r2) {
            return Integer.compare(r1.M, r2.M);
        }
    }

    static class Input {
        int U;
        Request[] requests = new Request[10000];

        public void addRequest(int m, String r, int index) {
            requests[index] = new Request(m, r);
        }

        @Override
        public String toString() {
            return "Input [U=" + U + ", requests=" + Arrays.toString(requests) + "]";
        }

        public void sortRequests() {
            Arrays.sort(requests, new RequestComparator());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            Input input = readInput(scanner);
            String solution = solve(input);
            System.out.println("Case #" + ks + ": " + solution);
        }
    }

    private static String solve(Input input) {
        String[] mapping = new String[10];
        Set<String> alphabet = new TreeSet<>();
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (Request request : input.requests) {
            if (request == null) break;
            alphabet.addAll(Arrays.asList(request.R));
            if (alphabet.size() >= 10) break;
        }

        for (String letter : alphabet) {
            frequencyMap.put(letter, 0);
        }

        for (Request request : input.requests) {
            if (request == null) break;
            if (request.R.length == input.U) {
                frequencyMap.put(request.R[0], frequencyMap.get(request.R[0]) + 1);
            }
        }

        List<Map.Entry<String, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort(Map.Entry.comparingByValue());

        for (int i = 0; i < frequencyList.size(); i++) {
            if (i == 0) {
                mapping[0] = frequencyList.get(i).getKey();
            } else {
                mapping[10 - i] = frequencyList.get(i).getKey();
            }
        }

        return String.join("", mapping);
    }

    private static Input readInput(Scanner scanner) {
        int U = scanner.nextInt();
        Input input = new Input();
        input.U = U;
        for (int i = 0; i < 10000; i++) {
            int m = scanner.nextInt();
            String r = scanner.next();
            input.addRequest(m, r, i);
        }
        input.sortRequests();
        return input;
    }
}