package ru.damirmanapov.operands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.State;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StorageOperands {

    private static final Logger logger = LoggerFactory.getLogger(StorageOperands.class);

    public static State sload(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer index = stack.get(0);
        stack.remove(0);
        Integer value = 0;
        if (state.getStorage().containsKey(index)) {
            value = state.getStorage().get(index);
        }
        stack.add(0, value);
        state.setStack(stack);
        return state;
    }

    public static State sstore(State initialState) {

        State state = new State(initialState);

        List<Integer> stack = new LinkedList(state.getStack());
        Integer index = stack.get(0);
        stack.remove(0);
        Integer value = stack.get(0);
        stack.remove(0);
        Map<Integer, Integer> storage = state.getStorage();
        storage.put(index, value);
        state.setStorage(storage);
        state.setStack(stack);
        return state;
    }

}
