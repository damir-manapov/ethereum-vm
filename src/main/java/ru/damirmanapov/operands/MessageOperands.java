package ru.damirmanapov.operands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.State;

import java.util.LinkedList;
import java.util.List;

public class MessageOperands {

    private static final Logger logger = LoggerFactory.getLogger(MessageOperands.class);

    public static State callDataLoad(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer offset = stack.get(0) / 8;
        stack.remove(0);
        Integer value = Long.valueOf(state.getMessageValue().readUnsignedInt(offset)).intValue();
        stack.add(0, value);
        state.setStack(stack);
        return state;
    }

}
