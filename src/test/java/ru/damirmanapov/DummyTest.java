package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import ru.damirmanapov.exception.AppException;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@Test
public class DummyTest {

    private static final Logger logger = LoggerFactory.getLogger(DummyTest.class);

    @Test
    public void testIs() {
        assertThat(true, is(true));
    }

    @Test
    public void testSamePropertyValuesAs() {

        TestEntity expectedTestEntity = new TestEntity("Test Name");

        TestEntity actualTestEntity = new TestEntity("Test Name");

        assertThat(actualTestEntity, samePropertyValuesAs(expectedTestEntity));
    }

    @Test
    public void test_stackMachine_handle_add() {

        List<Integer> initialState = new LinkedList();
        initialState.add(1);
        initialState.add(7);
        initialState.add(8);
        List<Integer> expectedState = new LinkedList();
        expectedState.add(15);
        List<Integer> actualState = handle(initialState);

        assertThat(actualState, is(expectedState));
    }


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

    public List<Integer> add(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a + b);

        return stack;
    }

    public List<Integer> subtract(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a - b);

        return stack;
    }

    public List<Integer> multiply(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a * b);

        return stack;
    }

    public List<Integer> divide(List<Integer> initialStack) {

        Integer a = initialStack.get(0);
        Integer b = initialStack.get(1);

        List<Integer> stack = new LinkedList(initialStack.subList(2, initialStack.size()));
        stack.add(0, a / b);

        return stack;
    }

    public List<Integer> handle(List<Integer> initialStack) {

        Integer command = initialStack.get(0);

        List<Integer> stack = new LinkedList(initialStack.subList(1, initialStack.size()));

        switch (command) {
            case 1:
                logger.info("add");
                stack = add(stack);
                break;
            case 2:
                logger.info("subtract");
                stack = subtract(stack);
                break;
            case 3:
                logger.info("multiply");
                stack = multiply(stack);
                break;
            case 4:
                logger.info("divide");
                stack = divide(stack);
                break;
            default:
                throw new AppException("Not supported operation");
        }

        return stack;
    }

}
