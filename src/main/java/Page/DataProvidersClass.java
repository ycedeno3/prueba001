package Page;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {
    @DataProvider(name = "correos")
    public static Object[][] DataProviderMethod() {
        return new Object[][]{{"ycedeno1@gmail.com"},
                {"ycedeno2@mgail.com"},
                {"ycedeno3@mgail.com"}};
    }
}
