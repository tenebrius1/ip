package duke.util;

import duke.exception.DukeException;
import duke.exception.DukeNegativeIndexException;
import duke.exception.InvalidIndexException;
import duke.task.Task;

import java.util.ArrayList;

/**
 * This class encapsulates a List.
 *
 * @author Tan Yi Guan
 * @version CS2103T AY21/22 Semester 1
 */
public class ToDoList {
    private final ArrayList<Task> list;
    private final DataManager dataManager;
    private final String ls = System.lineSeparator();

    /** Instantiates a new To do list. */
    public ToDoList(ArrayList<Task> list, DataManager dataManager) {
        this.list = list;
        this.dataManager = dataManager;
    }

    /** Prints the list of items that the user entered. */
    public void printList() {
        Ui.printList(list);
    }

    /**
     * Adds user input to list and pretty prints a visual feedback.
     *
     * @param task Task to be stored into the list.
     */
    public void addToList(Task task) {
        list.add(task);
        Ui.prettyPrint(
                String.format(
                        "Got it. I've added this task:" + ls + "\t\t%s\tNow you have %s tasks in the list.",
                        task + ls, list.size()));
    }

    /**
     * Marks the task at index specified to be done.
     *
     * @param index Index of task to be marked as done.
     */
    public void markTaskAsDone(int index) throws DukeException {
        if (index > list.size()) {
            throw new InvalidIndexException(list.size());
        } else {
            Task task = list.get(index - 1);
            task.markAsDone();
            Ui.prettyPrint(String.format("Good job on completing this task!\r\n\t\t%s", task));
        }
    }

    public void removeFromList(int index) throws DukeException {
        if (index > list.size()) {
            throw new InvalidIndexException(list.size());
        } else if (index < 0) {
            throw new DukeNegativeIndexException();
        } else {
            Task task = list.get(index - 1);
            Ui.prettyPrint(
                    String.format(
                            "Noted. I've removed this task:\r\n\t\t%s\tNow you have %s tasks in the list.",
                            task + ls, list.size() - 1));
            list.remove(index - 1);
        }
    }

    public void updateData() throws DukeException {
        dataManager.updateData(list);
    }

    public ArrayList<Task> filterList(String dateTime) {
        ArrayList<Task> filteredList = new ArrayList<>();
        for (Task t : list) {
            if (t.isSameDateTime(dateTime)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    /**
     * Searches through the list and filters out tasks containing a keyword.
     * Returns ArrayList of tasks containing the keyword.
     *
     * @param keyword Keyword to search the list with.
     * @return ArrayList of tasks containing the keyword.
     */
    public ArrayList<Task> searchList(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (Task t : list) {
            if (t.toString().contains(keyword)) {
                matchingTasks.add(t);
            }
        }

        return matchingTasks;
    }
}
