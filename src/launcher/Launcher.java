package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Student franc = new Student(134679, "Schmidt", "Francisco", "franschmidt2415@gmail.com", "https://github.com/schmidtfrancisco", "/images/fotopers.jpg");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
					SimplePresentationScreen frame = new SimplePresentationScreen(franc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
        
        
    }
}