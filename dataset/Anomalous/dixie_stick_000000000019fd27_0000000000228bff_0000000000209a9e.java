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

        Map<Pair, String> transformationMap = new HashMap<>();
        transformationMap.put(new Pair(0, 0), "eb");
        transformationMap.put(new Pair(0, 3), "ac");
        transformationMap.put(new Pair(1, 1), "ec");
        transformationMap.put(new Pair(1, 2), "ab");
        transformationMap.put(new Pair(2, 1), "ab");
        transformationMap.put(new Pair(2, 2), "ec");
        transformationMap.put(new Pair(3, 0), "ac");
        transformationMap.put(new Pair(3, 3), "eb");

        for (int t = 0; t < T; t++) {
            initializeArrays(B);
            int unknownIndex = 0;

            for (int z = 0; z < 15; z++) {
                if (getKnownTypes().isEmpty()) {
                    if (unknownIndex >= B / 2) break;
                    processUnknownTypes(B, unknownIndex);
                    if (unknownIndex >= B / 2) break;
                } else if (getKnownTypes().size() == 1) {
                    processSingleKnownType(B, transformationMap, unknownIndex);
                    if (unknownIndex >= B / 2) break;
                } else {
                    processMultipleKnownTypes(B, transformationMap, unknownIndex);
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

    private static void processUnknownTypes(int B, int unknownIndex) {
        for (int i = 0; i < 5; i++) {
            int bit = query(unknownIndex + 1);
            int otherSide = query(B - unknownIndex);
            arr[unknownIndex] = bit;
            arr[B - unknownIndex - 1] = otherSide;
            int bitmask = 2 * bit + otherSide;
            typeOf[unknownIndex] = bitmask;
            typeOf[B - unknownIndex - 1] = bitmask;
            if (indices[bitmask] == -1) indices[bitmask] = i;
            unknownIndex++;
        }
    }

    private static void processSingleKnownType(int B, Map<Pair, String> transformationMap, int unknownIndex) {
        int knownType = getKnownTypes().get(0);
        int indexOfKnownType = indices[knownType];
        int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        int bit = query(indexOfKnownType + 1);
        int otherSide = query(B - indexOfKnownType);
        int newType = 2 * bit + otherSide;
        String transformations = transformationMap.get(new Pair(originalType, newType));
        applyTransformation(transformations.substring(0, 1));
        updateArrays(B, unknownIndex);
    }

    private static void processMultipleKnownTypes(int B, Map<Pair, String> transformationMap, int unknownIndex) {
        List<Integer> knownTypes = getKnownTypes();
        char firstTransformation = getFirstTransformation(transformationMap, knownTypes);
        applyTransformation(String.valueOf(firstTransformation));
        updateArrays(B, unknownIndex);
    }

    private static void updateArrays(int B, int unknownIndex) {
        for (int i = 0; i < 4; i++) {
            if (unknownIndex >= B / 2) break;
            int bit = query(unknownIndex + 1);
            int otherSide = query(B - unknownIndex);
            arr[unknownIndex] = bit;
            arr[B - unknownIndex - 1] = otherSide;
            int bitmask = 2 * bit + otherSide;
            typeOf[unknownIndex] = bitmask;
            typeOf[B - unknownIndex - 1] = bitmask;
            if (indices[bitmask] == -1) indices[bitmask] = i;
            unknownIndex++;
        }
    }

    private static char getFirstTransformation(Map<Pair, String> transformationMap, List<Integer> knownTypes) {
        int knownType = knownTypes.get(0);
        int indexOfKnownType = indices[knownType];
        int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        int bit = query(indexOfKnownType + 1);
        int otherSide = query(B - indexOfKnownType);
        int newType = 2 * bit + otherSide;
        String currentTransformations = transformationMap.get(new Pair(originalType, newType));

        knownType = knownTypes.get(1);
        indexOfKnownType = indices[knownType];
        originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        bit = query(indexOfKnownType + 1);
        otherSide = query(B - indexOfKnownType);
        newType = 2 * bit + otherSide;
        String otherTransformations = transformationMap.get(new Pair(originalType, newType));

        Set<Character> set1 = new HashSet<>(Arrays.asList(currentTransformations.charAt(0), currentTransformations.charAt(1)));
        Set<Character> set2 = new HashSet<>(Arrays.asList(otherTransformations.charAt(0), otherTransformations.charAt(1)));
        set1.retainAll(set2);

        return set1.iterator().next();
    }

    private static void applyTransformation(String transformation) {
        switch (transformation) {
            case "e":
                break;
            case "a":
                applyComplementTransformation();
                break;
            case "b":
                applyReverseTransformation();
                break;
            case "c":
                applyComplementAndReverseTransformation();
                break;
        }
    }

    private static void applyComplementTransformation() {
        for (int i = 0; i < typeOf.length; i++) {
            if (arr[i] != -1) {
                arr[i] = 1 - arr[i];
                typeOf[i] = 3 - typeOf[i];
            }
        }
        swapIndices(0, 3);
        swapIndices(1, 2);
    }

    private static void applyReverseTransformation() {
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

    private static void applyComplementAndReverseTransformation() {
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

    private static void swapIndices(int index1, int index2) {
        int temp = indices[index1];
        indices[index1] = indices[index2];
        indices[index2] = temp;
    }

    private static int query(int pos) {
        numGuesses++;
        System.out.println(pos);
        System.out.flush();
        return in.nextInt();
    }

    private static boolean outputFinalArray() {
        StringBuilder sb = new StringBuilder();
        for (int bit : arr) sb.append(bit);
        System.out.println(sb.toString());
        System.out.flush();
        return in.next().equals("Y");
    }

    private static List<Integer> getKnownTypes() {
        List<Integer> knownTypes = new ArrayList<>();
        if (indices[0] != -1) knownTypes.add(0);
        if (indices[1] != -1) knownTypes.add(1);
        if (indices[2] != -1) knownTypes.add(2);
        if (indices[3] != -1) knownTypes.add(3);
        return knownTypes;
    }

    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}