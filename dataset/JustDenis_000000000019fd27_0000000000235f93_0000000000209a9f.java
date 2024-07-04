import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            solve(scanner, i);
        }
    }

    private static void solve(Scanner scanner, int testNum) {
        char[] input = scanner.next().toCharArray();
        Element[] elements = new Element[input.length];

        for (int i = 0; i < input.length; i++) {
            elements[i] = new Element(input[i], i);
        }

        Element e = findMax(elements);
        while (e.numInt != 0) {
            int leftIndex = e.index;
            int rightIndex = e.index;
            while (leftIndex >= 0 && elements[leftIndex].numInt != 0) {
                leftIndex--;
            }
            while (rightIndex < elements.length && elements[rightIndex].numInt != 0) {
                rightIndex++;
            }

            elements[leftIndex + 1].openCount++;
            elements[rightIndex - 1].closeCount++;
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                elements[i].numInt--;
            }
            e = findMax(elements);
        }

        System.out.print("Case #" + (testNum + 1) +  ": ");
        for (Element element : elements) {
            System.out.print(element.toString());
        }
        System.out.println("");
    }

    private static Element findMax(Element[] elements) {
        Element max = elements[0];
        for (Element e : elements) {
            if (max.numInt < e.numInt) {
                max = e;
            }
        }
        return max;
    }
    private static class Element implements Comparable<Element> {
        public char originNum;
        public int numInt;
        public int index;
        public int openCount;
        public int closeCount;

        Element (char numChar, int index) {
            originNum = numChar;
            this.numInt = numChar - '0';
            this.index = index;
            this.openCount = 0;
            this.closeCount = 0;
        }

        @Override
        public int compareTo(Element other) {
            return numInt - other.numInt;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < openCount; i++) {
                sb.append('(');
            }
            sb.append(originNum);
            for (int i = 0; i < closeCount; i++) {
                sb.append(')');
            }
            return sb.toString();
        }
    }
}
