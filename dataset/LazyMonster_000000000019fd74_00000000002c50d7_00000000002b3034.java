
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ducbm
 */
public class Solution {

    public static void doMainFunc(BufferedReader reader) {
        try {
            int T = Integer.valueOf(reader.readLine());
            for (int i = 0; i < T; i++) {
                int N = Integer.valueOf(reader.readLine());

                List<Character> listStart = new LinkedList<>();
                LinkedList<Character> listEnd = new LinkedList<>();

                boolean possible = true;
                for (int j = 0; j < N; j++) {
                    String line = reader.readLine();
                    char[] arr = line.toCharArray();

                    int idx = 0;
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k] == '*') {
                            break;
                        } else {
                            if (k == listStart.size()) {
                                listStart.add(arr[k]);
                            }
//                            else if (k < listEnd.size()) {
//                                if (idx >= 0 && idx < listEnd.size() && listEnd.get(idx) != arr[k]) {
//                                    possible = false;
//                                }
//                            }
                        }
                        idx++;
                    }

                    idx = 0;
                    for (int k = arr.length - 1; k >= 0; k--) {
                        if (arr[k] == '*') {
                            break;
                        } else {
                            if (arr.length - 1 - k == listEnd.size()) {
                                listEnd.add(arr[k]);
                            } else if (arr.length - 1 - k < listEnd.size()) {
                                if (idx >= 0 && idx < listEnd.size() && listEnd.get(idx) != arr[k]) {
                                    possible = false;
                                }
                            }
                        }
                        idx++;
                    }
                }
                for (int j = listEnd.size() - 1; j >= 0; j--) {
                    listStart.add(listEnd.get(j));
                }

                StringBuilder buffer = new StringBuilder();
                for (char c : listStart) {
                    buffer.append(c);
                }

                if (possible) {
                    System.out.println(String.format("Case #%d: %s", i + 1, buffer.toString()));
                } else {
                    System.out.println(String.format("Case #%d: %s", i + 1, "*"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void doFunc() {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                doMainFunc(reader);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void doFuncTest(String fileName) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "UTF-8"))) {
                doMainFunc(reader);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doFunc();
    }
}
