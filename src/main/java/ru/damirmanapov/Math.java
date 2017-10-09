package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Math {

    private static final Logger logger = LoggerFactory.getLogger(Math.class);

    public static List<Integer> add(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a + b);

        return stack;
    }

    public static List<Integer> subtract(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a - b);

        return stack;
    }

    public static List<Integer> multiply(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a * b);

        return stack;
    }

    public static List<Integer> divide(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a / b);

        return stack;
    }

}
