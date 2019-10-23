import org.eclipse.swt.widgets.Composite;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TodoListUI extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	
	private Task task = new Task("New Task");


	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TodoListUI(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Label lblTitle = new Label(this, SWT.NONE);
		FormData fd_lblTitle = new FormData();
		fd_lblTitle.left = new FormAttachment(0, 10);
		lblTitle.setLayoutData(fd_lblTitle);
		lblTitle.setText("Title:");
		
		Label lblDescription = new Label(this, SWT.NONE);
		fd_lblTitle.bottom = new FormAttachment(100, -251);
		FormData fd_lblDescription = new FormData();
		fd_lblDescription.top = new FormAttachment(lblTitle, 21);
		fd_lblDescription.left = new FormAttachment(lblTitle, 0, SWT.LEFT);
		lblDescription.setLayoutData(fd_lblDescription);
		lblDescription.setText("Description:");
		
		Label lblDeadline = new Label(this, SWT.NONE);
		FormData fd_lblDeadline = new FormData();
		fd_lblDeadline.top = new FormAttachment(lblDescription, 30);
		fd_lblDeadline.left = new FormAttachment(lblTitle, 0, SWT.LEFT);
		lblDeadline.setLayoutData(fd_lblDeadline);
		lblDeadline.setText("Deadline:");
		
		Label lblPriority = new Label(this, SWT.NONE);
		FormData fd_lblPriority = new FormData();
		fd_lblPriority.top = new FormAttachment(lblDeadline, 32);
		fd_lblPriority.left = new FormAttachment(lblTitle, 0, SWT.LEFT);
		lblPriority.setLayoutData(fd_lblPriority);
		lblPriority.setText("Priority:");
		
		text = new Text(this, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.bottom = new FormAttachment(lblTitle, 0, SWT.BOTTOM);
		fd_text.left = new FormAttachment(lblTitle, 22);
		text.setLayoutData(fd_text);
		
		text_1 = new Text(this, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.bottom = new FormAttachment(lblDescription, 0, SWT.BOTTOM);
		fd_text_1.left = new FormAttachment(lblDescription, 6);
		text_1.setLayoutData(fd_text_1);
		
		text_2 = new Text(this, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.bottom = new FormAttachment(lblDeadline, 0, SWT.BOTTOM);
		fd_text_2.left = new FormAttachment(lblDeadline, 6);
		text_2.setLayoutData(fd_text_2);
		
		text_3 = new Text(this, SWT.BORDER);
		FormData fd_text_3 = new FormData();
		fd_text_3.bottom = new FormAttachment(lblPriority, 0, SWT.BOTTOM);
		fd_text_3.left = new FormAttachment(lblPriority, 6);
		text_3.setLayoutData(fd_text_3);
		
		Button btnCompleted = new Button(this, SWT.CHECK | SWT.CENTER);
		FormData fd_btnCompleted = new FormData();
		fd_btnCompleted.left = new FormAttachment(100, -440);
		fd_btnCompleted.right = new FormAttachment(100, -360);
		fd_btnCompleted.top = new FormAttachment(lblPriority, 27);
		btnCompleted.setLayoutData(fd_btnCompleted);
		btnCompleted.setText("Completed");
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Task newTask = new Task(text.getText());
				newTask.setTitle(text_1.getText());
				String dateFormate = "yyyy-mm-dd";
				DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					newTask.setDeadline(dtf.parse(text_2.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		FormData fd_btnSave = new FormData();
		fd_btnSave.top = new FormAttachment(btnCompleted, 23);
		fd_btnSave.left = new FormAttachment(lblTitle, 0, SWT.LEFT);
		btnSave.setLayoutData(fd_btnSave);
		btnSave.setText("Save");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
