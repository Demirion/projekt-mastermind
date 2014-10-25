package MIB13;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class Counter extends JFrame {

	private Timer timer;
	public static int count = 0;

	//Timer constructor
	public Counter() {
		timer = new Timer(1000, new TimerListener()); //Tempo
		timer.start();
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			count++; //Sekundenzähler
		    Integer time = new Integer(Counter.count);
		    String times = time.toString();
		    MasterGUI.timeLabel.setText("Zeit: " + times); //Überschreiben des Labels
		}
	}

	public static void main(String[] args) {
		new Counter();
	}
}