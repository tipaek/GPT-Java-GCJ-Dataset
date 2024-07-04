package com.company;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Activities {
        String name = null;
        Time timeToStart = null;
        Time timeToEnd = null;
        Person person = null;
    }

    public static class PossibleErrorsSolutions {

        public static int hourInsertions() {
            Scanner scanner = new Scanner(System.in);
            int hour;
            try {
                hour = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please insert a number");
                hour = hourInsertions();
            }
            return hour;
        }

        public static String stringInsertions() {
            Scanner scanner = new Scanner(System.in);
            String string;
            try {
                string = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please insert a string");
                string = stringInsertions();
            }
            if (string == null || string.isEmpty()) {
                System.out.println("Please insert a string");
                string = stringInsertions();
            }
            return string;
        }

        public static boolean reconsider(int a, int b, Activities activities) {
            boolean verification = false;
            if (a > b) {
                activities.timeToEnd = new Time(a, 0, 0);
                activities.timeToStart = new Time(b, 0, 0);
                verification = true;
            } else {
                System.out.println("Please check again if the hours are correct");
                a = reintroducingHours(a);
                b = reintroducingHours(b);
                verification = reconsider(a, b, activities);
            }
            return verification;
        }

        public static int reintroducingHours(int a) {
            System.out.println("When do you want to start this activity?");
            a = hourInsertions();
            return a;
        }

        public static boolean personAssignment(ArrayList<Activities> activitiesList, Person person, Activities activities) {
            boolean ver = false;
            int cursor = 0;
            for (Activities act : activitiesList) {
                if (act.person != null && act.person.name.equals(person.name)) {
                    if ((act.timeToStart.before(activities.timeToStart) && act.timeToEnd.after(activities.timeToStart))
                            || (act.timeToStart.before(activities.timeToEnd) && act.timeToEnd.after(activities.timeToEnd))) {
                        cursor++;
                    }
                }
            }
            if (cursor == 0) {
                ver = true;
            }
            return ver;
        }
    }

    public static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the number of activities for today: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ArrayList<Activities> activityList = new ArrayList<>();
        Person Cameron = new Person("Cameron");
        Person Jamie = new Person("Jamie");

        for (int i = 0; i < N; i++) {
            Activities activities = new Activities();
            System.out.println("Please insert the name of the activity:");
            activities.name = PossibleErrorsSolutions.stringInsertions();

            System.out.println("When do you want to start this activity?");
            int hourToStart = PossibleErrorsSolutions.hourInsertions();

            System.out.println("When do you want to end this activity?");
            int hourToEnd = PossibleErrorsSolutions.hourInsertions();

            PossibleErrorsSolutions.reconsider(hourToEnd, hourToStart, activities);

            activityList.add(activities);
        }

        for (int i = 0; i < activityList.size(); i++) {
            Activities act = activityList.get(i);
            System.out.println("Your '" + i + "' activity '" + act.name + "' starts at " + act.timeToStart + " and ends at " + act.timeToEnd);
        }

        for (int i = 0; i < activityList.size(); i++) {
            Activities act = activityList.get(i);
            System.out.println("You have to decide which person does the activity");
            System.out.println("Your '" + i + "' activity '" + act.name + "' starts at " + act.timeToStart + " and ends at " + act.timeToEnd);
            System.out.print("You can assign this activity to: ");

            boolean cameronAvailable = PossibleErrorsSolutions.personAssignment(activityList, Cameron, act);
            boolean jamieAvailable = PossibleErrorsSolutions.personAssignment(activityList, Jamie, act);

            if (cameronAvailable && jamieAvailable) {
                System.out.println("Cameron and Jamie");
                String personName = scanner.nextLine();
                if (Cameron.name.equals(personName)) {
                    act.person = Cameron;
                } else {
                    act.person = Jamie;
                }
            } else if (cameronAvailable) {
                System.out.println("Cameron");
                act.person = Cameron;
            } else if (jamieAvailable) {
                System.out.println("Jamie");
                act.person = Jamie;
            } else {
                System.out.println("You have no person to do this activity");
                act.person = null;
            }
        }

        for (int i = 0; i < activityList.size(); i++) {
            Activities act = activityList.get(i);
            System.out.println("Your '" + i + "' activity '" + act.name + "' starts at " + act.timeToStart + " and ends at " + act.timeToEnd + " and is done by " + (act.person != null ? act.person.name : "no one"));
        }
    }
}