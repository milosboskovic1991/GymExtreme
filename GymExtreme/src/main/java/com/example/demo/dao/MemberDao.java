package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Member;

@Repository
public interface MemberDao extends CrudRepository<Member, Long> {

}
