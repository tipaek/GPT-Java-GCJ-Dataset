
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int total = t;
        while (t-- >0) {
            int n = in.nextInt();
            String arr[] = new String[n];
            String start[] = new String[n];
            String end[] = new String[n];

            for (int i=0;i<n;i++) {
                arr[i] = in.next();
                start[i]=getStart(arr[i]);
                end[i]=getEnd(arr[i]);
            }

            String startString = getStartString(start);
            if (startString.equals("*")) {
                System.out.println("*");
            } else {
                String endString = getEndString(end);
                if (endString.equals("*")) {
                    System.out.println("*");
                } else {
                    String mainString = "";
                    for (int i=0;i<n;i++) {
                        //Get the string between the astrixes
                        int startCounter = 0;
                        while (arr[i].charAt(startCounter)!='*') {
                            startCounter++;
                        }
                        int endCounter = arr[i].length()-1;
                        while (arr[i].charAt(endCounter)!='*') {
                            endCounter--;
                        }
                        if (startCounter!=0 && endCounter!=arr[i].length()-1) {
                            for (int j=startCounter+1;j<endCounter;j++) {
                                if (arr[i].charAt(j)!='*') {
                                    mainString=mainString.concat(arr[i].charAt(j)+"");
                                }
                            }
                        }

                    }
                    System.out.println(startString.concat(mainString).concat(endString));
                }
            }


        }
    }

    private static String getEndString(String[] end) {
        String overall="";
        int var=0;

        for (int i=0;i<end.length;i++) {
            if (end[i].length()>var) {
                var=end[i].length();
                overall=end[i];
            }
        }

        for (int i=0;i<end.length;i++) {
            if (!overall.contains(end[i])) {
                return "*";
            }
        }

        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(overall);

        // reverse StringBuilder input1
        input1 = input1.reverse();
        return input1.toString();
    }

    private static String getStartString(String[] start) {
        String overall="";
        int var=0;

        for (int i=0;i<start.length;i++) {
            if (start[i].length()>var) {
                var=start[i].length();
                overall=start[i];
            }
        }

        for (int i=0;i<start.length;i++) {
            if (!overall.contains(start[i])) {
                return "*";
            }
        }
        return overall;
    }

    public static String getStart(String s) {
        if (s.indexOf('*')==-1) {
            return s;
        } else {
            int counter=0;
            String start="";
            while (s.charAt(counter)!='*') {
                start=start.concat(s.charAt(counter)+"");
                counter++;
            }
            return start;
        }
    }

    public static String getEnd(String s) {
        if (s.indexOf('*')==-1) {
            return "";
        } else {
            int counter=s.length()-1;
            String start="";
            while (s.charAt(counter)!='*') {
                start=start.concat(s.charAt(counter)+"");
                counter--;
            }
            return start;
        }
    }
}
