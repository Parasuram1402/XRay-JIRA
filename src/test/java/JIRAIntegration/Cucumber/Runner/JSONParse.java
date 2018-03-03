package JIRAIntegration.Cucumber.Runner;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import org.apache.commons.io.FileUtils;

public class JSONParse {
 
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
 // TODO Auto-generated method stub
 JSONParser parser = new JSONParser();
 String report_json = FileUtils.readFileToString(new File("report.json")); 
  try{
  Object obj = parser.parse(report_json);
  JSONArray array = (JSONArray)obj;
  JSONObject obj2;
  String concat="";
  int count=0;
  
 for (int JArr=0; JArr<array.size(); JArr++){
  obj2 = (JSONObject)array.get(JArr);
  Set keySet=obj2.keySet();
  
 JSONArray obj3=(JSONArray)obj2.get("elements");
  for (int i=0;i<obj3.size();i++)
  {
  concat="{\n\t";
  count=0;
  String reportFileName="";
  for (Object ky : keySet)
  {
   if(!ky.toString().equals("elements")){
   count=count+1;
   if(keySet.size()==(count+1)){
   if(obj2.get(ky).getClass().toString().equals("class java.lang.String"))
   concat=concat + "\"" + ky + "\":\"" + obj2.get(ky) + "\n\"}";
   else
   concat=concat + "\"" + ky + "\":" + obj2.get(ky) + "\n}";
   }
   else{
   if(obj2.get(ky).getClass().toString().equals("class java.lang.String"))
   concat=concat + "\"" + ky + "\":\"" + obj2.get(ky) + "\",\n\t";
   else
   concat=concat + "\"" + ky + "\":" + obj2.get(ky) + ",\n\t";
   }
   if(ky.toString().equals("tags")){
   JSONArray obj4=(JSONArray)obj2.get("tags");
   JSONObject tagObj=(JSONObject) obj4.get(0);
   reportFileName=reportFileName+"_"+tagObj.get("name").toString();
   tagObj=(JSONObject) obj4.get(1);
   reportFileName=reportFileName+"_"+tagObj.get("name").toString();
   }
   
  } else {
   concat=concat+"\""+ ky + "\":[" +obj3.get(i) + "],\n\t";
   
  //JSONArray obj4=(JSONArray)obj3.get("tags");
   JSONObject tagObjs=(JSONObject) obj3.get(i);
   JSONArray tagObjArr=(JSONArray)tagObjs.get("tags");
   JSONObject tagObj=(JSONObject) tagObjArr.get(i);
   //System.out.println(tagObj.get("name"));
   reportFileName=tagObj.get("name").toString();
   
  
  }  
 }
   System.out.println(reportFileName+"\n"+concat);
   FileUtils.writeStringToFile(new File(reportFileName+".json"), concat, false); 
 }
   
 }
  }catch(ParseException pe){
  
 System.out.println("position: " + pe.getPosition());
  System.out.println(pe);
  }
 }

}