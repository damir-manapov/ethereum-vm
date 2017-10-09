package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static ru.damirmanapov.Configuration.*;
import static ru.damirmanapov.Processor.process;
import static ru.damirmanapov.TestUtil.stateEqual;

@Test
public class EthTest {

    @Test
    public void test_simple() {

        State initialState = new State();
        initialState.setMessageValue(54, 2020202020);


//      PC: 0 STACK: [] MEM: [], STORAGE: {}

        State expectedState_1 = new State();
        List<Integer> program = new LinkedList();
        stateEqual(process(program, initialState), expectedState_1);


//      PUSH1 0

        State expectedState_2 = new State();
        expectedState_2.setPc(2);
        expectedState_2.setStack(0);

        program.add(PUSH1_COMMAND);
        program.add(0);

        stateEqual(process(program, initialState), expectedState_2);


//      CALLDATALOAD

//      The instruction at position 2 is CALLDATALOAD,
//      which pops one value from the stack, loads the 32 bytes of message data
//      starting from that index, and pushes that on to the stack.
//      Recall that the first 32 bytes here encode 54.

//      PC: 3 STACK: [54] MEM: [], STORAGE: {}

        State expectedState_3 = new State();
        expectedState_3.setPc(3);
        expectedState_3.setStack(54);

        program.add(CALLDATALOAD_COMMAND);

        stateEqual(process(program, initialState), expectedState_3);


//      SLOAD

//      SLOAD pops one from the stack, and pushes the value in contract storage
//      at that index onto the stack. Since the contract is used for the first time, it has nothing there, so zero.
//
//      PC: 4 STACK: [0] MEM: [], STORAGE: {}

        State expectedState_4 = new State();
        expectedState_4.setPc(4);
        expectedState_4.setStack(0);

        program.add(SLOAD_COMMAND);

        stateEqual(process(program, initialState), expectedState_4);


//      NOT pops one value and pushes 1 if the value is zero, else 0
//
//      PC: 5 STACK: [1] MEM: [], STORAGE: {}

        State expectedState_5 = new State();
        expectedState_5.setPc(5);
        expectedState_5.setStack(1);

        program.add(NOT_COMMAND);

        stateEqual(process(program, initialState), expectedState_5);


//      Next, we PUSH1 9.
//
//      PC: 7 STACK: [1, 9] MEM: [], STORAGE: {}

        State expectedState_6 = new State();
        expectedState_6.setPc(7);
        expectedState_6.setStack(1, 9);

        program.add(PUSH1_COMMAND);
        program.add(9);

        stateEqual(process(program, initialState), expectedState_6);


//      The JUMPI instruction pops 2 values and jumps to the instruction designated by
//      the first only if the second is nonzero. Here, the second is nonzero, so we jump.
//      If the value in storage index 54 had not been zero, then the second value from top
//      on the stack would have been 0 (due to NOT), so we would not have jumped, and
//      we would have advanced to the STOP instruction which would have led to us
//      stopping execution.
//
//      PC: 9 STACK: [] MEM: [], STORAGE: {}

        State expectedState_7 = new State();
        expectedState_7.setPc(9);

        program.add(JUMPI_COMMAND);

        stateEqual(process(program, initialState), expectedState_7);


//      Here, we PUSH1 32.
//
//      PC: 11 STACK: [32] MEM: [], STORAGE: {}

        State expectedState_8 = new State();
        expectedState_8.setPc(11);
        expectedState_8.setStack(32);

        program.add(STOP_COMMAND);
        program.add(PUSH1_COMMAND);
        program.add(32);

        stateEqual(process(program, initialState), expectedState_8);


//      Now, we CALLDATALOAD again, popping 32 and pushing the bytes in message data starting from byte 32 until byte 63.
//
//      PC: 13 STACK: [2020202020] MEM: [], STORAGE: {}

        State expectedState_9 = new State();
        expectedState_9.setPc(12);
        expectedState_9.setStack(2020202020);

        program.add(CALLDATALOAD_COMMAND);

        stateEqual(process(program, initialState), expectedState_9);


//      Next, we PUSH1 0.
//
//      PC: 14 STACK: [2020202020, 0] MEM: [], STORAGE: {}

        State expectedState_10 = new State();
        expectedState_10.setPc(14);
        expectedState_10.setStack(2020202020, 0);

        program.add(PUSH1_COMMAND);
        program.add(0);

        stateEqual(process(program, initialState), expectedState_10);


//      Now, we load message data bytes 0-31 again (loading message data is just as cheap as loading memory, so we don't bother to save it in memory)
//
//      PC: 16 STACK: [2020202020, 54] MEM: [], STORAGE: {}

        State expectedState_11 = new State();
        expectedState_11.setPc(15);
        expectedState_11.setStack(2020202020, 54);

        program.add(CALLDATALOAD_COMMAND);

        stateEqual(process(program, initialState), expectedState_11);


//      Finally, we SSTORE to save the value 2020202020 in storage at index 54.
//      PC: 17 STACK: [] MEM: [], STORAGE: {54: 2020202020}

        State expectedState_12 = new State();
        expectedState_12.setPc(16);
        expectedState_12.setStorage(54, 2020202020);

        program.add(SSTORE_COMMAND);

        stateEqual(process(program, initialState), expectedState_12);

    }

}
