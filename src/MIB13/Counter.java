package MIB13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame {

	public static Timer timer;
	public static int count = 0;
	public static int time = 0;
	public static int min = 0;

	//Timer constructor
	public Counter() {
		timer = new Timer(1000, new TimerListener()); //Tempo
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    MasterGUI.timeLabel.setText(String.format("     Zeit: %02d:%02d" ,min, time)); //Überschreiben des Labels
			count++; //Sekundenzähler
			time++;
			if(time == 60){
				min++;
				time = 0;
			}
		}
	}
}