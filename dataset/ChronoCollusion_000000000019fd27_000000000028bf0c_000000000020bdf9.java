import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


        Person[] people = new Person[2];

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            people[0] = new Person("C");
            people[1] = new Person("J");


            ArrayList<Time> times = new ArrayList<Time>(n);

            for(int s = 0; s < n; s++) {
                int from = in.nextInt();
                int to = in.nextInt();
                times.add(new Time(from, to, s));
            }

            times.sort(Comparator.comparing(Time::getFrom));


            String temp = "";
            for(Time time : times) {
                if(time.from >= people[0].getTo()) {
                    time.setName(people[0].getName());
                    people[0].setFrom(time.getFrom());
                    people[0].setTo(time.getTo());
                    continue;
                }

                if(time.from >= people[1].getTo()) {
                    time.setName(people[1].getName());
                    people[1].setFrom(time.getFrom());
                    people[1].setTo(time.getTo());
                    continue;
                }

                temp = "IMPOSSIBLE";
                break;

            }

            if(!temp.equals("IMPOSSIBLE")) {
                times.sort(Comparator.comparing(Time::getIndex));
                for(Time time : times) {
                    temp +=time.getName();
                }

            }

            System.out.println(String.format("Case #%s: %s", i,temp));
        }
    }
}

class Person {

    int from = 0;
    int to = 0;
    String name;

    public Person(String name) {
        this.name=name;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }
}

class Time {

    int from;
    int to;
    int index;
    String name;

    public Time(int from, int to, int index) {
        this.from = from;
        this.to = to;
        this.index = index;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}