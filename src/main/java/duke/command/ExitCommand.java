package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Command to exit the Duke app.
 */
public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    /**
     * Checks whether the command should exit the app.
     *
     * @return True.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        return "Bye. Hope to see you again soon!";
    }
}
