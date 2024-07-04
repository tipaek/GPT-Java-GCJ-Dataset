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

                    if (unknownIndex >= B / 2) break;

                } else if (getKnownTypes().size() == 1) {
                    int knownType = getKnownTypes().get(0);
                    int indexOfKnownType = indices[knownType];

                    int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
                    int bit = query(indexOfKnownType + 1);
                    int otherSide = query(B - indexOfKnownType);

                    int newType = 2 * bit + otherSide;

                    String currentTransformations = transformationMap.get(new Pair(originalType, newType));
                    String firstTransformations = currentTransformations.substring(0, 1);

                    applyTransformation(firstTransformations);

                    for (int i = 0; i < 4; i++) {
                        if (unknownIndex >= B / 2) break;

                        bit = query(unknownIndex + 1);
                        otherSide = query(B - unknownIndex);

                        arr[unknownIndex] = bit;
                        arr[B - unknownIndex - 1] = otherSide;

                        int bitmask = 2 * bit + otherSide;
                        typeOf[unknownIndex] = bitmask;
                        typeOf[B - unknownIndex - 1] = bitmask;
                        if (indices[bitmask] == -1) indices[bitmask] = i;

                        unknownIndex++;
                    }

                    if (unknownIndex >= B / 2) break;

                } else {
                    List<Integer> saved = getKnownTypes();

                    int knownType = saved.get(0);
                    int indexOfKnownType = indices[knownType];

                    int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
                    int bit = query(indexOfKnownType + 1);
                    int otherSide = query(B - indexOfKnownType);

                    int newType = 2 * bit + otherSide;

                    String currentTransformations = transformationMap.get(new Pair(originalType, newType));

                    knownType = saved.get(1);
                    indexOfKnownType = indices[knownType];

                    originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
                    bit = query(indexOfKnownType + 1);
                    otherSide = query(B - indexOfKnownType);

                    newType = 2 * bit + otherSide;

                    String otherTransformations = transformationMap.get(new Pair(originalType, newType));

                    Set<Character> set1 = new HashSet<>(Arrays.asList(currentTransformations.charAt(0), currentTransformations.charAt(1)));
                    Set<Character> set2 = new HashSet<>(Arrays.asList(otherTransformations.charAt(0), otherTransformations.charAt(1)));

                    set1.retainAll(set2);

                    char firstTransformation = set1.iterator().next();

                    applyTransformation(String.valueOf(firstTransformation));

                    for (int i = 0; i < 3; i++) {
                        if (unknownIndex >= B / 2) break;

                        bit = query(unknownIndex + 1);
                        otherSide = query(B - unknownIndex);

                        arr[unknownIndex] = bit;
                        arr[B - unknownIndex - 1] = otherSide;

                        int bitmask = 2 * bit + otherSide;
                        typeOf[unknownIndex] = bitmask;
                        typeOf[B - unknownIndex - 1] = bitmask;
                        if (indices[bitmask] == -1) indices[bitmask] = i;

                        unknownIndex++;
                    }

                    if (unknownIndex >= B / 2) break;
                }
            }

            boolean result = outputFinalArray();

            if (!result) return;
        }
    }

    public static void applyTransformation(String transformation) {
        switch (transformation) {
            case "e":
                break;
            case "a":
                for (int i = 0; i < typeOf.length; i++) {
                    if (arr[i] != -1) {
                        arr[i] = 1 - arr[i];
                        typeOf[i] = 3 - typeOf[i];
                    }
                }
                swapIndices(0, 3);
                swapIndices(1, 2);
                break;
            case "b":
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
                break;
            case "c":
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
                break;
        }
    }

    public static int query(int pos) {
        numGuesses++;
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

        String response = in.next();
        return response.equals("Y");
    }

    public static List<Integer> getKnownTypes() {
        List<Integer> list = new ArrayList<>();
        if (indices[0] != -1) list.add(0);
        else if (indices[3] != -1) list.add(3);

        if (indices[1] != -1) list.add(1);
        else if (indices[2] != -1) list.add(2);

        return list;
    }

    public static void swapIndices(int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int x, int y) {
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