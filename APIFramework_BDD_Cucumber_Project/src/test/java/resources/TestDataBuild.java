package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.Location;

public class TestDataBuild {
	public Addplace addplacePayload(String name, String langugae, String address) {
		Addplace ap = new Addplace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(langugae);
		ap.setPhone_number("\"(+91) 983 893 393");
		ap.setWebsite("http://google.com");
		ap.setName(name);
		List<String> alist = new ArrayList<String>();
		alist.add("shoe park");
		alist.add("shoe park");
		ap.setTypes(alist);
		Location lc = new Location();
		lc.setLat(-38.383494);
		lc.setLng(33.427362);
		ap.setLocation(lc);
		
		return ap;
	}
	public String deleteplacepayload(String place_Id) {
		return "{\r\n    \"place_id\":\""+place_Id+"\"\r\n}\r\n";
	}

}
