import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ToDoList {

	private HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public String completeTask(String description) {
		Task task = null;
		task = tasks.get(description);
		if (task != null && !task.isComplete()){
			task.setComplete(true);
			return "Updated successfully";
		} else {
			return "Task already completed";
		}
	}
	public boolean getStatus(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			return task.isComplete();
		};
		return false;
	}
	
	public String getPriority(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			return task.getPriority().toString();
		};
		return "";
	}
	
	public Date getDeadline(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			return task.getDeadline();
		};
		
		return null;
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
		Collection<Task> completedTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for (Task task: allTasks) 
			if (task.isComplete() == true) completedTasks.add(task);
		return completedTasks;
	}
}
