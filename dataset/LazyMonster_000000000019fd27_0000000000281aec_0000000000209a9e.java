import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author ducbm
 */
public class Solution {

    static enum Type {
        FLIP(0), REVERSE(1), FLIP_REVERSE(2), NONE(3);

        int value;

        Type(int value) {
            this.value = value;
        }
    }

    static int testFunc(int[] oldHead, int[] oldTail, int[] newHead) {
        int length = oldHead.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (oldHead[i] == newHead[i]) {
                counter++;
            }
        }
        if (counter == length) {
            return Type.NONE.value;
        }

        counter = 0;
        for (int i = 0; i < length; i++) {
            if (oldHead[i] == 1 - newHead[i]) {
                counter++;
            }
        }
        if (counter == length) {
            return Type.FLIP.value;
        }

        counter = 0;
        for (int i = 0; i < length; i++) {
            if (newHead[i] == oldTail[length - i - 1]) {
                counter++;
            }
        }
        if (counter == length) {
            return Type.REVERSE.value;
        }

        return Type.FLIP_REVERSE.value;
    }

    public static void main(String[] args) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line = reader.readLine();
                String[] tokens = line.split(" ");

                int T = Integer.valueOf(tokens[0]);
                int B = Integer.valueOf(tokens[1]);

                for (int i = 0; i < T; i++) {
                    if (B == 10) {
                        StringBuilder builder = new StringBuilder();
                        for (int j = 1; j <= B; j++) {
                            System.out.println(j);

                            line = reader.readLine();
                            builder.append(line);
                        }

                        System.out.println(builder.toString());
                        reader.readLine();
                    } else if (B == 20) {
                        int[] arr1 = new int[20];
                        for (int j = 1; j <= 5; j++) {
                            System.out.println(j);

                            line = reader.readLine();
                            arr1[j - 1] = Integer.valueOf(line);
                        }

                        for (int j = 16; j <= 20; j++) {
                            System.out.println(j);

                            line = reader.readLine();
                            arr1[j - 1] = Integer.valueOf(line);
                        }

                        for (int j = 6; j <= 15; j++) {
                            System.out.println(j);

                            line = reader.readLine();
                            arr1[j - 1] = Integer.valueOf(line);
                        }

                        int[] arr2 = new int[10];
                        for (int j = 1; j <= 10; j++) {
                            System.out.println(j);

                            line = reader.readLine();
                            arr2[j - 1] = Integer.valueOf(line);
                        }

                        int[] oldHead = new int[5];
                        int[] oldTail = new int[5];
                        int[] newHead = new int[5];
                        System.arraycopy(arr1, 0, oldHead, 0, 5);
                        System.arraycopy(arr1, 15, oldTail, 0, 5);
                        System.arraycopy(arr2, 0, newHead, 0, 5);
                        int type1 = testFunc(oldHead, oldTail, newHead);

                        System.arraycopy(arr1, 5, oldHead, 0, 5);
                        System.arraycopy(arr1, 10, oldTail, 0, 5);
                        System.arraycopy(arr2, 5, newHead, 0, 5);
                        int type2 = testFunc(oldHead, oldTail, newHead);

                        int[] ret = new int[20];
                        if (type1 == Type.NONE.value) {
                            for (int j = 0; j < 5; j++) {
                                ret[j] = arr1[j];
                            }
                            for (int j = 15; j < 20; j++) {
                                ret[j] = arr1[j];
                            }
                        } else if (type1 == Type.FLIP.value) {
                            for (int j = 0; j < 5; j++) {
                                ret[j] = 1 - arr1[j];
                            }
                            for (int j = 15; j < 20; j++) {
                                ret[j] = 1 - arr1[j];
                            }
                        } else if (type1 == Type.REVERSE.value) {
                            for (int j = 0; j < 5; j++) {
                                ret[j] = arr1[19 - j];
                            }
                            for (int j = 15; j < 20; j++) {
                                ret[j] = arr1[19 - j];
                            }
                        } else {
                            for (int j = 0; j < 5; j++) {
                                ret[j] = 1 - arr1[19 - j];
                            }
                            for (int j = 15; j < 20; j++) {
                                ret[j] = 1 - arr1[19 - j];
                            }
                        }
                        
                        if (type2 == Type.NONE.value) {
                            for (int j = 5; j < 15; j++) {
                                ret[j] = arr1[j];
                            }
                        } else if (type2 == Type.FLIP.value) {
                            for (int j = 5; j < 15; j++) {
                                ret[j] = 1 - arr1[j];
                            }
                        } else if (type2 == Type.REVERSE.value) {
                            for (int j = 5; j < 15; j++) {
                                ret[j] = arr1[19 - j];
                            }
                        } else {
                            for (int j = 5; j < 15; j++) {
                                ret[j] = 1 - arr1[19 - j];
                            }
                        }
                        
                        char[] arr = new char[20];
                        for (int j = 0; j < ret.length; j++) {
                            arr[j] = (char) (ret[j] + 48);
                        }
                        
                        System.out.println(new String(arr));
                        reader.readLine();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
