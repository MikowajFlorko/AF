package com.example.demo.service.impl;

import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Base64MultipartFile;
import com.example.demo.entity.Image;
import com.example.demo.repository.ImageCommentRepository;
import com.example.demo.repository.ImageNameRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.ImageService;
import sun.misc.BASE64Decoder;

@Service
public class ImageServiceImpl implements ImageService {
	
	private final static String PATH = "C:/Users/Mik/Desktop/sendPicture"; 
	
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ImageNameRepository imageNameRepository;
	@Autowired
	private ImageCommentRepository imageCommentRepository;

	public Image savePhoto(Image image) throws IOException {
		byte[]fileContent;
		BASE64Decoder decoder = new BASE64Decoder();
		fileContent = decoder.decodeBuffer(image.getName().split(",")[1]);
		String expansion = image.getName().split(",")[0].split("/")[1].split(";")[0];
		image.setName(null);
		image = imageRepository.saveAndFlush(image);
		Base64MultipartFile multipartFile = new Base64MultipartFile(fileContent, image.getId()+"."+expansion);
		saveFile(multipartFile);
		image.setName("/images/"+image.getId()+"."+expansion);
		return imageRepository.save(image);
	}
	
	private void saveFile(MultipartFile file) throws FileNotFoundException, IOException {
		File pathToFolder = new File(PATH);
		createFolder(pathToFolder);
		File newFile = new File(pathToFolder+"/"+file.getOriginalFilename());
		writeFile(newFile, file);
	}
	private void createFolder(File path) {
		if(!path.exists()) {
			path.mkdirs();
		}
	}
	private void writeFile(File file, MultipartFile multipartFile) throws FileNotFoundException, IOException {
		try(OutputStream fos = new FileOutputStream(file);BufferedOutputStream bos = new BufferedOutputStream(fos)){
			bos.write(multipartFile.getBytes(),0,multipartFile.getBytes().length);
			bos.flush();
		}catch(IOException e){
			
		}
	}

	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	public Image findOne(int id) {
		return imageRepository.findOne(id);
	}

	public void delete(int id) {
		imageRepository.delete(id);
		
	}

}
