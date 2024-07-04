//package com.example.myapplication.test;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    class Element {
        int before, after, curVal, oriVal;
    }

    public Solution() throws FileNotFoundException {
//        System.setIn(new FileInputStream("test.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());
        int tc = 1;

        while (T-- > 0) {
            String s = sc.nextLine();
            Element values [] = new Element[s.length()];
            for(int i = 0; i < s.length(); ++i) {
                Element e = new Element();
                e.curVal = e.oriVal = s.charAt(i) - '0';
                values[i] = e;
            }
            Stack<Element> stack = new Stack<>();
            for (int i = 0; i < values.length; ++i) {
                if (values[i].curVal == 0) continue;
                int min = values[i].curVal;
                Element firtElement = values[i];
                Element lastElement = firtElement;
                stack.clear();
                stack.push(firtElement);
                int k = i + 1;
                while(k < values.length && values[k].curVal != 0) {
                    min = Math.min(min, values[k].curVal);
                    lastElement = values[k];
                    stack.push(values[k]);
                    ++k;
                }
                while (!stack.empty()) {
                    Element e = stack.pop();
                    e.curVal -= min;
                }
                firtElement.before =+ min;
                lastElement.after += min;
            }
            StringBuilder sb = new StringBuilder();
            for (Element e: values) {
                while(e.before-- != 0) sb.append('(');
                sb.append(e.oriVal);
                while(e.after-- != 0) sb.append(')');
            }
            System.out.println(String.format("Case #%d: %s", tc++, sb.toString()));
        }
    }
}

