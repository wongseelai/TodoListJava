package todolist;

import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures

	private ToDoList toDoList;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		toDoList = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		toDoList = null;
	}

	@Test
	public void testAddTask() {
		//list should not contain any tasks
		assertTrue(toDoList.getAllTasks().isEmpty());
		
		//create and add task to to do list
		Task t1 = new Task("First Task");
		toDoList.addTask(t1);
		
		//list should not be empty
		assertFalse(toDoList.getAllTasks().isEmpty());
		
		//list should contain 1 task
		assertTrue(toDoList.getAllTasks().size() == 1);
		
		//task in list should be same as added task
		Task resultTask = toDoList.getTask(t1.getDescription());
		
		assertSame(t1, resultTask);
		
		
	}
	@Test
	public void testgetStatus() {
		assertTrue(toDoList.getAllTasks().isEmpty());
		
		Task t1 = new Task("First Task", true);
		toDoList.addTask(t1);
		
		assertSame(t1, toDoList.getTask(t1.getDescription()));
		
		assertEquals(t1.isComplete(), toDoList.getStatus(t1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		Task t1 = new Task("First Task");
		toDoList.addTask(t1);
		
		assertFalse(toDoList.getAllTasks().isEmpty());
		
		toDoList.removeTask(t1.getDescription());
		
		assertTrue(toDoList.getAllTasks().isEmpty());
		
	}
	@Test
	public void testGetCompletedTasks() {
		Task t1 = new Task("First Task", true);
		Task t2 = new Task("Second Task", false);
		toDoList.addTask(t1);
		toDoList.addTask(t2);
		
		assertFalse(toDoList.getAllTasks().isEmpty());
		
		Collection<Task> resultTasks = toDoList.getCompletedTasks();
		
		assertTrue(resultTasks.size() == 1);
		Task resultTask = resultTasks.iterator().next();
		
		assertSame(t1, resultTask);
		
	}
	
	@Test
	public void testCompleteTask() {
		Task t1 = new Task("First Task", false);
		
		toDoList.addTask(t1);
		assertFalse(toDoList.getAllTasks().isEmpty());
		assertTrue(toDoList.getCompletedTasks().isEmpty());
		
		toDoList.completeTask(t1.getDescription());
		
		assertFalse(toDoList.getCompletedTasks().isEmpty());
		assertTrue(toDoList.getCompletedTasks().size() == 1);
		
		Task resultTask = toDoList.getCompletedTasks().iterator().next();
		assertEquals(t1.getDescription(), resultTask.getDescription());
	}
}
