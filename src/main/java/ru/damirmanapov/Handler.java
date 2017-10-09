package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

import java.util.LinkedList;
import java.util.List;

import static ru.damirmanapov.Configuration.*;
import static ru.damirmanapov.Math.*;

public class Handler {

    private static final Logger logger = LoggerFactory.getLogger(Handler.class);

    public static List<Integer> handle(List<Integer> initialStack) {

        Integer command = initialStack.get(0);

        List<Integer> stack = new LinkedList(initialStack.subList(1, initialStack.size()));

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
            default:
                throw new AppException("Not supported operation");
        }

        return stack;
    }

}
