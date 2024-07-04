import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();

        int numOfCases = Integer.parseInt(input.split(" ")[0]);
        int size = Integer.parseInt(input.split(" ")[1]);
        for(int i=0;i<numOfCases;i++) {
            TestCase tc = new TestCase(size, scanner);
            String result = tc.getResult();
            System.out.println(result);
            input = scanner.nextLine();
            if (!input.equals("Y")) {
                exit(1);
            }
        }

    }


    public static class TestCase {

        private final int size;
        private final Integer[] data;
        private final Scanner scanner;
        public TestCase(int size, Scanner scanner) {
            this.size = size;
            this.scanner = scanner;
            data = new Integer[size];
        }

        private void complement() {
            for (int i=0;i<size;i++) {
                Integer val = data[i];
                if (val != null) {
                    if (val==0) {
                        data[i]=1;
                    } else {
                        data[i]=0;
                    }
                }
            }
        }

        private void reverse() {
            for (int i=0;i<size/2;i++) {
                Integer val = data[i];
                data[i]=data[size-i-1];
                data[size-i-1]=val;
            }
        }

        private String getResult() {

            int guess=1;
            int idx=0;
            boolean flag=true;
            boolean fetching = true;
            int sameIdx =-1;
            int diffIdx =-1;

            while(guess<=150 && Arrays.asList(data).stream().anyMatch(x->x == null)) {
                if (guess != 1 && guess % 10 ==1) {
                    //check if reset
                    fetching = false;
                }
                if (fetching) {
                    int ask;
                    if (flag) {
                        ask = idx;
                    } else {
                        ask = size - idx -1;
                        idx++;
                    }

                    System.out.println(ask+1);
                    String input = scanner.nextLine();
                    if (input.equals("0") || input.equals("1")) {
                        data[ask] = Integer.parseInt(input);
                        if (!flag) {
                            if (data[idx-1]==data[ask]) {
                                sameIdx=idx-1;
                            } else {
                                diffIdx=idx-1;
                            }
                        }
                    } else {
                        exit(1);
                    }
                    flag = !flag;
                    guess++;
                } else {
                    if (sameIdx != -1 ) {
                        System.out.println(sameIdx+1);
                        String input = scanner.nextLine();
                        if (input.equals("0") || input.equals("1")) {
                            if (data[sameIdx]!=Integer.parseInt(input)) {
                                complement();
                            }
                        } else {
                            exit(1);
                        }
                        guess++;
                    }
                    if (diffIdx !=-1) {
                        System.out.println(diffIdx+1);
                        String input = scanner.nextLine();
                        if (input.equals("0") || input.equals("1")) {
                            if (data[diffIdx]!=Integer.parseInt(input)) {
                                reverse();
                            }
                        } else {
                            exit(1);
                        }
                        guess++;
                    }
                    fetching = true;
                }

            }

            StringBuffer sb = new StringBuffer();
            for (int i=0;i<size;i++) {
                sb.append(data[i]);
            }
            return sb.toString();
        }
    }
}