package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtils eU = new ExcelUtils(projectPath+"\\excel\\data.xlsx", "Hoja1");
		eU.getRowCount();
		eU.getCellDataString(0, 0);
		eU.getCellDataNumber(1,1);
	}
	
}
