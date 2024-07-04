import java.util.*;
import java.io.*;

public class Solution {

    private static int attempt;

    private static void sendInt(int x) {
        System.out.println(x);
        System.out.flush();
        attempt++;
    }

    private static void sendByteArray(byte[] x) {
        String out = "";
        for (byte b : x) {
            out += Byte.toString(b);
        }
        System.out.println(out);
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        int b = in.nextInt();

        for (int t = 1; t <= tests; ++t) {
            attempt = 0;
            byte[] data = new byte[b];
            int elp = 0, dlp = 0;
            byte buffer1, buffer2;
            boolean eFound = false, dFound = false;
            boolean read = false;
            int i = 0;
            while (attempt < 150) {
                if (!eFound || !dFound) {
                    sendInt(i + 1);
                    buffer1 = in.nextByte();
                    sendInt(b - i);
                    buffer2 = in.nextByte();
                    if (buffer1 == buffer2) {
                        eFound = true;
                        data[i] = buffer1;
                        data[b - i - 1] = buffer2;
                        elp = i;
                    }
                    if (buffer1 != buffer2) {
                        dFound = true;
                        data[i] = buffer1;
                        data[b - i - 1] = buffer2;
                        dlp = i;
                    }
                    i++;
                } else if (!read) {
                    if (attempt >= 10) {
                        while (attempt % 10 != 0) {
                            sendInt(1);
                        }
                        sendInt(elp + 1);
                        buffer1 = in.nextByte();
                        data[elp] = buffer1;
                        data[b - elp - 1] = buffer1;
                        sendInt(dlp + 1);
                        buffer1 = in.nextByte();
                        data[dlp] = buffer1;
                        data[b - dlp - 1] = buffer1 == 0 ? (byte) 1 : (byte) 0;
                    }
                    read = true;
                    i = 0;
                } else {
                    if (attempt % 10 == 0) {
                        sendInt(elp + 1);
                        buffer1 = in.nextByte();
                        sendInt(dlp + 1);
                        buffer2 = in.nextByte();
                        boolean complemented = data[elp] != buffer1;
                        boolean reversed = complemented ? data[dlp] == buffer2 : data[dlp] != buffer2;
                        if (complemented) {
                            data = complement(data);
                        }
                        if (reversed) {
                            data = reverse(data);
                        }
                    } else {
                        if (i == elp || i == b - elp - 1 || i == dlp || i == b - dlp - 1) {
                            i++;
                        } else if (i < b) {
                            sendInt(i + 1);
                            data[i] = in.nextByte();
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
            sendByteArray(data);
            String result = in.next();
            if (result.equals("N")) {
                break;
            }
        }
    }

    private static byte[] complement(byte[] data) {
        byte[] out = new byte[data.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = data[i] == 0 ? (byte) 1 : (byte) 0;
        }
        return out;
    }

    private static byte[] reverse(byte[] data) {
        byte[] out = new byte[data.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = data[data.length - i - 1];
        }
        return out;
    }

}