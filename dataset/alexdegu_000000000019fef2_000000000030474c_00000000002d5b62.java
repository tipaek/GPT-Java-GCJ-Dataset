import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int x, y;
            boolean x_odd, y_odd;

            ArrayList list_x_sol1, list_x_sol2, list_y_sol1, list_y_sol2, list_y_sol3, list_y_sol4;
            for (int l = 1; l <= t; ++l) {
                x = in.nextInt();
                y = in.nextInt();

                x_odd = x % 2 != 0;

                y_odd = y % 2 != 0;

                if (x_odd == y_odd) {
                    System.out.println("Case #" + l + ": IMPOSSIBLE");
                    continue;
                }

                list_x_sol1 = new ArrayList();
                list_x_sol2 = new ArrayList();

                if (x_odd) {
                    int tt = x;
                    x = y;
                    y = tt;
                }

                int list_max[] = new int[8];

                if (x != 0) {
                    int num_ = (int) (Math.log(Math.abs(x)) / Math.log(2));

                    if (Math.abs(x) == Math.pow(2, num_)) {
                        list_x_sol1.add(num_);
                        list_x_sol2.add(num_);
                        for (int i = 0; i < 8; i++) {
                            list_max[i] = num_;
                        }
                    } else {
                        for (int i = 0; i < 8; i++) {
                            if (i % 4 <= 1) {
                                list_max[i] = num_;
                            } else {
                                list_max[i] = num_ + 1;
                            }

                        }

                        list_x_sol1.add(num_);
                        int x_x = Math.abs(x) - (int) Math.pow(2, num_);
                        int num_x = num_;
                        while (x_x > 0) {
                            if (x_x >= Math.pow(2, num_x - 1)) {
                                x_x -= Math.pow(2, num_x - 1);
                                list_x_sol1.add(num_x - 1);
                            }
                            num_x--;
                        }

                        list_x_sol2.add(num_ + 1);
                        x_x = (int) Math.pow(2, num_ + 1) - Math.abs(x);
                        num_x = num_;
                        while (x_x > 0) {
                            if (x_x >= Math.pow(2, num_x - 1)) {
                                x_x -= Math.pow(2, num_x - 1);
                                list_x_sol2.add(num_x - 1);
                            }
                            num_x--;
                        }
                    }

                }
                list_y_sol1 = new ArrayList();
                list_y_sol2 = new ArrayList();
                list_y_sol3 = new ArrayList();
                list_y_sol4 = new ArrayList();
                boolean list[] = new boolean[8];

                int yy = y - 1;
                if (yy != 0) {
                    int num = (int) (Math.log(Math.abs(yy)) / Math.log(2));
                    //System.out.println(num);
                    if (Math.abs(yy) == Math.pow(2, num)) {
                        for (int i = 0; i < 4; i++) {
                            if (list_max[i] < num) {
                                list_max[i] = num;
                            }
                        }
                        list_y_sol1.add(num);
                        list_y_sol2.add(num);
                        if (list_x_sol1.contains(num)) {
                            list[0] = true;
                            list[1] = true;
                        }
                        if (list_x_sol2.contains(num)) {
                            list[2] = true;
                            list[3] = true;
                        }
                    } else {
                        for (int i = 0; i < 2; i++) {
                            if (list_max[i] < num) {
                                list_max[i] = num;
                            }
                        }
                        for (int i = 2; i < 4; i++) {
                            if (list_max[i] < num + 1) {
                                list_max[i] = num + 1;
                            }
                        }

                        list_y_sol1.add(num);
                        int y_y = Math.abs(yy) - (int) Math.pow(2, num);
                        int num_y = num;
                        while (y_y > 0 && (!list[0] || !list[2])) {
                            if (y_y >= Math.pow(2, num_y - 1)) {
                                if (list_x_sol1.contains(num_y - 1)) {
                                    list[0] = true;
                                }
                                if (list_x_sol2.contains(num_y - 1)) {
                                    list[2] = true;
                                }

                                y_y -= Math.pow(2, num_y - 1);
                                list_y_sol1.add(num_y - 1);
                            }
                            num_y--;
                        }

                        list_x_sol2.add(num + 1);
                        y_y = (int) Math.pow(2, num + 1) - Math.abs(yy);
                        num_y = num;
                        while (y_y > 0 && (!list[1] || !list[3])) {
                            if (y_y >= Math.pow(2, num_y - 1)) {
                                if (list_x_sol1.contains(num_y - 1)) {
                                    list[1] = true;
                                }
                                if (list_x_sol2.contains(num_y - 1)) {
                                    list[3] = true;
                                }

                                y_y -= Math.pow(2, num_y - 1);
                                list_y_sol2.add(num_y - 1);
                            }
                            num_y--;
                        }
                    }
                }
                //------------------------------
                yy = y + 1;
                if (yy != 0) {
                    int num__ = (int) (Math.log(Math.abs(yy)) / Math.log(2));
                    //System.out.println(num);
                    if (Math.abs(yy) == Math.pow(2, num__)) {
                        for (int i = 4; i < 8; i++) {
                            if (list_max[i] < num__) {
                                list_max[i] = num__;
                            }
                        }

                        list_y_sol3.add(num__);
                        list_y_sol4.add(num__);
                        if (list_x_sol1.contains(num__)) {
                            list[4] = true;
                            list[5] = true;
                        }
                        if (list_x_sol2.contains(num__)) {
                            list[6] = true;
                            list[7] = true;
                        }
                    } else {
                        for (int i = 4; i < 6; i++) {
                            if (list_max[i] < num__) {
                                list_max[i] = num__;
                            }
                        }
                        for (int i = 6; i < 8; i++) {
                            if (list_max[i] < num__ + 1) {
                                list_max[i] = num__ + 1;
                            }
                        }
                        list_y_sol3.add(num__);
                        int y_y = Math.abs(yy) - (int) Math.pow(2, num__);
                        int num_y = num__;
                        while (y_y > 0 && (!list[4] || !list[6])) {
                            if (y_y >= Math.pow(2, num_y - 1)) {
                                if (list_x_sol1.contains(num_y - 1)) {
                                    list[4] = true;
                                }
                                if (list_x_sol2.contains(num_y - 1)) {
                                    list[6] = true;
                                }

                                y_y -= Math.pow(2, num_y - 1);
                                list_y_sol3.add(num_y - 1);
                            }
                            num_y--;
                        }

                        list_y_sol4.add(num__ + 1);
                        y_y = (int) Math.pow(2, num__ + 1) - Math.abs(x);
                        num_y = num__;
                        while (y_y > 0 && (!list[5] || !list[7])) {
                            if (y_y >= Math.pow(2, num_y - 1)) {
                                if (list_x_sol1.contains(num_y - 1)) {
                                    list[5] = true;
                                }
                                if (list_x_sol2.contains(num_y - 1)) {
                                    list[7] = true;
                                }

                                y_y -= Math.pow(2, num_y - 1);
                                list_y_sol4.add(num_y - 1);
                            }
                            num_y--;
                        }
                    }
                }
                /*System.out.println(list_x_sol1);
                System.out.println(list_x_sol2);
                System.out.println(list_y_sol1);
                System.out.println(list_y_sol2);
                System.out.println(list_y_sol3);
                System.out.println(list_y_sol4);*/
                boolean ok = false;
                int min = Integer.MAX_VALUE;
                int curr = -1;
                for (int i = 0; i < 8; i++) {
                    switch (i) {
                        case 0: {
                            if (!list[i] && list_max[i] == list_x_sol1.size() + list_y_sol1.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 1: {
                            if (!list[i] && list_max[i] == list_x_sol1.size() + list_y_sol2.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 2: {
                            if (!list[i] && list_max[i] == list_x_sol2.size() + list_y_sol1.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 3: {
                            if (!list[i] && list_max[i] == list_x_sol2.size() + list_y_sol2.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 4: {
                            if (!list[i] && list_max[i] == list_x_sol1.size() + list_y_sol3.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 5: {
                            if (!list[i] && list_max[i] == list_x_sol1.size() + list_y_sol4.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 6: {
                            if (!list[i] && list_max[i] == list_x_sol2.size() + list_y_sol3.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }
                        case 7: {
                            if (!list[i] && list_max[i] == list_x_sol2.size() + list_y_sol4.size() && min > list_max[i]) {
                                ok = true;
                                min = list_max[i];
                                curr = i;
                            }
                            break;
                        }

                    }
                }

                if (ok) {
                    ArrayList firstList = new ArrayList(), secondList = new ArrayList();
                    switch (curr) {
                        case 0: {
                            firstList = list_x_sol1;
                            secondList = list_y_sol1;
                            break;
                        }
                        case 1: {
                            firstList = list_x_sol1;
                            secondList = list_y_sol2;
                            break;
                        }
                        case 2: {
                            firstList = list_x_sol2;
                            secondList = list_y_sol1;
                            break;
                        }
                        case 3: {
                            firstList = list_x_sol2;
                            secondList = list_y_sol2;
                            break;
                        }
                        case 4: {
                            firstList = list_x_sol1;
                            secondList = list_y_sol3;
                            break;
                        }
                        case 5: {
                            firstList = list_x_sol1;
                            secondList = list_y_sol4;
                            break;
                        }
                        case 6: {
                            firstList = list_x_sol2;
                            secondList = list_y_sol3;
                            break;
                        }
                        case 7: {
                            firstList = list_x_sol2;
                            secondList = list_y_sol4;
                            break;
                        }

                    }

                    Collections.sort(firstList);
                    Collections.sort(secondList);

                    String arr[] = new String[list_max[curr] + 1];

                    if (x_odd) {
                        if (curr < 4) {
                            arr[0] = "E";
                        } else {
                            arr[0] = "W";
                        }
                        if (secondList.size() > 0) {
                            if (x < 0) {
                                if ((int) secondList.get(secondList.size() - 1) > Math.abs(x)) {
                                    for (int i = 0; i < secondList.size() - 1; i++) {
                                        arr[(int) secondList.get(i)] = "E";
                                    }
                                    arr[(int) secondList.get(secondList.size() - 1)] = "W";
                                } else {
                                    for (int i = 0; i < secondList.size(); i++) {
                                        arr[(int) secondList.get(i)] = "W";
                                    }
                                }
                            } else {
                                if ((int) secondList.get(secondList.size() - 1) > Math.abs(x)) {
                                    for (int i = 0; i < secondList.size() - 1; i++) {
                                        arr[(int) secondList.get(i)] = "W";
                                    }
                                    arr[(int) secondList.get(secondList.size() - 1)] = "E";
                                } else {
                                    for (int i = 0; i < secondList.size(); i++) {
                                        arr[(int) secondList.get(i)] = "E";
                                    }
                                }
                            }
                        }
                        //y, x-odd

                        if (firstList.size() > 0) {
                            if (y < 0) {
                                if ((int) firstList.get(firstList.size() - 1) > Math.abs(y)) {
                                    for (int i = 0; i < firstList.size() - 1; i++) {
                                        arr[(int) firstList.get(i)] = "N";
                                    }
                                    arr[(int) firstList.get(firstList.size() - 1)] = "S";
                                } else {
                                    for (int i = 0; i < firstList.size(); i++) {
                                        arr[(int) firstList.get(i)] = "S";
                                    }
                                }
                            } else {
                                if ((int) firstList.get(firstList.size() - 1) > Math.abs(y)) {
                                    for (int i = 0; i < firstList.size() - 1; i++) {
                                        arr[(int) firstList.get(i)] = "S";
                                    }
                                    arr[(int) firstList.get(firstList.size() - 1)] = "N";
                                } else {
                                    for (int i = 0; i < firstList.size(); i++) {
                                        arr[(int) firstList.get(i)] = "N";
                                    }
                                }
                            }
                        }

                    } else {
                        if (curr < 4) {
                            arr[0] = "N";
                        } else {
                            arr[0] = "S";
                        }
                        if (secondList.size() > 0) {
                            if (y < 0) {
                                if ((int) secondList.get(secondList.size() - 1) > Math.abs(y)) {
                                    for (int i = 0; i < secondList.size() - 1; i++) {
                                        arr[(int) secondList.get(i)] = "N";
                                    }
                                    arr[(int) secondList.get(secondList.size() - 1)] = "S";
                                } else {
                                    for (int i = 0; i < secondList.size(); i++) {
                                        arr[(int) secondList.get(i)] = "S";
                                    }
                                }
                            } else {
                                if ((int) secondList.get(secondList.size() - 1) > Math.abs(y)) {
                                    for (int i = 0; i < secondList.size() - 1; i++) {
                                        arr[(int) secondList.get(i)] = "S";
                                    }
                                    arr[(int) secondList.get(secondList.size() - 1)] = "N";
                                } else {
                                    for (int i = 0; i < secondList.size(); i++) {
                                        arr[(int) secondList.get(i)] = "N";
                                    }
                                }
                            }
                        }
                        //y, x-odd
                        if (firstList.size() > 0) {
                            if (x < 0) {
                                if ((int) firstList.get(firstList.size() - 1) > Math.abs(x)) {
                                    for (int i = 0; i < firstList.size() - 1; i++) {
                                        arr[(int) firstList.get(i)] = "E";
                                    }
                                    arr[(int) firstList.get(firstList.size() - 1)] = "W";
                                } else {
                                    for (int i = 0; i < firstList.size(); i++) {
                                        arr[(int) firstList.get(i)] = "W";
                                    }
                                }
                            } else {
                                if ((int) firstList.get(firstList.size() - 1) > Math.abs(x)) {
                                    for (int i = 0; i < firstList.size() - 1; i++) {
                                        arr[(int) firstList.get(i)] = "W";
                                    }
                                    arr[(int) firstList.get(firstList.size() - 1)] = "E";
                                } else {
                                    for (int i = 0; i < firstList.size(); i++) {
                                        arr[(int) firstList.get(i)] = "E";
                                    }
                                }
                            }

                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arr.length; i++) {
                        sb.append(arr[i]);
                    }
                    System.out.println("Case #" + l + ": " + sb.toString());
                } else {
                    System.out.println("Case #" + l + ": IMPOSSIBLE");
                }

            }
      }
    }