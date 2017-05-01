package commands.fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import commands.CommandInterface;

public class Load implements CommandInterface,FileOperationsInterface {
private static Load _inst;
private String name;
private String dir="forestsDB";
private List loadedList = new ArrayList();
private Load(){
	
}
public static Load getInst(){
	if(_inst==null)_inst= new Load();
	return _inst;
	}

	
	@Override
	public String execute(Object data){
		StringBuilder sb=new StringBuilder();
		String result="";
		loadedList = new ArrayList();
try(Scanner in = new Scanner(new File(new File("").getAbsolutePath()+"\\src\\"+dir+"\\"+name))) {
			
			while (in.hasNextLine()) {
				String s= in.nextLine();
				sb.append(s+"\n");
				loadedList.add(s);
				
			}
			result=sb.toString();
		
		}catch(FileNotFoundException e){throw new RuntimeException("ERROR: Invalid file name");} 
catch (Exception e){
			e.printStackTrace();
		} 
			return result;
		
	}
	@Override
	public void setFile(String fileName) {
		name=fileName+".txt";
		
	}
	public List getLoadedList() {
		return loadedList;
	}
	public void setLoadedList(List loadedList) {
		this.loadedList = loadedList;
	}

}
