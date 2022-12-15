package com.gabby.Service;

import com.gabby.Exception.AddressException;

import com.gabby.model.Address;
;

public interface AddressService {
	public Address addAddress(Address address) throws AddressException;
	public Address updateAddress(Address address) throws AddressException;
	public Address removeAddress(Address address) throws AddressException;
}
