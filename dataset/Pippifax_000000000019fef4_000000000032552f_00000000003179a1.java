import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static BufferedReader in;
    static List<Assignment> assignments = new ArrayList<>();

    public static void main(String[] args) {
        readInput();

        int i = 1;

        for (Assignment assignment : assignments) {
            if (Long.parseLong(assignment.number[0]) != -1) {
                processOpenAssignment(assignment, i);
            } else {
                processClosedAssignment(assignment, i);
            }
            i++;
        }
    }

    private static void processOpenAssignment(Assignment assignment, int testcaseId) {
        List<Set<Character>> characterMapping = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            characterMapping.add(new HashSet<>());
        }

        List<String[]> interrestingAssignments = getInterrestingAssignments(assignment);
        interrestingAssignments.sort((a1, a2) -> a1[0].compareToIgnoreCase(a2[0]));

        int currentNumber = 1;
        boolean satiated = false;

        for (String[] interestingAssignment : interrestingAssignments) {
            if (satiated) {
                if (Character.getNumericValue(interestingAssignment[0].charAt(0)) != currentNumber) {
                    currentNumber++;
                    satiated = false;
                }
            } else {
                characterMapping.get(currentNumber).add(interestingAssignment[1].charAt(0));

                if (characterMapping.get(currentNumber).size() == currentNumber) {
                    satiated = true;
                }
            }
        }

        for (int i = 9; i >= 0; i--) {
            Set<Character> currentCharacterMapping = characterMapping.get(i);

            if (i - 1 >= 0) {
                Set<Character> currentCharacterMapping2 = characterMapping.get(i - 1);
                currentCharacterMapping.removeAll(currentCharacterMapping2);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10; i++) {
            for (Character character : characterMapping.get(i)) {
                sb.append(character);
            }
        }

        String resultString = sb.toString();

        for (int i = 0; i < 10000; i++) {
            char[] chars = assignment.resultString[i].toCharArray();

            for (char character : chars) {
                if (resultString.indexOf(character) == -1) {
                    resultString = character + resultString;
                    System.out.println("Case #" + testcaseId + ": " + resultString);
                    return;
                }
            }
        }
    }

    private static void processClosedAssignment(Assignment assignment, int testcaseId) {
        Comparator<Map.Entry<Character, Integer>> valueComparator = (e1, e2) -> {
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            return v1.compareTo(v2);
        };

        HashMap<Character, Integer> characterCount = new HashMap<>();

        List<String[]> interrestingAssignments = getInterrestingClosedAssignments(assignment);

        for (String[] interestingAssignment : interrestingAssignments) {
            char firstChar = interestingAssignment[1].charAt(0);

            Integer currentCharCount = characterCount.get(firstChar);
            if (currentCharCount == null) {
                currentCharCount = 0;
            }
            characterCount.put(firstChar, currentCharCount + 1);
        }

        List<Map.Entry<Character, Integer>> listOfEntries = new ArrayList<>(characterCount.entrySet());

        listOfEntries.sort(valueComparator);

        String resultString = "";

        for (Map.Entry<Character, Integer> entry : listOfEntries) {
            resultString = entry.getKey() + resultString;
        }

        for (int i = 0; i < 10000; i++) {
            char[] chars = assignment.resultString[i].toCharArray();

            for (char character : chars) {
                if (resultString.indexOf(character) == -1) {
                    resultString = character + resultString;
                    System.out.println("Case #" + testcaseId + ": " + resultString);
                    return;
                }
            }
        }
    }

    private static List<String[]> getInterrestingAssignments(Assignment assignment) {
        List<String[]> interrestingAssignments = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            if (assignment.number[i].length() == assignment.resultString[i].length()) {
                String[] interrestingAssignment = new String[2];
                interrestingAssignment[0] = assignment.number[i];
                interrestingAssignment[1] = assignment.resultString[i];
                interrestingAssignments.add(interrestingAssignment);
            }
        }

        return interrestingAssignments;
    }

    private static List<String[]> getInterrestingClosedAssignments(Assignment assignment) {
        List<String[]> interrestingAssignments = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            String[] interrestingAssignment = new String[2];
            interrestingAssignment[0] = assignment.number[i];
            interrestingAssignment[1] = assignment.resultString[i];
            interrestingAssignments.add(interrestingAssignment);
        }

        return interrestingAssignments;
    }

    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                Assignment assignment = new Assignment();

                for (int j = 0; j < 10000; j++) {
                    line = in.readLine();

                    String[] fractals = line.split(" ");

                    assignment.number[j] = fractals[0];
                    assignment.resultString[j] = fractals[1];
                }

                assignments.add(assignment);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }

    private static class Assignment {
        String[] number = new String[10000];
        String[] resultString = new String[10000];
    }
}
