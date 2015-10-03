package com.variacode.bancointeligente.core.rest;

import com.variacode.bancointeligente.entity.DepositSlip;
import com.variacode.bancointeligente.entity.UserAccount;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author miguel@variacode.com
 */
@Path("brach")
@Api(value = "/branch", description = "Sucursal API")
public class BankBranchResource extends AbstractResource {

    public BankBranchResource() {
    }

    @GET
    @Path("/user")
    @Produces("application/json")
    @ApiOperation(value = "usuarios en una sucursal con una accion especifica",
            notes = "",
            response = UserAccount.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid something")})
    public Response getJsonAll(@HeaderParam("branchName") String branchName, @HeaderParam("action") String action) {
        try {
            checkNullsOrEmptyString(branchName, action);
        } catch (BancoInteligenteRESTException ex) {
            return responseWithBodyAndLog(ex.getStatus(), ex.getMessage());
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName("Roi");
        userAccount.setPremium(true);
        userAccount.setRut("1-9");
        userAccount.setPhotoURL("http://mundoejecutivo.com.mx/sites/default/files/styles/large/public/cliente_1.jpg");
        userAccount.setSpecialAssistance(true);
        UserAccount userAccount2 = new UserAccount();
        userAccount2.setFirstName("Gus");
        userAccount2.setPremium(true);
        userAccount2.setRut("1-9");
        userAccount2.setPhotoURL("http://mundoejecutivo.com.mx/sites/default/files/styles/large/public/cliente_1.jpg");
        userAccount2.setSpecialAssistance(false);
        List<UserAccount> userAccountList = new ArrayList<>();
        userAccountList.add(userAccount);
        userAccountList.add(userAccount2);
        return Response.ok(userAccountList).build();
    }

    @GET
    @Path("/user/deposit")
    @Produces("application/json")
    @ApiOperation(value = "trae depositos de un cliente",
            notes = "",
            response = DepositSlip.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid something")})
    public Response getJson(@HeaderParam("rut") String rut) {
        try {
            checkNullsOrEmptyString(rut);
        } catch (BancoInteligenteRESTException ex) {
            return responseWithBodyAndLog(ex.getStatus(), ex.getMessage());
        }
        DepositSlip depositSlip = new DepositSlip();
        depositSlip.setAmount(100.0);
        depositSlip.setDepositId(1L);
        depositSlip.setFromName("sdf");
        depositSlip.setFromPhone("345345");
        depositSlip.setStatus("NEW");
        depositSlip.setToAccount("23452345345");
        depositSlip.setToName("asdf");
        depositSlip.setType("CHECK");
        DepositSlip depositSlip2 = new DepositSlip();
        depositSlip2.setAmount(100.0);
        depositSlip2.setDepositId(1L);
        depositSlip2.setFromName("sdf");
        depositSlip2.setFromPhone("345345");
        depositSlip2.setStatus("NEW");
        depositSlip2.setToAccount("23452345345");
        depositSlip2.setToName("asdf");
        depositSlip2.setType("CHECK");
        List<DepositSlip> depositSlipList = new ArrayList<>();
        depositSlipList.add(depositSlip);
        depositSlipList.add(depositSlip2);
        return Response.ok(depositSlipList).build();
    }

    @PUT
    @Path("/user/deposit")
    @Produces("application/json")
    @ApiOperation(value = "cliente o ejecutivo graba o modifica un deposito",
            notes = "status=NEW,IGNORE,DONE "
            + "type=CHECK,CASH",
            response = DepositSlip.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid something")})
    public Response putJson(@HeaderParam("rut") String rut, DepositSlip depositSlip) {
        try {
            checkNullsOrEmptyString(depositSlip, rut);
        } catch (BancoInteligenteRESTException ex) {
            return responseWithBodyAndLog(ex.getStatus(), ex.getMessage());
        }
        return Response.ok(depositSlip).build();
    }

}
