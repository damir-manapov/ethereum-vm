package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

import java.util.List;

import static ru.damirmanapov.Configuration.*;
import static ru.damirmanapov.operands.JumpOperands.jumpi;
import static ru.damirmanapov.operands.LogicOperands.not;
import static ru.damirmanapov.operands.MathOperands.*;
import static ru.damirmanapov.operands.MessageOperands.callDataLoad;
import static ru.damirmanapov.operands.StackOperands.*;
import static ru.damirmanapov.operands.StorageOperands.sload;
import static ru.damirmanapov.operands.StorageOperands.sstore;

public class Processor {

    private static final Logger logger = LoggerFactory.getLogger(Processor.class);

    public static State process(List<Integer> commands, State initialState) {

        State state = new State(initialState);

        while (commands.size() > 0 && state.getPc() < commands.size()) {

            Integer command = commands.get(state.getPc());
            state.setPc(state.getPc() + 1);

            switch (command) {
                case ADD_COMMAND:
                    logger.info("add");
                    state = add(state);
                    break;
                case SUBSTRACT_COMMAND:
                    logger.info("subtract");
                    state = subtract(state);
                    break;
                case MULTIPLY_COMMAND:
                    logger.info("multiply");
                    state = multiply(state);
                    break;
                case DIVIDE_COMMAND:
                    logger.info("divide");
                    state = divide(state);
                    break;
                case PUSH1_COMMAND:
                    logger.info("push");
                    Integer value = commands.get(state.getPc());
                    state.setPc(state.getPc() + 1);
                    logger.info("push value: {}", value);
                    state = push(state, value);
                    break;
                case CALLDATALOAD_COMMAND:
                    logger.info("callDataLoad");
                    state = callDataLoad(state);
                    break;
                case SLOAD_COMMAND:
                    logger.info("sload");
                    state = sload(state);
                    break;
                case NOT_COMMAND:
                    logger.info("not");
                    state = not(state);
                    break;
                case JUMPI_COMMAND:
                    logger.info("jumpi");
                    state = jumpi(state);
                    break;
                case SSTORE_COMMAND:
                    logger.info("sstore");
                    state = sstore(state);
                case STOP_COMMAND:
                    logger.info("stop");
                    return state;
                default:
                    throw new AppException("Not supported operation");
            }

        }

        return state;
    }

}
