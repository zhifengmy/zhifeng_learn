package decode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件工具类
 * @author 张超
 *
 */
public final class FileUtils {
	
	/**
	 * 读取文件内容，并把内容作为字符串返回
	 * @param f 要读取的文件
	 * @return 字符串形式的文件内容。
	 */
	public static String readAsString(File f) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String str = br.readLine();
			while (null != str) {
				sb.append(str).append("\n");
				str = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != br) {
				br.close();
				br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}