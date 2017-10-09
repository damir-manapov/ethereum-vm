package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

import java.util.LinkedList;
import java.util.List;

import static ru.damirmanapov.Math.*;

public class Configuration {

    public static final int ADD_COMMAND = 1;
    public static final int SUBSTRACT_COMMAND = 2;
    public static final int MULTIPLY_COMMAND = 3;
    public static final int DIVIDE_COMMAND = 4;

    public static final int PUSH_COMMAND = 5;
    public static final int PULL_COMMAND = 6;

    public static final int TERMINATE_COMMAND = 20;

}
