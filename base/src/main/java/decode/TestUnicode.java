package decode;

import java.io.File;
import java.net.URLDecoder;

/**
 * 测试 \\u +　Unicode　转换成汉字
 * @author 张超
 *
 */
public class TestUnicode {

	public static void main(String[] args) {
		String jsonStr = FileUtils.readAsString(new File("E:\\workspace\\ludas_learn\\base\\src\\main\\java\\MyJson.json"));
		String str = UicodeBackslashU.unicodeToCn(jsonStr);
		System.out.println(str);
	}


	/**
	 * java处理 /x 开头的，redis客户端返回的汉字编码
	 * @throws Exception
	 */
	public static void decodeX() throws Exception {
		String s = "\\xe9\\xab\\x98\\xe6\\x94\\xb6\\xe7\\x9b\\x8a";
		String s1 = s.replaceAll("\\\\x", "%");
		String decode = URLDecoder.decode(s1, "utf-8");
		System.out.println(decode);
	}


}
