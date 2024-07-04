import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int halfMax = 1000000000 / 2;
        
        for (int testCase = 1; testCase <= t; testCase++) {
            int curX = -1, curY = -1;
            boolean found = false;
            
            found = checkAndSetCoordinates(reader, writer, 0, halfMax, curX, curY);
            if (found) continue;
            
            found = checkAndSetCoordinates(reader, writer, 0, -halfMax, curX, curY);
            if (found) continue;
            
            found = checkAndSetCoordinates(reader, writer, halfMax, 0, curX, curY);
            if (found) continue;
            
            found = checkAndSetCoordinates(reader, writer, -halfMax, 0, curX, curY);
            if (found) continue;
            
            int upperBound = binarySearch(reader, writer, curX, curY, true, true);
            int lowerBound = binarySearch(reader, writer, curX, curY, true, false);
            int leftBound = binarySearch(reader, writer, curX, curY, false, false);
            int rightBound = binarySearch(reader, writer, curX, curY, false, true);
            
            if (upperBound == -1 || lowerBound == -1 || leftBound == -1 || rightBound == -1) continue;
            
            int finalY = (upperBound + lowerBound) / 2;
            int finalX = (leftBound + rightBound) / 2;
            
            finalAdjustments(reader, writer, finalX, finalY);
        }
        
        writer.close();
    }
    
    private static boolean checkAndSetCoordinates(BufferedReader reader, PrintWriter writer, int x, int y, int curX, int curY) throws IOException {
        writer.println(x + " " + y);
        writer.flush();
        String response = reader.readLine();
        
        if ("CENTER".equals(response)) {
            return true;
        } else if ("HIT".equals(response)) {
            curX = x;
            curY = y;
        }
        return false;
    }
    
    private static int binarySearch(BufferedReader reader, PrintWriter writer, int curX, int curY, boolean vertical, boolean positive) throws IOException {
        int l = vertical ? curY : curX;
        int r = positive ? 1000000000 : -1000000000;
        int result = l;
        
        while (l != r) {
            int mid = l + (r - l) / 2;
            writer.println(vertical ? (curX + " " + mid) : (mid + " " + curY));
            writer.flush();
            String response = reader.readLine();
            
            if ("CENTER".equals(response)) {
                return -1;
            } else if ("HIT".equals(response)) {
                if (positive) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                result = mid;
            } else {
                if (positive) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return result;
    }
    
    private static void finalAdjustments(BufferedReader reader, PrintWriter writer, int finalX, int finalY) throws IOException {
        int buffer = 5;
        for (int x = finalX - buffer; x <= finalX + buffer; x++) {
            for (int y = finalY - buffer; y <= finalY + buffer; y++) {
                if (!isInBounds(x, y)) continue;
                writer.println(x + " " + y);
                writer.flush();
                
                String response = reader.readLine();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
    
    private static boolean isInBounds(int x, int y) {
        return x >= -1000000000 && x <= 1000000000 && y >= -1000000000 && y <= 1000000000;
    }
}