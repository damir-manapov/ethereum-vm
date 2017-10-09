package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.damirmanapov.Configuration.ADD_COMMAND;
import static ru.damirmanapov.Handler.handle;
import static ru.damirmanapov.Math.*;
import static ru.damirmanapov.StackOperands.push;

@Test
public class HandlerTest {

    @Test
    public void test_stackMachine_handle_add() {

        List<Integer> initialState = new LinkedList();
        initialState.add(ADD_COMMAND);
        initialState.add(7);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(15);
        List<Integer> actualState = handle(initialState);

        assertThat(actualState, is(expectedState));
    }

}
