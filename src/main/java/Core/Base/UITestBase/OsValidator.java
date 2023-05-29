package Core.Base.UITestBase;

public class OsValidator {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static String getDeviceOS() {
        if (isWindows()) {
            return "windows";
        } else if (isMac()) {
            return "mac";
        } else if (isLinux()) {
            return "Linux";
        } else {
            return "Invalid";
        }
    }


    public static boolean isWindows() {
        return OS.toLowerCase().contains("win");
    }

    public static boolean isMac() {
        return OS.toLowerCase().contains("mac");
    }

    public static boolean isLinux() {
        return OS.toLowerCase().contains("nux");
    }

}
