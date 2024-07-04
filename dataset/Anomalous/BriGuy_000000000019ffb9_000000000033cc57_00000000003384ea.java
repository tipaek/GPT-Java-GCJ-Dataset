import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long L = Long.parseLong(tokenizer.nextToken());
            long R = Long.parseLong(tokenizer.nextToken());

            long difference = Math.abs(L - R);
            long left = 0;
            long right = difference;
            long answer = (left + right) / 2;

            while (left <= right) {
                if (left == right) break;
                if (left == right - 1) {
                    answer = !isValid(left, difference) ? right : left;
                    break;
                }

                answer = (left + right) / 2;
                if (isValid(answer, difference)) {
                    right = answer;
                } else {
                    left = answer;
                }
            }

            long leftover = 0;
            long rightOver = 0;

            if (L >= R) {
                L -= answer * (answer + 1) / 2;
            } else {
                R -= answer * (answer + 1) / 2;
            }

            long next = answer + 1;
            if (next % 2 == 0) {
                if (L < R) {
                    L += (next / 2) * (next / 2);
                    long temp = (long) Math.sqrt(L);
                    leftover = L - temp * temp;

                    temp = temp * 2 - 1;
                    rightOver = R - (temp / 2) * (temp / 2 + 1) + (answer / 2 * (answer / 2 + 1));

                    if (rightOver > temp + 1) {
                        rightOver -= temp + 1;
                        temp++;
                    }

                    answer = temp;
                } else {
                    R += (next / 2) * (next / 2);
                    long temp = (long) Math.sqrt(R);
                    rightOver = R - temp * temp;

                    temp = temp * 2 - 1;
                    leftover = L - (temp / 2) * (temp / 2 + 1) + (answer / 2 * (answer / 2 + 1));

                    if (leftover > temp + 1) {
                        leftover -= temp + 1;
                        temp++;
                    }

                    answer = temp;
                }
            } else {
                if (L < R) {
                    long a = 0;
                    long b = L;
                    long mid = (a + b) / 2;

                    while (a <= b) {
                        if (a == b) {
                            mid = a;
                            break;
                        }

                        if (a == b - 1) {
                            mid = isValid2(b, answer, L) ? b : a;
                            break;
                        }

                        mid = (a + b) / 2;
                        if (isValid2(mid, answer, L)) {
                            a = mid;
                        } else {
                            b = mid;
                        }
                    }

                    if (mid % 2 == 1) mid--;

                    leftover = L - (mid / 2) * (mid / 2 + 1) + (answer / 2 * (answer / 2 + 1));
                    rightOver = R + (next / 2) * (next / 2) - (mid / 2) * (mid / 2);

                    if (rightOver >= mid + 1) {
                        rightOver -= mid + 1;
                        mid++;
                    }

                    answer = mid;
                } else {
                    long a = 0;
                    long b = R;
                    long mid = (a + b) / 2;

                    while (a <= b) {
                        if (a == b) {
                            mid = a;
                            break;
                        }

                        if (a == b - 1) {
                            mid = isValid2(b, answer, R) ? b : a;
                            break;
                        }

                        mid = (a + b) / 2;
                        if (isValid2(mid, answer, R)) {
                            a = mid;
                        } else {
                            b = mid;
                        }
                    }

                    if (mid % 2 == 1) mid--;

                    rightOver = R - (mid / 2) * (mid / 2 + 1) + (answer / 2 * (answer / 2 + 1));
                    leftover = L + (next / 2) * (next / 2) - (mid / 2) * (mid / 2);

                    if (leftover >= mid + 1) {
                        leftover -= mid + 1;
                        mid++;
                    }

                    answer = mid;
                }
            }

            System.out.println("Case #" + t + ": " + answer + " " + leftover + " " + rightOver);
        }
    }

    public static boolean isValid(long a, long b) {
        return (a * (a + 1) / 2 >= b);
    }

    public static boolean isValid2(long a, long answer, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (answer / 2 * (answer / 2 + 1)) >= 0);
    }
}