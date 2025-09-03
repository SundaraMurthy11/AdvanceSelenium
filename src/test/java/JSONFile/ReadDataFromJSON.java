package JSONFile;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {
public static void main(String[] args) throws IOException, ParseException {
	//step1: Parse JSON physical file into the JAVA Object JSON Parser class
	FileReader reader= new FileReader("D:\\MyWorkSpace\\ninzaCRM\\src\\test\\resources\\ConfigurationData.json");

	//step2: Create Object for JSON Parser class
	JSONParser parser= new JSONParser();
	Object obj=parser.parse(reader);
	
	//step3: convert java object into json object
	JSONObject jobj= (JSONObject) obj;
	
	//step4: Get the data from the json file using keys
	String un=jobj.get("UserName").toString();
	String password= jobj.get("password").toString();
	System.out.println(un);
	System.out.println(password);

}
}
