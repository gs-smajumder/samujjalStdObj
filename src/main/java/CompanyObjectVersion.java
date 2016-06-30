/**
 * Created by samujjal on 30/06/16.
 */
public class CompanyObjectVersion {

    private Version companyVersion;
    private UpgradeHandlerBase upgradeHandlerBase;
    private CompanyObjectVersion nextCompanyVersion;

    public CompanyObjectVersion(Version version){
        this.companyVersion = version;
    }

    public Version getCompanyVersion() {
        return companyVersion;
    }

    public UpgradeHandlerBase getUpgradeHandlerBase() {
        return upgradeHandlerBase;
    }

    public void setUpgradeHandlerBase(UpgradeHandlerBase upgradeHandlerBase) {
        this.upgradeHandlerBase = upgradeHandlerBase;
    }

    public CompanyObjectVersion getNextCompanyVersion() {
        return nextCompanyVersion;
    }

    public void setNextCompanyVersion(CompanyObjectVersion nextCompanyVersion) {
        this.nextCompanyVersion = nextCompanyVersion;
    }
}
