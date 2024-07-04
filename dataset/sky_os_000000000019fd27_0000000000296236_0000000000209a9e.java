
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;
    private static Random rand = new Random();

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        Collections.fill(lst, "");
        try (Scanner scanner = new Scanner(System.in)) {
            int testCount = scanner.nextInt();
            int BSize = scanner.nextInt();
            for (int i = 0; i < BSize; i++) {
                lst.add("0");
            }

            for (int count = 0; count < testCount; count++) {
                int realIndex = 0;

                for (int index = 1;; index++) {
                    _callServer(realIndex + 1);
                    int reciveValue = scanner.nextInt();

                    lst.set(realIndex, reciveValue + "");
//                    writeFile(String.format("[%d,%d,%d]\n", index, realIndex, reciveValue));
                    realIndex++;
                    if (realIndex == 10) {
                        break;
                    }
                }
                String submitValue = String.join("", lst);
                _submitTestCase(submitValue);
                String resultValue = scanner.next();
                if (resultValue.equals("N")) {
                    System.exit(0);
                }
//                writeFile(String.format("result:%s, submitValue:%s", resultValue, submitValue));
            }
//                System.out.flush();
        } catch (Exception ex) {
//            writeFile(ex.getMessage());

        }

    }

    public static void writeFile(String content) {
        try {
            try (FileWriter myWriter = new FileWriter("filename.txt", true)) {
                myWriter.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _callServer(int value) {
        System.out.println(value);
        System.out.flush();
    }

    public static void _submitTestCase(String value) {
        System.out.println(value);
        System.out.flush();
    }
}
