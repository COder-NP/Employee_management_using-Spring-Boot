package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeService {
	
	@Autowired
	private EmpRepo repo;
	
	public void AddEmp(Employee e)
	{
		repo.save(e);
	}
	
	
	public List<Employee> getAllEmp()
	{
		return repo.findAll();
	}
	
	
public Employee getEMpById(int id)
{
	 Optional<Employee> e = repo.findById(id);
	if(e.isPresent())
	{
		return e.get();
	}
	return null;
	}



public void deleteEMp(int id)
{   
	
	
	repo.deleteById(id);
	}


}
