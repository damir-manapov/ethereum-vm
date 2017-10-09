package ru.damirmanapov.operands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.State;

import java.util.LinkedList;
import java.util.List;

public class JumpOperands {

    private static final Logger logger = LoggerFactory.getLogger(JumpOperands.class);

    // The JUMPI instruction pops 2 values and jumps to the instruction designated
    // by the first only if the second is nonzero. Here, the second is nonzero, so we jump.
    // If the value in storage index 54 had not been zero, then the second value from top on
    // the stack would have been 0 (due to NOT), so we would not have jumped, and we would
    // have advanced to the STOP instruction which would have led to us stopping execution.
    public static State jumpi(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer firstValue = stack.get(0);
        stack.remove(0);
        Integer secondValue = stack.get(0);
        stack.remove(0);
        if (secondValue != 0) {
            state.setPc(firstValue);
        }
        state.setStack(stack);
        return state;
    }

}
