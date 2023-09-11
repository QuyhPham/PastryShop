package Test;
import javax.swing.UIManager;

import App.Manager1;
public class Testt {

		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				new Manager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


