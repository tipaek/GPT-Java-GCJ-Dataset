import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

class Solution {
    public static int numBits;
    public static BufferedReader reader;
    public static boolean flipPolarity;
    public static boolean flipOrder;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            parts = line.split("\\s+");
            int numberOfSets = Integer.parseInt(parts[0]);
            numBits = Integer.parseInt(parts[1]);

            for (int i = 0; i < numberOfSets; i++) {
                int[] bitArray = new int[numBits];
                flipPolarity = false;
                flipOrder = false;

                int polInd = 0;
                boolean polIndFound = false;
                int ordInd = 0;
                boolean ordIndFound = false;

                int pos = 0;
                int revPos = numBits - 1 - pos;

                for (int j = 0; j < 150;) {
                    if (j % 10 == 0) {
                        flipPolarity = false;
                        flipOrder = false;

                        if (polIndFound) {
                            flipPolarity = read(polInd) != bitArray[polInd];
                            j++;
                        }
                        if (ordIndFound) {
                            flipOrder = read(ordInd) != bitArray[ordInd];
                            j++;
                        }
                        
                        if(polIndFound != ordIndFound)
                        {
                            read(0);
                            j++;
                        }
                    }

                    int out1 = read(pos);
                    j++;
                    int out2 = read(revPos);
                    j++;

                    if(!polIndFound && out1 == out2) {
                        polInd = pos;
                        polIndFound = true;
                    }
                    if(!ordIndFound && out1 != out2) {
                        ordInd = pos;
                        ordIndFound = true;
                    }

                    bitArray[pos] = out1;
                    bitArray[revPos] = out2;

                    pos++;
                    revPos = numBits - 1 - pos;

                    if (revPos < pos) {
                        break;
                    }
                }

                for (int j = 0; j < numBits; j++) {
                    pos = flipOrder ? numBits - 1 - j : j;
                    int out = flipPolarity ? 1 - bitArray[pos] : bitArray[pos];
                    System.out.print(out);
                }
                System.out.println();
                line = reader.readLine();
                if(line.equals("N")) {
                    return;
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int read(int pos) throws IOException {
        if (flipOrder) {
            pos = numBits - 1 - pos;
        }
        System.out.println(pos + 1);

        int out = Integer.parseInt(reader.readLine());
        if (flipPolarity) {
            out = 1 - out;
        }

        return out;
    }
}
