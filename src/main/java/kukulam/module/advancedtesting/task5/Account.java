package kukulam.module.advancedtesting.task5;

// Use in tests: @Mock, @InjectMocks, @BeforeEach, assertThat
public class Account {
    private Person person;
    private AccountBalance accountBalance;

    public String balanceInfo() {
         return person.getName() + "'s account has " + accountBalance.getBalance() + " " + accountBalance.getCurrency();
    }
}

