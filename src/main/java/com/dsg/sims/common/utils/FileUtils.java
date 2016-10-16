package com.dsg.sims.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * 文件操作工具类
 * @author JieChen
 * @createTime 11/15/15 4:35 PM
 */
public final class FileUtils {

	private FileUtils() {

	}

	/**
	 * 获取文件输入流
	 * @author chenjie
	 * @date 2015-4-1 下午08:49:51
	 * @param fileName 文件路径
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream getFileInputStream(String fileName) throws IOException{
		File file = new File(getlocalPath(fileName)); 
		if(!file.exists())
			throw new FileNotFoundException("can't found file : "+fileName);
		InputStream in = new FileInputStream(file);
		return in;
	}

	/**
	 * 获取本地路径
	 * @author chenjie
	 * @date 2015-4-2 下午02:03:49
	 * @return String
	 */
	private static String getlocalPath(String fileName) {
		return FileUtils.class.getResource(fileName).getFile();
	}

	/**
	 * 获取文件输出流
	 * @author chenjie
	 * @date 2015-4-1 下午08:51:02
	 * @param fileName
	 * @param append
	 * @return OutputStream
	 * @throws IOException
	 */
	public static OutputStream getFileOutPutStream(String fileName, boolean append) throws IOException {
		File file = new File(getlocalPath(fileName));
		if (!file.exists())
			throw new FileNotFoundException("can't found file : " + fileName);
		OutputStream out = new FileOutputStream(file, append);
		return out;
	}

	/**
	 * 读取文件信息 
	 * @author chenjie
	 * @date 2015-4-1 下午08:52:49
	 * @param filePath
	 * @return String
	 * @throws IOException
	 */
	public static String readFile(String filePath) throws Exception {
		InputStream in = getFileInputStream(filePath);
		StringBuilder xmlSb = new StringBuilder();
		byte[] b = new byte[1024];
		int i;
		try {
			while ((i = in.read(b)) != -1) {
				xmlSb.append(new String(b, 0, i, "UTF-8"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != in)
				IOUtils.closeQuietly(in);
		}
		return xmlSb.toString();
	}

	/**
	 * 写文件
	 * @author chenjie
	 * @date 2015-4-1 下午08:54:01
	 * @param filePath
	 * @param message
	 * @throws Exception
	 */
	public static void appendFile(String filePath, String message) throws Exception {
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bwr = null;
		try {
			out = getFileOutPutStream(filePath, true);
			osw = new OutputStreamWriter(out, "utf-8");
			bwr = new BufferedWriter(osw);
			bwr.write(message);
			bwr.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			IOUtils.closeQuietly(bwr);
			IOUtils.closeQuietly(osw);
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * 查找指定路径下所有的文件
	 * 
	 * @param filepath
	 * @param classList
	 * @return List
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> getSubFileNameList(File file, List<String> classList) {
		if (null == classList)
			classList = new ArrayList<String>();
		if(null == file || !file.exists())
			return classList;
		if(file.isFile()){
			 classList.add(getFilePath(file));
			 return classList;
		}
		File[] files = file.listFiles();
		for (File tempFile : files) {
			if (tempFile.isFile())
				classList.add(tempFile.getPath());
			else
				getSubFileNameList(tempFile, classList);
		}
		return classList;
	}
	
	/**
	 * 获取项目根路径
	 * @return String
	 */
	public static String getProjectRootPath(){
		return FileUtils.class.getResource("/").getFile();
	}

	/**
	 * 获取文件路径
	 * 
	 * @param tempFile
	 * @return String
	 */
	private static String getFilePath(File tempFile) {
		return tempFile.getPath();
	}

	public static void main(String[] args) {
		/*try {
			for (int i = 0; i < 160; i++) {
				appendFile("successIds.txt", "587" + i + ",");
			}
			System.out.println(readFile("successIds.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		// System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
		String rootPath = FileUtils.class.getResource("/").getFile();
		File file = new File(rootPath);
		System.out.println(file.getPath());
		List<String> filePathList = new ArrayList<>();
		long timeMills = System.currentTimeMillis();
		getSubFileNameList(file,filePathList);
		for(String path : filePathList)
			System.out.println(path);
		System.out.println(System.currentTimeMillis() - timeMills);
	}

}
