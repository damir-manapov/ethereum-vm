package ru.damirmanapov;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

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
