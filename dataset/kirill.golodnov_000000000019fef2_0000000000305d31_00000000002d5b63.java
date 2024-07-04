import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8))) {
            StringTokenizer tokens = new StringTokenizer(in.readLine());
            int tests = parseInt(tokens.nextToken());
            int a = parseInt(tokens.nextToken());
            int b = parseInt(tokens.nextToken());
            for (int t = 1; t <= tests; t++) {
                if (a == b && a == 1000000000 - 5) {
                    boolean success = false;
                    for (int x = -5; x <= 5; x++) {
                        for (int y = -5; y <= 5; y++) {
                            String s = readResponse(x, y, in, out);
                            if (s.equals("CENTER")) {
                                success = true;
                                break;
                            }
                        }
                        if (success) {
                            break;
                        }
                    }
                } else if (a == b && a == 1000000000 - 50) {
                    int r = 1000000000 - 50;
                    int sqrt = 707106745;
                    String s = readResponse(0, 0, in, out);
                    if (s.equals("CENTER")) {
                        continue;
                    }
                    int xs;
                    int xe;
                    int ys;
                    int ye;
                    String s1 = readResponse(sqrt, sqrt, in, out);
                    String s2 = readResponse(-sqrt, sqrt, in, out);
                    String s3 = readResponse(sqrt, -sqrt, in, out);
                    String s4 = readResponse(-sqrt, -sqrt, in, out);
                    if (s1.equals("HIT")) {
                        xs = 0;
                        xe = 50;
                        ys = 0;
                        ye = 50;
                    } else if (s2.equals("HIT")) {
                        xs = -50;
                        xe = 0;
                        ys = 0;
                        ye = 50;
                    } else if (s3.equals("HIT")) {
                        xs = 0;
                        xe = 50;
                        ys = -50;
                        ye = 0;
                    } else {
                        xs = -50;
                        xe = 0;
                        ys = -50;
                        ye = 0;
                    }
                    int xc = (xs + xe) / 2;
                    int yc = (ys + ye) / 2;
                    s = readResponse(xc, yc, in, out);
                    if (s.equals("CENTER")) {
                        continue;
                    }
                    s1 = readResponse(xc + sqrt, yc + sqrt, in, out);
                    s2 = readResponse(xc - sqrt, yc + sqrt, in, out);
                    s3 = readResponse(xc + sqrt, yc - sqrt, in, out);
                    s4 = readResponse(xc - sqrt, yc - sqrt, in, out);
                    if (s1.equals("HIT")) {
                        xs = xc;
                        ys = yc;
                    } else if (s2.equals("HIT")) {
                        xe = xc;
                        ys = yc;
                    } else if (s3.equals("HIT")) {
                        xs = xc;
                        ye = yc;
                    } else {
                        xe = xc;
                        ye = yc;
                    }


                    xc = (xs + xe) / 2;
                    yc = (ys + ye) / 2;
                    s = readResponse(xc, yc, in, out);
                    if (s.equals("CENTER")) {
                        continue;
                    }

                    boolean success = false;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            s = readResponse(xc + i, yc + i, in, out);
                            if (s.equals("CENTER")) {
                                success = true;
                                break;
                            }
                        }
                        if (success) {
                            break;
                        }
                    }
                    if (success) {
                        continue;
                    }

                    s1 = readResponse(xc + sqrt, yc + sqrt, in, out);
                    s2 = readResponse(xc - sqrt, yc + sqrt, in, out);
                    s3 = readResponse(xc + sqrt, yc - sqrt, in, out);
                    s4 = readResponse(xc - sqrt, yc - sqrt, in, out);
                    if (s1.equals("HIT")) {
                        xs = xc;
                        ys = yc;
                    } else if (s2.equals("HIT")) {
                        xe = xc;
                        ys = yc;
                    } else if (s3.equals("HIT")) {
                        xs = xc;
                        ye = yc;
                    } else {
                        xe = xc;
                        ye = yc;
                    }

                    System.err.println("xs = " + xs + ", xe = " + xe + ", ys = " + ys + ", ye = " + ye);
                    success = false;
                    for (int x = xs; x <= xe; x++) {
                        for (int y = ys; y <= ye; y++) {
                            String resp = readResponse(x, y, in, out);
                            if (resp.equals("CENTER")) {
                                success = true;
                                break;
                            }
                        }
                        if (success) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static String readResponse(int x, int y, BufferedReader in, BufferedWriter out) throws IOException {
        out.write(x + " " + y);
        out.newLine();
        out.flush();
        return in.readLine();
    }
}
