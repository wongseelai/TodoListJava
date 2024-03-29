import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToDoListTest {
	private Task task1;
	private Task task2;
	private Task task3;
	private ToDoList todoList;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		task1 = new Task ("desc 1");
		task2 = new Task ("desc 2");
		task3 = new Task ("desc 3");
		
		todoList = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
		task3 = null;
		
		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		assertEquals(task1, todoList.getTask(task1.getDescription()));
	}
	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.completeTask(task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
	}
	@Test
	public void testGetPriority() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.getPriority(task1.getDescription());
	}
	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);;
		
		todoList.removeTask(task1.getDescription());
		assertNull(todoList.getTask(task1.getDescription()));	
	}
	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		
		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}
	
	@Test
	public void testUpdateTaskStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		String result = todoList.completeTask(task1.getDescription());
		assertEquals("Updated successfully", result);
		assertEquals(true, todoList.getStatus(task1.getDescription()));
		result = todoList.completeTask(task1.getDescription());
		assertEquals("Task already completed", result);
	}
	
	@Test
	public void testUpdateComments() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertNull(todoList.getTask(task1.getDescription()).getComments());
		todoList.getTask(task1.getDescription()).setComments("test update comment");
		assertEquals("test update comment", todoList.getTask(task1.getDescription()).getComments());
	}
	
	@Test
	public void testUpdateDeadline() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertNull(todoList.getTask(task1.getDescription()).getDeadline());
		Date deadline = new Date();
		todoList.getTask(task1.getDescription()).setDeadline(deadline);
		assertEquals(deadline, todoList.getTask(task1.getDescription()).getDeadline());
	}
	
	@Test
	public void testGetDeadline() {
		Date today = new Date();
		assertNotNull(todoList);
		task1.setDeadline(today);
		todoList.addTask(task1);
		
		assertEquals(today, todoList.getDeadline(task1.getDescription()));
		
	}
}
