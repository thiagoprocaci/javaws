package com.tbp.service.v1.webservice;


import com.tbp.service.v1.FindPersonByExampleRequestType;
import com.tbp.service.v1.FindPersonByExampleResponseType;
import com.tbp.service.v1.PersonInterface;

import javax.jws.WebService;

@WebService(endpointInterface = "com.tbp.service.v1.PersonInterface")
//@HandlerChain(file = "handlers.xml")
public class PersonSoap implements PersonInterface {


    @Override
    public FindPersonByExampleResponseType findPersonByExample(FindPersonByExampleRequestType findPersonByExampleRequest) {
        return null;
    }
}
