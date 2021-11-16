package SnakeSRC;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	// GUI
	GUI() {
		this.add(new Panel());
		this.setTitle("Snek");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.requestFocus();
		this.addKeyListener(new KeyListener());
		System.out.println("GUI Constructed");
	}

	// Panel
	public class Panel extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;

		static final int WIDTH = 800;
		static final int HEIGHT = 800;

		Panel() {
			this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			this.setBackground(Color.black);
			this.setFocusable(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	// KeyListener
	public class KeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				System.out.println("Pressed up");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Pressed down");
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("Pressed left");
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("Pressed right");
				break;
			}
		}
	}

}
