package ru.animal.clinic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Палыч on 21.09.2019.
 */
public class ClientTest {

    @Test
    public void setName() throws UserException{
        Client client = new Client();
        client.setName("Bob");
        assertEquals("client Bob", client.getName());
    }

   @Test(expected = UserException.class)
    public void setNameException() throws Exception {
        Client client = new Client();
        client.setName(null);
        assertEquals("client ", client.getName());
    }

}