import java.util.*;

public class Solution {

    private static Scanner in;
    private static int numGuesses;
    private static int[] arr;
    private static int[] typeOf;
    private static int[] indices;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();

        Map<Pair, String> transformationMap = initializeTransformationMap();

        for (int t = 0; t < T; t++) {
            initializeArrays(B);
            int unknownIndex = 0;

            for (int z = 0; z < 15; z++) {
                if (getKnownTypes().isEmpty()) {
                    if (unknownIndex >= B / 2) break;
                    processUnknownTypes(B, unknownIndex);
                    if (unknownIndex >= B / 2) break;
                } else {
                    int knownTypesCount = getKnownTypes().size();
                    if (knownTypesCount == 1) {
                        processSingleKnownType(B, transformationMap, unknownIndex);
                        if (unknownIndex >= B / 2) break;
                    } else {
                        processMultipleKnownTypes(B, transformationMap, unknownIndex);
                        if (unknownIndex >= B / 2) break;
                    }
                }
            }

            if (!outputFinalArray()) return;
        }
    }

    private static Map<Pair, String> initializeTransformationMap() {
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
            updateArrays(B, unknownIndex, bit, otherSide);
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
        String currentTransformations = transformationMap.get(new Pair(originalType, newType));
        map(currentTransformations.substring(0, 1));
        processUnknownTypes(B, unknownIndex);
    }

    private static void processMultipleKnownTypes(int B, Map<Pair, String> transformationMap, int unknownIndex) {
        List<Integer> saved = getKnownTypes();
        String currentTransformations = getTransformations(B, transformationMap, saved.get(0));
        String otherTransformations = getTransformations(B, transformationMap, saved.get(1));
        char firstTransformation = findCommonTransformation(currentTransformations, otherTransformations);
        map(String.valueOf(firstTransformation));
        processUnknownTypes(B, unknownIndex);
    }

    private static String getTransformations(int B, Map<Pair, String> transformationMap, int knownType) {
        int indexOfKnownType = indices[knownType];
        int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
        int bit = query(indexOfKnownType + 1);
        int otherSide = query(B - indexOfKnownType);
        int newType = 2 * bit + otherSide;
        return transformationMap.get(new Pair(originalType, newType));
    }

    private static char findCommonTransformation(String currentTransformations, String otherTransformations) {
        Set<Character> set1 = new HashSet<>(Arrays.asList(currentTransformations.charAt(0), currentTransformations.charAt(1)));
        Set<Character> set2 = new HashSet<>(Arrays.asList(otherTransformations.charAt(0), otherTransformations.charAt(1)));
        set1.retainAll(set2);
        return set1.iterator().next();
    }

    private static void map(String transformation) {
        switch (transformation) {
            case "e":
                break;
            case "a":
                complement();
                swapIndices(0, 3);
                swapIndices(1, 2);
                break;
            case "b":
                reverse();
                swapIndices(1, 2);
                break;
            case "c":
                reverseAndComplement();
                swapIndices(0, 3);
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
    }

    private static void reverse() {
        for (int i = 0; i < typeOf.length / 2; i++) {
            if (arr[i] != -1) {
                swapElements(i, typeOf.length - 1 - i);
                if (typeOf[i] == 1 || typeOf[i] == 2) {
                    typeOf[i] = 3 - typeOf[i];
                }
            }
        }
    }

    private static void reverseAndComplement() {
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
    }

    private static void swapIndices(int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    private static void swapElements(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        return in.next().equals("Y");
    }

    private static List<Integer> getKnownTypes() {
        List<Integer> list = new ArrayList<>();
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
            return a == p2.a ? Integer.compare(b, p2.b) : Integer.compare(a, p2.a);
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