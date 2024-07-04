    import java.util.*;


    //530640054
    public class Solution {

        public static void main(String[] args)  {
            Scanner scanner = new Scanner(System.in);
            int numCases = Integer.parseInt(scanner.nextLine());
            for(int caseNum = 0; caseNum < numCases; caseNum++) {
                String target = scanner.nextLine();
                List<Integer> numbers = new ArrayList();
                for( char number : target.toCharArray()) {
                    numbers.add(Integer.parseInt(String.valueOf(number)));
                }
                int occurrences = Collections.frequency(numbers, 0);
                String currentAnswer = "";
                if (occurrences > 0) {
                    for(int i = 0; i < occurrences; i++) {
                        int currentOcurrence = numbers.indexOf(0);
                        if (currentOcurrence == 0) {
                            currentAnswer += 0;
                        } else {
                            currentAnswer += calculateAnswer(numbers.subList(0, currentOcurrence));
                            currentAnswer += numbers.get(currentOcurrence);
                        }
                        numbers = numbers.subList(currentOcurrence + 1, numbers.size());

                        if ((i +1 ) == occurrences && numbers.size() > 0) {
                            currentAnswer += calculateAnswer(numbers);
                        }
                    }
                } else {
                    currentAnswer = calculateAnswer(numbers);
                }
                System.out.println("Case #" + (caseNum + 1) + ":" + " " + currentAnswer);
            }
        }

        static String calculateAnswer(List<Integer> numbers) {
            String answer = "";
            String opening  = "(";
            String closing = ")";

            for (int each : numbers) {
                if (answer.contains(String.valueOf(each))) {
                    answer = answer.substring(0, answer.indexOf(String.valueOf(each)) + 1) +
                            each + answer.substring(answer.indexOf(String.valueOf(each) ) + 1);
                } else {
                    for(int i = 0; i < each -1; i++) {
                        answer += opening;
                    }
                    answer += each;
                    for(int i = 0; i < each -1; i++) {
                        answer += closing;
                    }
                }
            }
            String finalAnswer = opening + answer + closing;

            return finalAnswer;
        }
    }
