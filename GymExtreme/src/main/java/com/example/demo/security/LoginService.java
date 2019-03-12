package com.example.demo.security;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.OperatorDao;
import com.example.demo.domain.Operator;
import com.example.demo.domain.dto.OperatorLoginDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {
	
	@Autowired
	OperatorDao operatorDao;
	
	public static final String KEY = "1335A";

	public LoginService() {
		super();
	}
	
	public String authorize(OperatorLoginDto operaterLoginDto) {
		Operator operator=operatorDao.findByEmailAndOperatorPassword(operaterLoginDto.getEmail(), operaterLoginDto.getOperatorPassword());
		if(operator!=null) {
			String jws = Jwts.builder().setIssuer(operator.getName())
					.setSubject(operator.getEmail())
					.claim("name", operator.getName()+""+operator.getSurname())
					.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
					.signWith( SignatureAlgorithm.HS256,KEY).compact();
			return jws;
		}
		return "Unknown operator!!!";
		
	}
	
	public String getOperatorEmail(@RequestParam String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
		
		return jws.getBody().getSubject() ;
	}
	
	public boolean checkToken( String token) {
		String operatorEmail = this.getOperatorEmail(token);
		return operatorEmail != null;
	}
}
