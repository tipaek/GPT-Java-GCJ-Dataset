import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> output = new ArrayList<>();
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String start = "";
            String end = "";
            StringBuilder middle = new StringBuilder();
            boolean stop = false;
            
            for (int j = 0; j < n; j++) {
                String pattern = scanner.nextLine();
                if (!stop && !pattern.isEmpty() && !(pattern.length() == 1 && pattern.charAt(0) == '*')) {
                    String[] strArray = pattern.split("\\*");
                    boolean isStartElement = pattern.charAt(0) != '*';
                    boolean isEndElement = pattern.charAt(pattern.length() - 1) != '*';
                    
                    for (int k = 0; k < strArray.length; k++) {
                        if (k == 0 && isStartElement) {
                            start = processStart(start, strArray[0]);
                            if (start.equals("*")) {
                                stop = true;
                                output.add("*");
                                break;
                            }
                        } else if (k == strArray.length - 1 && isEndElement) {
                            end = processEnd(end, strArray[strArray.length - 1]);
                            if (end.equals("*")) {
                                stop = true;
                                output.add("*");
                                break;
                            }
                        } else {
                            if (!middle.toString().contains(strArray[k])) {
                                middle.append(strArray[k]);
                            }
                        }
                    }
                }
            }
            
            if (!stop) {
                if (start.length() + end.length() + middle.length() < 10000) {
                    output.add(start + middle + end);
                } else {
                    output.add("*");
                }
            }
        }
        
        for (int i = 0; i < output.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + output.get(i));
        }
        
        scanner.close();
    }

    private static String processEnd(String end, String endElement) {
        if (end.length() == endElement.length()) {
            if (!end.equals(endElement)) {
                return "*";
            }
        } else if (end.length() < endElement.length()) {
            if (!endElement.endsWith(end)) {
                return "*";
            } else {
                return endElement;
            }
        } else {
            if (!end.endsWith(endElement)) {
                return "*";
            }
        }
        return end;
    }

    private static String processStart(String start, String startElement) {
        if (start.length() == startElement.length()) {
            if (!start.equals(startElement)) {
                return "*";
            }
        } else if (start.length() < startElement.length()) {
            if (!startElement.startsWith(start)) {
                return "*";
            } else {
                return startElement;
            }
        } else {
            if (!start.startsWith(startElement)) {
                return "*";
            }
        }
        return start;
    }
}