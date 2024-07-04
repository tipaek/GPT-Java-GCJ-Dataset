import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        in.useDelimiter(System.getProperty("line.separator"));

        // read number of tests T and array size B
        String input = in.next();
        int t = Integer.parseInt(input.split(" ")[0]);
        int b = Integer.parseInt(input.split(" ")[1]);

        for (int i = 1; i <= t; ++i) {
            Element[] solution = new Element[b];
            int requestCount = 1;
            for (int position = 1; position <= b / 2; position++) {

                // check if correction is needed
                if (requestCount > 10 && requestCount % 10 == 1) {
                    int check = findFirstSymmetric(solution);
                    if (check >= 0) {
                        if (solution[check].value != readValue(in, check + 1)) {
                            //re read returns new value, correction needed
                            invertValues(solution, true);
                        }
                    } else {
                        readValue(in,1);
                    }
                    requestCount++;

                    check = findFirstNonSymmetric(solution);
                    if (check >= 0) {
                        if (solution[check].value != readValue(in, check + 1)) {
                            //re read returns new value, correction needed
                            invertValues(solution, false);
                        }
                    } else {
                        readValue(in,1);
                    }
                    requestCount++;
                }

                int value = readValue(in, position);
                solution[position - 1] = new Element(value);
                requestCount++;

                int index = b - position + 1;
                value = readValue(in, index);
                solution[index - 1] = new Element(value);
                requestCount++;

                if (solution[index - 1].value == solution[position - 1].value) {
                    solution[index - 1].symmetric = true;
                    solution[position - 1].symmetric = true;
                }
            }

            System.out.println(generateOutput(solution));
            System.out.flush();
            String answer = in.next();
            if (answer.equalsIgnoreCase("n")) {
                System.exit(1);
            }
        }
    }

    static int readValue(Scanner in, int position) {
        System.out.println(position);
        System.out.flush();
        String answer = in.next();
        return Integer.parseInt(answer);
    }

    static String generateOutput(Element[] elements) {
        StringBuffer buf = new StringBuffer();
        for (Element e : elements) {
            buf.append(e.value);
        }
        return buf.toString();
    }

    static void invertValues(Element[] elements, boolean symmetric) {
        for (Element e : elements) {
            if (e != null && e.symmetric == symmetric) {
                if (e.value == 0) {
                    e.value = 1;
                } else {
                    e.value = 0;
                }
            }
        }
    }

    static int findFirstSymmetric(Element[] elements) {
        int result = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].symmetric) {
                result = i;
                break;
            }
        }
        return result;
    }

    static int findFirstNonSymmetric(Element[] elements) {
        int result = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && (!elements[i].symmetric)) {
                result = i;
                break;
            }
        }
        return result;
    }

}

class Element {
    int value;
    boolean symmetric;

    public Element(int value) {
        this.value = value;
        symmetric = false;
    }
}