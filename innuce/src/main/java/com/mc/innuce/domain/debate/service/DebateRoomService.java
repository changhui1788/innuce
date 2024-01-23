package com.mc.innuce.domain.debate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.innuce.domain.debate.dao.DebateRoomDAO;
import com.mc.innuce.domain.debate.dto.DebateRoomDTO;

@Service
public class DebateRoomService {
	@Autowired
	DebateRoomDAO debateRoomDAO;

	public List<DebateRoomDTO> openDebateRoomList() {
		// TODO Auto-generated method stub
		return debateRoomDAO.openDebateRoomList();
	}

	public DebateRoomDTO selectOneDebateRoom(int debate_room_key) {
		// TODO Auto-generated method stub
		return debateRoomDAO.selectOneDebateRoom(debate_room_key);
	}

	public int increaseParticipants(int debate_room_key) {
		// TODO Auto-generated method stub
		return debateRoomDAO.increaseParticipants(debate_room_key);
	}
	
}
