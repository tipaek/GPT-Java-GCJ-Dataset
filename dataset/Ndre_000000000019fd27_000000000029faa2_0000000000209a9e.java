import java.util.ArrayList;
import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        String ok;
        if (b == 10) {
            for (int i = 1; i <= t; i++) {
                String res = "";
                for (int j = 1; j <= b; j++) {
                    System.out.println(j);
                    res += sc.next();
                }
                System.out.println(res);
                ok = sc.next();
                if (ok.equals("N")) return;
            }
        } else {
            for (int i = 1; i <= t; i++) {
                int query = 1;
                int[] norm = new int[b];
                int[] neg = new int[b];
                int[] rev = new int[b];
                int[] rev_neg = new int[b];
                for (int j = 1; j <= 5; j++) {
                    System.out.println(j);
                    norm[j - 1] = sc.nextInt();
                    neg[j - 1] = (norm[j - 1] + 1) % 2;
                    rev[b - j] = norm[j - 1];
                    rev_neg[b - j] = neg[j - 1];
                    query++;
                }
                for (int j = 0; j < 5; j++) {
                    System.out.println(b - j);
                    norm[b - j - 1] = sc.nextInt();
                    neg[b - j - 1] = (norm[b - j - 1] + 1) % 2;
                    rev[j] = norm[b - j - 1];
                    rev_neg[j] = neg[b - j - 1];
                    query++;
                }
                int cont = 10;
                ArrayList<Integer> toCheck = new ArrayList<>();
                int index_same = -1, index_diff = -1;
                for (int j = 0; j < 5; j++) {
                    if (norm[j] == rev[j]) index_same = j;
                    else index_diff = j;
                }
                if (index_same != -1) {
                    toCheck.add(index_same);
                }
                if (index_diff != -1) {
                    toCheck.add(index_diff);
                }
                int start = 5;
                int end = b - 4;
                while (cont < b) {
                    int check_1 = toCheck.get(0);
                    System.out.println((check_1+1));
                    query++;
                    int risp_1 = sc.nextInt();
                    if(toCheck.size()==1){
                        System.out.println("1");
                        sc.nextInt();
                        query++;
                    }
                    if (toCheck.size() == 2) {
                        int check_2 = toCheck.get(1);
                        System.out.println((check_2+1));
                        query++;
                        int risp_2 = sc.nextInt();
                        if (risp_1 == norm[check_1] && risp_2 == norm[check_2]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                norm[start + x - 1] = sc.nextInt();
                                neg[start + x - 1] = (norm[start + x - 1] + 1) % 2;
                                rev[end - x - 1] = norm[start + x - 1];
                                rev_neg[end - x - 1] = neg[start + x - 1];
                                System.out.println(end - x);
                                query++;
                                norm[end - x - 1] = sc.nextInt();
                                neg[end - x - 1] = (norm[end - x - 1] + 1) % 2;
                                rev[start + x - 1] = norm[end - x - 1];
                                rev_neg[start + x - 1] = neg[end - x - 1];
                                cont += 2;
                            }
                        } else if (risp_1 == rev[check_1] && risp_2 == rev[check_2]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                rev[start + x - 1] = sc.nextInt();
                                rev_neg[start + x - 1] = (rev[start + x - 1] + 1) % 2;
                                norm[end - x - 1] = rev[start + x - 1];
                                neg[end - x - 1] = (norm[end - x - 1] + 1) % 2;
                                System.out.println(end - x);
                                query++;
                                rev[end - x - 1] = sc.nextInt();
                                rev_neg[end - x - 1] = (rev[end - x - 1] + 1) % 2;
                                norm[start + x - 1] = rev[end - x - 1];
                                neg[start + x - 1] = (norm[start + x - 1] + 1) % 2;
                                cont += 2;
                            }
                        } else if (risp_1 == neg[check_1] && risp_2 == neg[check_2]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                neg[start + x - 1] = sc.nextInt();
                                norm[start + x - 1] = (neg[start + x - 1] + 1) % 2;
                                rev[end - x - 1] = norm[start + x - 1];
                                rev_neg[end - x - 1] = (rev[end - x - 1] + 1) % 2;
                                System.out.println(end - x);
                                query++;
                                neg[end - x - 1] = sc.nextInt();
                                norm[end - x - 1] = (neg[end - x - 1] + 1) % 2;
                                rev[start + x - 1] = norm[end - x - 1];
                                rev_neg[start + x - 1] = neg[end - x - 1];
                                cont += 2;
                            }
                        } else if (risp_1 == rev_neg[check_1] && risp_2 == rev_neg[check_2]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                rev_neg[start + x - 1] = sc.nextInt();
                                rev[start + x - 1] = (rev_neg[start + x - 1] + 1) % 2;
                                norm[end - x - 1] = rev[start + x - 1];
                                neg[end - x - 1] = (norm[end - x - 1] + 1) % 2;
                                System.out.println(end - x);
                                query++;
                                rev_neg[end - x - 1] = sc.nextInt();
                                rev[end - x - 1] = (rev_neg[end - x - 1] + 1) % 2;
                                norm[start + x - 1] = rev[end - x - 1];
                                neg[start + x - 1] = (norm[start + x - 1] + 1) % 2;
                                cont += 2;
                            }
                        }
                        start += 4;
                        end -= 4;
                    } else {
                        if (risp_1 == norm[check_1] && risp_1 == rev[check_1]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                norm[start + x - 1] = sc.nextInt();
                                rev[end - x - 1] = norm[start + x - 1];
                                neg[start + x - 1] = (norm[start + x - 1] + 1) % 2;
                                rev_neg[end - x - 1] = neg[start + x - 1];
                                System.out.println(end - x);
                                query++;
                                norm[end - x - 1] = sc.nextInt();
                                rev[start + x - 1] = norm[end - x - 1];
                                neg[end - x - 1] = (norm[end - x - 1] + 1) % 2;
                                rev_neg[start + x - 1] = neg[end - x - 1];
                                cont += 2;
                            }
                        }
                        else if (risp_1 == norm[check_1] && risp_1 == rev_neg[check_1]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                norm[start + x - 1] = sc.nextInt();
                                rev_neg[end - x - 1] = norm[start + x - 1];
                                neg[start + x - 1] = (norm[start + x - 1] + 1) % 2;
                                rev[end - x - 1] = neg[start + x - 1];
                                System.out.println(end - x);
                                query++;
                                norm[end - x - 1] = sc.nextInt();
                                rev_neg[start + x - 1] = norm[end - x - 1];
                                neg[end + x - 1] = (norm[end + x - 1] + 1) % 2;
                                rev[start + x - 1] = neg[end + x - 1];
                                cont += 2;
                            }
                        }
                        else if (risp_1 == rev[check_1] && risp_1 == neg[check_1]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                rev[start + x - 1] = sc.nextInt();
                                neg[end + x - 1] = rev[start + x - 1];
                                norm[end + x - 1] = (neg[end + x - 1] + 1) % 2;
                                rev_neg[start + x - 1] = norm[end + x - 1];
                                System.out.println(end - x);
                                query++;
                                rev[end - x - 1] = sc.nextInt();
                                neg[start + x - 1] = rev[end - x - 1];
                                norm[start + x - 1] = (neg[start + x - 1] + 1) % 2;
                                rev_neg[end - x - 1] = norm[start + x - 1];
                                cont += 2;
                            }
                        }
                        else if (risp_1 == rev_neg[check_1] && risp_1 == neg[check_1]) {
                            for (int x = 1; x <= 4 && cont < b; x++) {
                                System.out.println(start + x);
                                query++;
                                rev_neg[start + x - 1] = sc.nextInt();
                                neg[end - x - 1] = rev_neg[start + x - 1];
                                norm[end - x - 1] = (neg[end - x - 1] + 1) % 2;
                                rev[start + x - 1] = norm[end - x - 1];
                                System.out.println(end - x);
                                query++;
                                rev_neg[end - x - 1] = sc.nextInt();
                                neg[start + x - 1] = rev_neg[end - x - 1];
                                norm[start + x - 1] = (neg[start + x - 1] + 1) % 2;
                                rev[end - x - 1] = norm[start + x - 1];
                                cont += 2;
                            }
                        }
                        index_same = -1;
                        index_diff = -1;
                        toCheck = new ArrayList<>();
                        for (int j = 1; j <= 4; j++) {
                            if (norm[start + j] == rev[start + j]) index_same = start+j - 1;
                            else index_diff = start+ j - 1;
                        }
                        if (index_same != -1) {
                            toCheck.add(index_same);
                        }
                        if (index_diff != -1) {
                            toCheck.add(index_diff);
                        }
                        start += 4;
                        end -= 4;
                    }
                }
                if ((query + 1) % 10 == 1) {
                    System.out.println("1");
                    sc.nextInt();
                } else if ((query + 2) % 10 == 1) {
                    System.out.println("1");
                    sc.nextInt();
                    System.out.println("1");
                    sc.nextInt();
                }
                int check_1 = toCheck.get(0);
                System.out.println((check_1+1));
                int risp_1 = sc.nextInt();
                System.out.println(risp_1);
                StringBuilder ris = new StringBuilder();
                if (toCheck.size() == 2) {
                    int check_2 = toCheck.get(1);
                    System.out.println((check_2+1));
                    int risp_2 = sc.nextInt();
                    System.out.println(risp_2);
                    if (risp_1 == norm[check_1] && risp_2 == norm[check_2]) {
                        for (int f = 0; f < b; f++) {
                            ris.append(norm[f]);
                        }
                    } else if (risp_1 == rev[check_1] && risp_2 == rev[check_2]) {
                        for (int f = 0; f < b; f++) {
                            ris.append(rev[f]);
                        }
                    } else if (risp_1 == neg[check_1] && risp_2 == neg[check_2]) {
                        for (int f = 0; f < b; f++) {
                            ris.append(neg[f]);
                        }

                    } else if (risp_1 == rev_neg[check_1] && risp_2 == rev_neg[check_2]) {
                        for (int f = 0; f < b; f++) {
                            ris.append(rev_neg[f]);
                        }

                    }

                } else {
                    if (risp_1 == norm[check_1]) {
                        for (int f = 0; f < b; f++) {
                            ris.append(norm[f]);
                        }
                    } else if (risp_1 == neg[check_1]) {
                        for (int f = 0; f < b; f++) {
                            ris.append(neg[f]);
                        }
                    }
                }
                System.out.println(ris.toString());
                ok = sc.next();
                if (ok.equals("N")) return;
            }
        }
    }
}