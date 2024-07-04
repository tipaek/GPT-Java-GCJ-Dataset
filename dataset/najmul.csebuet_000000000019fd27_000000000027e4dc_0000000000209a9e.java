//package Codejam.Year2020.Qualification.ESAbATAd.Nine;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Segment {

    List<Integer> list = new ArrayList<>();

    Segment(List<Integer> list) {
        this.list.addAll(list);
    }

    Segment(int segmentNumber, Scanner sc, PrintWriter out) {
        for (int i = 0; i < 5; i++) {
            int P = 5*segmentNumber - 4 + i;
            out.println(P);
            out.flush();
            list.add(sc.nextInt());
        }
    }

    public boolean isNothingOf(Segment segment) {

        for (int i = 0; i < segment.list.size(); i++) {
            if (!list.get(i).equals(segment.list.get(i)))return false;
        }

        return true;
    }

    public boolean isComplementOf(Segment segment) {

        for (int i = 0; i < segment.list.size(); i++) {
            if (list.get(i) + segment.list.get(i) != 1)return false;
        }

        return true;
    }

    public boolean isReverseOf(Segment segment) {

        for (int i = 0; i < segment.list.size(); i++) {
            if (!list.get(i).equals(segment.list.get(segment.list.size() - 1 - i)))return false;
        }

        return true;
    }

    public boolean isComplementReverseOf(Segment segment) {

        segment.complement();
        segment.reverse();

        boolean nothingOf = isNothingOf(segment);

        segment.reverse();
        segment.complement();

        return nothingOf;
    }

    public void reverse() {
        Collections.reverse(list);
    }

    public void complement() {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 1 - list.get(i));
        }
    }
}

public class Solution {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = false;//Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();
        int B = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            if (B == 10) {
                new Solution().solve10(testCaseNumber, B, sc);
            }
            else if (B == 20) {
                /*new Solution().solve20(testCaseNumber, B, sc);*/
                new Solution().solve20Test(testCaseNumber, B, sc);
            }
            else if (B == 100) {
                new Solution().solve100(testCaseNumber, B, sc);
            }
        }

        if (fileInOut) {
            verify(Solution.class.getResource("ans.txt").getFile());
        }
    }

    public void solve20Test(int testCaseNumber, int B, Scanner sc) {

        for (int i = 1; i <= 20; i++) {
            out.print(1);
        }
        out.println();
        out.flush();

        String response = sc.next();
        if (response.equals("Y"))return;
        if (response.equals("N"))return;
    }

    public void solve100(int testCaseNumber, int B, Scanner sc) {

        for (int i = 1; i <= 100; i++) {
            out.print(1);
        }
        out.println();
        out.flush();

        String response = sc.next();
        if (response.equals("Y"))return;
        if (response.equals("N"))return;
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solve10(int testCaseNumber, int B, Scanner sc) {

        //List<int[]> list = new ArrayList<>();

        for (int query = 1; query <= 15; query++) {

            int[] array = new int[11];

            for (int i = query*10 - 9; i <= query*10; i++) {
                int P = i;
                out.println(P);
                out.flush();

                //0/1/P
                int value = sc.nextInt();
                array[P] = value;
            }

            //Now lets review "array"
            for (int i = 1; i <= 10; i++) {
                out.print(array[i]);
            }
            out.println();
            out.flush();

            String response = sc.next();
            if (response.equals("Y"))return;
            if (response.equals("N"))return;
        }
    }

    public void solve20(int testCaseNumber, int B, Scanner sc) {

        Segment one1 = new Segment(1, sc, out);
        Segment four1 = new Segment(4, sc, out);

        Segment one2 = new Segment(1, sc, out);
        Segment three2 = new Segment(3, sc, out);
        Segment four2 = computeFour2(one1, four1, one2);

        Segment one3 = new Segment(1, sc, out);
        Segment two3 = new Segment(2, sc, out);
        Segment three3 = computeThree3(one2, three2, four2, one3, two3);
        Segment four3 = computeFour3(one2, four2, one3);

        List<Integer> ans = new ArrayList<>();
        ans.addAll(one3.list);
        ans.addAll(two3.list);
        ans.addAll(three3.list);
        ans.addAll(four3.list);

        //Now lets review "array"
        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i));
        }
        out.println();
        out.flush();

        String response = sc.next();
        if (response.equals("Y"))return;
        if (response.equals("N"))return;
    }

    private Segment computeFour3(Segment one2, Segment four2, Segment one3) {

        Segment four3 = null;

        boolean nothingOf = one3.isNothingOf(one2);
        boolean complementOf = one3.isComplementOf(one2);

        boolean reverseOf = one3.isReverseOf(four2);
        boolean complementReverseOf = one3.isComplementReverseOf(four2);

        if (nothingOf) {
            four3 = new Segment(four2.list);
        }
        else if (complementOf) {
            four2.complement();
            four3 = new Segment(four2.list);
            four2.complement();
        }
        else if (reverseOf) {
            one2.reverse();
            four3 = new Segment(one2.list);
            one2.reverse();
        }
        else if (complementReverseOf) {
            one2.complement();
            one2.reverse();
            four3 = new Segment(one2.list);
            one2.reverse();
            one2.complement();
        }

        return four3;
    }

    private Segment computeThree3(Segment one2, Segment three2, Segment four2, Segment one3, Segment two3) {

        Segment three3 = null;

        boolean nothingOf = one3.isNothingOf(one2);
        boolean complementOf = one3.isComplementOf(one2);

        boolean reverseOf = one3.isReverseOf(four2);
        boolean complementReverseOf = one3.isComplementReverseOf(four2);

        if (nothingOf) {
            three3 = new Segment(three2.list);
        }
        else if (complementOf) {
            three2.complement();
            three3 = new Segment(three2.list);
            three2.complement();
        }
        else if (reverseOf) {
            two3.reverse();
            three3 = new Segment(two3.list);
            two3.reverse();
        }
        else if (complementReverseOf) {
            two3.complement();
            two3.reverse();
            three3 = new Segment(two3.list);
            two3.reverse();
            two3.complement();
        }

        return three3;
    }

    private Segment computeFour2(Segment one1, Segment four1, Segment one2) {

        Segment four2 = null;

        boolean nothingOf = one2.isNothingOf(one1);
        boolean complementOf = one2.isComplementOf(one1);

        boolean reverseOf = one2.isReverseOf(four1);
        boolean complementReverseOf = one2.isComplementReverseOf(four1);

        if (nothingOf) {
            four2 = new Segment(four1.list);
        }
        else if (complementOf) {
            four1.complement();
            four2 = new Segment(four1.list);
            four1.complement();
        }
        else if (reverseOf) {
            one1.reverse();
            four2 = new Segment(one1.list);
            one1.reverse();
        }
        else if (complementReverseOf) {
            one1.complement();
            one1.reverse();
            four2 = new Segment(one1.list);
            one1.reverse();
            one1.complement();
        }

        return four2;
    }
}
