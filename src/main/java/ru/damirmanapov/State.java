package ru.damirmanapov;

import io.atomix.catalyst.buffer.Buffer;
import io.atomix.catalyst.buffer.DirectBuffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class State {

    private Buffer messageValue = DirectBuffer.allocate(64);
    private List<Integer> stack = new LinkedList();
    private List<Integer> memory = new LinkedList();
    private Map<Integer, Integer> storage = new HashMap();
    private int pc = 0;

    public State() {
    }

    public State(List<Integer> stack, List<Integer> memory, Map<Integer, Integer> storage, int pc, Buffer messageValue) {
        this.stack = stack;
        this.memory = memory;
        this.storage = storage;
        this.pc = pc;
        this.messageValue = messageValue;
    }

    public State(State state) {
        this.stack = new LinkedList(state.getStack());
        this.memory = new LinkedList(state.getMemory());
        this.storage = new HashMap<>(state.getStorage());
        this.messageValue.write(state.getMessageValue().bytes());
        this.pc = state.getPc();
    }

    public Buffer getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(int... values) {
        for (Integer value : values) {
            this.messageValue.writeInt(value);
        }
    }

    public void setMessageValue(Buffer messageValue) {
        this.messageValue = messageValue;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public List<Integer> getStack() {
        return stack;
    }

    public void setStack(Integer... values) {
        List<Integer> stack = new LinkedList<>();
        for (int i = values.length - 1; i >= 0; i--) {
            stack.add(values[i]);
        }
        this.stack = stack;
    }

    public void setStack(List<Integer> stack) {
        this.stack = stack;
    }

    public List<Integer> getMemory() {
        return memory;
    }

    public void setMemory(List<Integer> memory) {
        this.memory = memory;
    }

    public Map<Integer, Integer> getStorage() {
        return storage;
    }

    public void setStorage(int... values) {
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i = values.length - 1; i >= 0; i -= 2) {
            storage.put(values[i - 1], values[i]);
        }
        this.storage = storage;
    }

    public void setStorage(Map<Integer, Integer> storage) {
        this.storage = storage;
    }
}
