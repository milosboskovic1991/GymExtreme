package com.example.demo.mail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Member;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	@Autowired
	private Member member;

	
	@RequestMapping("/sendMail")
	@Scheduled(cron = "0 0 0 1 * ? ")
	public String send() {
		
		try {
			emailService.sendEmail();
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the member.";
	}
	 
	@RequestMapping("/sendMailAttachment")
	public String sendWithAttachment() throws MessagingException {
		
		try {
			emailService.sendEmailWithAttachment(member);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Your mail with attachment has been send to the member.";
	}
	
}
