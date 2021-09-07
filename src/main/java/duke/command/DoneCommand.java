package duke.command;

import duke.Storage;
import duke.Ui;
import duke.notes.NotesList;
import duke.tasks.TaskList;

public class DoneCommand extends Command {
    String taskNumber;
    public DoneCommand(String command) {
        this.taskNumber = command;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Integer count = Integer.valueOf(this.taskNumber);
        tasks.getTask(count - 1).markAsDone();
        storage.rewriteFile(tasks.getTasks());
        return ui.respondToDone(tasks.getTasks(), count);
    }

    @Override
    public String execute(NotesList notes, Ui ui, Storage storage) {
        return "";
    };

    @Override
    public Boolean isTaskRelatedCommand() {
        return true;
    };

    @Override
    public Boolean isExit() {
        return false;
    }
}
