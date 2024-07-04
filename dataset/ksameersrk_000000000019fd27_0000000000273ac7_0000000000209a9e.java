import java.util.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    static class Marker {
        int left;
        int right;
        int b;
        int counter;

        public Marker(int B) {
            left = 0;
            right = B-1;
            b = B;
            counter = 1;
        }

        public int incrementLeft(int n) {
            left += n;
            return left;
        }

        public int decrementLeft(int n) {
            left -= n;
            return left;
        }

        public int incrementCounter(int n) {
            counter += n;
            return counter;
        }

        public int getCounter() {
            return counter;
        }

        public int incrementCounter() {
            return ++counter;
        }

        public int getAndIncrementCounter() {
            return counter++;
        }

        public int getAndIncrementLeft() {
            return left++;
        }

        public int decrementRight(int n) {
            right -= n;
            return right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public boolean isDone() {
            return left >= right;
        }

        public int getB() {
            return b;
        }
    }

    private static void start() {
        int T = in.nextInt();
        int B = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int arr[] = new int[B];
            for(int i=0; i<B; i++) arr[i] = -1;
            int index = 0;
            if(B <= 10) {
                while (index < B) {
                    System.out.println(index+1);
                    arr[index] = in.nextInt();
                    index++;
                }
            } else {
                int res;
                Marker marker = new Marker(B);
                for(int i=0; i<5; i++) {
                    System.out.println(marker.getAndIncrementCounter());
                    res = in.nextInt();
                    arr[marker.getAndIncrementLeft()] = res;

                    System.out.println(marker.getAndIncrementCounter());
                    res = in.nextInt();
                    arr[marker.getRight()] = res;
                    marker.decrementRight(1);
                }
                while (!marker.isDone()) {
                    int newArr[] = new int[5];
                    for(int newIndex = 4; newIndex >= 0; newIndex--){
                        System.out.println(newIndex);
                        marker.incrementCounter();
                        res = in.nextInt();
                        newArr[newIndex] = res;
                        newIndex++;
                    }

                    nextFive(arr, newArr, marker);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int r : arr) {
                sb.append(r);
            }
            in.nextLine();
            System.out.println(sb);
            String verdict = in.nextLine();
            if(!verdict.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static int nextFive(int []arr, int []newArr, Marker marker) {
        boolean isSame = true;
        for(int i=0; i<5; i++) {
            if(arr[i] != newArr[i]) {
                isSame = false;
                break;
            }
        }

        boolean isComplement = true;
        for(int i=0; i<5; i++) {
            if(arr[i] != newArr[i]) {
                isComplement = false;
                break;
            }
        }

        boolean isReverse = true;
        for(int i=0; i<5; i++) {
            if(arr[marker.getB()-1-i] != newArr[i]) {
                isReverse = false;
                break;
            }
        }

        boolean isComplementReverse = !(isSame || isComplement || isReverse);

        if(isComplementReverse) {
            int[] brr = new int[marker.getB()];
            for(int i=0; i<marker.getB(); i++) {
                brr[marker.getB()-1-i] = complementN(arr, i);
            }
            arr = brr;
        } else if(isReverse) {
            int[] brr = new int[marker.getB()];
            for(int i=0; i<marker.getB(); i++) {
                brr[marker.getB()-1-i] = arr[i];
            }
            arr = brr;

        } else if(isComplement) {
            int[] brr = new int[marker.getB()];
            for(int i=0; i<marker.getB(); i++) {
                brr[i] = complementN(arr, i);
            }
            arr = brr;
        }

        int left = marker.getLeft();
        for(int i=0; i<5; i++) {
            System.out.println(left+1);
            arr[marker.getAndIncrementLeft()] = in.nextInt();
        }



        return marker.getLeft();
    }

    private static int complementN(int []a, int index) {
        if(a[index] == -1) return -1;
        else return a[index] == 1? 0 : 1;
    }
}
