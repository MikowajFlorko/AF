//package com.example.demo.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Message;
//import com.example.demo.repository.MessageRepository;
//import com.example.demo.service.MessageService;
//
//@Service
//public class MessageServiceImpl implements MessageService {
//	
//	@Autowired
//	private MessageRepository messageRepository;
//
//	public void save(Message message) {
//		messageRepository.save(message);
//		
//	}
//
//	public List<Message> findAll() {
//		return messageRepository.findAll();
//	}
//
//	public Message findOne(int id) {
//		return messageRepository.findOne(id);
//	}
//
//	public void delete(int id) {
//		messageRepository.delete(id);
//		
//	}
//	
//	
//
//}
