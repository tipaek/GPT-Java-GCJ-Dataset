import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    static void complement(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                arr[i] = '1';
            } else if (arr[i] == '1') {
                arr[i] = '0';
            }
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        String w = scanner.nextLine();
        for (int i = 0; i < t; i++) {
            char[] data = new char[b];
            if (b % 2 != 0) {
                int diff = 0;
                int delta = -1;
                int left = -1;
                int right = -1;
                for (int j = 0; j < 150;) {
                    if (j % 10 == 0) {
                        System.out.println(b / 2 + 1);
                        char ch = scanner.next().charAt(0);
                        if (j == 0) {
                            data[b / 2] = ch;
                            j++;
                            continue;
                        } else {
                            j++;
                            if (left == -1) {
                                for (int k = 0; k < diff; k++) {
                                    if (data[(b / 2) - (k + 1)] != data[(b / 2) + (k + 1)] && (data[(b / 2) - (k + 1)] == '1' || data[(b / 2) - (k + 1)] == '0') && (data[(b / 2) + (k + 1)] == '1' || data[(b / 2) + (k + 1)] == '0')) {
                                        left = (b / 2) - (k + 1);
                                        right = (b / 2) + (k + 1);
                                    }
                                }
                            }
                            if (data[b / 2] == ch) {
                                if (left != -1) {
                                    System.out.println(left + 1);
                                    char chl = scanner.next().charAt(0);
                                    j++;
                                    if (chl != data[left]) {
                                        Collections.reverse(Arrays.asList(data));
                                    }
                                }
                            } else {
                                if (left == -1) {
                                    complement(data);
                                } else {
                                    System.out.println(left + 1);
                                    char chl = scanner.next().charAt(0);
                                    j++;
                                    if (chl != data[left]) {
                                        complement(data);
                                    } else {
                                        Collections.reverse(Arrays.asList(data));
                                        complement(data);
                                    }
                                }
                            }
                        }
                    } else {
                        int sleft = (((j / 10) * 10) + 10) - j;
                        boolean done = false;
                        for (int k = 0; k < sleft; k++) {
                            System.out.println((b / 2) + delta + 1);
                            data[(b / 2) + delta] = scanner.next().charAt(0);
                            j++;
                            if ((b / 2) + delta == b - 1) {
                                done = true;
                                break;
                            }
                            if (delta < 0) {
                                delta *= -1;
                            } else {
                                delta *= -1;
                                delta -= 1;
                                diff++;
                            }
                        }
                        if (done) {
                            break;
                        }
                    }
                }
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < b; j++) {
                    s.append(data[j]);
                }
                System.out.println(s);
                char result = scanner.next().charAt(0);
                if (result == 'Y') {
                    continue;
                } else {
                    System.exit(0);
                }
            } else {
                int diff = 0;
                int delta = -1;
                int left = -1;
                int right = -1;
                System.out.println(b / 2);
                char chl = scanner.next().charAt(0);
                System.out.println((b / 2) + 1);
                char chr = scanner.next().charAt(0);
                data[(b / 2) - 1] = chl;
                data[b / 2] = chr;
                if (chl == chr) {
                    left = (b / 2) - 1;
                    right = b / 2;
                    for (int j = 2; j < 150; j++) {


                        if (j % 10 == 0) {
                            System.out.println(b / 2 + 1);
                            char ch = scanner.next().charAt(0);
                            j++;
                                if (data[b / 2] == ch) {
                                    if (left != -1) {
                                        System.out.println(left + 1);
                                        char chleft = scanner.next().charAt(0);
                                        j++;
                                        if (chleft != data[left]) {
                                            Collections.reverse(Arrays.asList(data));
                                        }
                                    }
                                } else {
                                    if (left == -1) {
                                        complement(data);
                                    } else {
                                        System.out.println(left + 1);
                                        char chleft = scanner.next().charAt(0);
                                        j++;
                                        if (chleft != data[left]) {
                                            complement(data);
                                        } else {
                                            Collections.reverse(Arrays.asList(data));
                                            complement(data);
                                        }
                                    }
                                }

                        } else {
                            int sleft = (((j / 10) * 10) + 10) - j;
                            boolean done = false;
                            for (int k = 0; k < sleft; k++) {
                                if (delta < 0) {
                                    System.out.println((b / 2) + delta);
                                    data[(b / 2) + delta - 1] = scanner.next().charAt(0);
                                } else {
                                    System.out.println((b / 2) + delta + 1);
                                    data[(b / 2) + delta] = scanner.next().charAt(0);
                                }
                                j++;
                                if ((b / 2) + delta == b - 1) {
                                    done = true;
                                    break;
                                }
                                if (delta < 0) {
                                    delta *= -1;
                                } else {
                                    delta *= -1;
                                    delta -= 1;
                                    diff++;
                                }
                            }
                            if (done) {
                                break;
                            }
                        }


                    }
                } else {
                    for (int j = 2; j < 150; j++) {
                        if (j % 10 == 0) {
                            System.out.println(b / 2 + 1);
                            char ch = scanner.next().charAt(0);
                            j++;


                            if (left == -1) {
                                for (int k = 0; k < diff; k++) {
                                    if (data[(b / 2) - (k + 1) - 1] == data[(b / 2) + (k + 1)] && (data[(b / 2) - (k + 1) - 1] == '1' || data[(b / 2) - (k + 1) - 1] == '0')) {
                                        left = (b / 2) - (k + 1) - 1;
                                        right = (b / 2) + (k + 1);
                                    }
                                }
                            }

                            if (data[b / 2] == ch) {
                                if (left != -1) {
                                    System.out.println(left + 1);
                                    char chleft = scanner.next().charAt(0);
                                    j++;
                                    if (chleft != data[left]) {
                                        Collections.reverse(Arrays.asList(data));
                                        complement(data);
                                    }
                                }
                            } else {
                                if (left != -1) {
                                    System.out.println(left + 1);
                                    char chleft = scanner.next().charAt(0);
                                    j++;
                                    if (chleft != data[left]) {
                                        complement(data);
                                    } else {
                                        Collections.reverse((Arrays.asList(data)));
                                    }
                                } else {
                                    complement(data);
                                }
                            }
                        } else {

                            int sleft = (((j / 10) * 10) + 10) - j;
                            boolean done = false;
                            for (int k = 0; k < sleft; k++) {
                                if (delta < 0) {
                                    System.out.println((b / 2) + delta);
                                    data[(b / 2) + delta - 1] = scanner.next().charAt(0);
                                } else {
                                    System.out.println((b / 2) + delta + 1);
                                    data[(b / 2) + delta] = scanner.next().charAt(0);
                                }
                                j++;
                                if ((b / 2) + delta == b - 1) {
                                    done = true;
                                    break;
                                }
                                if (delta < 0) {
                                    delta *= -1;
                                } else {
                                    delta *= -1;
                                    delta -= 1;
                                    diff++;
                                }
                            }
                            if (done) {
                                break;
                            }

                        }
                    }
                }
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < b; j++) {
                s.append(data[j]);
            }
            System.out.println(s);
            char result = scanner.next().charAt(0);
            if (result == 'Y') {
                continue;
            } else {
                System.exit(0);
            }
        }
    }
}