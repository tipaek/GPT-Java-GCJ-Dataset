import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            String inputStr = scanner.next();
            char[] valuesArr = inputStr.toCharArray();
            Node headNode = new Node(null, null, Character.getNumericValue(valuesArr[0]));
            Node prevNode = headNode;

            for (int k = 1; k < valuesArr.length; k++) {
                Node newNode = new Node(prevNode, null, Character.getNumericValue(valuesArr[k]));
                prevNode.nextNode = newNode;
                prevNode = newNode;
            }

            adjustParentheses(headNode);

            String nestedString = buildNestedString(headNode);
            System.out.println("Case #" + i + ": " + nestedString);
        }
    }

    private static void adjustParentheses(Node headNode) {
        Node currentNode = headNode;

        while (currentNode != null) {
            if (currentNode.prevNode != null && currentNode.value != 0) {
                if (currentNode.prevNode.openParentheses > currentNode.closeParentheses) {
                    currentNode.prevNode.closeParentheses -= currentNode.closeParentheses;
                    currentNode.openParentheses = 0;
                } else if (currentNode.prevNode.openParentheses < currentNode.closeParentheses) {
                    currentNode.openParentheses -= currentNode.prevNode.openParentheses;
                    currentNode.prevNode.closeParentheses = 0;
                } else {
                    currentNode.prevNode.closeParentheses = 0;
                }
            }
            while (currentNode.nextNode != null && currentNode.nextNode.value == currentNode.value) {
                currentNode = currentNode.nextNode;
            }
            currentNode = currentNode.nextNode;
        }
    }

    private static String buildNestedString(Node headNode) {
        StringBuilder nestedString = new StringBuilder();
        Node currentNode = headNode;

        while (currentNode != null) {
            nestedString.append("(".repeat(currentNode.openParentheses)).append(currentNode.value);

            while (currentNode.nextNode != null && currentNode.nextNode.value == currentNode.value) {
                currentNode = currentNode.nextNode;
                nestedString.append(currentNode.value);
            }

            nestedString.append(")".repeat(currentNode.closeParentheses));
            currentNode = currentNode.nextNode;
        }

        return nestedString.toString();
    }

    static class Node {
        Node prevNode;
        Node nextNode;
        int value;
        int openParentheses;
        int closeParentheses;

        Node(Node prevNode, Node nextNode, int value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
            this.openParentheses = value;
            this.closeParentheses = value;
        }
    }
}