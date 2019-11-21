package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.Liike;


public interface LiikeRepository extends CrudRepository<Liike,String>
{

	Liike findLiikeByIdMsgAndNomUsr(String nom, String msg);

	List<Liike> findLiikeByidMsg(String msg);

	List<Liike> findLiikeByIdMsg(String showlikers);
	@Transactional
	void deleteLiikeByNomUsrAndIdMsg(String nom, String jaime);
	@Transactional
	void deleteLiikeByIdMsg(String idmessage);
	
}