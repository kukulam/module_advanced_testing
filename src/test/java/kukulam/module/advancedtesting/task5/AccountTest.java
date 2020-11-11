package kukulam.module.advancedtesting.task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class AccountTest {

    @Mock
    private Person mockedPerson;
    @Mock
    private AccountBalance mockedAccountBalance;
    @InjectMocks
    private Account account;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnCorrectAccountInfo() {
        // given
        String accountName = "Mike";
        double accountBalance = 12.01;
        String balanceCurrency = "USD";
        String expectedAccountBalanceInfo = accountName + "'s account has " + accountBalance + " " + balanceCurrency;

        when(mockedPerson.getName()).thenReturn(accountName);
        when(mockedAccountBalance.getBalance()).thenReturn(accountBalance);
        when(mockedAccountBalance.getCurrency()).thenReturn(balanceCurrency);

        // when
        String accountBalanceInfo = account.balanceInfo();

        // then
        assertThat(accountBalanceInfo).isEqualTo(expectedAccountBalanceInfo);
    }

}