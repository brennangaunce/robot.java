/**
 * Copyright (c) 2007-2013, Kaazing Corporation. All rights reserved.
 */

package org.kaazing.robot.cli;

import org.kaazing.robot.RobotServerFactories;
import org.kaazing.robot.control.RobotControlFactories;
import org.kaazing.robot.control.RobotControlFactory;

public final class RobotCLI {

    private RobotCLI() {

    }

    public static void main(String... args) throws Exception {

        if (args.length == 0) {
            // interactive
            Interpreter interpreter = new InteractiveInterpreter();
            AbstractRobotController controller = new InProcessRobotController(interpreter,
                    RobotControlFactories.createRobotServerFactory(),
                    RobotServerFactories.createRobotServerFactory());
            interpreter.run(controller);
        } else {
            // non interactive
            Interpreter interpreter = new NonInteractiveInterpreter(args);
            AbstractRobotController controller = new InProcessRobotController(interpreter,
                    RobotControlFactories.createRobotServerFactory(),
                    RobotServerFactories.createRobotServerFactory());
            // TODO use FileDrivenRobotController when completed
//            RobotController controller = new FileDrivenRobotController(interpreter);
            interpreter.run(controller);
        }

    }
}
