package Ass3_Q1;

public class DataPoint {
	private double[] data;
	private char status;
	private Boolean statusBool;
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
		}
		this.status = data[1].charAt(0);
		if(data[1].charAt(0) == 'M') {
			this.statusBool = Boolean.TRUE;
		}else {
			this.statusBool = Boolean.FALSE;
		}
	}
	
	public void printDataPoint() {
		System.out.printf("%1c", this.status);
		System.out.printf("%6b", this.statusBool);
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
