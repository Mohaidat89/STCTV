package Core.Base.TestDataBase;

import Core.Helpers.ReadWriteHelper;

import java.util.Map;

public class TestDataBase {

    protected String testConfigPath;
    protected String baseUrl;
    protected String browser;
    protected long waitTime;
    protected long retries;
    protected boolean headlessMode;

    public TestDataBase() {
        testConfigPath = "src/main/java/Config/testConfig.json";

        Map testConfig = ReadWriteHelper.getDataFromJson(testConfigPath);
        Map envConfig = (Map) testConfig.get("env_config");
        baseUrl = (String) envConfig.get("baseUrl");
        waitTime = (long) envConfig.get("defaultWaitTime");
        headlessMode = (boolean) envConfig.get("headlessMode");
        browser = (String) envConfig.get("browser");
    }
}
