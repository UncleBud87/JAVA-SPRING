package com.dojo.BeltExam.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.BeltExam.models.Song;
import com.dojo.BeltExam.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	
	public SongService(SongRepository songRepository)
	{
		this.songRepository=songRepository;
	}
	
	public void Create(Song song)
	{
		songRepository.save(song);
	}

	
	public Song ReadOne(Long id)
	{
		Optional<Song> song=songRepository.findById(id);
		return song.isPresent()?song.get():null;
	}
	
	public ArrayList<Song> ReadAll()
	{
		ArrayList<Song> songs=(ArrayList<Song>)songRepository.findAll();
		return songs;
	}
	
	public void Update(Song song)
	{
		Create(song);
	}
	
//	public void UpdateC(Integer count)
//	{
//		SetCount(count);
//	}
//	
//	private void SetCount(Integer count) {
//		// TODO Auto-generated method stub
//		
//	}

	public void Delete(Long id)
	{
		songRepository.deleteById(id);
	}
	

}
