package com.mc.innuce.domain.debate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.innuce.domain.debate.dao.DebateUserDAO;
import com.mc.innuce.domain.debate.dto.DebateRoomDTO;
import com.mc.innuce.domain.debate.dto.DebateUserDTO;

@Service
public class DebateUserService {
	@Autowired
	DebateRoomService debateRoomService;
	
	@Autowired
	DebateUserDAO debateUserDAO;

	// roomId 유효성 검사, DebateUser 테이블 중복 확인 후 결과 반환
	public int createDebateUser(DebateUserDTO dudto) {
		// TODO Auto-generated method stub
		int key = 0;
		// roomId 값으로 DebateRoom 데이터를 가져와 null 이거나 status가 0이면 0 반환
		DebateRoomDTO tempdr = debateRoomService.selectOneDebateRoom(dudto.getDebate_room_key());
		if(tempdr == null
				|| tempdr.getDebate_room_status() == 0) {
			return key;
		}
		// null이 아니면
		// DebateUser 테이블 검색하여
		// 기존 데이터(user_key, debate_room_key) 존재 하면 dto 반환
		DebateUserDTO tempdu = debateUserDAO.selectOneDebateUserByData(dudto);
		if(tempdu != null) {
			
		}
		// 기존 데이터 존재하지 않으면 생성 후 dto 반환
		// 헤당 debate_room 참여인원 증가
		else {
			debateUserDAO.insertDebateUser(dudto);
			debateRoomService.increaseParticipants(dudto.getDebate_room_key());
			tempdu = debateUserDAO.selectOneDebateUserByData(dudto);
		}
		
		// key값 저장
		key = tempdu.getDebate_user_key();
		
		return key;
	}
	
}
