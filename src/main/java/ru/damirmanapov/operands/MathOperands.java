package ru.damirmanapov.operands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.State;

import java.util.LinkedList;
import java.util.List;

public class MathOperands {

    private static final Logger logger = LoggerFactory.getLogger(MathOperands.class);

    public static State add(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer firstValue = stack.get(0);
        stack.remove(0);
        Integer secondValue = stack.get(0);
        stack.remove(0);
        stack.add(0, firstValue + secondValue);
        state.setStack(stack);
        return state;
    }

    public static State subtract(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer firstValue = stack.get(0);
        stack.remove(0);
        Integer secondValue = stack.get(0);
        stack.remove(0);
        stack.add(0, firstValue - secondValue);
        state.setStack(stack);
        return state;
    }

    public static State multiply(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer firstValue = stack.get(0);
        stack.remove(0);
        Integer secondValue = stack.get(0);
        stack.remove(0);
        stack.add(0, firstValue * secondValue);
        state.setStack(stack);
        return state;
    }

    public static State divide(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer firstValue = stack.get(0);
        stack.remove(0);
        Integer secondValue = stack.get(0);
        stack.remove(0);
        stack.add(0, firstValue / secondValue);
        state.setStack(stack);
        return state;
    }

}
