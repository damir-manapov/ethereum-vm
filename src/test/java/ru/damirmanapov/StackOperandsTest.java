package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.damirmanapov.Math.*;
import static ru.damirmanapov.StackOperands.push;

@Test
public class StackOperandsTest {

    @Test
    public void test_stackMachine_push() {

        List<Integer> initialState = new LinkedList();
        initialState.add(56);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(18);
        expectedState.add(56);
        expectedState.add(8);
        List<Integer> actualState = push(initialState, 18);

        assertThat(actualState, is(expectedState));
    }

}
