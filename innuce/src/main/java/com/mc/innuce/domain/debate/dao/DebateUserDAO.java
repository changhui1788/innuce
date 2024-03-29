package com.mc.innuce.domain.debate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mc.innuce.domain.debate.dto.DebateUserDTO;

@Repository
@Mapper
public interface DebateUserDAO {

	DebateUserDTO selectOneDebateUserByData(DebateUserDTO dudto);

	void insertDebateUser(DebateUserDTO dudto);

	String selectOneUserId(int debate_user_key);

	List<String> selectUserIdList(List<Integer> debateUserKeyList);

	void updateDebateUserStatusParticipated(int debate_user_key);

	List<Integer> openDebateRoomUserCountList(List<Integer> openDebateRoomKeyList);

	int selectParticipatedUserCount(int roomId);

	int updateDebateUserStatusLeave(int debate_user_key);

	int updateDebateUserConnectStatusConnect(int debate_user_key);

	int updateDebateUserConnectStatusDisconnect(int debate_user_key);

	int selectConnectedUserCount(int roomId);

	List<Integer> openDebateRoomUserConnectCountList(List<Integer> openDebateRoomKeyList);

	List<Integer> myDebateRoomKeyList(int user_key);

	int myDebateRoomKeyCount(int user_key);

	List<Integer> selectDebateRoomKeyListByUserCount(int closeRoomUserCount);

}
