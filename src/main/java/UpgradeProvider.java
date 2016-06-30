/**
 * Created by samujjal on 28/06/16.
 */
public class UpgradeProvider {

    private CompanyObjectVersion companyObjectVersion;

    private static UpgradeProvider instance = null;
    private static Object mutex = new Object();

    private UpgradeProvider() {
        companyObjectVersion = new CompanyObjectVersion(new Version("0.0"));
    }

    public static UpgradeProvider getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) {
                    instance = new UpgradeProvider();
                }
            }
        }
        return instance;
    }

    public UpgradeHandlerBase getNextHandler(Version sourceVersion, StandardObjectType standardObjectType) {
        switch (standardObjectType) {
            case Company:
                return getNextCompanyHandler(sourceVersion);
        }
        return null;
    }

    private UpgradeHandlerBase getNextCompanyHandler(Version sourceVersion) {
        CompanyObjectVersion companyObj = this.companyObjectVersion;
        while (!companyObj.getCompanyVersion().equals(sourceVersion)) {
            companyObj = companyObj.getNextCompanyVersion();
        }
        return companyObj.getUpgradeHandlerBase();
    }

    public void registerHandler(UpgradeHandlerBase upgradeHandlerBase) {
        switch (upgradeHandlerBase.getStandardObjectType()) {
            case Company:
                updateCompanyVersionList(upgradeHandlerBase);
                break;
            default:
                break;
        }
    }

    private void updateCompanyVersionList(UpgradeHandlerBase upgradeHandlerBase) {
        CompanyObjectVersion lastNode = getLastNode(companyObjectVersion);
        // New Handler can only be attached to last Node
        if (canRegister(upgradeHandlerBase, lastNode)) {
            lastNode.setUpgradeHandlerBase(upgradeHandlerBase);
            lastNode.setNextCompanyVersion(new CompanyObjectVersion(upgradeHandlerBase.getTargetVersion()));
        } else {
            throw new IllegalArgumentException(String.format("Incorrect source version for Handler. " +
                    "Handler can only be attached to %s", lastNode.getCompanyVersion()));
        }
    }

    private boolean canRegister(UpgradeHandlerBase upgradeHandlerBase, CompanyObjectVersion lastNode) {
        return lastNode.getCompanyVersion().equals(upgradeHandlerBase.getSourceVersion()) && lastNode.getCompanyVersion().compareTo(upgradeHandlerBase.getTargetVersion()) == -1;
    }

    private CompanyObjectVersion getLastNode(CompanyObjectVersion companyObject) {
        while (companyObject.getNextCompanyVersion() != null) {
            companyObject = companyObject.getNextCompanyVersion();
        }
        return companyObject;
    }
}
