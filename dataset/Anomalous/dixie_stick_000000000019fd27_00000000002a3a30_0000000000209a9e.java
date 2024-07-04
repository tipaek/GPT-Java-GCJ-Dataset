import java.util.*;

public class Solution {
    public static Scanner in;
    public static int numGuesses;
    public static int[] arr;
    public static int[] typeOf;
    public static int[] indices;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();

        Map<Pair, String> transformationsMap = initializeTransformationsMap();

        for (int t = 0; t < T; t++) {
            numGuesses = 0;
            arr = new int[B];
            Arrays.fill(arr, -1);

            typeOf = new int[B];
            Arrays.fill(typeOf, -1);

            indices = new int[4];
            Arrays.fill(indices, -1);

            int unknownIndex = 0;

            for (int z = 0; z < 15; z++) {
                if (getKnownTypes().isEmpty()) {
                    if (unknownIndex >= B / 2) break;

                    handleUnknownTypes(B, unknownIndex);
                    if (unknownIndex >= B / 2) break;
                } else if (getKnownTypes().size() == 1) {
                    handleSingleKnownType(B, transformationsMap, unknownIndex);
                    if (unknownIndex >= B / 2) break;
                } else {
                    handleTwoKnownTypes(B, transformationsMap, unknownIndex);
                    if (unknownIndex >= B / 2) break;
                }
            }

            if (!outputFinalArray()) return;
        }
    }

    private static void handleUnknownTypes(int B, int unknownIndex) {
        for (int i = 0; i < 5; i++) {
            int bit = query(unknownIndex + 1);
            int otherSide = query(B - unknownIndex);

            arr[unknownIndex] = bit;
            arr[B - unknownIndex - 1] = otherSide;

            int bitmask = 2 * bit + otherSide;
            typeOf[unknownIndex] = bitmask;
            typeOf[B - unknownIndex - 1] = bitmask;
            if (indices[bitmask] == -1) {
                indices[bitmask] = unknownIndex;
            }

            unknownIndex++;
        }
    }

    private static void handleSingleKnownType(int B, Map<Pair, String> transformationsMap, int unknownIndex) {
        int knownType = getKnownTypes().get(0);
        int indexOfKnownType = indices[knownType];

        int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        int bit = query(indexOfKnownType + 1);
        int otherSide = query(B - indexOfKnownType);

        int newType = 2 * bit + otherSide;

        String currentTransformations = transformationsMap.get(new Pair(originalType, newType));
        String firstTransformations = currentTransformations.substring(0, 1);

        map(firstTransformations);

        for (int i = 0; i < 4; i++) {
            if (unknownIndex >= B / 2) break;

            bit = query(unknownIndex + 1);
            otherSide = query(B - unknownIndex);

            arr[unknownIndex] = bit;
            arr[B - unknownIndex - 1] = otherSide;

            int bitmask = 2 * bit + otherSide;
            typeOf[unknownIndex] = bitmask;
            typeOf[B - unknownIndex - 1] = bitmask;
            if (indices[bitmask] == -1) {
                indices[bitmask] = unknownIndex;
            }

            unknownIndex++;
        }
    }

    private static void handleTwoKnownTypes(int B, Map<Pair, String> transformationsMap, int unknownIndex) {
        List<Integer> saved = getKnownTypes();

        int knownType = saved.get(0);
        int indexOfKnownType = indices[knownType];

        int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        int bit = query(indexOfKnownType + 1);
        int otherSide = query(B - indexOfKnownType);

        int newType = 2 * bit + otherSide;

        String currentTransformations = transformationsMap.get(new Pair(originalType, newType));

        knownType = saved.get(1);
        indexOfKnownType = indices[knownType];

        originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        bit = query(indexOfKnownType + 1);
        otherSide = query(B - indexOfKnownType);

        newType = 2 * bit + otherSide;

        String otherTransformations = transformationsMap.get(new Pair(originalType, newType));

        HashSet<Character> intersection = new HashSet<>();
        intersection.add(currentTransformations.charAt(0));
        intersection.add(currentTransformations.charAt(1));
        intersection.retainAll(Set.of(otherTransformations.charAt(0), otherTransformations.charAt(1)));

        char firstTransformation = intersection.iterator().next();

        map(String.valueOf(firstTransformation));

        for (int i = 0; i < 3; i++) {
            if (unknownIndex >= B / 2) break;

            bit = query(unknownIndex + 1);
            otherSide = query(B - unknownIndex);

            arr[unknownIndex] = bit;
            arr[B - unknownIndex - 1] = otherSide;

            int bitmask = 2 * bit + otherSide;
            typeOf[unknownIndex] = bitmask;
            typeOf[B - unknownIndex - 1] = bitmask;
            if (indices[bitmask] == -1) {
                indices[bitmask] = unknownIndex;
            }

            unknownIndex++;
        }
    }

    private static Map<Pair, String> initializeTransformationsMap() {
        Map<Pair, String> map = new HashMap<>();
        map.put(new Pair(0, 0), "eb");
        map.put(new Pair(0, 3), "ac");
        map.put(new Pair(1, 1), "ec");
        map.put(new Pair(1, 2), "ab");
        map.put(new Pair(2, 1), "ab");
        map.put(new Pair(2, 2), "ec");
        map.put(new Pair(3, 0), "ac");
        map.put(new Pair(3, 3), "eb");
        return map;
    }

    public static void map(String transformation) {
        switch (transformation) {
            case "e":
                break;
            case "a":
                complement();
                break;
            case "b":
                reverse();
                break;
            case "c":
                complementAndReverse();
                break;
        }
    }

    private static void complement() {
        for (int i = 0; i < typeOf.length; i++) {
            if (arr[i] != -1) {
                arr[i] = 1 - arr[i];
                typeOf[i] = 3 - typeOf[i];
            }
        }
        swapIndices(0, 3);
        swapIndices(1, 2);
    }

    private static void reverse() {
        for (int i = 0; i < typeOf.length / 2; i++) {
            if (arr[i] != -1) {
                int temp = arr[i];
                arr[i] = arr[typeOf.length - 1 - i];
                arr[typeOf.length - 1 - i] = temp;

                if (typeOf[i] == 1 || typeOf[i] == 2) {
                    typeOf[i] = 3 - typeOf[i];
                }
            }
        }
        swapIndices(1, 2);
    }

    private static void complementAndReverse() {
        for (int i = 0; i <= typeOf.length / 2; i++) {
            if (arr[i] != -1) {
                int temp1 = arr[i];
                int temp2 = arr[typeOf.length - 1 - i];

                arr[i] = 1 - temp2;
                arr[typeOf.length - 1 - i] = 1 - temp1;

                if (typeOf[i] == 0 || typeOf[i] == 3) {
                    typeOf[i] = 3 - typeOf[i];
                }
            }
        }
        swapIndices(0, 3);
    }

    private static void swapIndices(int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    public static int query(int pos) {
        numGuesses++;
        System.out.println("making guess #" + numGuesses);
        System.out.println(pos);
        System.out.flush();
        return in.nextInt();
    }

    public static boolean outputFinalArray() {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        System.out.flush();
        return in.next().equals("Y");
    }

    public static List<Integer> getKnownTypes() {
        List<Integer> list = new ArrayList<>();
        if (indices[0] != -1) list.add(0);
        if (indices[3] != -1) list.add(3);
        if (indices[1] != -1) list.add(1);
        if (indices[2] != -1) list.add(2);
        return list;
    }

    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int x, int y) {
            a = x;
            b = y;
        }

        @Override
        public int compareTo(Pair p2) {
            return (a != p2.a) ? Integer.compare(a, p2.a) : Integer.compare(b, p2.b);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair p2 = (Pair) o;
            return a == p2.a && b == p2.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }
}