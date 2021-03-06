package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IEquipmentRepository;

@Component
@Service
@Transactional
public class DefaultEquipmentService implements IEquipmentService {

	@Autowired
	IEquipmentRepository equipRepo;
	
	@Override
	public Equipment save(Equipment equipment) {
		return equipRepo.save(equipment);
	}

	@Override
	public List<Equipment> findByOwner(User user) {
		return equipRepo.findEquipmentByOwner(user);
	}

	@Override
	public List<Equipment> findByCompanyName(String companyname) {
		return equipRepo.findEquipmentByCompanyName(companyname);
	}


	@Override
	public List<Equipment> findByGameServiceName(String gameservicename , String gamename) {
		return equipRepo.findEquipmentByGameServiceName(gameservicename,gamename);
	}

	@Override
	public List<Equipment> findByEquipName(String equipname) {
		return equipRepo.findEquipmentByEquipName(equipname);
	}

	@Override
	public List<Equipment> findByGameName(String gamename) {
		return equipRepo.findEquipmentByGameName(gamename);
	}

	@Override
	public List<Equipment> getAllEquipment() {
		Sort sort = new Sort(Direction.DESC,"createDate");
		return (List<Equipment>) equipRepo.findAll(sort);
	}

	@Override
	public List<Equipment> findByOwnerId(Integer id) {
		return equipRepo.findEquipmentByOwnerId(id);
	}

	@Override
	public List<Equipment> findBySellOrBuy(Boolean isSell) {
		return equipRepo.findEquipmentBySellOrBuy(isSell);
	}

	@Override
	public Page<Equipment> getByCreateDatePage(int page) {
		Sort sort = new Sort(Direction.DESC,"createDate");
		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return equipRepo.findAll(pageRequest);
	}

	@Override
	public Page<Equipment> getByLookCheckPage(int page) {
		Sort sort = new Sort(Direction.DESC , "lookcheck");
		PageRequest pageRequest = new PageRequest(page, 20, sort);
		return equipRepo.findAll(pageRequest);
	}

	@Override
	public Equipment findById(Integer id) {
		return equipRepo.findEquipmentById(id);
	}

	@Override
	public Equipment findEquipmentByid(int equipId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}