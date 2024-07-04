import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = stoi(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb.append(String.format("Case #%d: ", i));
            st = new StringTokenizer(br.readLine());
            int in1 = stoi(st.nextToken());
            int in2 = stoi(st.nextToken());
            boolean xmin = (in1 < 0);
            boolean ymin = (in2 < 0);

            int x = Math.abs(in1);
            int y = Math.abs(in2);

            if (((x + y + 1) & (x + y)) == 0) {
                int j = 1;
                while ((x + y) > 0) {
                    if ((x & j) > 0) {
                        sb.append((xmin) ? "W" : "E");
                        x -= (x & (-x));
                    } else {
                        sb.append((ymin) ? "S" : "N");
                        y -= (y & (-y));
                    }
                    j <<= 1;
                }
            } else if (x > y) {
                if (((-x + y + 1) & (-x + y)) == 0) {
                    int j = 1;
                    while ((x + y) > 0) {
                        if ((x & j) > 0) {
                            if (((x - 1) & x) != 0) {
                                sb.append((xmin) ? "E" : "W");
                                x -= (x & (-x));
                            } else {
                                x -= (x & (-x));
                            }
                        } else {
                            sb.append((ymin) ? "S" : "N");
                            y -= (y & (-y));
                        }
                        j <<= 1;
                    }
                    sb.append((xmin) ? "W" : "E");
                }
            } else if (x < y) {
                if (((x - y + 1) & (x - y)) == 0) {
                    int j = 1;
                    while ((x + y) > 0) {
                        if ((x & j) > 0) {
                            sb.append((xmin) ? "W" : "E");
                            x -= (x & (-x));
                        } else {
                            if (((y - 1) & y) != 0) {
                                sb.append((ymin) ? "N" : "S");
                                y -= (y & (-y));
                            } else {
                                y -= (y & (-y));
                            }
                        }
                        j <<= 1;
                    }
                    sb.append((ymin) ? "S" : "N");
                }
            } else if (((-x - y + 1) & (-x - y)) == 0) {
                int j = 1;
                while ((x + y) > 0) {
                    if ((x & j) > 0) {
                        if (((x - 1) & y) != 0) {
                            sb.append((xmin) ? "E" : "W");
                            x -= (x & (-x));
                        } else {
                            x -= (x & (-x));
                        }
                    } else {
                        if (((y - 1) & y) != 0) {
                            sb.append((ymin) ? "N" : "S");
                            y -= (y & (-y));
                        } else {
                            y -= (y & (-y));
                        }
                    }
                    j <<= 1;
                }
                if (x > y) {
                    sb.append((ymin) ? "S" : "N");
                    sb.append((xmin) ? "W" : "E");
                } else {
                    sb.append((xmin) ? "W" : "E");
                    sb.append((ymin) ? "S" : "N");
                }
            } else {
                sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
