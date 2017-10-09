package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.damirmanapov.Configuration.ADD_COMMAND;
import static ru.damirmanapov.Configuration.PUSH_COMMAND;
import static ru.damirmanapov.Configuration.TERMINATE_COMMAND;
import static ru.damirmanapov.Processor.process;
//import static ru.damirmanapov.Processor.handle;

@Test
public class StateMachineTest {

    @Test
    public void test_simple() {


        List<Integer> initialState = new LinkedList();

        List<Integer> program = new LinkedList();
        program.add(PUSH_COMMAND);
        program.add(7);
        program.add(PUSH_COMMAND);
        program.add(8);
        program.add(ADD_COMMAND);
        program.add(TERMINATE_COMMAND);

        List<Integer> expectedState = new LinkedList();
        expectedState.add(15);

        List<Integer> actualState = process(program, initialState);

        assertThat(actualState, is(expectedState));
    }

}
