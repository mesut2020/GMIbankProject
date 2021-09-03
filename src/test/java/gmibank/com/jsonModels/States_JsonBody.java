package gmibank.com.jsonModels;

import java.util.HashMap;

public class States_JsonBody {

    final public static  String createState1 = "{\"countryId\": 1,\"name\":\"New Hampshire\" }";

    public HashMap<String,Object> stateData(){
        HashMap<String,Object> expectedStateData = new HashMap<>();
        expectedStateData.put("countryId",1);
        expectedStateData.put("name","New Hampshire");
        return stateData();

    }
}
