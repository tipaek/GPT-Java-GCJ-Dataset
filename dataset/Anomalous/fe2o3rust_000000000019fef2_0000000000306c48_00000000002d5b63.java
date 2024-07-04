import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int numCases = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        for (int i = 0; i < numCases; i++) {
            processCase(A, B);
        }
    }

    private static void processCase(int A, int B) throws IOException {
        State state = new State(A, B);

        for (int i = 0; i < 300; i++) {
            makeQuery(state);
            sendQuery(state);
            if (isComplete(state)) {
                break;
            }
        }
    }

    private static boolean isComplete(State state) {
        return "CENTER".equals(state.getLastQuery().getResponse());
    }

    private static void makeQuery(State state) {
        Query query = new Query();

        if (!state.hasAnyHits()) {
            if (state.getQueries().size() >= state.numTriesInScan()) {
                query.setX(1);
                query.setY(1);
            } else {
                int trialNum = state.getQueries().size() + 1;
                query.setX(state.getXForScan(trialNum));
                query.setY(state.getYForScan(trialNum));
            }
        } else {
            state.updateBoxesIfNeeded();
            if (state.areBoxesSame()) {
                query.setX(state.getInnerBox().getCenterX());
                query.setY(state.getInnerBox().getCenterY());
            } else {
                query.setX(state.getNextQueryX());
                query.setY(state.getNextQueryY());
            }
        }

        state.addQuery(query);
    }

    private static void sendQuery(State state) throws IOException {
        Query query = state.getLastQuery();
        System.out.println(query.getX() + " " + query.getY());
        query.setResponse(reader.readLine());
    }

    public static class Query {
        private int x;
        private int y;
        private String response;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }

    public static class Box {
        private int minx;
        private int miny;
        private int maxx;
        private int maxy;

        public int getMinx() {
            return minx;
        }

        public void setMinx(int minx) {
            this.minx = minx;
        }

        public int getMiny() {
            return miny;
        }

        public void setMiny(int miny) {
            this.miny = miny;
        }

        public int getMaxx() {
            return maxx;
        }

        public void setMaxx(int maxx) {
            this.maxx = maxx;
        }

        public int getMaxy() {
            return maxy;
        }

        public void setMaxy(int maxy) {
            this.maxy = maxy;
        }

        public int getCenterX() {
            return minx + (maxx - minx) / 2;
        }

        public int getCenterY() {
            return miny + (maxy - miny) / 2;
        }
    }

    public static class State {
        private final int A;
        private final int B;
        private final List<Query> queries = new ArrayList<>();
        private Box outerBox;
        private Box innerBox;
        private boolean hitYet;

        public State(int A, int B) {
            this.A = A;
            this.B = B;
        }

        public List<Query> getQueries() {
            return queries;
        }

        public void addQuery(Query query) {
            queries.add(query);
        }

        public Query getLastQuery() {
            return queries.get(queries.size() - 1);
        }

        public boolean hasAnyHits() {
            if (!hitYet) {
                hitYet = queries.stream().anyMatch(q -> "HIT".equals(q.getResponse()));
            }
            return hitYet;
        }

        public void updateBoxesIfNeeded() {
            if (innerBox == null) {
                makeInitialInnerBox();
            }
            if (outerBox == null) {
                makeInitialOuterBox();
            }
        }

        public boolean areBoxesSame() {
            return innerBox.getMinx() == outerBox.getMinx() &&
                   innerBox.getMiny() == outerBox.getMiny() &&
                   innerBox.getMaxx() == outerBox.getMaxx() &&
                   innerBox.getMaxy() == outerBox.getMaxy();
        }

        public void makeInitialOuterBox() {
            List<Query> hits = getFilteredQueries("HIT");
            List<Query> misses = getFilteredQueries("MISS");

            outerBox = new Box();
            outerBox.setMinx(getBoundary(misses, hits, Comparator.comparing(Query::getX), true));
            outerBox.setMiny(getBoundary(misses, hits, Comparator.comparing(Query::getY), true));
            outerBox.setMaxx(getBoundary(misses, hits, Comparator.comparing(Query::getX), false));
            outerBox.setMaxy(getBoundary(misses, hits, Comparator.comparing(Query::getY), false));
        }

        public void makeInitialInnerBox() {
            List<Query> hits = getFilteredQueries("HIT");

            innerBox = new Box();
            innerBox.setMinx(hits.stream().min(Comparator.comparing(Query::getX)).get().getX());
            innerBox.setMiny(hits.stream().min(Comparator.comparing(Query::getY)).get().getY());
            innerBox.setMaxx(hits.stream().max(Comparator.comparing(Query::getX)).get().getX());
            innerBox.setMaxy(hits.stream().max(Comparator.comparing(Query::getY)).get().getY());
        }

        private List<Query> getFilteredQueries(String response) {
            return queries.stream().filter(q -> response.equals(q.getResponse())).collect(Collectors.toList());
        }

        private int getBoundary(List<Query> misses, List<Query> hits, Comparator<Query> comparator, boolean isMin) {
            List<Query> sortedMisses = new ArrayList<>(misses);
            sortedMisses.sort(comparator);

            List<Query> sortedHits = new ArrayList<>(hits);
            sortedHits.sort(comparator);

            int boundary = isMin ? -1000000000 : 1000000000;
            if (!sortedMisses.isEmpty()) {
                boundary = isMin ? sortedMisses.get(sortedMisses.size() - 1).getX() : sortedMisses.get(0).getX();
            }
            return boundary;
        }

        public int numTriesInScan() {
            return (int) Math.pow(Math.floorDiv(2000000000, A), 2);
        }

        public int getXForScan(int trialNum) {
            int numRadii = Math.floorDiv(2000000000, A);
            int column = (trialNum - 1) % numRadii;
            return -1000000000 + (A * column);
        }

        public int getYForScan(int trialNum) {
            int numRadii = Math.floorDiv(2000000000, A);
            int row = (trialNum - 1) / numRadii;
            return 1000000000 - (A * (row + 1));
        }

        public Box getInnerBox() {
            return innerBox;
        }

        public int getNextQueryX() {
            int topDiff = outerBox.getMaxy() - innerBox.getMaxy();
            int botDiff = innerBox.getMiny() - outerBox.getMiny();
            int leftDiff = innerBox.getMinx() - outerBox.getMinx();
            int rightDiff = outerBox.getMaxx() - innerBox.getMaxx();

            if (topDiff >= botDiff && topDiff >= leftDiff && topDiff >= rightDiff) {
                return outerBox.getCenterX();
            } else if (botDiff >= topDiff && botDiff >= leftDiff && botDiff >= rightDiff) {
                return outerBox.getCenterX();
            } else if (leftDiff >= topDiff && leftDiff >= botDiff && leftDiff >= rightDiff) {
                return innerBox.getMinx();
            } else {
                return innerBox.getMaxx() + rightDiff;
            }
        }

        public int getNextQueryY() {
            int topDiff = outerBox.getMaxy() - innerBox.getMaxy();
            int botDiff = innerBox.getMiny() - outerBox.getMiny();
            int leftDiff = innerBox.getMinx() - outerBox.getMinx();
            int rightDiff = outerBox.getMaxx() - innerBox.getMaxx();

            if (topDiff >= botDiff && topDiff >= leftDiff && topDiff >= rightDiff) {
                return topDiff + innerBox.getMaxy();
            } else if (botDiff >= topDiff && botDiff >= leftDiff && botDiff >= rightDiff) {
                return innerBox.getMiny() - botDiff;
            } else if (leftDiff >= topDiff && leftDiff >= botDiff && leftDiff >= rightDiff) {
                return outerBox.getCenterY();
            } else {
                return outerBox.getCenterY();
            }
        }
    }
}