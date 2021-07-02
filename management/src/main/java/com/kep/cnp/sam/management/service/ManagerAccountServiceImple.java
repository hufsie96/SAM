package com.kep.cnp.sam.management.service;

import com.kep.cnp.sam.management.api.ApiService;
import com.kep.cnp.sam.management.vo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ManagerAccountServiceImple implements ManagerAccountService{

    @Value("${kep.manageraccount.api-url}")
    private String ACCOUNT_API_URI;

    @Autowired
    private ApiService apiService;// = new ApiService();

    @Override
    public boolean createManager(String jwt_token, Manager manager) {
        String url = ACCOUNT_API_URI + "/user";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("jwt-token", jwt_token);
        apiService.post(url, httpHeaders, manager);

        return true;
    }

    @Override
    public Manager getDetailManager(String jwt_token, String librarianId) {

        String url = ACCOUNT_API_URI + "/user";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("jwt-token", jwt_token);

        Map<String, String> params = new HashMap<String, String>();
        params.put("librarianId", librarianId);

        apiService.get(url, httpHeaders, Manager.class, params);

        return null;
    }

    @Override
    public String generateToken(Manager manager) {
        String url = ACCOUNT_API_URI + "/generateToken";
        ResponseEntity responseEntity = apiService.post(url, null, manager, String.class);
        if ( responseEntity.getStatusCode().is2xxSuccessful())
            return (String)responseEntity.getBody();
        else
            return null;
    }

    @Override
    public boolean validationToken(String token) {
        String url = ACCOUNT_API_URI+"validationToken";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("jwt-token", token);
        try{
            HttpStatus httpStatus = apiService.get(url, httpHeaders).getStatusCode();

            if(httpStatus.is2xxSuccessful())
                return true;
            else if(httpStatus.is4xxClientError())
                return false;
        }catch (Exception ex){

        }
        return false;
    }

    @Override
    public String checkAuthentication(String librarianId, String password) {

        String url = ACCOUNT_API_URI+"/checkAuthentication/"+librarianId+"/"+password;
        HttpHeaders httpHeaders = new HttpHeaders();

        try{
            ResponseEntity responseEntity = apiService.get(url, httpHeaders);
            System.out.println("response:"+responseEntity.getBody());
            if(responseEntity.getStatusCode().is2xxSuccessful())
                return responseEntity.getHeaders().getFirst("token");
            else if(responseEntity.getStatusCode().is4xxClientError())
                throw new Exception();
        }catch (Exception ex){
            return null;
        }

        return null;
    }
}
