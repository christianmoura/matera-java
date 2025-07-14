package com.desafio.matera_java;

import com.desafio.matera_java.model.Account;
import com.desafio.matera_java.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModelTests {

    public final static Long ID = 1L;
    public final static String NAME = "Christian B Moura";
    public final static String CPF = "58371021240";
    public final static String PHONENUMBER = "922325106";
    public final static String EMAIL = "christian@nestacpe.net";
    public final static String COUNTRY = "Brasil";
    public final static String UF = "AM";
    public final static String CITY = "Manaus";
    public final static String CEP = "69020-050";
    public final static String HOMENUMBER = "164";
    public final static String STREET = "Rua Ipixuna";
    public final static String NEIGHBORHOOD = "CENTRO";
    public final static String COMPLEMENT = "-";

    public final static Long ID2 = 2L;
    public final static String NAME2 = "Regina B Moura";
    public final static String CPF2 = "70626206294";
    public final static String PHONENUMBER2 = "512325106";
    public final static String EMAIL2 = "regina@aol.com";
    public final static String COUNTRY2 = "Brasil";
    public final static String UF2 = "AM";
    public final static String CITY2 = "Manaus";
    public final static String CEP2 = "69020-050";
    public final static String HOMENUMBER2 = "164";
    public final static String STREET2 = "Rua Ipixuna";
    public final static String NEIGHBORHOOD2 = "CENTRO";
    public final static String COMPLEMENT2 = "-";

    public final static Long ACCOUNTID = 1L;
    public final static String AGENCY = "8271";
    public final static String AGENCYERIFICATIONDIGIT = null;
    public final static String ACCOUNTNUMBER = "06319";
    public final static String ACCOUNTVERIFIATIONDIGIT = "3";

    public final static Long ACCOUNTID2 = 2L;
    public final static String AGENCY2 = "8272";
    public final static String AGENCYERIFICATIONDIGIT2 = null;
    public final static String ACCOUNTNUMBER2 = "06320";
    public final static String ACCOUNTVERIFIATIONDIGIT2 = "4";


    public final static Cliente clienteIn = Cliente.builder()
            .id(ID).name(NAME).cpf(CPF).phoneNumber(PHONENUMBER).email(EMAIL)
            .country(COUNTRY).uf(UF).city(CITY).cep(CEP).homeNumber(HOMENUMBER)
            .street(STREET).neighborhood(NEIGHBORHOOD).comṕlement(COMPLEMENT)
            .build();

    public final static Cliente cliente2 = Cliente.builder()
            .id(ID2).name(NAME2).cpf(CPF2).phoneNumber(PHONENUMBER2).email(EMAIL2)
            .country(COUNTRY2).uf(UF2).city(CITY2).cep(CEP2).homeNumber(HOMENUMBER2)
            .street(STREET2).neighborhood(NEIGHBORHOOD2).comṕlement(COMPLEMENT2)
            .build();

    public final static Cliente CLIENTACCOUNT = clienteIn;

    public final static Account account = Account.builder()
            .id(ACCOUNTID).agency(AGENCY).agencyVerificationDigit(AGENCYERIFICATIONDIGIT)
            .accountNumber(ACCOUNTNUMBER).accountVeficationDigit(ACCOUNTVERIFIATIONDIGIT)
            .cliente(CLIENTACCOUNT)
            .build();

    @Test
    public void ClienteTest() {
        Assertions.assertEquals(ID, clienteIn.getId());
        Assertions.assertEquals(NAME, clienteIn.getName());
        Assertions.assertEquals(CPF, clienteIn.getCpf());
        Assertions.assertEquals(PHONENUMBER, clienteIn.getPhoneNumber());
        Assertions.assertEquals(EMAIL, clienteIn.getEmail());
        Assertions.assertEquals(COUNTRY, clienteIn.getCountry());
        Assertions.assertEquals(UF, clienteIn.getUf());
        Assertions.assertEquals(CITY, clienteIn.getCity());
        Assertions.assertEquals(CEP, clienteIn.getCep());
        Assertions.assertEquals(HOMENUMBER, clienteIn.getHomeNumber());
        Assertions.assertEquals(STREET, clienteIn.getStreet());
        Assertions.assertEquals(NEIGHBORHOOD, clienteIn.getNeighborhood());
        Assertions.assertEquals(COMPLEMENT, clienteIn.getComṕlement());

        clienteIn.setId(ID2);
        clienteIn.setName(NAME2);
        clienteIn.setCpf(CPF2);
        clienteIn.setPhoneNumber(PHONENUMBER2);
        clienteIn.setEmail(EMAIL2);
        clienteIn.setCountry(COUNTRY2);
        clienteIn.setUf(UF2);
        clienteIn.setCity(CITY2);
        clienteIn.setCep(CEP2);
        clienteIn.setHomeNumber(HOMENUMBER2);
        clienteIn.setStreet(STREET2);
        clienteIn.setNeighborhood(NEIGHBORHOOD2);
        clienteIn.setComṕlement(COMPLEMENT2);

        Assertions.assertEquals(clienteIn.getId(), cliente2.getId());
        Assertions.assertEquals(clienteIn.getName(), cliente2.getName());
        Assertions.assertEquals(clienteIn.getCpf(), cliente2.getCpf());
        Assertions.assertEquals(clienteIn.getPhoneNumber(), cliente2.getPhoneNumber());
        Assertions.assertEquals(clienteIn.getEmail(), cliente2.getEmail());
        Assertions.assertEquals(clienteIn.getCountry(), cliente2.getCountry());
        Assertions.assertEquals(clienteIn.getUf(), cliente2.getUf());
        Assertions.assertEquals(clienteIn.getCity(), cliente2.getCity());
        Assertions.assertEquals(clienteIn.getCep(), cliente2.getCep()) ;
        Assertions.assertEquals(clienteIn.getHomeNumber(), cliente2.getHomeNumber());
        Assertions.assertEquals(clienteIn.getStreet(), cliente2.getStreet());
        Assertions.assertEquals(clienteIn.getNeighborhood(), cliente2.getNeighborhood());
        Assertions.assertEquals(clienteIn.getComṕlement(), cliente2.getComṕlement());

    }

    @Test
    public void AccountTest() {
        Assertions.assertEquals(ACCOUNTID, account.getId());
        Assertions.assertEquals(AGENCY, account.getAgency());
        Assertions.assertEquals(AGENCYERIFICATIONDIGIT, account.getAgencyVerificationDigit());
        Assertions.assertEquals(ACCOUNTNUMBER, account.getAccountNumber());
        Assertions.assertEquals(ACCOUNTVERIFIATIONDIGIT, account.getAccountVeficationDigit());

        account.setId(ACCOUNTID2);
        account.setAgency(AGENCY2);
        account.setAgencyVerificationDigit(AGENCYERIFICATIONDIGIT2);
        account.setAccountNumber(ACCOUNTNUMBER2);
        account.setAccountVeficationDigit(ACCOUNTVERIFIATIONDIGIT2);

        Assertions.assertEquals(ACCOUNTID2, account.getId());
        Assertions.assertEquals(AGENCY2, account.getAgency());
        Assertions.assertEquals(AGENCYERIFICATIONDIGIT2, account.getAgencyVerificationDigit());
        Assertions.assertEquals(ACCOUNTNUMBER, account.getAccountNumber());
        Assertions.assertEquals(ACCOUNTVERIFIATIONDIGIT, account.getAccountVeficationDigit());


    }

}
