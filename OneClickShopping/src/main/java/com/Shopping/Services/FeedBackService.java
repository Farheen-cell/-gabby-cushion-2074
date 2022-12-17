package com.Shopping.Services;

import java.util.List;

import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.FeedBackException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Model.Feedback;

public interface FeedBackService {

	public Feedback AddFeedBack(Feedback feedback,Integer orderId,Integer customerId,String key)
	throws LoginException,CustomerException,OrderException,FeedBackException;
	
	public Feedback updateFeedback(Feedback feedback,Integer customerId,String key) 
			throws LoginException,CustomerException,FeedBackException;
	
	public String deletefeedback(Integer feedbackId,Integer customerId,String key)
			throws LoginException,CustomerException,FeedBackException;
	
	public List<Feedback> viewAllFeedback(Integer customerId,String key)
			throws LoginException,CustomerException,FeedBackException;
	
	public Feedback viewFeedBackById(Integer feedbackId,Integer customerId,String key)
			throws LoginException,CustomerException,FeedBackException;
	
	
}
