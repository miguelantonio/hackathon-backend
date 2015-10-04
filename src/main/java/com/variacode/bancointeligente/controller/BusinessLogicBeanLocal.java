package com.variacode.bancointeligente.controller;

import com.variacode.bancointeligente.core.rest.BancoInteligenteRESTException;
import javax.ejb.Local;

/**
 *
 * @author miguel@variacode.com
 */
@Local
public interface BusinessLogicBeanLocal {

    public String login(String rut, String pin);
    
    public void tokenCheck(String rut, String token) throws BancoInteligenteRESTException;
}
