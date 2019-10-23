package todolist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		Task task = tasks.get(description);
		task.setComplete(true);
		tasks.put(task.getDescription(), task);
	}
	public boolean getStatus(String description) {
		Task task = tasks.get(description);
		return task.isComplete();
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	
	}
	public Collection<Task> getCompletedTasks() {
	
		return null;
	}
}
