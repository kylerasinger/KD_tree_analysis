package Ass3_Q1;

public class DataPoint {
	private double[] data;
	public DataPoint(double[] data) {
		this.data = data;
	}
	public DataPoint(String[] data) {
		this.data = new double[10];
		for(int i = 2; i < 12; i++) {
			try{
				this.data[i-2] = Float.parseFloat(data[i]);
			}
			catch(Exception e){
				if(e instanceof NullPointerException) {
					this.data[i] = 0;
				}
			}
			finally {
				
			}
		}
	}
	public void printDataPoint() {
		for (double value : this.data) {
			System.out.printf("%15f", value);
		}
		System.out.println();
	}
	public double[] getData() {
		return data;
	}
	public void setData(double[] data) {
		this.data = data;
	}
	

}
