import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static int T, B;

    class Node {
        Node[] children = new Node[4];
        int[] bitArr;

        public Node(int[] arr) {
            this.bitArr = arr;
            children[0] = new Node(same(arr));
            children[1] = new Node(complement(arr));
            children[3] = new Node(reverse(arr));
            children[4] = new Node(complementAndReverse(arr));
        }

        public int[] complement(int[] arr) {
            int[] resArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                resArr[i] = arr[i];
                if (resArr[i] == 0) resArr[i] = 1;
                else if (resArr[i] == 1) resArr[i] = 0;
            }
            return resArr;
        }

        public int[] reverse(int[] arr) {
            int[] resArr = new int[arr.length];
            for (int i = 0, j = arr.length-1; i < arr.length && j >= 0; i++, j--) {
                resArr[j] = arr[i];
            }
            return resArr;
        }

        public int[] complementAndReverse(int[] arr) {
            return reverse(complement(arr));
        }

        public int[] same(int[] arr) {
            return arr.clone();
        }

        @Override
        public boolean equals(Object obj) {
            Node oNode = (Node)obj;
            return Arrays.equals(this.bitArr, oNode.bitArr);
        }
    }

    public static void getDataFromStdIn() {
        if (myReader.hasNextLine()) {
            String[] inputArr = myReader.nextLine().replace("\n", "").trim().split(" ");
            T = Integer.valueOf(inputArr[0]);
            B = Integer.valueOf(inputArr[1]);
        }
    }

    public static void processB10() {
        int[] rootArr = new int[10];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1);
            rootArr[i] = Integer.valueOf(myReader.nextLine().replace("\n", "").trim());
            res.append(rootArr[i]);
        }
        System.out.printf("%s\n", res.toString());
    }

    public static void processB20() {
        System.out.printf("%s\n", "1100");

    }

    public static void processB100() {
        System.out.printf("%s\n", "1100");
    }

    public static void main(String[] args) {
        getDataFromStdIn();
        if (B == 10) {
            for (int i = 0; i < T; i++)
                processB10();
        } else if(B == 20) {
            for (int i = 0; i < T; i++)
                processB20();
        } else if (B == 100) {
            for (int i = 0; i < T; i++)
                processB100();
        }
    }
}
