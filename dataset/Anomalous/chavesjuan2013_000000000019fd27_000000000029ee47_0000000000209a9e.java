import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int T = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);

        for (int m = 0; m < T; ++m) {
            ArrayList<Pair>[] lists = new ArrayList[(B / 10) * 4];
            for (int i = 0; i < (B / 10) * 4; ++i) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < B / 10; ++i) {
                for (int j = 5 * i + 1; j <= 5 * (i + 1); ++j) {
                    System.out.println(j);
                    int a = Integer.parseInt(br.readLine());
                    System.out.println(B + 1 - j);
                    int b = Integer.parseInt(br.readLine());

                    if (a == b) {
                        if (a == 0) {
                            lists[4 * i].add(new Pair(j, B + 1 - j));
                        } else {
                            lists[4 * i + 3].add(new Pair(j, B + 1 - j));
                        }
                    } else {
                        if (a == 1) {
                            lists[4 * i + 2].add(new Pair(j, B + 1 - j));
                        } else {
                            lists[4 * i + 1].add(new Pair(j, B + 1 - j));
                        }
                    }
                }
            }

            ArrayList<Pair> defList00 = new ArrayList<>();
            ArrayList<Pair> defList01 = new ArrayList<>();
            ArrayList<Pair> defList10 = new ArrayList<>();
            ArrayList<Pair> defList11 = new ArrayList<>();
            int queries = 0;

            for (int i = 0; i < B / 10; ++i) {
                if (lists[4 * i].isEmpty() && lists[4 * i + 3].isEmpty()) continue;

                if (defList00.isEmpty() && defList11.isEmpty()) {
                    defList00 = lists[4 * i];
                    defList11 = lists[4 * i + 3];
                    continue;
                }

                if (defList00.isEmpty()) {
                    processList(lists, defList11, defList00, 4 * i + 3, br);
                    queries += 2;
                } else {
                    processList(lists, defList00, defList11, 4 * i + 3, br);
                    queries += 2;
                }
            }

            while (queries % 10 != 0) {
                System.out.println(1);
                br.readLine();
                queries++;
            }

            for (int i = 0; i < B / 10; ++i) {
                if (lists[4 * i + 1].isEmpty() && lists[4 * i + 2].isEmpty()) continue;

                if (defList01.isEmpty() && defList10.isEmpty()) {
                    defList01 = lists[4 * i + 1];
                    defList10 = lists[4 * i + 2];
                    continue;
                }

                if (defList01.isEmpty()) {
                    processList(lists, defList10, defList01, 4 * i + 2, br);
                    queries += 2;
                } else {
                    processList(lists, defList01, defList10, 4 * i + 2, br);
                    queries += 2;
                }
            }

            while (queries % 10 != 0) {
                System.out.println(1);
                br.readLine();
                queries++;
            }

            char[] result = new char[B];
            fillResult(defList00, result, br);
            fillResult(defList11, result, br);
            fillResult(defList01, result, br);
            fillResult(defList10, result, br);

            System.out.println(new String(result));
            br.readLine();
        }
    }

    private static void processList(ArrayList<Pair>[] lists, ArrayList<Pair> defList1, ArrayList<Pair> defList2, int index, BufferedReader br) throws IOException {
        if (lists[index].isEmpty()) {
            System.out.println(defList1.get(0).a);
            int temp1 = Integer.parseInt(br.readLine());
            System.out.println(lists[index].get(0).a);
            int temp2 = Integer.parseInt(br.readLine());
            if (temp1 == temp2) {
                defList1.addAll(lists[index]);
            } else {
                defList2.addAll(lists[index]);
            }
        } else {
            System.out.println(defList1.get(0).a);
            int temp1 = Integer.parseInt(br.readLine());
            System.out.println(lists[index].get(0).a);
            int temp2 = Integer.parseInt(br.readLine());
            if (temp1 == temp2) {
                defList1.addAll(lists[index]);
                defList2.addAll(lists[index + 3]);
            } else {
                defList2.addAll(lists[index + 3]);
                defList1.addAll(lists[index]);
            }
        }
    }

    private static void fillResult(ArrayList<Pair> defList, char[] result, BufferedReader br) throws IOException {
        if (!defList.isEmpty()) {
            System.out.println(defList.get(0).a);
            String s = br.readLine();
            for (Pair p : defList) {
                result[p.a - 1] = s.charAt(0);
                result[p.b - 1] = s.charAt(0);
            }
        }
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}