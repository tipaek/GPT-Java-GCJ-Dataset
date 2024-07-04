import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = -1;
            }
            solve(sc, arr);
        }
    }
    public static void solve(Scanner sc, int[] arr) {
        if (arr.length == 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                arr[i] = sc.nextInt();
            }
            System.out.println(arrToString(arr));
            String s = sc.next();
            if (s.equals("Y")) {
            } else {
            }
            return;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
            arr[i] = sc.nextInt();
            System.out.println(arr.length - i);
            arr[arr.length - 1 - i] = sc.nextInt();
        }
        // check what operation happened
        // 1) check for just complement
        arr = openNextBits(arr, sc);
        System.out.println(arrToString(arr));
        String s = sc.next();
        if (s.equals("Y")) {
        } else {
        }
    }

    public static int[] openNextBits(int[] arr, Scanner sc) {
        // find firstNotOpened
        int index = getIndexFirstNotOpened(arr);
        if (index == -1) {
            return arr; // all opened
        }
        int iteration = 0;
        // found i: arr[i] != arr[arr.length - 1 - i]
        int I = -1;
        for (int i = 0; i < index; i++) {
            if(arr[arr.length - 1 - i] == -1) {
                break;
            }
            if (arr[i] != arr[arr.length - 1 - i]) {
                I = i;
                break;
            }
        }
        if (I == -1) {
            // R == N
            int someIndex = 1;
            System.out.println(someIndex);
            iteration++;
            int v = sc.nextInt();
            if (v == arr[someIndex - 1]) {
                // So => N
            } else {
                // So => C
                arr = complement(arr);
            }
        } else {
            System.out.println(I + 1);
            iteration++;
            int v = sc.nextInt();
            if (v == arr[I]) {
                // C+R or N
                // found j: arr[j] == arr[arr.length - 1 - j];
                int J = -1;
                for (int i = 0; i < index; i++) {
                    if(arr[arr.length - 1 - i] == -1) {
                        break;
                    }
                    if (arr[i] == arr[arr.length - 1 - i]) {
                        J = i;
                        break;
                    }
                }
                if (J == -1) {
                    // C + R == N => N
                } else {
                    System.out.println(J + 1);
                    iteration++;
                    int v2 = sc.nextInt();
                    if (v2 == arr[J]) {
                        // N
                    } else {
                        // C + R
                        arr = complementAndReverse(arr);
                    }
                }
            } else {
                // R or C
                // found j: arr[j] == arr[arr.length - 1 - j];
                int J = -1;
                for (int i = 0; i < index; i++) {
                    if(arr[arr.length - 1 - i] == -1) {
                        break;
                    }
                    if (arr[i] == arr[arr.length - 1 - i]) {
                        J = i;
                        break;
                    }
                }
                if (J == -1) {
                    // C == R
                    arr = complement(arr);
                } else {
                    System.out.println(J + 1);
                    iteration++;
                    int v2 = sc.nextInt();
                    if (v2 == arr[J]) {
                        // R
                        arr = reverse(arr);
                    } else {
                        // C
                        arr = complement(arr);
                    }
                }
            }
        }
        // here we can open 8 next items
        for (int i = index; i < index + 4; i++) {
            System.out.println(i + 1);
            arr[i] = sc.nextInt();
            System.out.println(arr.length - i);
            arr[arr.length - 1 - i] = sc.nextInt();
        }
        if(iteration == 1) {
            System.out.println(0 + 1);
            int vv = sc.nextInt();
            if (vv != arr[0]) {
                //System.err.println("Error");
            }
        }
        return openNextBits(arr, sc);
    }

    public static int getIndexFirstNotOpened(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public static int[] complement(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                res[i] = -1;
            } else if (arr[i] == 1) {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
        }
        return res;
    }

    public static int[] reverse(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[arr.length - 1 - i];
        }
        return res;
    }

    public static int[] complementAndReverse(int[] arr) {
        return reverse(complement(arr));
    }

    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
