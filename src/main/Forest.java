package main;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Forest {
	private List<Tree> _currentForest;
	private final String FOREST_NAME;
	private StringBuilder sb;
	private SecureRandom rand = new SecureRandom();
	
	public Forest(String forestName) {
		_currentForest = new ArrayList<Tree>();
		FOREST_NAME = forestName;
		for (int i= 0;i<10;i++){
			
				_currentForest.add(new Tree(i+1,newDouble(1,5),newInteger(50,100)));
			}
		
	}
	private Forest(List list){
		FOREST_NAME = list.get(0).toString();
		list.remove(0);
		_currentForest = new ArrayList<Tree>();
		list.forEach((e)->_currentForest.add(new Tree(e.toString())));
		
		
		
	}
	
	private double newDouble(int rangeMin ,int rangeMax){
		 double randomValue = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
		 return randomValue;
	}

	public void grow(){
		_currentForest.forEach(Tree::grow);
	}
	public String toString() {
		sb = new StringBuilder();
		sb.append(getForestName()+"\n");
		_currentForest.forEach((tree)->sb.append(tree.toString()+"\n"));
		
			return sb.toString();
	}
	public String reap(int height){
		sb = new StringBuilder();
		sb.append("");
		_currentForest.forEach((tree)->replace(tree,height));
		return sb.toString();
	}

	private void replace(Tree tree,int height) {
		if(tree.getHeight()>height){

			sb.append("Cut "+tree.toString()+"\n");
		tree = new Tree(tree.getNumber(),newDouble(1,5),newInteger(50,100));
		_currentForest.set(tree.getNumber()-1, tree);
		sb.append("New "+tree.toString()+"\n");
		}
	}
	
	private int newInteger(int rangeMin, int rangeMax){
		
		int result = rand.nextInt(rangeMax-rangeMin) + rangeMin;
		
			return result;
	}
	public String forestToData(){
		sb = new StringBuilder();
		sb.append(getForestName()+"\n");
		_currentForest.forEach((e)->sb.append(e.treeToData()+"\n"));
		return sb.toString();
	}
	public static Forest dataToForest(List loadedData){
		return new Forest(loadedData);
	}

	public String getForestName() {
		return FOREST_NAME;
	}
	
	
}
