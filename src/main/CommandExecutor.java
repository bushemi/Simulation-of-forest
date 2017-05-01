package main;
import commands.fileOperations.Load;
import commands.fileOperations.Save;

public class CommandExecutor {
	private static CommandExecutor _inst;
	
	private Save save;
	private Load load;
	private CommandExecutor(){
		save = Save.getInst();
		load = Load.getInst();
	}
	public static CommandExecutor getInst(){
		if(_inst==null)_inst= new CommandExecutor();
		return _inst;
	}
	
	public void saveForest(Forest forest) throws Exception{
		save.setFile(forest.getForestName());
		save.execute(forest.forestToData());
	}
	public Forest loadForest(String nameOfForest){
		load.setFile(nameOfForest);
		try{
		load.execute(new Object());}
		catch(Exception e){throw new RuntimeException(e.getMessage());}
		Forest forest = Forest.dataToForest(load.getLoadedList());
		return forest;
	}

	
}
