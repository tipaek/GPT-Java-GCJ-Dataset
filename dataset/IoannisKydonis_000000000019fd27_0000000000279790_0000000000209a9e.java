import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

class Solution {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; i++) {
            StringBuilder sb = createSb(b);

            Set<Integer> requested = new HashSet<>();
            List<Pair> opposite = new ArrayList<>();
            List<Pair> same = new ArrayList<>();
            List<ActionPair> pendingActions = new ArrayList<>();

            addToPending(pendingActions, sb, Action.REVERSE, Action.COMPLEMENT, Action.BOTH, Action.NONE);

            int index = 0;
            int countOfRequests = 0;
            do {
                if (countOfRequests != 0 && countOfRequests % 10 == 0){
                    // Fluctuation is coming next
                    // Won't run first time so at least one of same/opposite will be non empty
                    if (!same.isEmpty() && !opposite.isEmpty()){
                        Element sameElement = same.get(same.size() - 1).first;
                        Element oppositeElement = opposite.get(opposite.size() - 1).first;
                        System.out.println(sameElement.index);
                        int newSameVal = in.nextInt();
                        System.out.println(oppositeElement.index);
                        int newOppositeVal = in.nextInt();
                        countOfRequests += 2;

                        if (newSameVal == sameElement.value && newOppositeVal == oppositeElement.value){
                            addToPending(pendingActions, sb, Action.NONE);
                        }else if (newSameVal != sameElement.value && newOppositeVal == oppositeElement.value){
                            addToPending(pendingActions, sb, Action.BOTH);
                        }else if (newSameVal == sameElement.value && newOppositeVal != oppositeElement.value){
                            addToPending(pendingActions, sb, Action.REVERSE);
                        }else {
                            addToPending(pendingActions, sb, Action.COMPLEMENT);
                        }
                        sameElement.value = newSameVal;
                        oppositeElement.value = newOppositeVal;

                        runPending(pendingActions, pendingActions.size() - 1, 0);
                    }else if (!same.isEmpty()){
                        Element sameElement = same.get(same.size() - 1).first;
                        System.out.println(sameElement.index);
                        int newSameVal = in.nextInt();
                        countOfRequests++;

                        if (newSameVal == sameElement.value){
                            addToPending(pendingActions, sb, Action.NONE, Action.REVERSE);
                        }else{
                            addToPending(pendingActions, sb, Action.COMPLEMENT, Action.BOTH);
                        }

                        sb = createSb(b);
                    }else if (!opposite.isEmpty()){
                        Element oppositeElement = opposite.get(opposite.size() - 1).first;
                        System.out.println(oppositeElement.index);
                        int newOppositeVal = in.nextInt();
                        countOfRequests++;

                        if (newOppositeVal == oppositeElement.value){
                            addToPending(pendingActions, sb, Action.BOTH, Action.NONE);
                        }else{
                            addToPending(pendingActions, sb, Action.REVERSE, Action.COMPLEMENT);
                        }

                        sb = createSb(b);
                    }
                }else{
                    index = getNonRequestedOnFirstHalf(rand, b, requested);
                    if (index != -1){
                        Pair results = addPairOfResults(index, b, in, opposite, same);
                        writeResults(results, sb);
                    }else {
                        addPairOfResults(1, b, in, opposite, same);
                    }
                    countOfRequests += 2;
                }
            } while (index != -1 && countOfRequests < 150 && sb.indexOf("?") != -1);
            System.out.println(sb.toString());
            String response = in.nextLine();
            if (response.equals("N")){
                System.exit(0);
            }
        }
    }

    private static StringBuilder createSb(Integer b){
        StringBuilder sb = new StringBuilder(b);
        for (int j = 0; j < b; j++) sb.append('?');
        return sb;
    }
    private static void writeResults(Pair results, StringBuilder sb){
        sb.replace(results.first.index - 1, results.first.index, String.valueOf(results.first.value));
        sb.replace(results.second.index - 1, results.second.index, String.valueOf(results.second.value));
    }

    private static void runPending(List<ActionPair> pendingActions, int indexToRun, int subIndexToRun){
        ActionPair actionPair = pendingActions.get(indexToRun);
        actionPair.actions.get(subIndexToRun).doAction(actionPair.sb);
    }

    private static void addToPending(List<ActionPair> pendingActions, StringBuilder sb, Action... args) {
        if (args.length == 0) return;
        pendingActions.add(new ActionPair(new ArrayList<>(Arrays.asList(args)), new StringBuilder(sb)));
    }

    private static void reverse(StringBuilder sb) {
        sb.reverse();
    }

    private static void complement(StringBuilder sb) {
        char[] chars = new char[sb.length()];
        sb.getChars(0, sb.length(), chars, 0);
        sb.setLength(0);
        for (char c : chars) {
            if (c == '?') sb.append(c);
            else sb.append(c == '1' ? '0' : '1');
        }
    }

    private static void reverseAndComplement(StringBuilder sb) {
        reverse(sb);
        complement(sb);
    }

    private static void doNone(StringBuilder sb) {

    }

    private static Pair addPairOfResults(int index, int size, Scanner in, List<Pair> opposite, List<Pair> same) {
        System.out.println(index);
        int result = in.nextInt();
        Element first = new Element(result, index);
        System.out.println(size - index + 1);
        int symmetricResult = in.nextInt();
        Element second = new Element(symmetricResult, size - index + 1);
        if (result == symmetricResult && same.isEmpty()) {
            same.add(new Pair(first, second));
        } else if (result != symmetricResult && opposite.isEmpty()){
            opposite.add(new Pair(first, second));
        }
        return new Pair(first, second);
    }

    /**
     * Returns -1 if all bits have been requested
     */
    private static int getNonRequestedOnFirstHalf(Random rand, Integer limit, Set<Integer> requested) {
        if (requested.size() < limit / 2) {
            int randomIndex = 0;
            while (requested.contains(randomIndex) || randomIndex == 0) {
                randomIndex = rand.nextInt(limit / 2) + 1;
            }
            requested.add(randomIndex);
            return randomIndex;
        } else {
            int index = 1;
            while (requested.contains(index)) index++;
            if (index > limit / 2) return -1;
            requested.add(index);
            return index;
        }
    }

    private enum Action {
        REVERSE(Solution::reverse), COMPLEMENT(Solution::complement), BOTH(Solution::reverseAndComplement), NONE(Solution::doNone);

        Consumer<StringBuilder> cons;

        Action(Consumer<StringBuilder> cons) {
            this.cons = cons;
        }

        void doAction(StringBuilder sb) {
            this.cons.accept(sb);
        }
    }

    private static class ActionPair {
        List<Action> actions;
        StringBuilder sb;

        public ActionPair(List<Action> actions, StringBuilder sb) {
            this.actions = actions;
            this.sb = sb;
        }
    }

    private static class Element {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private static class Pair {
        Element first;
        Element second;

        public Pair(Element first, Element second) {
            this.first = first;
            this.second = second;
        }
    }
}