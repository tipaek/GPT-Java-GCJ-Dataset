import java.util.*;
import java.io.*;
import java.util.function.Function;
 
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            long x = in.nextLong();
            long y = in.nextLong();
            String ans;
            if ((x + y)%2 == 0) {
                ans = "IMPOSSIBLE";
            } else {
                List<Long> evenPos;
                long absX = Math.abs(x);
                long absY = Math.abs(y);
                if (absX%2 == 0) {
                    evenPos = evenPos(absX);
                    List<Long> oddPos = new ArrayList<>();
                    for (int j = 0; j<= 31; j++) {
                        if (!evenPos.contains( (long) j)) {
                            oddPos.add((long) j);
                        }
                    }
                    List<Pair<Long, Boolean>> oddAns = null;
                    for (int j = 0; j<=31; j++) {
                        if (oddAns == null) {
                            oddAns = oddAns(oddPos, j, absY);
                        }
                    }
                    if (oddAns == null) {
                        ans = "IMPOSSIBLE";
                    } else {
                        ans = "";
                        for (int j = 0; j<=32; j++) {
                            if (evenPos.contains((long)j)) {
                                if (x > 0) {
                                    ans += 'E';
                                } else {
                                    ans += 'W';
                                }
                            } else {
                                for (int k = 0; k <=32; k++) {
                                    if (k < oddAns.size() && oddAns.get(k).first == j) {
                                        if (oddAns.get(k).second) {
                                            if (y>0) {
                                                ans += 'N';
                                            } else {
                                                ans += 'S';
                                            }
                                        } else {
                                            if (y<0) {
                                                ans += 'N';
                                            } else {
                                                ans += 'S';
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    evenPos = evenPos(absY);
                    List<Long> oddPos = new ArrayList<>();
                    for (int j = 0; j<= 31; j++) {
                        if (!evenPos.contains((long)j)) {
                            oddPos.add((long) j);
                        }
                    }
                    List<Pair<Long, Boolean>> oddAns = null;
                    for (int j = 0; j<=31; j++) {
                        if (oddAns == null) {
                            oddAns = oddAns(oddPos, j, absX);
                        }
                    }
                    if (oddAns == null) {
                        ans = "IMPOSSIBLE";
                    } else {
                        ans = "";
                        for (int j = 0; j<=32; j++) {
                            if (evenPos.contains((long)j)) {
                                if (x > 0) {
                                    ans += 'N';
                                } else {
                                    ans += 'S';
                                }
                            } else {
                                for (int k = 0; k <=32; k++) {
                                    if (k < oddAns.size() && oddAns.get(k).first == j) {
                                        if (oddAns.get(k).second) {
                                            if (x>0) {
                                                ans += 'E';
                                            } else {
                                                ans += 'W';
                                            }
                                        } else {
                                            if (x<0) {
                                                ans += 'E';
                                            } else {
                                                ans += 'W';
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
 
    private static List<Pair<Long, Boolean>> oddAns(List<Long> oddPos, int currentPos, long num) {
        long calculate = 0;
        List<Pair<Long, Boolean>> ans = new ArrayList<>();
        while (currentPos >= 0) {
            if (oddPos.contains((long)currentPos)) {
                if (calculate < num) {
                    calculate += 1 << currentPos;
                    ans.add(Pair.of((long) currentPos, Boolean.TRUE));
                } else {
                    calculate -= 1 << currentPos;
                    ans.add(Pair.of((long) currentPos, Boolean.FALSE));
                }
            }
            currentPos--;
        }
        if (calculate == num) {
            return ans;
        }
        return null;
    }
 
    private static List<Long> evenPos(long num) {
        List<Long> evenPos = new ArrayList<>();
        for (int i = 0; i<= 30; i++) {
            long temp = 1 << i;
            if ((temp & num) != 0) {
                evenPos.add((long) i);
            }
        }
        return evenPos;
    }
 
    private static class Pair<A, B> implements Serializable {
 
        /** Creates a new pair containing the given elements in order. */
        public static <A, B> Pair<A, B> of( A first,  B second) {
            return new Pair<>(first, second);
        }
 
        /** The first element of the pair. */
        public final A first;
 
        /** The second element of the pair. */
        public final B second;
 
        /** For subclass usage only. To create a new pair, use {@code Pair.of(first, second)}. */
        protected Pair( A first,  B second) {
            this.first = first;
            this.second = second;
        }
 
        /** Returns the first element of this pair. */
        public A getFirst() {
            return first;
        }
 
        /** Returns the second element of this pair. */
        public B getSecond() {
            return second;
        }
 
        /** Returns a function that yields {@link #first}. */
        @SuppressWarnings("unchecked") // implementation is "fully variant"
        public static <A, B> Function<Pair<A, B>, A> firstFunction() {
            return (Function) PairFirstFunction.INSTANCE;
        }
 
        /** Returns a function that yields {@link #second}. */
        @SuppressWarnings("unchecked") // implementation is "fully variant"
        public static <A, B> Function<Pair<A, B>, B> secondFunction() {
            return (Function) PairSecondFunction.INSTANCE;
        }
 
        /*
         * If we use the enum singleton pattern for these functions, Flume's type
         * inference chokes: http://b/4863010
         */
 
        /*
         * Note that this implementation doesn't involve B, and A's are only "passed
         * through", so it has become "fully variant" in both parameters.
         */
        private static final class PairFirstFunction<A, B>
                implements Function<Pair<A, B>, A>, Serializable {
            static final PairFirstFunction<Object, Object> INSTANCE = new PairFirstFunction<>();
 
            @Override
            public A apply(Pair<A, B> from) {
                return from.getFirst();
            }
 
            private Object readResolve() {
                return INSTANCE;
            }
        }
 
        /*
         * Note that this implementation doesn't involve A, and B's are only "passed
         * through", so it has become "fully variant" in both parameters.
         */
        private static final class PairSecondFunction<A, B>
                implements Function<Pair<A, B>, B>, Serializable {
            static final PairSecondFunction<Object, Object> INSTANCE = new PairSecondFunction<>();
 
            @Override
            public B apply(Pair<A, B> from) {
                return from.getSecond();
            }
 
            private Object readResolve() {
                return INSTANCE;
            }
        }
 
        /**
         * Returns a comparator that compares two Pair objects by comparing the result of {@link
         * #getFirst()} for each.
         */
        @SuppressWarnings("unchecked") // safe contravariant cast
        public static <A extends Comparable<? super A>, B> Comparator<Pair<A, B>> compareByFirst() {
            return (Comparator) FirstComparator.FIRST_COMPARATOR;
        }
 
        /**
         * Returns a comparator that compares two Pair objects by comparing the result of {@link
         * #getSecond()} for each.
         */
        @SuppressWarnings("unchecked") // safe contravariant cast
        public static <A, B extends Comparable<? super B>> Comparator<Pair<A, B>> compareBySecond() {
            return (Comparator) SecondComparator.SECOND_COMPARATOR;
        }
 
        private enum FirstComparator implements Comparator<Pair<Comparable<?>, Object>> {
            FIRST_COMPARATOR;
 
            @Override
            public int compare(Pair<Comparable<?>, Object> pair1, Pair<Comparable<?>, Object> pair2) {
                @SuppressWarnings("unchecked")
                Comparable<Object> left = (Comparable<Object>) pair1.getFirst();
                Comparable<?> right = pair2.getFirst();
 
                /*
                 * Technically unsafe, but tolerable. If the comparables are badly
                 * behaved, this comparator will be equally badly behaved.
                 */
                int result = left.compareTo(right);
                return result;
            }
        }
 
        private enum SecondComparator implements Comparator<Pair<Object, Comparable<?>>> {
            SECOND_COMPARATOR;
 
            @Override
            public int compare(Pair<Object, Comparable<?>> pair1, Pair<Object, Comparable<?>> pair2) {
                @SuppressWarnings("unchecked")
                Comparable<Object> left = (Comparable<Object>) pair1.getSecond();
                Comparable<?> right = pair2.getSecond();
 
                /*
                 * Technically unsafe, but tolerable. If the comparables are badly
                 * behaved, this comparator will be equally badly behaved.
                 */
                int result = left.compareTo(right);
                return result;
            }
        }
 
        // TODO(kevinb): decide what level of commitment to make to this impl
        @Override
        public boolean equals( Object object) {
            // TODO(kevinb): it is possible we want to change this to
            // if (object != null && object.getClass() == getClass()) {
            if (object instanceof Pair) {
                Pair<?, ?> that = (Pair<?, ?>) object;
                return Objects.equals(this.getFirst(), that.getFirst())
                        && Objects.equals(this.getSecond(), that.getSecond());
            }
            return false;
        }
 
        @Override
        public int hashCode() {
            int hash1 = first == null ? 0 : first.hashCode();
            int hash2 = second == null ? 0 : second.hashCode();
            return 31 * hash1 + hash2;
        }
 
        /**
         * {@inheritDoc}
         *
         * <p>This implementation returns a string in the form {@code (first, second)}, where {@code
         * first} and {@code second} are the String representations of the first and second elements of
         * this pair, as given by {@link String#valueOf(Object)}. Subclasses are free to override this
         * behavior.
         */
        @Override
        public String toString() {
            // GWT doesn't support String.format().
            return "(" + getFirst() + ", " + getSecond() + ")";
        }
 
        private static final long serialVersionUID = 747826592375603043L;
    }
}