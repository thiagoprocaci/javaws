package com.tbp.service.v1.webservice;


import com.tbp.service.v1.FindPersonByExampleRequestType;
import com.tbp.service.v1.FindPersonByExampleResponseType;
import com.tbp.service.v1.PersonInterface;
import com.tbp.service.v1.repository.PersonRepository;

import javax.jws.WebService;

@WebService(endpointInterface = "com.tbp.service.v1.PersonInterface")
//@HandlerChain(file = "handlers.xml")
public class PersonSoap implements PersonInterface {


    @Override
    public FindPersonByExampleResponseType findPersonByExample(FindPersonByExampleRequestType findPersonByExampleRequest) {
        PersonRepository repository = new PersonRepository();
        FindPersonByExampleResponseType response = new FindPersonByExampleResponseType();
        response.getPersonList().addAll(repository.findByExample(findPersonByExampleRequest.getPerson()));
        return response;
    }
}
