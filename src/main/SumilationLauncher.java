package main;
import java.util.Scanner;

public class SumilationLauncher {
	private static boolean _isFinished=false;
	private static int command=0;
	private static Forest _forest;
	private static String message=Messages.STANDART.getDescription();
	private static int reapHeight;
	private static String newForestName="";
	private static CommandExecutor executor = CommandExecutor.getInst();
	public static void main(String[] args) {
		System.out.println("Start of simulation");
		
		scanning(); 
	
		System.out.println("Goodbye");
		
		
	}
	private static void scanning() {
		try(Scanner in = new Scanner(System.in)) {
					while (!_isFinished) {
						System.out.print(message);
		
						String s = in.nextLine();
						response(s);
						
						
					}
				} catch (Exception e){
					e.printStackTrace();
				}
	}
	public static void response(String data){
		
		message = Messages.STANDART.getDescription();
		switch(command){
		case(1):
			newForestName = data;
			newForest();
			resetCommand();
			return;
		case(2):
			try{
			reapHeight = Integer.parseInt(data);
			reapTrees();
			} catch (NumberFormatException e){System.out.println(Messages.ERR_INVALID_HEIGHT+"\n");}
			resetCommand();
			return;
		case(3):
			newForestName = data;
			loadForest();
			resetCommand();
			return;
			
		default:
		
			break;
		}
		
		if (data.toLowerCase().equals("d")){
			
			displayCurrentForest();
			return;
		}
		if (data.toLowerCase().equals("n")){
			message = Messages.NEW_FOREST_NAME.getDescription();
			command=1;
			return;}
		if (data.toLowerCase().equals("y")){
			oneMoreYear();
			return;}
		if (data.toLowerCase().equals("r")){
			message = Messages.REAP_MSG.getDescription();
			command=2;
			return;}
		if (data.toLowerCase().equals("s")){
			saveForest();
			return;}
		if (data.toLowerCase().equals("l")){
			message = Messages.NEW_FOREST_NAME.getDescription();
			command=3;
			return;}
		if (data.toLowerCase().equals("x")){
			exit();
			return;}
		
		message = Messages.ERR_INVALID_OPTION.getDescription()+"\n\n"+Messages.STANDART.getDescription();

	}
	private static void resetCommand() {
		command=0;
	}
	private static void displayCurrentForest(){
		if(_forest==null){
			System.out.println(Messages.ERR_NO_FOREST.getDescription()+"\n");
		}else{
			System.out.println(_forest.toString()+"\n");
		}
		
	}
	private static void newForest(){
		_forest =new Forest(newForestName);
	}
	private static void oneMoreYear(){
		_forest.grow();
		System.out.println();
	}
	private static void reapTrees(){
		
		System.out.println(_forest.reap(reapHeight)+"\n");
	}
	private static void saveForest(){
		 try {
			executor.saveForest(_forest);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	private static void loadForest() {
		try {
			_forest = executor.loadForest(newForestName);
		} catch (Exception e) {
			
			System.out.println(e.getMessage()+"\n");
		}
	}
	private static void exit(){
		
		_isFinished = true;
	}
	
}
