package com.natwest.listener.service;

import com.natwest.listener.model.Transaction;

/*
created by Rahul sawaria on 03/04/22
*/
public interface ListenerService {

    Object listenMessage(String transaction);

}
