import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameboard extends JFrame {

	int[][] fileArray;

	public Gameboard() {
		setSize(420,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());


		File gameFile = new File("board.txt");
		try {
			Scanner in = new Scanner(gameFile);
			fileArray = new int[19][19];
			for(int i = 0; i < 19; i++) {

				for(int j = 0; j < 19; j++) 
				{
					fileArray[i][j] = in.nextInt();

				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panel.add(new board());
		this.add(panel);
		setVisible(true);
	}

	public class board extends JComponent { 


		public board() {
			setPreferredSize(new Dimension(420, 500));
		}


		public void paintComponent(Graphics g)  {

			g.setColor(Color.BLACK);
			g.fillRect(0, 0 , getWidth(), getHeight());

			g.setColor(Color.WHITE);
			g.drawRect(20, 20 , getWidth() - 40, getWidth() - 40);


			for(int i = 0; i < 19; i++) {
				for(int j = 0; j < 19; j++) {
					if(fileArray[i][j] == -1) {
						g.setColor(Color.blue);
						g.fillRect(20 + i*20, 20 + j*20, 20, 20);
					}
					if(fileArray[i][j] == 1) {
						g.setColor(Color.yellow);
						g.fillOval(20 + i*20 + 10, 20 + j*20 + 10, 5, 5);
					}
				}
			}
		}
	}


	public static void main(String[] args) {
		Gameboard test = new Gameboard();
	}
}


