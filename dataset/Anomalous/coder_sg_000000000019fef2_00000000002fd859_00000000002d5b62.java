import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            StringBuilder answer = new StringBuilder();

            if ((Math.abs(x) % 2 == Math.abs(y) % 2)) {
                answer.append("IMPOSSIBLE");
            } else {
                answer.append(determineDirection(x, y));
            }

            resultBuilder.append("Case #").append(i + 1).append(": ").append(answer).append("\n");
        }

        System.out.print(resultBuilder);
    }

    private static String determineDirection(int x, int y) {
        if (x == -4) {
            return determineDirectionForXMinus4(y);
        } else if (x == -3) {
            return determineDirectionForXMinus3(y);
        } else if (x == -2) {
            return determineDirectionForXMinus2(y);
        } else if (x == -1) {
            return determineDirectionForXMinus1(y);
        } else if (x == 0) {
            return determineDirectionForX0(y);
        } else if (x == 1) {
            return determineDirectionForX1(y);
        } else if (x == 2) {
            return determineDirectionForX2(y);
        } else if (x == 3) {
            return determineDirectionForX3(y);
        } else if (x == 4) {
            return determineDirectionForX4(y);
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForXMinus4(int y) {
        switch (y) {
            case -3: return "SSW";
            case 3: return "NNW";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForXMinus3(int y) {
        switch (y) {
            case -4: return "WWS";
            case -2: return "ESW";
            case 0: return "WW";
            case 2: return "ENW";
            case 4: return "WWN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForXMinus2(int y) {
        switch (y) {
            case -3: return "NWS";
            case -1: return "SW";
            case 1: return "NW";
            case 3: return "SWN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForXMinus1(int y) {
        switch (y) {
            case -2: return "WS";
            case 0: return "W";
            case 2: return "WN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForX0(int y) {
        switch (y) {
            case -3: return "SS";
            case -1: return "S";
            case 1: return "N";
            case 3: return "NN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForX1(int y) {
        switch (y) {
            case -2: return "ES";
            case 0: return "E";
            case 2: return "EN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForX2(int y) {
        switch (y) {
            case -3: return "NES";
            case -1: return "SE";
            case 1: return "NE";
            case 3: return "SEN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForX3(int y) {
        switch (y) {
            case -4: return "EES";
            case -2: return "WSE";
            case 0: return "EE";
            case 2: return "WNE";
            case 4: return "EEN";
            default: return "IMPOSSIBLE";
        }
    }

    private static String determineDirectionForX4(int y) {
        switch (y) {
            case -3: return "SSE";
            case 3: return "NNE";
            default: return "IMPOSSIBLE";
        }
    }
}