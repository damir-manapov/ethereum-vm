package ru.damirmanapov;

import org.testng.annotations.Test;

import static ru.damirmanapov.operands.StackOperands.push;
import static ru.damirmanapov.TestUtil.stateEqual;

@Test
public class StackOperandsTest {

    @Test
    public void test_stackMachine_push() {

        State initialState = new State();
        initialState.setStack(56, 8);
        State expectedState = new State();
        expectedState.setStack(56, 8, 18);
        State actualState = push(initialState, 18);

        stateEqual(actualState, expectedState);
    }

}
