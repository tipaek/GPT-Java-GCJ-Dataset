import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static String line;
    private static int[] bits;

    private static int readBit(int pos) throws IOException{
        bw.write(""+pos+"\n");
        bw.flush();
        line = br.readLine();
        return Integer.parseInt(line);
    }

    private static void reverseStoredData(int b){
       // b is even!
       for(int j=0, temp; j < b/2;j++){
           temp = bits[j];
           bits[j] = bits[b-j-1];
           bits[b-j-1] = temp;
       }
    }

    private static void flipStoredData(int b){
        for(int j=0; j < b;j++){
            // unknowns are -1, don't flip them
            if(bits[j]>=0) {
                bits[j]=1-bits[j];
            }
        }
    }

    public static void main(String[] args) throws IOException{

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("QR20204.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("QR20204.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            line = br.readLine();
            String[] p;

            p = line.split("\\s+");
            int tests = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);// same b for all tests

            for(int i = 0; i < tests; i++){
                String answer;
                StringBuilder s = new StringBuilder(b);

                if(b == 10){
                    // minimal
                    for(int j=0;j<10;j++){
                        s.append(readBit(j+1));
                    }
                } else {// b=20 or b=100
                    bits = new int[b];
                    Arrays.fill(bits,-1);
                    int j, bit, bit2;

                    // query 1-10
                    // first 5, last 5
                    for(j = 1; j <= 5; bits[j-1] = readBit(j), j++);
                    for(j = b; j > b-5; bits[j-1] = readBit(j), j--);

                    int detectFlip = -1; // 0-indexed
                    int detectReverse = -1;// 0-indexed

                    for(j=0;j<5;j++){
                        // find first pair different
                        // different pair = detects simple reverse
                        if(bits[j] != bits[b-j-1]){
                            if(detectReverse < 0){
                                // different paired bits (0,1) or (1,0)
                                // so if it changes to (1,0) or (0,1)
                                // it detects simple reverse OR simple flip
                                // so we need to look at 1 detectFlip bit to see which case it is
                                detectReverse = j;
                            }
                        } else {//bits[j] == bits[b-j-1]
                            // same paired bits (0,0) or (1,1) detect if flipping occurred (but cannot detect reverse)
                            if(detectFlip < 0){
                                // so if it changes to (1,1) or (0,0) a flip has definitely occurred
                                detectFlip = j;
                            }
                        }
                    }

                    // might NOT have a detectFlip pairs or a detectReverse pairs at this point.
                    // but surely one of them was detected!
                    boolean haveBothTypeOfDetectors;
                    int bitsSoFar = 10;
                    int nextBitToRead = 5; // 0-indexed
                    int queriesSoFar = 10;

                    while (bitsSoFar < b && queriesSoFar <= 140) {
                        // keep making 10 query batches
                        // queriesSoFar+1 - queriesSoFar+10
                        haveBothTypeOfDetectors = detectFlip >= 0 && detectReverse >= 0;

                        if (haveBothTypeOfDetectors) {
                            //query 2 detectors to see how situation changed
                            //then query another 8 bits in batch

                            //read detectFlip bit
                            bit = readBit(detectFlip+1);
                            //read detectReverse bit
                            bit2 = readBit(detectReverse+1);

                            //4 cases
                            if(bit != bits[detectFlip]){
                                //flip definitely happened, don't know about reverse yet!
                                if(bit2 != bits[detectReverse]){
                                    //change detected by detectReverse pair
                                    //either a flip has occurred OR a reverse.
                                    // since we know for sure flip happened then NO reverse happened
                                    flipStoredData(b);
                                } else {
                                    //no change detected by detectReverse pair
                                    //since we know for sure flip happened then a reverse happened as well
                                    // because it messed around with the reverse detection
                                    flipStoredData(b);
                                    reverseStoredData(b);
                                }
                            } else {
                                //no flip happened, reverse may have happened!
                                if(bit2 != bits[detectReverse]){
                                    //change detected by detectReverse pair
                                    //either a flip has occurred OR a reverse.
                                    // since we know for sure flip DID NOT happen then reverse happened
                                    reverseStoredData(b);
                                } else {
                                    //no change detected by detectReverse pair
                                    //since we know for sure flip DID NOT happen then NO reverse happened
                                    //pretend it's raining!
                                }
                            }
                            //go on to read next 8 bits
                        } else if (detectFlip >= 0) {
                            //all bits so far were equal (in pairs) and so immune to reversing/mirroring

                            //read detectFlip bit
                            bit = readBit(detectFlip+1);
                            if(bit != bits[detectFlip]){
                                //a flip has occurred, flip stored data
                                flipStoredData(b);
                            }

                            // readpair, unnecessary, just to make 2 reads
                            bit = readBit(b-detectFlip-1+1);
                        } else {
                            //detectReverse >= 0
                            //all bits so far were detectReverse pairs,
                            //all bits so far were different in pairs

                            //read detectReverse bit
                            bit = readBit(detectReverse+1);
                            if(bit != bits[detectReverse]){
                                //change detected by detectReverse pair
                                //either a flip has occurred OR a reverse.
                                //end result is the same SINCE all bits so far were different = detectReverse pair
                                reverseStoredData(b);
                            }

                            // read pair, unnecessary, just to make 2 reads
                            bit = readBit(b-detectReverse-1+1);
                        }

                        //read 4 pairs of new bits, don't care if middle is crossed tbh
                        for(j = nextBitToRead; j < nextBitToRead+4; bits[j] = readBit(j+1), j++);
                        for(j = b-nextBitToRead; j > b-nextBitToRead-4; bits[j-1] = readBit(j), j--);

                        //look for missing detectors if any
                        if (detectReverse < 0) {
                            //try to find missing "entanglement" detector - detectReverse
                            for (j = nextBitToRead; j < nextBitToRead + 4; j++) {
                                // different pair = detects simple reverse
                                if (bits[j] != bits[b - j - 1]) {
                                    if (detectReverse < 0) {
                                        detectReverse = j;
                                    }
                                }
                            }
                        }

                        if(detectFlip < 0){
                            //try to find the missing "entanglement" detector - detectFlip
                            for(j = nextBitToRead; j < nextBitToRead+4;j++){
                                // same pair = detects simple flip, immune to reverse
                                if(bits[j] == bits[b-j-1]){
                                    if(detectFlip < 0){
                                        detectFlip = j;
                                    }
                                }
                            }
                        }

                        //read 4 new pairs
                        nextBitToRead+=4;
                        bitsSoFar+=4*2;
                        queriesSoFar +=10;
                    }

                    //dump answer and send
                    for(j=0;j<b;j++){
                        s.append(bits[j]);
                    }
                }

                answer = s.toString();

                //output
                bw.write(""+answer+"\n");
                bw.flush();

                //read response
                line = br.readLine();
                if(line.startsWith("N")){
                    throw new RuntimeException();
                }
            }

            if(FROM_FILE) {
                bw.close();
            }
        } finally {
            if(FROM_FILE) {
                br.close();
            }
        }
    }
}
