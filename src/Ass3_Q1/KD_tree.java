package Ass3_Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KD_tree {
	private Node root;
	private static final int dimensions = 10; //?
	
	public Node getRoot() {
		return root;
	}
	
	public KD_tree(List<DataPoint> dataPoints) {
		for(DataPoint dp : dataPoints) {
			insert(dp);
		}
	}
	
	public void insert(DataPoint point) {
		root = insert(root, point, 0);
	}
	
	public Node insert(Node node, DataPoint point, int depth) {
		if (node == null) {
			return new Node(point);
		}
		
		int dimension = depth % dimensions;
		if (point.getData()[dimension] < node.point.getData()[dimension]) {
			node.left = insert(node.left, point, depth + 1);
		} else {
			node.right = insert(node.right, point, depth + 1);
		}
		
		return node;
	}
	
	public boolean verify() {
		double[] lower = new double[dimensions];
	    double[] upper = new double[dimensions];
	    Arrays.fill(lower, Double.NEGATIVE_INFINITY);
	    Arrays.fill(upper, Double.POSITIVE_INFINITY);
		return verify(root, 0, lower, upper);
	}
	
	public boolean verify(Node node, int depth, double[] lower, double[] upper) {
		if (node == null) {
	        return true;
	    }
	    
	    int dimension = depth % dimensions;
	    if (node.point.getData()[dimension] < lower[dimension] || node.point.getData()[dimension] > upper[dimension]) {
	        return false;
	    }
	    
	    if (node.left != null) {
	        double[] newUpper = Arrays.copyOf(upper, dimensions);
	        newUpper[dimension] = node.point.getData()[dimension];
	        if (!verify(node.left, depth + 1, lower, newUpper)) {
	            return false;
	        }
	    }
	    
	    if (node.right != null) {
	        double[] newLower = Arrays.copyOf(lower, dimensions);
	        newLower[dimension] = node.point.getData()[dimension];
	        if (!verify(node.right, depth + 1, newLower, upper)) {
	            return false;
	        }
	    }
	    
	    return true;
	}
	
 	public class Node {
		private DataPoint point;
		private Node left;
		private Node right;
		private int layer; //?
		
		public Node(DataPoint point) {
			this.point = point;
		}
		public DataPoint getPoint() {
			return point;
		}
		public void setPoint(DataPoint contents) {
			this.point = contents;
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

	public static void main(String[] args) {	
		//creation of datapoints
		String file = "src\\reformatted_data.csv";
		BufferedReader reader = null;
		String line = "";
		
		List<DataPoint> listOfDataPoints = new ArrayList<DataPoint>();
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				DataPoint tempData = new DataPoint(row);
				
				listOfDataPoints.add(tempData);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
//		for(DataPoint dp : listOfDataPoints) {
//			dp.printDataPoint();
//		}
		
		//start of kd tree tests
		KD_tree kd_tree = new KD_tree(listOfDataPoints);
		
		boolean test = kd_tree.verify();
		System.out.print(test);
		
	}
}


