package duke.command;

import duke.exception.DukeException;
import duke.util.Parser;
import duke.util.ToDoList;

/**
 * This class encapsulates the command dealing with deleting tasks from the list.
 *
 * @author Tan Yi Guan
 * @version CS2103T AY21/22 Semester 1
 */
public class DeleteCommand extends Command {
    private final ToDoList list;

    public DeleteCommand(ToDoList list) {
        this.list = list;
    }

    @Override
    public String getResponse(String input) {
        int index = 0;
        try {
            index = Parser.extractIndex(input);
            String response = list.removeFromList(index);
            list.updateData();
            return response;
        } catch (DukeException e) {
            return e.getMessage();
        }
    }
}
