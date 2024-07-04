import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

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
                            lists[4 * i].add(new Pair(a, b));
                        } else {
                            lists[4 * i + 3].add(new Pair(a, b));
                        }
                    } else {
                        if (a == 1) {
                            lists[4 * i + 2].add(new Pair(a, b));
                        } else {
                            lists[4 * i + 1].add(new Pair(a, b));
                        }
                    }
                }
            }

            ArrayList<Pair> list00 = new ArrayList<>();
            ArrayList<Pair> list01 = new ArrayList<>();
            ArrayList<Pair> list10 = new ArrayList<>();
            ArrayList<Pair> list11 = new ArrayList<>();
            int queries = 0;

            queries = processLists(br, B, lists, list00, list11, queries, 0, 3);
            queries = processLists(br, B, lists, list01, list10, queries, 1, 2);

            while (queries % 10 != 0) {
                System.out.println(1);
                br.readLine();
                queries++;
            }

            char[] res = new char[B];
            fillResult(br, list00, res, true);
            fillResult(br, list11, res, true);
            fillResult(br, list01, res, false);
            fillResult(br, list10, res, false);

            System.out.println(new String(res));
        }
    }

    private static int processLists(BufferedReader br, int B, ArrayList<Pair>[] lists, ArrayList<Pair> listA, ArrayList<Pair> listB, int queries, int indexA, int indexB) throws IOException {
        for (int i = 0; i < B / 10; ++i) {
            if (lists[4 * i + indexA].isEmpty() && lists[4 * i + indexB].isEmpty()) continue;

            if (listA.isEmpty() && listB.isEmpty()) {
                listA.addAll(lists[4 * i + indexA]);
                listB.addAll(lists[4 * i + indexB]);
                continue;
            }

            if (listA.isEmpty()) {
                queries = updateLists(br, lists, listA, listB, queries, i, indexA, indexB);
            } else {
                queries = updateLists(br, lists, listB, listA, queries, i, indexB, indexA);
            }
        }
        return queries;
    }

    private static int updateLists(BufferedReader br, ArrayList<Pair>[] lists, ArrayList<Pair> listA, ArrayList<Pair> listB, int queries, int i, int indexA, int indexB) throws IOException {
        if (lists[4 * i + indexA].isEmpty()) {
            System.out.println(listB.get(0).a);
            int temp1 = Integer.parseInt(br.readLine());
            System.out.println(lists[4 * i + indexB].get(0).a);
            int temp2 = Integer.parseInt(br.readLine());
            queries += 2;
            if (temp1 == temp2) {
                listB.addAll(lists[4 * i + indexB]);
            } else {
                listA.addAll(lists[4 * i + indexB]);
            }
        } else {
            System.out.println(listB.get(0).a);
            int temp1 = Integer.parseInt(br.readLine());
            System.out.println(lists[4 * i + indexA].get(0).a);
            int temp2 = Integer.parseInt(br.readLine());
            queries += 2;
            if (temp1 == temp2) {
                listB.addAll(lists[4 * i + indexA]);
                listA.addAll(lists[4 * i + indexB]);
            } else {
                listA.addAll(lists[4 * i + indexB]);
                listB.addAll(lists[4 * i + indexA]);
            }
        }
        return queries;
    }

    private static void fillResult(BufferedReader br, ArrayList<Pair> list, char[] res, boolean sameChar) throws IOException {
        if (!list.isEmpty()) {
            System.out.println(list.get(0).a);
            String s = br.readLine();
            char ch = s.charAt(0);
            for (Pair p : list) {
                res[p.a - 1] = ch;
                res[p.b - 1] = sameChar ? ch : br.readLine().charAt(0);
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