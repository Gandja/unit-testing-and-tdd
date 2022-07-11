package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingAccountTest {

    private Client dummyClient;

    @BeforeEach
    public void createDummyClient() {
        int dummyId = 1;
        String dummyName = "dummyName";
        dummyClient = new Client(dummyId, dummyName);
    }

    @Test
    public void shouldCreateWhenValidParameters() {
        int id = 1;
        double amount = 1.3;

        SavingAccount savingAccount = new SavingAccount(id, dummyClient, amount);

        Assertions.assertThat(savingAccount)
                .hasFieldOrPropertyWithValue("id", id)
                .hasFieldOrPropertyWithValue("client", dummyClient)
                .hasFieldOrPropertyWithValue("amount", amount);
    }

    @Test
    public void shouldNotCreateWhenInvalidId() {
        int invalidId = 0;
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
        double invalidAmount = 0;

        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(dummyId, dummyClient, invalidAmount));
    }
}

