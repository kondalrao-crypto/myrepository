package jsonutilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonforhashmap {

	
	public List<HashMap<String, String>> getjsondataintofile(String Filepath) throws IOException {
		
		
		String Jsoncontent= FileUtils.readFileToString((new File(Filepath)),
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();

		List<HashMap<String,String>> data=mapper.readValue(Jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

}
