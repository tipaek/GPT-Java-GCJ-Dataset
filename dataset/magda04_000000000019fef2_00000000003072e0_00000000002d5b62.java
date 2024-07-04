package com.magda;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfTestCases = Integer.parseInt(scanner.nextLine());

        List<PointDistance> pointDistances = new ArrayList<>();

        for (int i = 0; i < numOfTestCases; i++) {
            String[] line = scanner.nextLine().split(" ");
            pointDistances.add(new PointDistance(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        for (int i = 0; i < numOfTestCases; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, pointDistances.get(i).findPath());
        }
    }

    private static class PointDistance {
        Point current;
        Point expected;
        int originalDistance;

        PointDistance(int x, int y) {
            this.expected = new Point(x, y);
            this.current = new Point(0, 0);
            this.originalDistance = Math.abs(x) + Math.abs(y);
        }

        private void goSouth(int i) {
            int newY = (int) (this.current.getY() + (Math.pow(2, i - 1) * (-1)));
            int x = (int) this.current.getX();
            this.current.setLocation(x, newY);
        }

        private void goNorth(int i) {
            int newY = (int) (this.current.getY() + (Math.pow(2, i - 1) * (1)));
            int x = (int) this.current.getX();
            this.current.setLocation(x, newY);
        }

        private void goWest(int i) {
            int newX = (int) (this.current.getX() + (Math.pow(2, i - 1) * (-1)));
            int y = (int) this.current.getY();
            this.current.setLocation(newX, y);
        }

        private void goEast(int i) {
            int newX = (int) (this.current.getX() + (Math.pow(2, i - 1) * (1)));
            int y = (int) this.current.getY();
            this.current.setLocation(newX, y);
        }

        private String findPath() {
            StringBuilder path = new StringBuilder();

            int distance = 0;
            int stepNum = 0;
            while (distance < originalDistance) {
                stepNum++;
                distance = distance + getStepUnit(stepNum);
            }

            if (distance == originalDistance) {

                if (expected.getX() > 0) {
                    for (int j = 1; j <= stepNum; j++) {
                        goEast(j);
                        path.append("E");
                    }
                }

                if (expected.getX() < 0) {
                    for (int j = 1; j <= stepNum; j++) {
                        goWest(j);
                        path.append("W");
                    }
                }

                if (expected.getY() > 0) {
                    for (int j = 1; j <= stepNum; j++) {
                        goNorth(j);
                        path.append("N");
                    }
                }

                if (expected.getY() < 0) {
                    for (int j = 1; j <= stepNum; j++) {
                        goSouth(j);
                        path.append("S");
                    }
                }
            }

            if (distance > originalDistance) {

                if (Math.abs(expected.getY()) > Math.abs(expected.getX())) {
                    if (expected.getY() > 0) {
                        goSouth(1);
                        path.append("S");
                    } else {
                        goNorth(1);
                        path.append("N");
                    }
                } else {
                    if (expected.getX() > 0) {
                        goWest(1);
                        path.append("W");
                    } else {
                        goEast(1);
                        path.append("E");
                    }
                }

                if (getStepUnit(2) == getDistanceX()) {
                    if (expected.getX() > 0) {
                        goEast(2);
                        path.append("E");
                    } else {
                        goWest(2);
                        path.append("W");
                    }
                } else if (getStepUnit(2) == getDistanceY()) {
                    if (expected.getY() > 0) {
                        goNorth(2);
                        path.append("N");
                    } else {
                        goSouth(2);
                        path.append("S");
                    }
                }

                if (getStepUnit(3) == getDistanceX()) {
                    if (expected.getX() > 0) {
                        goEast(3);
                        path.append("E");
                    } else {
                        goWest(3);
                        path.append("W");
                    }
                } else if (getStepUnit(3) == getDistanceY()) {
                    if (expected.getY() > 0) {
                        goNorth(3);
                        path.append("N");
                    } else {
                        goSouth(3);
                        path.append("S");
                    }
                }
            }

            if (current.equals(expected)) {
                return path.toString();
            }
            return "IMPOSSIBLE";
        }

        private static int getStepUnit(int i) {
            return (int) Math.pow(2, i - 1);
        }

        private int getDistanceX() {
            return (int) Math.abs(this.expected.getX() - this.current.getX());
        }


        private int getDistanceY() {
            return (int) Math.abs(this.expected.getY() - this.current.getY());
        }
    }

}