import java.util.*;

public class ESAB {

    private static Scanner in;
    private static int numGuesses;
    private static int[] arr;
    private static int[] typeOf;
    private static int[] indices;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();

        HashMap<Pair, String> transformMap = new HashMap<>();
        transformMap.put(new Pair(0, 0), "eb");
        transformMap.put(new Pair(0, 3), "ac");
        transformMap.put(new Pair(1, 1), "ec");
        transformMap.put(new Pair(1, 2), "ab");
        transformMap.put(new Pair(2, 1), "ab");
        transformMap.put(new Pair(2, 2), "ec");
        transformMap.put(new Pair(3, 0), "ac");
        transformMap.put(new Pair(3, 3), "eb");

        for (int t = 0; t < T; t++) {
            initializeArrays(B);

            int unknownIndex = 0;

            for (int z = 0; z < 15; z++) {
                if (getKnownTypes().isEmpty()) {
                    if (unknownIndex >= B / 2) break;

                    for (int i = 0; i < 5; i++) {
                        processUnknownIndex(B, unknownIndex);
                        unknownIndex++;
                    }

                    if (unknownIndex >= B / 2) break;

                } else if (getKnownTypes().size() == 1) {
                    int knownType = getKnownTypes().get(0);
                    int indexOfKnownType = indices[knownType];

                    int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
                    int bit = query(indexOfKnownType + 1);
                    int otherSide = query(B - indexOfKnownType);

                    int newType = 2 * bit + otherSide;

                    String currentTransformations = transformMap.get(new Pair(originalType, newType));
                    String firstTransformation = currentTransformations.substring(0, 1);

                    applyTransformation(firstTransformation);

                    for (int i = 0; i < 4; i++) {
                        if (unknownIndex >= B / 2) break;
                        processUnknownIndex(B, unknownIndex);
                        unknownIndex++;
                    }

                    if (unknownIndex >= B / 2) break;

                } else {
                    ArrayList<Integer> saved = getKnownTypes();

                    int knownType = saved.get(0);
                    int indexOfKnownType = indices[knownType];

                    int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
                    int bit = query(indexOfKnownType + 1);
                    int otherSide = query(B - indexOfKnownType);

                    int newType = 2 * bit + otherSide;

                    String currentTransformations = transformMap.get(new Pair(originalType, newType));

                    knownType = saved.get(1);
                    indexOfKnownType = indices[knownType];

                    originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
                    bit = query(indexOfKnownType + 1);
                    otherSide = query(B - indexOfKnownType);

                    newType = 2 * bit + otherSide;

                    String otherTransformations = transformMap.get(new Pair(originalType, newType));

                    char firstTransformation = findCommonTransformation(currentTransformations, otherTransformations);

                    applyTransformation(String.valueOf(firstTransformation));

                    for (int i = 0; i < 3; i++) {
                        if (unknownIndex >= B / 2) break;
                        processUnknownIndex(B, unknownIndex);
                        unknownIndex++;
                    }

                    if (unknownIndex >= B / 2) break;
                }
            }

            if (!outputFinalArray()) return;
        }
    }

    private static void initializeArrays(int B) {
        numGuesses = 0;
        arr = new int[B];
        Arrays.fill(arr, -1);
        typeOf = new int[B];
        Arrays.fill(typeOf, -1);
        indices = new int[4];
        Arrays.fill(indices, -1);
    }

    private static void processUnknownIndex(int B, int unknownIndex) {
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
    }

    private static char findCommonTransformation(String currentTransformations, String otherTransformations) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        set1.add(currentTransformations.charAt(0));
        set1.add(currentTransformations.charAt(1));

        set2.add(otherTransformations.charAt(0));
        set2.add(otherTransformations.charAt(1));

        set1.retainAll(set2); // set1 is now intersection of the original 2 sets

        return set1.iterator().next();
    }

    private static void applyTransformation(String transformation) {
        switch (transformation) {
            case "e":
                break;
            case "a":
                complementArray();
                break;
            case "b":
                reverseArray();
                break;
            case "c":
                reverseAndComplementArray();
                break;
        }
    }

    private static void complementArray() {
        for (int i = 0; i < typeOf.length; i++) {
            if (arr[i] != -1) {
                arr[i] = 1 - arr[i];
                typeOf[i] = 3 - typeOf[i];
            }
        }
        swapIndices(0, 3);
        swapIndices(1, 2);
    }

    private static void reverseArray() {
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

    private static void reverseAndComplementArray() {
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

    private static int query(int pos) {
        numGuesses++;
        System.out.println(pos);
        System.out.flush();
        return in.nextInt();
    }

    private static boolean outputFinalArray() {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        System.out.flush();

        String response = in.next();
        return response.equals("Y");
    }

    private static ArrayList<Integer> getKnownTypes() {
        ArrayList<Integer> list = new ArrayList<>();
        if (indices[0] != -1) list.add(0);
        if (indices[3] != -1) list.add(3);
        if (indices[1] != -1) list.add(1);
        if (indices[2] != -1) list.add(2);
        return list;
    }

    static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int x, int y) {
            a = x;
            b = y;
        }

        @Override
        public int compareTo(Pair p2) {
            if (a != p2.a) return Integer.compare(a, p2.a);
            return Integer.compare(b, p2.b);
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