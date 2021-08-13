package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*; // You may need to type this import manually to make use of 
// the argument matchers for Mockito, such as eq() or any()

import java.lang.annotation.Repeatable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.text.html.parser.DTD;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.Throwables;
import org.mockito.BDDMockito.Then;
import org.mockito.stubbing.OngoingStubbing;

import com.revature.dao.ClientDAO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Account;
import com.revature.model.Client;

import kotlin.KotlinNullPointerException;

public class ClientServiceTest {

	private ClientService clientService;
	private ClientDAO clientDao;

	@Before
	public void setUp() throws Exception {
		this.clientDao = mock(ClientDAO.class); //  client, is fake

		this.clientService = new ClientService(clientDao); //  mocked object is being used to  ClientService
															// object
	}

	// Positive test case
	@SuppressWarnings("unchecked")
	@Test
public void test_getAllclients_positive() throws DatabaseException, SQLException {
		//  Fake ClientDAO object, using a mocked ClientDAO,
		// Here we intend to specify, mocked ClientDAO, for whatsoever it is returning,
		// when invo	ke the clientDao.getAllclients() method
		List<Client> mockReturnValues = new ArrayList<>();
		//mockReturnValues.add(( new Account(1, "bankLite")));
		//mockReturnValues.add(( new Account(2, "bankJL")));
		when(clientDao.getAllClientsFromAccount(eq(1))).thenReturn(mockReturnValues);
		
		List<Client> JohnSebastianClient= new ArrayList<>();
		JohnSebastianClient.add(new Client(1, "Felix", " Bennin"));
		JohnSebastianClient.add(new Client(2, "Emma", "Takover"));
		List<Client> bankLite = null;
		When(clientDao.getAllClientsFromAccount(eq(1))).thenReturn(bankLite);
		// Here, the real data being returned by the getAllclients method from
		// clientService
		List<Client> actual = clientService.getAllclients();
    System.out.println(actual);
		// expected = what we expect for the clients List to contain
		List<Client> expected = new ArrayList<>();
		Client cl1 = new Client(1, "John" ,"Sebastian");
		String JonhSebastian1Client = null;
		cl1.setFirstName(JonhSebastian1Client);;
		Client cl2 = new Client(2, "Maria" ,"Tantrum");
		cl2.setClient(new ArrayList<>());
		expected.add(cl1);
		expected.add(cl2);

		// So, we do an assertEquals, to have these two compared to each other
		assertEquals(expected, actual);
		
	}

	private OngoingStubbing<List<Client>> When(Object allClientsFromAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void test_getAllClients_negative() throws SQLException {
		when(clientDao.getAllclients()).thenThrow(SQLException.class);
		// Simulate a situation where clientDao.getAllclients() throws a SQLException

		try {
			clientService.getAllclients();

			fail();
			// The fail() assertion, if DatabaseException (no use of thrown and caught)
			// Testing DatabaseException.
			// Checking for Exception
		} catch (DatabaseException e) {
			String exceptionMessage = e.getMessage();
			assertEquals("Something went wrong with our DAO operations", exceptionMessage);
		}

	}

//	@Test(expected = BadParameterException.class)

	// Testing for client IndexId int
//	}

	@Test
	public void test_getclientByIndexId_idStringIsNotAnInt()
			throws DatabaseException, ClientNotFoundException, BadParameterException {
		clientService.getclientByIndexId("XKKL1");

		fail();
	}

	@Test
	public void test_getclientByIndexId_existingId()
			throws SQLException, DatabaseException, ClientNotFoundException, BadParameterException {
		when(clientDao.getclientByIndexId(eq(1))).thenReturn(new Client());
		// Font

		Client actual = clientService.getclientByIndexId("1");

		Client expected = new Client();

		assertEquals(expected, actual);
	}

	@Test
	public void test_getClientByIndexId_clientDoesNotExist()
			throws DatabaseException, ClientNotFoundException, BadParameterException {
		clientService.getclientByIndexId("19"); //  test an int, values can be null
		

		//fail();
	}

	@Test
	public void test_getClientById_sqlExceptionEncountered()
			throws SQLException, ClientNotFoundException, BadParameterException {
		try {
			when(clientDao.getclientByIndexId(anyInt())).thenThrow(SQLException.class);

			clientService.getclientById("15");
			// Testing values, int against the object
			//fail();
		} catch (DatabaseException e) {
			assertEquals("Something went wrong with our DAO operations", e.getMessage());
		}
	}

	@Test
	public void test_addclient_positivePath() throws SQLException, DatabaseException, BadParameterException {

		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setLastName("Sebastian");
		dto.setIndexid(10);

		when(clientDao.addclient(eq(dto))).thenReturn(new Client());

		Client actual = clientService.addclient(dto);

		assertEquals(new Client(), actual);
	}

	@Test
	public void test_addclient_blankName() throws DatabaseException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setLastName("");
		dto.setIndexid(1);

		try {
			clientService.addclient(dto);

			fail();
		} catch (BadParameterException e) {
			assertEquals("Client name cannot be blank", e.getMessage());
		}

	}

	@Test
	public void test_addclient_blankNameWithSpaces() throws DatabaseException, BadParameterException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setLastName(" Fawlos ");
		dto.setIndexid(3);

		try {
			clientService.addclient(dto);

			fail();
		} catch (BadParameterException e) {
			assertEquals("Client name cannot be blank", e.getMessage());
		}
	}

	
 
	@Test
	
	public void test_addclient_negativeIndexId() throws DatabaseException, NullPointerException,BadParameterException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setLastName("Bennin");
		dto.setIndexid(-1);

		try {
			clientService.addclient(dto);

			fail();
			
		} catch (BadParameterException e) {
			assertEquals("Client indexid is not valid", e.getMessage());
		}

	}

	@Test
	public void test_addclient_negativeClientIndexIdAndBlankName() throws DatabaseException, BadParameterException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setLastName("");
		dto.setIndexid(0);

		try {
			clientService.addclient(dto);

			fail();
		} catch (BadParameterException e) {
			assertEquals("Client indexid can't be zero", e.getMessage());
		}

	}

	@Test(expected = DatabaseException.class)
	public void test_addclient_SQLExceptionEncountered() throws SQLException, DatabaseException, BadParameterException {
		when(clientDao.addclient(any())).thenThrow(SQLException.class);

		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setLastName("Fawlos");
		dto.setIndexid(1);
		clientService.addclient(dto);
	}
	
	}

