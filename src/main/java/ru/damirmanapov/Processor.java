package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

import java.util.LinkedList;
import java.util.List;

import static ru.damirmanapov.Configuration.*;
import static ru.damirmanapov.Math.*;
import static ru.damirmanapov.StackOperands.push;

public class Processor {

    private static final Logger logger = LoggerFactory.getLogger(Processor.class);

    public static List<Integer> process(List<Integer> commands, List<Integer> initialStack) {

        int currentPosition = 0;

        List<Integer> stack = new LinkedList(initialStack);

        while (true) {

            Integer command = commands.get(currentPosition);
            currentPosition++;

            switch (command) {
                case ADD_COMMAND:
                    logger.info("add");
                    stack = add(stack);
                    break;
                case SUBSTRACT_COMMAND:
                    logger.info("subtract");
                    stack = subtract(stack);
                    break;
                case MULTIPLY_COMMAND:
                    logger.info("multiply");
                    stack = multiply(stack);
                    break;
                case DIVIDE_COMMAND:
                    logger.info("divide");
                    stack = divide(stack);
                    break;
                case PUSH_COMMAND:
                    logger.info("push");
                    Integer value = commands.get(currentPosition);
                    currentPosition++;
                    stack = push(stack, value);
                    break;
                case TERMINATE_COMMAND:
                    logger.info("terminate");
                    return stack;
                default:
                    throw new AppException("Not supported operation");
            }

        }
    }

}
