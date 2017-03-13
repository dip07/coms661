/**
 *  To save the data to files
 */
package com.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author dipanjankarmakar
 *
 */
public class SaveFileUtil {
	
	public static void main(String args[])
	{
		SaveFileUtil.saveFile("test.txt", "fileFolder/", "Hello from function");
	}

	public static void saveFile(String fileName, String folderPath, String contents)
	{
		try{
		File dir = new File(folderPath);
		dir.mkdir();
		Path path = Paths.get(folderPath+fileName);
		BufferedWriter writer = Files.newBufferedWriter(path);
			writer.write(contents);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
