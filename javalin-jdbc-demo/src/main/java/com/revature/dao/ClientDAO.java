package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Client;

public interface ClientDAO {

	public abstract List<Client> getAllclients() throws SQLException;
	
	/**
	 * This method returns a Client from the database
	 * 
	 * @param id is an int  /id
	 * @return Client/client , or null
	 */
	public abstract Client getclientByIndexId(int indexid) throws SQLException;
	
	public abstract Client addclient(AddOrEditClientDTO client) throws SQLException;
	
	public abstract Client editclient(int clientId, AddOrEditClientDTO clinet) throws SQLException;
	
	public abstract void deleteclient(int clienttId) throws SQLException;

	public abstract Object getclientByIndexId(String clientIndexId);

	public abstract List<Client> getAllClientsFromAccount(String clientindexid);

	Client editclient(Client clientId, AddOrEditClientDTO client) throws SQLException;

	public abstract Client deleteclient(ClientDAO clientDao, Object client);

	public abstract Client getclientacc_balance(int id);

	Object getclientacc_Balance(String clientIndexId);

	public abstract Object getAllClientsFromAccount(int eq);
}
