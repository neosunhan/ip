package duke.command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Command to mark a task as not done.
 */
public class UnmarkTaskCommand extends Command {
    public static final String COMMAND_WORD = "unmark";

    private List<Integer> taskIndices;

    public UnmarkTaskCommand(List<Integer> taskIndices) {
        this.taskIndices = taskIndices;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        taskIndices = new ArrayList<>(new HashSet<>(taskIndices)); // Remove duplicates
        StringBuilder ret = new StringBuilder("Nice! I've marked these tasks as not done yet:");
        for (int taskIndex : taskIndices) {
            tasks.markTaskAsNotDone(taskIndex);
            ret.append("\n\t").append(tasks.getTask(taskIndex));
        }
        storage.write(tasks);
        return ret.toString();
    }
}
