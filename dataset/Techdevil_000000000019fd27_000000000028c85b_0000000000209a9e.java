import java.util.Scanner;

class Main {

    public static void magic(int v[], int n, int op) {
        if (op == 1) {  //flip
            for (int i = 0; i < n; ++i) {
                int r = n - i - 1;
                if (v[i] != -1 && v[r] != -1) {
                    v[i] = 1 - v[i];
                    v[r] = 1 - v[r];
                } else {
                    v[i] = -1;
                    v[r] = -1;
                }
            }
        } else if (op == 2) { //reverse
            for (int i = 0; i < n; ++i) {
                int r = n - i - 1;
                if (v[i] != -1 && v[r] != -1) {
                    int temp = v[i];
                    v[i] = v[r];
                    v[r] = temp;
                } else {
                    v[i] = -1;
                    v[r] = -1;
                }
            }
        } else { //reverse and flip
            for (int i = 0; i < n; ++i) {
                int r = n - i - 1;
                if (v[i] != -1 && v[r] != -1) {
                    int temp = v[i];
                    v[i] = v[r];
                    v[r] = temp;
                    v[i] = 1 - v[i];
                    v[r] = 1 - v[r];
                } else {
                    v[i] = -1;
                    v[r] = -1;
                }
            }
        }
    }
    
    public static void myAssert(boolean y){
        if(!y){
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        for (int testcase = 1; testcase <= testcases; testcase++) {

            int b = sc.nextInt();

            int arr[] = new int[b];
            for (int i = 0; i < b; i++)
                arr[i] = -1;

            int god[] = {-1, -1};

            int cur = 0;

            for (int tries = 1; tries <= 150;) {

                if (cur * 2 >= b)
                    break;

                if (tries != 1 && tries % 10 == 1) {

                    if (god[0] != -1) {

                        int idx = god[0];

                        myAssert (idx >= 0 && idx < b);

                        System.out.println(idx + 1);
                        tries++;

                        int val = sc.nextInt();
                        myAssert (val >= 0 && val <= 1);

                        if (val == arr[god[0]]) {

                            if (god[1] == -1) {
                                continue;
                            } else {
                                int idx2 = god[1];
                                myAssert (idx2 >= 0 && idx2 < b);
                                System.out.println(idx2 + 1);
                                tries++;

                                int val2 = sc.nextInt();
                                myAssert (val2 >= 0 && val2 <= 1);

                                if (val2 == arr[god[1]]) {
                                    continue;
                                } else {
                                    magic(arr, b, 2); //reverse
                                }
                            }

                        } else {
                            if (god[1] == -1) {
                                magic(arr, b, 1); //flip
                            } else {
                                int idx2 = god[1];
                                myAssert (idx2 >= 0 && idx2 < b);
                                System.out.println(idx2 + 1);
                                tries++;

                                int val2 = sc.nextInt();
                                myAssert (val2 >= 0 && val2 <= 1);

                                if (val2 == arr[god[1]]) {
                                    magic(arr, b, 3); //both
                                } else {
                                    magic(arr, b, 1); //flip
                                }
                            }
                        }

                    } else {
                        myAssert (god[1] != -1);

                        int idx = god[1];
                        myAssert (idx >= 0 && idx < b);
                        System.out.println(idx + 1);
                        tries++;

                        int val = sc.nextInt();
                        myAssert (val >= 0 && val <= 1);

                        if (val == arr[god[1]]) {
                            continue;
                        } else {
                            magic(arr, b, 1);
                        }

                    }

                } else {

                    if (tries % 10 == 0) {
                        System.out.println(1);
                        tries++;

                        int fl = sc.nextInt();
                        myAssert (fl >= 0 && fl <= 1);
                    } else {

                        myAssert (cur >= 0 && cur < b);
                        System.out.println(cur + 1);
                        tries++;

                        int val = sc.nextInt();
                        myAssert (val >= 0 && val <= 1);

                        arr[cur] = val;

                        myAssert (b - cur - 1 >= 0 && b - cur - 1 < b);
                        System.out.println(b - cur);
                        tries++;

                        int val2 = sc.nextInt();
                        myAssert (val2 >= 0 && val2 <= 1);

                        arr[b - cur - 1] = val2;
                        if (val == val2) {
                            god[0] = cur;
                        } else {
                            god[1] = cur;
                        }
                        cur++;
                    }

                }
            }

            for (int i = 0; i < b; ++i) {
                System.out.print(arr[i]);
                myAssert (arr[i] != -1);
            }
            System.out.println();

            String x = sc.next();

            if (x != null && x.equals("Y"))
                continue;
            else {
                myAssert(false);
                return;
            }
        }
    }
}
