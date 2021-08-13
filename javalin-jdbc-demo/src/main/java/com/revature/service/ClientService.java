package com.revature.service;

import java.sql.SQLException;

import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dao.ClientDAOImpl;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Account;
import com.revature.model.Client;

public class ClientService {

	private static final String clientindexid = null;// index is suggesting list/order
	private static final Object last_name = null;
	private static final Object first_name = null;
	// private static final String stringIndexId = null;// index/string will work
	// the index/order
	// ClientDAO is a dependency of ClientService
	private ClientDAO clientDao;

	// This constructor will instantiate a REAL ClientDAO object making use of the
	// ClientDAOImpl class
	@SuppressWarnings("rawtypes")
	public ClientService() {
		this.clientDao = new ClientDAOImpl();

	}

	public void NullPointerException() {
		// super();
	}

	// This constructor is used to instal or inject a fake ClientDAO object,so to
	// instantiating a ClientService object
	// will be use to perform unit tests o
	public ClientService(ClientDAO mockedDaoObject) {
		this.clientDao = mockedDaoObject;
	}

	// This method is dependent on a ClientDAO object to function
	// Because we're invoking the getAllclients() method from ClientDAO
	public List<Client> getAllclients() throws DatabaseException {
		List<Client> clients;
		try {
			clients = clientDao.getAllclients();
			for (Client client:clients) {
				List<Client>client1 = clientDao.getAllClientsFromAccount(Account.getId(0));
				Account.setClient(clients);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong with our DAO operations");
		}

		return clients;
	}

	public Client getclientById(String stringId)
			throws DatabaseException, ClientNotFoundException, BadParameterException {
		try {
			int id = Integer.parseInt(stringId);

			Client client = clientDao.getclientByIndexId(id);

			if (client == null) {
				throw new ClientNotFoundException("Client with indexid " + id + " was not found");
			}

			return client;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		} catch (NumberFormatException e) {
			throw new BadParameterException(
					stringId + " was passed in by the user as the indexid, " + "but it is not an int");
		}
	}

	public Client addclient(AddOrEditClientDTO clientName) throws DatabaseException, BadParameterException {
		if (clientName.getFirstName().trim().equals("") || clientName.getLastName().trim().equalsIgnoreCase(null)
				|| clientName.equals(null)) {

			throw new BadParameterException("Client name cannot be blank and String must be the same");
		}

		if (clientName.getFirstName().trim().equals("")) {
			throw new BadParameterException("Client name cannot be blank");
		}
		if (clientName.getLastName().trim().equals(""))
			throw new BadParameterException("Client name cannot be blank");
		@SuppressWarnings("unused")
		Object clientname;
		if (clientName.toString() == null) {
			throw new BadParameterException("Client name cannot be blank or other");
		}

		try {
			Client addedclientName = clientDao.addclient(clientName);

			return addedclientName;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}

	public Client editclient(String stringId, AddOrEditClientDTO client, Object editAccount)
			throws DatabaseException, ClientNotFoundException, BadParameterException {

		try {
			int clientId = Integer.parseInt(stringId);

			// Index is a modern way for database
			// When using Indexid, it invokes an ordered list of client
			// Before we can edit a Client, see if the client already exists, and if not,
			// throw an Exception
			if (clientDao.getclientByIndexId(clientindexid) == null) {
				throw new ClientNotFoundException("Client with IndexId " + clientindexid + " was not found");
			}

			// If client exists, we proceed to edit the client
			// String clientId1= ctx.pathParam("clientid");
			Client editedclientName = clientDao.editclient(clientId, client);
			List<Client> clients = clientDao.getAllClientsFromAccount(clientindexid);
			((Object) editclient(clientindexid, client, last_name)).equals(clients); // setClient(client);

			return editedclientName;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong with our DAO operations");

		} catch (NumberFormatException e) {
			throw new BadParameterException(
					stringId + " was passed in by the user as the id, " + "but it is not an int");
		}

	}

	@SuppressWarnings("unused")
	public <DeleteOrEditClientDTO> void deleteclient(String nameclient, String firstName, String lastName)
			throws BadParameterException, DatabaseException, ClientNotFoundException {

		// Check to see if the client exists
		try {
			int id = Integer.parseInt(nameclient);

			Client client1 = clientDao.getclientByIndexId(id);
			if (client1 == null) {
				throw new ClientNotFoundException(
						"Trying to delete client with an indexid of " + id + ", but it does not exist");
			}
			// If client does exist, we proceed to delete the client
			// String clientId1= ctx.pathParam("clientid");
			Client deleteclientName = clientDao.deleteclient(clientDao, firstName);
			List<Client> clients = clientDao.getAllClientsFromAccount(clientindexid);
			boolean equals = ((Object) deleteclient(1, first_name, last_name)).equals(clients); // setClient(client);

			clientDao.deleteclient(id);

		} catch (SQLException e) {
			
			throw new DatabaseException("Something went wrong with our DAO operations");
		} catch (NumberFormatException e) {
			throw new BadParameterException(nameclient + " was passed in by the user as the id, " + "but it is not an int");
		} finally {
		}

	}

	public Client getclientacc_Balance(String stringId)
			throws DatabaseException, ClientNotFoundException, BadParameterException, SQLException {
		try {
			int id = Integer.parseInt(stringId);

			Client client = clientDao.getclientacc_balance(id);

			if (client == null) {
				throw new ClientNotFoundException("Client with indexid " + id + " was not found");
			}

			return client;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new BadParameterException(
					stringId + " was passed in by the user as the indexid, " + "but it is not an int");
		}
	}

	private Object deleteclient(int i, Object firstName, Object lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	public Object deleteclient(String clientindexid, Client client, Object lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client getclientByIndexId(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client getclientacc_balance(String clientid) {
		// TODO Auto-generated method stub
		return null;
	}

}
