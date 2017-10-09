package ru.damirmanapov.operands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.State;

import java.util.LinkedList;
import java.util.List;

public class StackOperands {

    private static final Logger logger = LoggerFactory.getLogger(StackOperands.class);

    public static State push(State initialState, Integer value) {

        State state = new State(initialState);
        List<Integer> stack = new LinkedList(state.getStack());
        stack.add(0, value);
        state.setStack(stack);
        return state;
    }

}
