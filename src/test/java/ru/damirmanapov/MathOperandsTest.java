package ru.damirmanapov;

import org.testng.annotations.Test;

import static ru.damirmanapov.operands.MathOperands.*;
import static ru.damirmanapov.TestUtil.stateEqual;

@Test
public class MathOperandsTest {

    @Test
    public void test_stackMachine_add() {

        State initialState = new State();
        initialState.setStack(7, 8);
        State expectedState = new State();
        expectedState.setStack(15);
        State actualState = add(initialState);

        stateEqual(actualState, expectedState);
    }

    @Test
    public void test_stackMachine_subtract() {

        State initialState = new State();
        initialState.setStack(8, 7);
        State expectedState = new State();
        expectedState.setStack(-1);
        State actualState = subtract(initialState);

        stateEqual(actualState, expectedState);
    }

    @Test
    public void test_stackMachine_multiply() {

        State initialState = new State();
        initialState.setStack(7, 8);
        State expectedState = new State();
        expectedState.setStack(56);
        State actualState = multiply(initialState);

        stateEqual(actualState, expectedState);
    }

    @Test
    public void test_stackMachine_divide() {

        State initialState = new State();
        initialState.setStack(8, 56);
        State expectedState = new State();
        expectedState.setStack(7);
        State actualState = divide(initialState);

        stateEqual(actualState, expectedState);
    }

}
