package commands.fileOperations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import commands.CommandInterface;

public class Save implements CommandInterface,FileOperationsInterface {

	private static Save _inst;
	private String name="newFile.csv";
	private String dir="forestsDB";
	private Save(){
		
	}
	public static Save getInst(){
		if(_inst==null)_inst= new Save();
		return _inst;
	}

	@Override
	public String execute(Object data) throws Exception {
		 {
			
			String result="";
			String sb=data.toString();
			
			
			try(Writer w = new FileWriter(new File("").getAbsolutePath()+"\\src\\"+dir+"\\"+name,true)){
				w.write(sb);
				result="Done";
			
			}catch(IOException e){
			
				result="fail";
				throw new RuntimeException("Fail to save the file",e);
			} 
				return result;
			
		}
		
	}
	@Override
	public void setFile(String fileName) {
		name=fileName+".txt";
		
	}

}
