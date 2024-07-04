import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] input = inputLine.split(" ");

        int numTests = Integer.parseInt(input[0]);
        int numBits = Integer.parseInt(input[1]);
        int numChunks = numBits / 10;

        for (int i = 0; i < numTests; i++) {
            List<Set<String>> chunkList1 = new ArrayList<>(numChunks);
            List<Set<String>> chunkList2 = new ArrayList<>(numChunks);

            StringBuffer front = new StringBuffer();
            StringBuffer back = new StringBuffer();
            for(int j = 0; j < numChunks; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.println((j * 5) + k + 1);
                    char frontBit = scanner.nextLine().charAt(0);
                    System.out.println(numBits - ((j + 1) * 5) + k + 1);
                    char backBit = scanner.nextLine().charAt(0);

                    front.append(frontBit);
                    back.append(backBit);
                }
                Set<String> set1 = new HashSet<>();
                set1.add(front.toString());
                set1.add(back.reverse().toString());
                set1.add(getComplement(front.toString()));
                set1.add(getComplement(back.reverse().toString()));
                chunkList1.add(set1);

                Set<String> set2 = new HashSet<>();
                set2.add(front.reverse().toString());
                set2.add(back.toString());
                set2.add(getComplement(front.reverse().toString()));
                set2.add(getComplement(back.toString()));
                chunkList2.add(set2);
            }

            for (StringBuffer result : getResults(chunkList1, chunkList2)) {
                System.out.println(result.toString());
                System.out.flush();
                char answer = scanner.nextLine().charAt(0);
                if (answer == 'Y') {
                    break;
                }
            }
        }
        scanner.close();
    }

    private static List<StringBuffer> getResults(List<Set<String>> chunkSetList1, List<Set<String>> chunkSetList2) {
        LinkedList<StringBuffer> result1 = new LinkedList<>();
        result1.add(new StringBuffer());
        LinkedList<StringBuffer> result2 = new LinkedList<>();

        boolean flag = true;
        for (int i = 0; i < chunkSetList1.size(); i++) {
            LinkedList<StringBuffer> src = flag ? result1 : result2;
            LinkedList<StringBuffer> dst = new LinkedList<>();
            Set<String> set = chunkSetList1.get(i);
            for(StringBuffer s : src) {
                for(String chunk : set) {
                    dst.add(new StringBuffer(s).append(chunk));
                }
            }
            if (flag) {
                result2 = dst;
            } else {
                result1 = dst;
            }
            flag = !flag;
        }

        for (int i = 0; i < chunkSetList2.size(); i++) {
            LinkedList<StringBuffer> src = flag ? result1 : result2;
            LinkedList<StringBuffer> dst = new LinkedList<>();
            Set<String> set = chunkSetList1.get(chunkSetList2.size() - 1 - i);
            for(StringBuffer s : src) {
                for(String chunk : set) {
                    dst.add(new StringBuffer(s).append(chunk));
                }
            }
            if (flag) {
                result2 = dst;
            } else {
                result1 = dst;
            }
            flag = !flag;
        }
        return flag ? result1 : result2;
    }

    private static String getComplement(String base) {
        StringBuffer result = new StringBuffer();
        for (char c : base.toCharArray()) {
            if (c == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return result.toString();
    }

}