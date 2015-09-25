package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.*;
import fr.treeptik.model.*;

@Service
public class NoteService {

	@Autowired
    private NoteDAO noteDao;

    public NoteService() {
	}
    
    public NoteService(NoteDAO noteDao) {
		this.noteDao = noteDao;
	}

	public Note findById(int id) {
        return noteDao.findById(id);
    }

	public List<Note> findAll() {
		return noteDao.findAll();
	}

	public Note save(Note drink) {
		return noteDao.save(drink);
	}

	public Note update(Note drink) {
		return noteDao.save(drink);
	}

	public void removeById(Integer id) {
		noteDao.delete(id);
	}
}
