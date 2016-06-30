import java.util.List;

/**
 * Created by samujjal on 30/06/16.
 */
public class StandardObjectInstaller {

    static {
        init();
    }

    public static void init() {
        UpgradeProvider provider = UpgradeProvider.getInstance();
        provider.registerHandler(new CompanyObjectHandler(new Version("0.0"), new Version("1.0")));
        provider.registerHandler(new CompanyObjectHandler(new Version("1.0"), new Version("1.1")));
        provider.registerHandler(new CompanyObjectHandler(new Version("1.1"), new Version("2.0")));
        provider.registerHandler(new CompanyObjectHandler(new Version("2.0"), new Version("2.4")));
    }

    public static void installCompanyObject(String tenantId) {
        Version startVersion = new Version("0.0");
        UpgradeProvider provider = UpgradeProvider.getInstance();
        UpgradeHandlerBase upgradeHandlerBase = provider.getNextHandler(startVersion, StandardObjectType.Company);
        while (upgradeHandlerBase != null) {
            if (upgradeHandlerBase.canUpgrade(tenantId)) {
                upgradeHandlerBase.upgrade(tenantId);
                upgradeHandlerBase = provider.getNextHandler(upgradeHandlerBase.getTargetVersion(), StandardObjectType.Company);
            }
        }
    }

    public static void installStandardObjects(List<String> tenantIdList) {
        for (String tenantId :
                tenantIdList) {
            if (checkStandardObjectsPresence(tenantId)) {
                //TODO: Make MSD Entry & LOG and skip tenant
                continue;
            }
            installCompanyObject(tenantId);
        }
    }

    private static boolean checkStandardObjectsPresence(String tenantId) {
        //TODO: Make collectionMaster call for all standard Objects for the tenant
        return false;
    }
}