package labirent;

import java.io.*;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Maze {
	private FileReader in;
	boolean mazeData[][];
	int mark[][];
	int dim1 = 0;
	int dim2 = 0;

	public static void main(String args[]) {
		Maze solver = new Maze();
		solver.getMaze();
		solver.solveMaze();
		
	}

	public void solveMaze() {

		Stack<currentInfo> path = new Stack();
		currentInfo current = new currentInfo();
		current.row = 1;
		current.col = 0;
		mark[1][0] = 1;
		path.push(current);
		boolean flag = false;
		while (current.col != dim2 - 1 && current.row != dim1 - 1) {
			// System.out.println("Current position : (" + current.row
			// +","+current.col+")");

			if (mazeData[current.row][current.col + 1] && mark[current.row][current.col + 1] == 0) {
				current.col++;
				flag = true;
			} else if (mazeData[current.row][current.col - 1] && mark[current.row][current.col - 1] == 0) {
				current.col--;
				flag = true;
			} else if (mazeData[current.row + 1][current.col] && mark[current.row + 1][current.col] == 0) {
				current.row++;
				flag = true;
			} else if (mazeData[current.row - 1][current.col] && mark[current.row - 1][current.col] == 0) {
				current.row--;
				flag = true;
			} else { // no path out cornered

				mark[current.row][current.col] = 2;
				try {
					path.pop();
					current.row = path.peek().row;
					current.col = path.peek().col;
				} catch (Exception e) {
					System.out.println("There is no solution ");
					System.exit(0);
				}
				flag = false;
			}
			if (flag) {
				path.push(new currentInfo(current));
				mark[current.row][current.col] = 1;
			}
		}

		current.col = 0;
		current.row = 1;

		while (current.col != dim2 - 1 && current.row != dim1 - 1) {
			System.out.print("(" + current.row + "," + current.col + ")");
			mark[current.row][current.col] = 0;
			if (mark[current.row][current.col + 1] == 1) {
				current.col++;
			} else if (mark[current.row][current.col - 1] == 1) {
				current.col--;
			} else if (mark[current.row + 1][current.col] == 1) {
				current.row++;
			} else if (mark[current.row - 1][current.col] == 1) {
				current.row--;
			}
		}
	}

	public void getMaze() {
		int c;

		StringBuffer buf = new StringBuffer();
		try {
			in = new FileReader("maze.dat");
		} catch (FileNotFoundException fnfe) {
			System.out.println("there should be a maze file named maze.dat in the current directory.");
			System.exit(0);
		}

		try {
			while ((c = in.read()) != -1 && !Character.isWhitespace((char) c)) {
				buf.append((char) c);

			}
			// System.out.println( "dim1 : " +buf.toString());
			dim1 = Integer.parseInt(buf.toString());
			buf = new StringBuffer();
			while ((c = in.read()) != -1 && !Character.isWhitespace((char) c)) {
				buf.append((char) c);
			}
			dim2 = Integer.parseInt(buf.toString());
			buf = new StringBuffer();
			// System.out.println("maze dimensions: " + dim1 + ":" + dim2);
			mazeData = new boolean[dim1][dim2];
			mark = new int[dim1][dim2];
			int i = 0, j = 0;
			// in.read();

			while ((c = in.read()) != -1) {
				if (Character.isWhitespace((char) c)) {
					j++;
					i = 0;
					// in.read(); //dummy read for end of line

					continue;
				}
				// System.out.println("current location" + j +":"+ i + ":" + (char) c );
				if ('1' == (char) c)
					mazeData[j][i] = false;
				else
					mazeData[j][i] = true;
				i++;

			}
		} catch (IOException e) {
			System.out.println("file io error");
		}

	}

}

class currentInfo {
	int row;
	int col;

	public currentInfo() {

	}

	public currentInfo(currentInfo c) {
		row = c.row;
		col = c.col;
	}

	public currentInfo(int r, int c) {
		row = r;
		col = c;
	}

	public String toString() {
		return "col : " + col + " row:" + row;
		
	}
}