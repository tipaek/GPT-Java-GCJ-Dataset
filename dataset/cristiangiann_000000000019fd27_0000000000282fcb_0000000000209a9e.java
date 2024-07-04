public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        int nTests = Integer.parseInt(input.split(" ")[0]);
        int B = Integer.parseInt(input.split(" ")[1]);
        for (int counter = 0; counter < nTests; counter++) {
            int recursions = 5;
            String result = "";
            int[] array = new int[B];
            Arrays.fill(array, -1);
            int startIndex = 0;

            for (int query = 0; query < B;) {
                for (int i = 0; i < recursions; i++) {
                    System.out.println(startIndex + i + 1);
                    array[startIndex + i] = (Integer.parseInt(in.nextLine()));

                    System.out.println(B - startIndex - i);
                    array[B - startIndex - i - 1] = (Integer.parseInt(in.nextLine()));
                    query += 2;
                }
                if(query == B) break;
                array = findValues(array, in);
                startIndex += recursions;
                recursions = Math.min(4, (B - query) / 2);
            }
            for(int value: array) System.out.print(value);
            System.out.println();
            String serverResponse = in.nextLine();
            if (serverResponse == "N") return;
        }
    }

    private static int[] findValues(int[] array, Scanner in){
        int[] complement = calculateComplement(array);
        int[] reverse = calculateReverse(array);
        int[] compRev = calculateReverse(complement);
        int[] indexesToCheck = new int[2];
        HashMap<Integer, String> values = new HashMap<>();
        boolean found = false;

        for (int i = 0; i < array.length && !found; i++) {
            for (int j = i + 1; j < array.length && !found; j++) {
                if(array[i] != -1) {
                    HashMap<Integer, String> valuesTemp = new HashMap<>();
                    valuesTemp.put(array[i] * 2 + array[j], "none");
                    valuesTemp.put(complement[i] * 2 + complement[j], "comp");
                    valuesTemp.put(reverse[i] * 2 + reverse[j], "reve");
                    valuesTemp.put(compRev[i] * 2 + compRev[j], "core");
                    if(valuesTemp.size() >= 3) {
                        values = (HashMap<Integer, String>) valuesTemp.clone();
                        indexesToCheck[0] = i;
                        indexesToCheck[1] = j;
                        if(values.size() == 4) found = true;
                    }
                }
            }
        }
        if(values.size() < 3) {
            indexesToCheck[0] = 0;
            indexesToCheck[1] = 1;
            values.put(array[0] * 2 + array[1], "none");
            values.put(complement[0] * 2 + complement[1], "comp");
            values.put(reverse[0] * 2 + reverse[1], "reve");
            values.put(compRev[0] * 2 + compRev[1], "core");
        }

        //Find what happened
        System.out.println(indexesToCheck[0] + 1);
        int a = Integer.parseInt(in.nextLine());
        System.out.println(indexesToCheck[1] + 1);
        int b = Integer.parseInt(in.nextLine());

        String whatHappened = values.get(a * 2 + b);
        switch (whatHappened){
            case "comp":
                return complement;
            case "reve":
                return reverse;
            case "core":
                return compRev;
        }
        return array;
    }

    private static int[] calculateReverse(int[] array) {
        int[] reverse = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - 1 - i];
        }
        return reverse;
    }

    private static int[] calculateComplement(int[] array) {
        int[] complement = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            complement[i] = array[i] != -1 ? 1 - array[i] : -1;
        }
        return complement;
    }
}
