package practice;

import org.testng.annotations.DataProvider;

public class DataUtil {
	
	   @DataProvider(name = "formData")
	    public Object[][] getFormData() {
	        Object[][] data = new Object[20][4]; // 20 rows, 4 columns: name, email, phone, address

	        for (int i = 0; i < 20; i++) {
	            data[i][0] = "User" + (i + 1);                      // Name
	            data[i][1] = "user" + (i + 1) + "@example.com";      // Email
	            data[i][2] = "88066758" + String.format("%02d", i);  // Phone
	            data[i][3] = "Address " + (i + 1);                   // Address
	        }

	        return data;
	    }

}
