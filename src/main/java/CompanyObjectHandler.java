/**
 * Created by apple on 28/06/16.
 */
public class CompanyObjectHandler extends UpgradeHandlerBase {

    public CompanyObjectHandler(Version sourceVersion, Version targetVersion){
        this.setSouceVersion(sourceVersion);
        this.setTargetVersion(targetVersion);
        this.setStandardObjectType(StandardObjectType.Company);
    }
}
