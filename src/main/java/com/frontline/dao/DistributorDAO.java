package com.frontline.dao;

import java.util.List;

import com.frontline.model.Distributor;

public interface DistributorDAO {

	public boolean addDistributor(Distributor distributor);
	public boolean deleteDistributor(Distributor distributor);
	public boolean updateDistributor(Distributor distributor);
	public List<Distributor> listDistributors();
	public Distributor getDistributor(int distributorid);
	
}
