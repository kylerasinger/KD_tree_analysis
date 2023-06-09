package Ass3_Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KD_tree {
	private Node root;
	private static int dimensions;
	private double shortestDistance = 0;
	private int visitedNodes = 0;
	
	public class Node {
		private double[] contents;
		private Node left;
		private Node right;
		private int layer;
	
		public double[] getContents() {
			return contents;
		}
		public void setContents(double contents[]) {
			this.contents = contents;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public int getLayer() {
			return layer;
		}
		public void setLayer(int layer) {
			this.layer = layer;
		}
	}

	
	public KD_tree(int dimensions, List<Node> nodes) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String file = "src\\reformatted_data.csv";
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				List<DataPoint> listOfDataPoints = new ArrayList<DataPoint>();
				DataPoint tempData = new DataPoint(row);
				
				for(int i = 2; i < 12; i++) {
					listOfDataPoints.add(tempData);
					//System.out.printf("%10s", row[i]);
				}
				tempData.printDataPoint();
				
//				for(String index : row) {
//					System.out.printf("%-10s", index);
//				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}

}


