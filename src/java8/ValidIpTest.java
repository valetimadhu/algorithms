package java8;

public class ValidIpTest {

	public boolean isValidIP(String ipadd) {
		
		String[] strList = ipadd.split("\\.");
		
		if(strList.length != 4) return false;
		
		for(String ippart: strList) {
			Integer ip = Integer.valueOf(ippart);
			if(!(ip < 255) && !(ip > 0)) return false;
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
