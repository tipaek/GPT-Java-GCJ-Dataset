import java.util.*;
import java.util.logging.*;
import java.io.*;
import java.time.LocalDateTime;

public class Solution {
    private static Logger logger = Logger.getLogger(Solution.class.getName());
    private FileHandler fileHandler;
    private Scanner scanner;
    private static final int MAX_QUERIES = 150;
    private static final double CHUNK_SIZE = 9.0;

    public Solution() {
        initializeLogger();
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    private void initializeLogger() {
        try {
            File logFile = new File("logging.txt");
            if (logFile.createNewFile()) {
                logger.info("File created: " + logFile.getName());
            } else {
                logger.info("File already exists: " + logFile.getCanonicalPath());
            }

            fileHandler = new FileHandler("logging.txt");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        logger.info(LocalDateTime.now().plusDays(1).toString());
    }

    public void closeLogger() {
        logger.info("******** END OF LOG");
        fileHandler.close();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    private boolean requestBit(int position) {
        System.out.println(position);
        int receivedBit = scanner.nextInt();
        logger.info(String.format("Requested bit #%d: received %d", position, receivedBit));
        return receivedBit == 1;
    }

    public boolean decodeArray(int bitCount) {
        int chunkCount = (int) Math.ceil(bitCount / CHUNK_SIZE);
        logger.info(String.format("Number of %d bits chunks: %d", bitCount, chunkCount));

        boolean[][] bitArray = new boolean[chunkCount][(int) CHUNK_SIZE];

        for (int i = 1; i <= bitCount; i++) {
            int bitPosition = i % bitCount == 0 ? bitCount : i % bitCount;
            boolean bit = requestBit(bitPosition);
            int chunkIndex = (int) Math.ceil(bitPosition / CHUNK_SIZE) - 1;
            int chunkPosition = bitPosition % (int) CHUNK_SIZE == 0 ? (int) CHUNK_SIZE - 1 : bitPosition % (int) CHUNK_SIZE - 1;
            bitArray[chunkIndex][chunkPosition] = bit;
        }

        int permutations = (int) Math.pow(chunkCount, 2);
        String[] decodedArrays = new String[permutations];
        Arrays.fill(decodedArrays, "");

        for (int i = 0; i < chunkCount; i++) {
            String[] decodedChunks = new String[2];
            decodedChunks[0] = "";
            decodedChunks[1] = "";

            for (int j = 0; j < CHUNK_SIZE && !(i == chunkCount - 1 && j + 1 == bitCount % CHUNK_SIZE); j++) {
                decodedChunks[0] += bitArray[i][j] ? "1" : "0";
                decodedChunks[1] += bitArray[i][j] ? "0" : "1";
            }

            decodedArrays[0] += decodedChunks[0];
            decodedArrays[1] += decodedChunks[1];
        }

        for (String array : decodedArrays) {
            if (sendArray(array)) {
                return true;
            }
        }
        return false;
    }

    public boolean sendArray(String array) {
        logger.info("Send array: " + array);
        System.out.println(array);
        String response = readLine();
        return "Y".equals(response);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String firstLine = solution.readLine();
        String[] tb = firstLine.split(" ");
        int testCases = Integer.parseInt(tb[0]);
        int bitCount = Integer.parseInt(tb[1]);
        logger.info(String.format("Cases %d and bits %d", testCases, bitCount));

        for (int t = 1; t <= testCases; t++) {
            if (!solution.decodeArray(bitCount)) {
                break;
            }
        }

        solution.closeLogger();
    }
}