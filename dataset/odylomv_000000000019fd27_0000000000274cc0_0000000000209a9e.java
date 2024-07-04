import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        int b = in.nextInt();
        for (int loops = 1; loops <= t; ++loops) {
            //Input
//            int m = in.nextInt();

            //Solution
            int[] array = new int[b];
            int[] check = new int[b];
            int reverseIndex = -1, sameIndex = -1;
            Arrays.fill(array, -1);

            String response;
            Stack<Integer> indexStack = new Stack<>(), checkStack = new Stack<>();

            for (int i = b - 1; i >= 0; i--) {
                //Switch from front to end
                Integer index = (i % 2 == 0) ? i / 2 : b - 1 - (i / 2);
                indexStack.push(index);
            }

//            for (int query = 0; query < 10; query++) {
//                int index = query % 2 == 0 ? query / 2 : b - 1 - (query / 2);
//                System.out.println(index);
//                System.out.flush();
//
//                response = in.next();
//                if (response.equals("N"))
//                    return;
//                array[index] = Integer.parseInt(response);
//            }

            for (int query = 1; query <= 150; query++) {
                if (isFull(array))
                    break;

                if (query % 10 == 1 && query != 1) {
                    Arrays.fill(check, -1);
                    //Populate check stack
                    reverseIndex = -1;
                    sameIndex = -1;
                    for (int i = 0; i < b / 2; i++) {
                        if (reverseIndex == -1 && (array[i] != array[b - 1 - i])) {
                            reverseIndex = i;
                        }

                        if (sameIndex == -1 && (array[i] == array[b - 1 -i]) && array[i] != -1) {
                            sameIndex = i;
                        }
                    }

                    if (reverseIndex != -1 && sameIndex != -1) {
                        checkStack.push(reverseIndex);
                        checkStack.push(sameIndex);
                    }
                    else if (reverseIndex == -1) {
                        checkStack.push(sameIndex);
                    }
                    else {
                        checkStack.push(reverseIndex);
                    }

                }

                if (!checkStack.isEmpty()) {
                    int index = checkStack.pop();
                    System.out.println(index + 1);
                    System.out.flush();

                    response = in.next();
                    if (response.charAt(0) == 'N')
                        return;
                    check[index] = Integer.parseInt(response);

                    if (checkStack.isEmpty()) {
                        //Both
                        if (reverseIndex != -1 && sameIndex != -1) {
                            if (array[reverseIndex] != check[reverseIndex] && array[sameIndex] == check[sameIndex]) {
                                //mirror
                                mirror(array);
                            }
                            else if (array[reverseIndex] == check[reverseIndex] && array[sameIndex] != check[sameIndex]){
                                //rev + mirror
                                reverse(array);
                                mirror(array);
                            }
                            else if (array[reverseIndex] != check[reverseIndex] && array[sameIndex] != check[sameIndex]) {
                                //rev
                                reverse(array);
                            }
                        }
                        //Reverse Only
                        else if (reverseIndex != -1) {
                            if (array[reverseIndex] != check[reverseIndex]) {
                                //rev or mirror do the same thing
                                reverse(array);
                            }
                        }
                        //Same Only
                        else {
                            if (array[sameIndex] != check[sameIndex]) {
                                //rev
                                reverse(array);
                            }
                        }
                    }
                }
                else {
                    int index = indexStack.pop();
                    System.out.println(index + 1);
                    System.out.flush();

                    response = in.next();
                    if (response.charAt(0) == 'N')
                        return;
                    array[index] = Integer.parseInt(response);
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(array[i]);
            }

            //Result
            System.out.println(result);
            System.out.flush();
            response = in.next();
            if (response.charAt(0) == 'N')
                return;
//            System.out.println("Case #" + loops + ": ");
        }
    }

    public static boolean isFull(int[] array) {
        for (int val : array)
            if (val == -1)
                return false;

        return true;
    }

    public static void reverse(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                array[i] = array[i] == 0 ? 1 : 0;
            }
        }
    }

    public static void mirror(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}