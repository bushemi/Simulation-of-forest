package main;
import java.text.DecimalFormat;

public class Tree {
	
	private final int ONE_HUNDRED_PERSENT=100;
	
	private int _number;
	private double _height;
	private final String DELIMETER=";";
	
	
	public Tree(int number, double height, int growthRate) {
		
		this._number = number;
		this._height = roundDown2(height);
		this._growthRate = growthRate;
	}
	public Tree(String treeDescription){
		String[] s = treeDescription.split(DELIMETER);
		this._number = Integer.parseInt(s[0]);
		this._height = roundDown2(Double.parseDouble(s[1]));
		this._growthRate = Integer.parseInt(s[2]);
	}
	public String treeToData(){
		return new String(getNumber()+DELIMETER+getHeight()+DELIMETER+_growthRate);
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return _number + " : " + df.format(_height) + " (" + _growthRate + "% pa)";
	}
	
	public double getHeight() {
		return _height;
	}
	private int _growthRate;

	public int getNumber() {
		return _number;
	}

	public void grow(){
		_height = _height*(_growthRate+ONE_HUNDRED_PERSENT)/ONE_HUNDRED_PERSENT;
		_height = roundDown2(_height);
		
	}
	public static double roundDown2(double d) {
		    return Math.floor(d * 1e2) / 1e2;
		}
	
}
