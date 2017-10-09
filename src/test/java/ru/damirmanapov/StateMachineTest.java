package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static ru.damirmanapov.Configuration.*;
import static ru.damirmanapov.Processor.process;
import static ru.damirmanapov.TestUtil.stateEqual;

@Test
public class StateMachineTest {

    @Test
    public void test_simple() {


        State initialState = new State();

        List<Integer> program = new LinkedList();
        program.add(PUSH1_COMMAND);
        program.add(7);
        program.add(PUSH1_COMMAND);
        program.add(8);
        program.add(ADD_COMMAND);
        program.add(STOP_COMMAND);

        State expectedState = new State();
        expectedState.setPc(6);
        expectedState.setStack(15);

        State actualState = process(program, initialState);

        stateEqual(actualState, expectedState);
    }

}
