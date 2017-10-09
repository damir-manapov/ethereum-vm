package ru.damirmanapov;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUtil {

    public static void stateEqual(State actualState, State expectedState) {

        assertThat(actualState.getPc(), is(expectedState.getPc()));
        assertThat(actualState.getStack(), is(expectedState.getStack()));
        assertThat(actualState.getMemory(), is(expectedState.getMemory()));
        assertThat(actualState.getStorage(), is(expectedState.getStorage()));
    }

}
