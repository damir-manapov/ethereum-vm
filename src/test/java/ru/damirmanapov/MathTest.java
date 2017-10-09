package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.damirmanapov.Math.*;

@Test
public class MathTest {

    @Test
    public void test_stackMachine_add() {

        List<Integer> initialState = new LinkedList();
        initialState.add(7);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(15);
        List<Integer> actualState = add(initialState);

        assertThat(actualState, is(expectedState));
    }

    @Test
    public void test_stackMachine_subtract() {

        List<Integer> initialState = new LinkedList();
        initialState.add(7);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(-1);
        List<Integer> actualState = subtract(initialState);

        assertThat(actualState, is(expectedState));
    }

    @Test
    public void test_stackMachine_multiply() {

        List<Integer> initialState = new LinkedList();
        initialState.add(7);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(56);
        List<Integer> actualState = multiply(initialState);

        assertThat(actualState, is(expectedState));
    }

    @Test
    public void test_stackMachine_divide() {

        List<Integer> initialState = new LinkedList();
        initialState.add(56);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(7);
        List<Integer> actualState = divide(initialState);

        assertThat(actualState, is(expectedState));
    }

}
