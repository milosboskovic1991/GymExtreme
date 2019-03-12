package com.example.demo.mail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Workout;
import com.example.demo.service.implementation.MemberService;


@Service
public class EmailService{
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail() throws MailException {
		
		Calendar cal = Calendar.getInstance();
		Date endDate = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date startDate = cal.getTime();
		
		List<Member> members = memberService.findAll();
		for(Member mem:members) {
			double price = 0.0;
			List<Workout>workouts = mem.getWorkouts();
			for(Workout workout:workouts) {
				if(workout.getDateWorkout().after(startDate)&&workout.getDateWorkout().before(endDate)) {
					price += workout.getPrice();
				}				
			}	
			
			SimpleMailMessage mail = new SimpleMailMessage();

			mail.setTo(mem.getEmail());
			mail.setFrom("keopskv@gmail.com");
			mail.setSubject("Monthly check!");
			mail.setText("Your monthly check is: "+price);
					
			javaMailSender.send(mail);
		}	
	}
	
	public void sendEmailWithAttachment(Member member) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(member.getEmail());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		FileSystemResource file = new FileSystemResource("");//enter path to some document
		helper.addAttachment(file.getFilename(), file);

		javaMailSender.send(message);
	}

}
