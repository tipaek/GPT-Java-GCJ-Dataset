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
            for (int i = 0; i < lists.length; ++i) {
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

            ArrayList<Pair> list00 = new ArrayList<>();
            ArrayList<Pair> list01 = new ArrayList<>();
            ArrayList<Pair> list10 = new ArrayList<>();
            ArrayList<Pair> list11 = new ArrayList<>();
            int queries = 0;

            for (int i = 0; i < B / 10; ++i) {
                if (lists[4 * i].isEmpty() && lists[4 * i + 3].isEmpty()) continue;

                if (list00.isEmpty() && list11.isEmpty()) {
                    list00 = lists[4 * i];
                    list11 = lists[4 * i + 3];
                    continue;
                }

                if (list00.isEmpty()) {
                    handleEmptyList(br, lists, i, list11, list00, queries);
                } else {
                    handleEmptyList(br, lists, i, list00, list11, queries);
                }
            }

            while (queries % 10 != 0) {
                System.out.println(1);
                br.readLine();
                queries++;
            }

            for (int i = 0; i < B / 10; ++i) {
                if (lists[4 * i + 1].isEmpty() && lists[4 * i + 2].isEmpty()) continue;

                if (list01.isEmpty() && list10.isEmpty()) {
                    list01 = lists[4 * i + 1];
                    list10 = lists[4 * i + 2];
                    continue;
                }

                if (list01.isEmpty()) {
                    handleEmptyList(br, lists, i, list10, list01, queries);
                } else {
                    handleEmptyList(br, lists, i, list01, list10, queries);
                }
            }

            while (queries % 10 != 0) {
                System.out.println(1);
                br.readLine();
                queries++;
            }

            char[] result = new char[B];
            fillResultArray(br, list00, result, true);
            fillResultArray(br, list11, result, true);
            fillResultArray(br, list01, result, false);
            fillResultArray(br, list10, result, false);

            StringBuilder sb = new StringBuilder();
            for (char c : result) {
                sb.append(c);
            }

            System.out.println(sb.toString());
            if (br.readLine().equals("N")) return;
        }
    }

    private static void handleEmptyList(BufferedReader br, ArrayList<Pair>[] lists, int i, ArrayList<Pair> list1, ArrayList<Pair> list2, int queries) throws IOException {
        if (lists[4 * i].isEmpty()) {
            System.out.println(list1.get(0).a);
            int temp1 = Integer.parseInt(br.readLine());
            System.out.println(lists[4 * i + 3].get(0).a);
            int temp2 = Integer.parseInt(br.readLine());
            queries += 2;
            if (temp1 == temp2) {
                list1.addAll(lists[4 * i + 3]);
            } else {
                list2.addAll(lists[4 * i + 3]);
            }
        } else {
            System.out.println(list1.get(0).a);
            int temp1 = Integer.parseInt(br.readLine());
            System.out.println(lists[4 * i].get(0).a);
            int temp2 = Integer.parseInt(br.readLine());
            queries += 2;
            if (temp1 == temp2) {
                list1.addAll(lists[4 * i]);
                list2.addAll(lists[4 * i + 3]);
            } else {
                list2.addAll(lists[4 * i + 3]);
                list1.addAll(lists[4 * i]);
            }
        }
    }

    private static void fillResultArray(BufferedReader br, ArrayList<Pair> list, char[] result, boolean singleRead) throws IOException {
        if (!list.isEmpty()) {
            System.out.println(list.get(0).a);
            String s = br.readLine();
            if (singleRead) {
                for (Pair p : list) {
                    result[p.a - 1] = s.charAt(0);
                    result[p.b - 1] = s.charAt(0);
                }
            } else {
                System.out.println(list.get(0).b);
                String t = br.readLine();
                for (Pair p : list) {
                    result[p.a - 1] = s.charAt(0);
                    result[p.b - 1] = t.charAt(0);
                }
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