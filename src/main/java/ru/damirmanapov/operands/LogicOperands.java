package ru.damirmanapov.operands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.State;

import java.util.LinkedList;
import java.util.List;

public class LogicOperands {

    private static final Logger logger = LoggerFactory.getLogger(LogicOperands.class);

    //      NOT pops one value and pushes 1 if the value is zero, else 0
    public static State not(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer value = stack.get(0);
        stack.remove(0);
        stack.add(0, value == 0 ? 1 : 0);
        state.setStack(stack);
        return state;
    }

}
