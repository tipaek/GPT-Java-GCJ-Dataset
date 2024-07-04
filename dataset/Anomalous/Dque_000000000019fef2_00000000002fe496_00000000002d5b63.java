import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        
        int halfMax = 1000000000 / 2;
        
        for (int q = 1; q <= t; q++) {
            int curX = -1;
            int curY = -1;
            
            if (probe(writer, reader, "0 " + halfMax).equals("HIT")) {
                curX = 0;
                curY = halfMax;
            } else if (probe(writer, reader, "0 " + (-halfMax)).equals("HIT")) {
                curX = 0;
                curY = -halfMax;
            } else if (probe(writer, reader, halfMax + " 0").equals("HIT")) {
                curX = halfMax;
                curY = 0;
            } else if (probe(writer, reader, (-halfMax) + " 0").equals("HIT")) {
                curX = -halfMax;
                curY = 0;
            }
            
            if (curX == -1 && curY == -1) continue;
            
            boolean found = false;
            int upperY = binarySearch(writer, reader, curX, curY, 1000000000, true, false);
            if (upperY == Integer.MIN_VALUE) continue;
            
            int lowerY = binarySearch(writer, reader, curX, curY, -1000000000, true, true);
            if (lowerY == Integer.MIN_VALUE) continue;
            
            int leftX = binarySearch(writer, reader, curX, curY, -1000000000, false, true);
            if (leftX == Integer.MIN_VALUE) continue;
            
            int rightX = binarySearch(writer, reader, curX, curY, 1000000000, false, false);
            if (rightX == Integer.MIN_VALUE) continue;
            
            int centerX = (leftX + rightX) / 2;
            int centerY = (upperY + lowerY) / 2;
            
            if (!searchCenter(writer, reader, centerX, centerY)) {
                writer.println("1000000001 1000000001");
                writer.close();
                reader.readLine();  // Read the "WRONG" response
                return;
            }
        }
        
        writer.close();
    }
    
    private static String probe(PrintWriter writer, BufferedReader reader, String coordinates) throws IOException {
        writer.println(coordinates);
        writer.flush();
        return reader.readLine();
    }
    
    private static int binarySearch(PrintWriter writer, BufferedReader reader, int curX, int curY, int limit, boolean isVertical, boolean isNegative) throws IOException {
        int l = isNegative ? limit : (isVertical ? curY : curX);
        int r = isNegative ? (isVertical ? curY : curX) : limit;
        int mid;
        int ans = isVertical ? curY : curX;
        
        while (l <= r) {
            mid = l + (r - l) / 2;
            String coordinates = isVertical ? curX + " " + mid : mid + " " + curY;
            String response = probe(writer, reader, coordinates);
            
            if (response.equals("CENTER")) {
                return Integer.MIN_VALUE;
            } else if (response.equals("HIT")) {
                if (isNegative) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                ans = mid;
            } else {
                if (isNegative) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        
        return ans;
    }
    
    private static boolean searchCenter(PrintWriter writer, BufferedReader reader, int centerX, int centerY) throws IOException {
        int buffer = 7;
        for (int x = centerX - buffer; x <= centerX + buffer; x++) {
            for (int y = centerY - buffer; y <= centerY + buffer; y++) {
                if (isValidCoordinate(x, y)) {
                    if (probe(writer, reader, x + " " + y).equals("CENTER")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean isValidCoordinate(int x, int y) {
        return x >= -1000000000 && x <= 1000000000 && y >= -1000000000 && y <= 1000000000;
    }
}