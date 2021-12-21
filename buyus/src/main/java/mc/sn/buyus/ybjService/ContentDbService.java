package mc.sn.buyus.ybjService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.sn.buyus.ybjDAO.ContentDbDAO;
import temp.ContentDbVO;

@Service("contentDbServie")
public class ContentDbService {
	@Autowired
	private ContentDbDAO contentDbDao;
	
		//파일읽기
		public void getContent(int movieNo) {

			String apiURL = "https://api.themoviedb.org/3/movie/"+movieNo+"?api_key=c9863c962c1c50d869ffd887e8d19d8e&language=en-US";

	        String apiMessage = "";

	        try {
	            URL url = new URL(apiURL);


	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("Content-Type", "application/json;UTF-8");
	            
	            con.setDoOutput(true);
	            int responseCode = con.getResponseCode();

	            BufferedReader br;

	            if(responseCode==200) { // Normal call
	                System.out.println("con "+con.getResponseMessage());

	                BufferedReader in = new BufferedReader(
	                        new InputStreamReader(
	                                con.getInputStream()));
	                String decodedString;
	                while ((decodedString = in.readLine()) != null) {
	                    apiMessage = decodedString;
	                }
	                in.close();
	                System.out.println(apiMessage);
	                this.jsonToString(apiMessage, movieNo); // 아래 출력
	                
	            } else { 
	            	apiMessage = con.getResponseMessage();
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }

	    }
		
		
		public void jsonToString(String jsonStr, int movieNo) {
		
			try {

				JSONObject jsonObj = new JSONObject(jsonStr);
				List<String> name= new ArrayList<String>();
				JSONArray genresArray = (JSONArray) jsonObj.get("genres");
				for(Object temp : genresArray) {
					JSONObject obj = (JSONObject)temp;
					System.out.println(obj.get("id")+","+obj.get("name"));
					name.add((String) obj.get("name"));
					
				}
				
				System.out.println("name"+name);
				String title = (String) jsonObj.get("title");
				System.out.printf("%d %s \n", genresArray.length(),title);
				int id = movieNo;
				ContentDbVO contentVo=new ContentDbVO(id,title, name.toString());
				this.writeDB_title(contentVo);
				//genre가 string
//				ContentDbVO contentVo=new ContentDbVO(title, name);
//				this.writeDB_real(contentVo);
//				
				//genre가 jsonarray
				//ContentDbVO contentVo=new ContentDbVO(title, genresArray);
				//this.writeDB_real(contentVo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		public boolean writeDB(String title) {
//			boolean flag=false;
//			int result=0;
//			result=contentDbDao.insertDB(title);
//			if(result>0) {
//				flag=true;
//			}
//			return flag;
//		}
		public boolean writeDB_title(ContentDbVO vo) {
			boolean flag=false;
			int result=0;
			result=contentDbDao.insertDB_real(vo);
			if(result>0) {
				flag=true;
			}
			return flag;
		}
//		public boolean writeDB_genre(ContentDbVO vo) {
//			boolean flag=false;
//			int result=0;
//			result=contentDbDao.insertDB_real(vo);
//			if(result>0) {
//				flag=true;
//			}
//			return flag;
//		}
		
	}

