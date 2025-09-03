package JSONFile;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromMultipleObjects {
public static void main(String[] args) throws IOException, ParseException {
	//Step1: create JSON Parser Object
	
	JSONParser parser= new JSONParser();
	
	//Step2: read and parse json file and cast it into JSONArray
	JSONArray jsonarray= (JSONArray) parser.parse(new FileReader("D:\\MyWorkSpace\\ninzaCRM\\src\\test\\resources\\ConfigurationData.json"));
	
	//iterating to separate each value from the array
	
	for(Object o: jsonarray) {
		JSONObject obj=(JSONObject) o;
		String un= obj.get("UserName").toString();
		System.out.println(un);
		
	}
	
}
}
