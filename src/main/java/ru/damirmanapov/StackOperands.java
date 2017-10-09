package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

import java.util.LinkedList;
import java.util.List;

import static ru.damirmanapov.Math.*;

public class StackOperands {

    private static final Logger logger = LoggerFactory.getLogger(StackOperands.class);

    public static List<Integer> push(List<Integer> initialStack, Integer value) {

        List<Integer> stack = new LinkedList(initialStack);
        stack.add(0, value);

        return stack;
    }

}
