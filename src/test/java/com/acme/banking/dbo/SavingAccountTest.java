package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class SavingAccountTest {

    @Test
    public void shouldCreateWhenValidParameters() {
        int id = 1;
        Client client = createClient();
        double amount = 1.3;

        SavingAccount savingAccount = new SavingAccount(id, client, amount);

        Assertions.assertThat(savingAccount)
                .hasFieldOrPropertyWithValue("id", id)
                .hasFieldOrPropertyWithValue("client", client)
                .hasFieldOrPropertyWithValue("amount", amount);
    }

    @Test
    public void shouldNotCreateWhenInvalidId() {
        int invalidId = 0;
        Client dummyClient = createClient();
        double dummyAmount = 1;

        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(invalidId, dummyClient, dummyAmount));
    }

    @Test
    public void shouldNotCreateWhenClientIsNull() {
        int dummyId = 1;
        double dummyAmount = 1;

        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(dummyId, null, dummyAmount));
    }

    @Test
    public void shouldNotCreateWhenAmountInvalid() {
        int dummyId = 1;
        Client dummyClient = createClient();
        double invalidAmount = 0;

        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(dummyId, dummyClient, invalidAmount));
    }

    private Client createClient() {
        int dummyId = 1;
        String dummyName = "dummyName";
        return new Client(dummyId, dummyName);
    }
}

