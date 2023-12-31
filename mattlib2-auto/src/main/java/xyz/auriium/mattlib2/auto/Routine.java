package xyz.auriium.mattlib2.auto;

/**
 * Similar to a Command from wpilib, but designed to be compact and simple.
 */
public interface Routine {

    /**
     * The orders of a routine describes what the system controlling the routine desires the routine to do
     * The system controlling the routine could be another routine, the robot brain, etc
     *
     * the routine does not always have to listen to the orders but for the most part should do so
     */
    enum Orders {
        CONTINUE, //Tells the routine to keep working
        CANCEL //Tells the routine to stop working and return a "ok cancelled"
    }

    /**
     * The outcome of a routine describes what the routine thinks the state of whatever it is trying to accomplish is
     * used by the robot brain or controlling routine to determine what to do next
     */
    enum Outcome {
        WORKING, //tells the brain this routine is still working on it's goal
        OK_FINISHED, //tells the brain that this routine has successfully completed its goal
        OK_CANCELLED, //tells the brain that this routine has successfully been cancelled
        FAIL, //tells the routine that something caused this routine to fail //i.e. something gets in the way of an arm
    }


    /**
     * The method describing the order-outcome loop. The routine takes orders, performs actions, then describes the outcome of it's mission
     * @param ctx
     */
    Outcome runLogic(Orders ctx);

}
