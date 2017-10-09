package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static ru.damirmanapov.Configuration.ADD_COMMAND;
import static ru.damirmanapov.Handler.handle;
import static ru.damirmanapov.Math.*;
import static ru.damirmanapov.StackOperands.push;

@Test
public class DummyTest {

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

}
