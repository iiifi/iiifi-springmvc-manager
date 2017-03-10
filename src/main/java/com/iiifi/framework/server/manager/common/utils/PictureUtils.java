package com.iiifi.framework.server.manager.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.iiifi.framework.server.manager.common.config.Global;

/**
 * 处理图片的工具类
 * 
 * @author 
 *
 */
public class PictureUtils {
	protected static Logger logger = LoggerFactory.getLogger(PictureUtils.class);
	/**
	 * 保存图片返回相对路径
	 * 
	 * @return String
	 * @throws IOException
	 */
	public static String savePicture(
			MultipartFile multipartFile, String fileName) throws IOException {
		String baseResPath = Global.getUserfilesBaseDir();
		String picturePath = baseResPath + File.separator+"userfiles";
		File file = new File(picturePath);
		if (!file.exists() || !file.isDirectory()) {
			file.mkdir();
		}
		File file1 = new File(picturePath + File.separator + "1");
		if (!file1.exists() || !file1.isDirectory()) {
			file1.mkdir();
		}
		File imagesFile = new File(file1 + File.separator + "images");
		if (!imagesFile.exists() || !imagesFile.isDirectory()) {
			imagesFile.mkdir();
		}
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		File myDir = new File(imagesFile + File.separator + year + "-" + month);
		if (!myDir.exists() || !myDir.isDirectory()) {
			myDir.mkdir();
		}
		File newPhotoFile = new File(myDir.getCanonicalPath()+File.separator+IdGen.uuid()
				+ fileName.substring(fileName.indexOf(".")));
		FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), newPhotoFile);
		String resultPath=myDir.getPath() + File.separator + newPhotoFile.getName();
		int index=resultPath.indexOf("userfiles");
		String resultStr=resultPath.substring(index-1);
		return resultStr.replaceAll("\\\\","/");
	}
}
