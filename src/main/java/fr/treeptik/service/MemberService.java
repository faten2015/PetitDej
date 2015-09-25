package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.*;
import fr.treeptik.model.*;

@Service
public class MemberService {

	@Autowired
    private MemberDAO memberDao;

    public MemberService() {
	}
    
    public MemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public Member findById(int id) {
        return memberDao.findById(id);
    }

	public List<Member> findAll() {
		return memberDao.findAll();
	}

	public Member save(Member drink) {
		return memberDao.save(drink);
	}

	public Member update(Member drink) {
		return memberDao.save(drink);
	}

	public void removeById(Integer id) {
		memberDao.delete(id);
	}
}