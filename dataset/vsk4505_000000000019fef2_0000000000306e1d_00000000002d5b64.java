import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public final static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 1; k <= S; k++)
             {
                 for (int j = 1; j <= R; j++)
                 {
                    list.add(j);
                }
            }

            ArrayList<Integer> outputList = new ArrayList<>();
            boolean sorted = false;
            int operationCount = 0;

            while (!sorted) {
                int AStartIndex = 0;
                int AEndIndex = 0;
                int BStartIndex = 0;
                int BEndIndex = 0;
                int AGroupCount = 0;
                int BGroupCount = 0;
                //System.out.println("list: " + list);
                int index = AStartIndex;
                while (index + 1 < list.size() && list.get(index) <= list.get(index + 1)) {
                    index++;
                    AEndIndex = index;
                }
                if (index + 1 >= list.size()) {
                    sorted = true;
                    break;
                }
                BStartIndex = AEndIndex + 1;
                index = BStartIndex;
                while (index + 1 < list.size() && list.get(index) <= list.get(index + 1) && list.get(index) < list.get(AEndIndex)) {
                    index++;
                    BEndIndex = index;
                }
                //System.out.println("index: " + (AEndIndex+1) + " , " + (BEndIndex - BStartIndex));
                outputList.add((AEndIndex+1));
                outputList.add((BEndIndex - BStartIndex));
                for (index = BStartIndex; index < BEndIndex; index++) {
                    Integer elem = list.remove(index);
                    //System.out.println("elem: " + elem);
                    list.add(index - BStartIndex, elem);
                }
                operationCount++;
            }

            System.out.println("Case #" + (i + 1) + ": " + operationCount);
            for (int j = 0; j < outputList.size(); j += 2) {
                System.out.println(outputList.get(j) + ", " + outputList.get(j + 1));
            }
        }
    }
}