package com.banking.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.matrimony.entity.Login;
import com.matrimony.service.MatrimonyServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MatrimonyServiceImplTest {
	
	@InjectMocks
	MatrimonyServiceImpl matrimonyServiceImpl;
	
	@Test
	public void testCreateAccount() {
		Login log = matrimonyServiceImpl.createProfile(loginDto);
		Assert.assertEquals("RohKum", log.getLoginName());
	}

	@Test
	public void testValidateLogin() {
		Mockito.when(loginRepository.findByUserNameAndPassword("RohKum", "password")).thenReturn(login);
		Login actval3 = bankingServiceImpl.validateLogin("RohKum", "password");
		Assert.assertEquals("RohKum", actval3.getUserName());
	}
	
}
